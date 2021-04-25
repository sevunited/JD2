package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.controller.command.Command;

public class GoToEditUser implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession();
			if (session!=null) {
				UserInfo userInfo = (UserInfo)session.getAttribute("user");
				request.setAttribute("user", userInfo);
				
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
				requestDispatcher.forward(request, response);	
			} else {
				// ?????????????????????????????????
			}
		
	}

}
