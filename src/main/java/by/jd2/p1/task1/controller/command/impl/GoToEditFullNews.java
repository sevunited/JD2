package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.jd2.p1.task1.bean.News;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.NewsService;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;

public class GoToEditFullNews implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		try {
			
			News news = newsService.takeOne(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("newsone", news);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit_full_news.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (ServiceException e) {

//			���� � ��� �� ���������� �������� �������, �� �� ��������� �� 
//			���������� �������� Error, ������� ������� � �������� ����� � index.jsp
//			
			e.printStackTrace();
		}
		
		
		
		

	}

}
