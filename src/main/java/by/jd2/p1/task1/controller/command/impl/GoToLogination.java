package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.bean.UserLoginationInfo;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;
import by.jd2.p1.task1.service.UserService;

public class GoToLogination implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//validation sdelat'
//		UserLoginationInfo userLog = new UserLoginationInfo();
		
//		userLog.setLogin(request.getParameter("login"));
//		userLog.setLogin(request.getParameter("password"));
//		System.out.println(userLog.toString());

//		System.out.println("Login: " + request.getParameter("login"));
//		System.out.println("Password: " + request.getParameter("password"));
		
		
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			
//			response.sendRedirect("Controller?command=gotoindexpage");
//			System.out.println("Сессия есть");
//			return;
//		}
		
		
		
		
		
		UserLoginationInfo userLog = new UserLoginationInfo();
		userLog.setLogin(request.getParameter("login"));
		userLog.setPassword(request.getParameter("password"));
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		UserInfo userInfo = null;
		
//		boolean isResult = true;
//		RequestDispatcher requestDispatcher = null;
//		if (isResult)
		try {
			userInfo = userService.authorization(userLog);
			//System.out.println(userInfo.toString());
			
			if (userInfo == null) {
//				request.setAttribute("message", "wrong2");
				response.sendRedirect("Controller?command=gotoindexpage&message=logination error");
//				requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
				return;
			}
			
			
			HttpSession session = request.getSession(true);
			//session = request.getSession(true);
			session.setAttribute("auth", userInfo.getName());
			session.setAttribute("role", userInfo.getRole());
			session.setAttribute("user", userInfo);
			//response.sendRedirect("Controller?command=gotomainpage");
			response.sendRedirect("Controller?command=gotoindexpage&message=Hello" + userInfo.getName());
			// или как ниже лучше написать ???
			// response.sendRedirect("Controller?command=gotoindexpage");

			
			
			
//			requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			
			
		} catch(ServiceException e) {
			response.sendRedirect("Controller?command=goToIndexPage&message=" + e.getMessage());
			// точно пойдет e.getMessage ???
		}
		
		//requestDispatcher.forward(request, response);
		
	}

}
