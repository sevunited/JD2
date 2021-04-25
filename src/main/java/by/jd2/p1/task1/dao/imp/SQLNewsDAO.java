package by.jd2.p1.task1.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.jd2.p1.task1.bean.News;
import by.jd2.p1.task1.dao.DAOException;
import by.jd2.p1.task1.dao.NewsDAO;
import by.jd2.p1.task1.dao.connection_pool.ConnectionPool;
import by.jd2.p1.task1.dao.connection_pool.ConnectionPoolException;

public class SQLNewsDAO implements NewsDAO {

	static {
		MySQLDriverLoader.getInstance();
	}
	
	ConnectionPool connectionPool = ConnectionPool.getInstanse();

	@Override
	public List<News> selectFullNews() throws DAOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<News> news = null;
		
		try {
			
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			
			ps = con.prepareStatement("SELECT * FROM news WHERE status='active'");
			rs = ps.executeQuery();
			
			news = new ArrayList<News>();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				news.add(new News(id, title, brief, content, date.toLocalDate()));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return news;
	}

	@Override
	public News selectOneNews(int idOne) throws DAOException {
		
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		News news = null;
		
		try {
			
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			
			ps = con.prepareStatement("SELECT * FROM news WHERE id=?");
			ps.setInt(1, idOne);
			
			rs = ps.executeQuery();
			
			news = new News();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				news = new News(id, title, brief, content, date.toLocalDate());
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		return news;
	}

	@Override
	public Boolean updateNews(News news) throws DAOException {
		
		String title = news.getTitle();
		String brief = news.getBrief();
		String content = news.getContent();
		int id = news.getId();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Boolean isUpdate = false;
		try {
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			
			ps = con.prepareStatement("SELECT * FROM news WHERE id=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = con.prepareStatement("UPDATE news SET title=?, brief=?, content=? WHERE id=?;");
				ps.setString(1, title);
				ps.setString(2, brief);
				ps.setString(3, content);
				ps.setInt(4, id);
				
				int rows = ps.executeUpdate();
				if (rows!=1) {
					System.out.println("oshibka dobavleniya");
				}		
				isUpdate = true;
			} else {
				System.out.println("novosti s takim id - NET!!!");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return isUpdate;
	}

	@Override
	public List<News> deleteOneNews(int id) throws DAOException {
		
		Connection con = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		
		List<News> news = null;
		try {
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			
			ps = con.prepareStatement("SELECT * FROM news WHERE id=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if (rs.next()) {				
				ps = con.prepareStatement("UPDATE news SET status='deleted' WHERE id=?;");
				ps.setInt(1, id);
				
				int rows = ps.executeUpdate();
				if (rows!=1) {
					System.out.println("oshibka udaleniya");
				}		
				news = selectFullNews();
			} else {
				System.out.println("novosti s takim id - NET!!!");
				// podumat....
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return news;
	}

	@Override
	public int addNews(News news) throws DAOException {
		
		String title = news.getTitle();
		String brief = news.getBrief();
		String content = news.getContent();
		LocalDate date = news.getDate();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int id = 0;
		try {
			
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			ps = con.prepareStatement("INSERT INTO news (title, brief, content, date) VALUES (?, ?, ?, ?);");
			ps.setString(1, title);
			ps.setString(2, brief);
			ps.setString(3, content);
			ps.setDate(4, java.sql.Date.valueOf(date));
			
			int rows = ps.executeUpdate();
			if (rows!=1) { // Proverit tochno dolgno vozvrachat' 1 ???
				System.out.println("oshibka dobavleniya");
				// Obrabotat chto delat...
			}
			
			ps = con.prepareStatement("SELECT id FROM news WHERE title=?;");
			ps.setString(1, title);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
			
			} else {
				System.out.println("Oshibka dobavleniya");
			}
			

		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		
		return id;
	}
	
	

}
