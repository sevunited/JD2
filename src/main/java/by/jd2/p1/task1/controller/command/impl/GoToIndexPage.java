package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.jd2.p1.task1.bean.News;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.NewsService;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;

public class GoToIndexPage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		try {
			
			List<News> news = newsService.takeAll();
			request.setAttribute("news", news);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (ServiceException e) {
			//????????????????????????????????
			e.printStackTrace();
		}
		
		
		
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main_index.jsp");
//		requestDispatcher.forward(request, response);

	}

}
