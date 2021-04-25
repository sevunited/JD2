package by.jd2.p1.task1.dao;

import java.util.List;

import by.jd2.p1.task1.bean.News;

public interface NewsDAO {
	
	List<News> selectFullNews() throws DAOException;
	News selectOneNews(int id) throws DAOException;
	Boolean updateNews(News news) throws DAOException;
	List<News> deleteOneNews(int id) throws DAOException;
	int addNews(News news) throws DAOException;
	

}
