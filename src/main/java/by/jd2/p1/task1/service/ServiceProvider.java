package by.jd2.p1.task1.service;

import by.jd2.p1.task1.service.imp.NewsServiceImpl;
import by.jd2.p1.task1.service.imp.UserServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private ServiceProvider() {}
	
	private final UserService userService= new UserServiceImpl();
	
	private final NewsService newsService= new NewsServiceImpl();

	
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public NewsService getNewsService() {
		return newsService;
	}
	
	
}
