package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd2.p1.task1.bean.News;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.NewsService;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;

public class GoToOneFullNews implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); // здесь ошибка, но какая ??? true что ли передать ????
		// разобрался - проверка на null обязательно нужно сделать...
		
		if (session == null) {
			//System.out.println("������ ����� ����");
			// ����������� ��������� ��� ������ ���� ������ ���, �������� ���������� �� ������ ��� � ������ �����
			response.sendRedirect("Controller?command=goToIndexPage&message=����� �� ���� ��������� ������� ������ � ����� ������ �������� ��� ����� �������");
			return;
		
		}	
		
		String isAuth = (String) session.getAttribute("auth");
		
		if (isAuth == null) {
			response.sendRedirect("Controller?command=goToIndexPage&message=error");
			return;
		}
		
		int id = Integer.parseInt((String)request.getParameter("id"));
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		
		
		try {
			News news = newsService.takeOne(id);
			
			request.setAttribute("newsone", news);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/full_news.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (ServiceException e) {

			
			e.printStackTrace();
			
			
			
		}

	}

}
