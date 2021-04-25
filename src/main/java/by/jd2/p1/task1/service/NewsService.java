package by.jd2.p1.task1.service;

import java.util.List;

import by.jd2.p1.task1.bean.News;

public interface NewsService {
	List<News> takeAll() throws ServiceException;
	News takeOne(int id) throws ServiceException;
	Boolean updateFullNews(News news) throws ServiceException;
	List<News> deleteOneNews(int id) throws ServiceException;
	// может просто Boolean, так как все равно попадаем на главную и там идет выборка заново всех данных...
	int addFullNews(News news) throws ServiceException;
	
}
