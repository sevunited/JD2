package by.jd2.p1.task1.controller.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.jd2.p1.task1.dao.connection_pool.ConnectionPool;
import by.jd2.p1.task1.dao.connection_pool.ConnectionPoolException;

public class ListenerPool implements ServletContextListener {

	public ListenerPool() {
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
			ConnectionPool cp = ConnectionPool.getInstanse();
			cp.initPoolData();
		} catch (ConnectionPoolException e) {
			// ??????????????????????????????????????			
		}
		ServletContextListener.super.contextInitialized(sce);
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ConnectionPool cp = ConnectionPool.getInstanse();
		cp.dispose();
		ServletContextListener.super.contextDestroyed(sce);
	}
	
}
