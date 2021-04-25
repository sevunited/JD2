package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd2.p1.task1.controller.command.Command;

public class GoToMainPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session == null) {
			System.out.println("������ ����� ����");
			// ����������� ��������� ��� ������ ���� ������ ���, �������� ���������� �� ������ ��� � ������ �����
			response.sendRedirect("Controller?command=goToIndexPage&message=����� �� ���� ��������� ������� ������ � ����� ������ �������� ��� ����� �������");
			return;
		
		}
		
		
		String isAuth = (String) session.getAttribute("auth");
		
		if (isAuth == null) {
			response.sendRedirect("Controller?command=goToIndexPage&message=error");
			return;
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
		requestDispatcher.forward(request, response);

	}

}
