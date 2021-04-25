package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.bean.UserRegistrationInfo;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;
import by.jd2.p1.task1.service.UserService;

public class GoToSaveNewUser implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserRegistrationInfo regInfo = new UserRegistrationInfo();
		regInfo.setName(request.getParameter("name"));
		regInfo.setSurname(request.getParameter("surname"));
		regInfo.setLogin(request.getParameter("login"));
		regInfo.setPassword(request.getParameter("password"));
		regInfo.setEmail(request.getParameter("email"));
		
		
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		UserInfo userInfo = null;
		
		try {
			userInfo = userService.registration(regInfo);	
			System.out.println("Vernulis v provider");
			if (userInfo == null) {
				// ??????????????????????????????????????????????????????????????????????????????????????????
				response.sendRedirect("Controller?command=registration&regmessage=errorregistration");
				// ??????????????????????????????????????????????????????????????????????????????????????????
				return;
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("auth", userInfo.getName());
			session.setAttribute("role", userInfo.getRole());
			session.setAttribute("user", userInfo);
			
			
			System.out.println("vihodim na glavnuy");
			response.sendRedirect("Controller?command=gotoindexpage&message=Hello" + userInfo.getName());
			System.out.println("vse ok");
			return;
			
			
			
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=registration&regmessage=" + e.getMessage());
		
		}
		
		
		
//		System.out.println("GoToSaveNewUser implements Command");	
		
//		request.setAttribute("message", "����������� ������ �������");
		
//		response.sendRedirect("Controller?command=gotoindexpage&message=����������� ������ �������");
		
		
//		response.sendRedirect("Controller?command=gotomainpage&regmessage=Registration OK");
		
		
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
//		requestDispatcher.forward(request, response);
		
	}

}
