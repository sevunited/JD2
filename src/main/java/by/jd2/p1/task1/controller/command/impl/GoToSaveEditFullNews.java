package by.jd2.p1.task1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.jd2.p1.task1.bean.News;
import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.service.NewsService;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.ServiceProvider;

public class GoToSaveEditFullNews implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		News news = new News();
		news.setId(Integer.parseInt(request.getParameter("id")));
		news.setTitle(request.getParameter("title"));
		news.setBrief(request.getParameter("brief"));
		news.setContent(request.getParameter("content"));
		
		
		System.out.println(news.toString());
		
		Boolean isUpdate = false;
		
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();
		
		
		try {
			isUpdate = newsService.updateFullNews(news);
			if (!isUpdate) {
				response.sendRedirect("Controller?command=gotoeditfullnews&id=" + request.getParameter("id") + "&newsmessage=errorregistration");
				return;
			}
			response.sendRedirect("Controller?command=gotoonefullnews&id=" + request.getParameter("id"));
			//return;
			
			
			
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=registration&regmessage=" + e.getMessage());
		
		}
		
	}

}
