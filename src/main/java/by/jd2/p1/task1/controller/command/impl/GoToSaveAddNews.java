package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.jd2.p1.task1.bean.News;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.NewsService;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;

public class GoToSaveAddNews implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		News news = new News(request.getParameter("title"), request.getParameter("brief"), request.getParameter("content"), LocalDate.now());
				
		int id;
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		
		try {
			id = newsService.addFullNews(news);
			if (id == 0) {
				System.out.println("Ne poluchilos dobavit");
				response.sendRedirect("Controller?command=gotoeditfullnews&newsmessage=errorregistration");
				return;
			}
			//System.out.println("vozvrachaemsy na glavnuy");
			response.sendRedirect("Controller?command=gotoonefullnews&id=" + id);
			//System.out.println("vse ok");
			//return;
			
			
			
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=gotoaddnews&regmessage=" + e.getMessage());
			// исправить ошибки...
		}
		
		
	}

}
