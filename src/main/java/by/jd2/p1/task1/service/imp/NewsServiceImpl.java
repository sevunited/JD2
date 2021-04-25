package by.jd2.p1.task1.service.imp;

import java.util.List;

import by.jd2.p1.task1.bean.News;
import by.jd2.p1.task1.dao.DAOException;
import by.jd2.p1.task1.dao.DAOProvider;
import by.jd2.p1.task1.dao.NewsDAO;
import by.jd2.p1.task1.service.NewsService;
import by.jd2.p1.task1.service.ServiceException;

public class NewsServiceImpl implements NewsService{

	@Override
	public List<News> takeAll() throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstanse();
		NewsDAO newsDAO = provider.getNewsDAO();
		List<News> news = null;
		try {
			news = newsDAO.selectFullNews();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return news;
	}

	@Override
	public News takeOne(int id) throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstanse();
		NewsDAO newsDAO = provider.getNewsDAO();
		News news = null;
		
		try {
			news = newsDAO.selectOneNews(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return news;
	}

	@Override
	public Boolean updateFullNews(News news) throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstanse();
		NewsDAO newsDAO = provider.getNewsDAO();
		Boolean isUpdate = false;
		
		try {
			isUpdate = newsDAO.updateNews(news);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		
		
		return isUpdate;
	}

	@Override
	public List<News> deleteOneNews(int id) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstanse();
		NewsDAO newsDAO = provider.getNewsDAO();
		
		List<News> news = null;
		
		try {
			news = newsDAO.deleteOneNews(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		
		
		return news;
	}

	@Override
	public int addFullNews(News news) throws ServiceException {
		
		// Валидация... здесь сделать
		
		DAOProvider provider = DAOProvider.getInstanse();		
		NewsDAO newsDAO = provider.getNewsDAO();
		
		int id;
		
		try {
			id = newsDAO.addNews(news);
		} catch(DAOException e) {
			throw new ServiceException("error message", e);
		}
		
		return id;	
	}
	
	
	

}
