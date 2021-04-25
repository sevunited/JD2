package by.jd2.p1.task1.dao;

import by.jd2.p1.task1.dao.imp.SQLNewsDAO;
import by.jd2.p1.task1.dao.imp.SQLUserDAO;

public final class DAOProvider {
	
	private static final DAOProvider instance = new DAOProvider();
	
	private final UserDAO userDAO = new SQLUserDAO();
	
	private final NewsDAO newsDAO = new SQLNewsDAO();
	
	private DAOProvider() {}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}
	
	public static DAOProvider getInstanse() {
		return instance;
	}
	

}
