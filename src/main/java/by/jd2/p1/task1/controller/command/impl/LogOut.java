package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd2.p1.task1.controller.command.Command;

public class LogOut implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute("auth");
			session.removeAttribute("role");
			session.removeAttribute("user");
		}
		response.sendRedirect("Controller?command=goToIndexPage&message=logout");		

	}

}
