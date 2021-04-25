package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd2.p1.task1.bean.UserEditInfo;
import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;
import by.jd2.p1.task1.service.UserService;

public class GoToSaveEditUser implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserEditInfo userEditInfo = new UserEditInfo();
		userEditInfo.setLogin(request.getParameter("login"));
		userEditInfo.setPasswordNew(request.getParameter("passwordNew"));
		userEditInfo.setPasswordOld(request.getParameter("passwordOld"));
		userEditInfo.setName(request.getParameter("name"));
		userEditInfo.setSurname(request.getParameter("surname"));
		userEditInfo.setEmail(request.getParameter("email"));
		
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		UserInfo userInfo = null;
				
		try {
			userInfo = userService.edit(userEditInfo);
			if (userInfo == null) {
				// ??????????????????????????????????????????????????????????????????????????????????????????
				response.sendRedirect("Controller?command=registration&regmessage=errorsavedituser");
				// ??????????????????????????????????????????????????????????????????????????????????????????
				return;
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("auth", userInfo.getName());
			session.setAttribute("role", userInfo.getRole());
			session.setAttribute("user", userInfo); // ???????????????????????
			
			
			response.sendRedirect("Controller?command=gotoindexpage");
			return;
			
			
			
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=registration&regmessage=" + e.getMessage());
		
		}
		
		
		
		
	}

}
