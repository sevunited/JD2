package by.jd2.p1.task1.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.jd2.p1.task1.bean.UserEditInfo;
import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.bean.UserLoginationInfo;
import by.jd2.p1.task1.bean.UserRegistrationInfo;
import by.jd2.p1.task1.dao.DAOException;
import by.jd2.p1.task1.dao.UserDAO;
import by.jd2.p1.task1.dao.connection_pool.ConnectionPool;
import by.jd2.p1.task1.dao.connection_pool.ConnectionPoolException;

public class SQLUserDAO implements UserDAO{
	
	static {
		MySQLDriverLoader.getInstance();
	}

	ConnectionPool connectionPool = ConnectionPool.getInstanse();
	
	
	@Override
	public UserInfo authorization(UserLoginationInfo userLogInfo) throws DAOException{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserInfo userInfo = null;

		try {
			
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			
			ps = con.prepareStatement("SELECT * FROM users WHERE login=? AND password=?");
			ps.setString(1, userLogInfo.getLogin());
			ps.setString(2, userLogInfo.getPassword());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if ("blocked".equals(rs.getString("status"))) {
					//////придумать дальше реализацию....
					// return userInfo; // либо правильно генерация исключения
				}
				userInfo = new UserInfo();
				userInfo.setLogin(rs.getString("login"));
				userInfo.setName(rs.getString("name"));
				userInfo.setSurname(rs.getString("surname"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setRole(rs.getString("role"));
			} else {
				System.out.println("Net dannyh");
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

		return userInfo;
	}

	@Override
	public UserInfo registration(UserRegistrationInfo userRegInfo) throws DAOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserInfo userInfo = null;
		
		String login = userRegInfo.getLogin();
		String password = userRegInfo.getPassword();
		String name = userRegInfo.getName();
		String surname = userRegInfo.getSurname();
		String email = userRegInfo.getEmail();
		
		try {
			
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			
			ps = con.prepareStatement("SELECT login FROM users WHERE login=?");
			ps.setString(1, login);
			rs = ps.executeQuery();
			
			if (!rs.next()) {
				ps = con.prepareStatement("INSERT INTO users (login, password, name, surname, email) VALUES (?, ?, ?, ?, ?);");
				ps.setString(1, login);
				ps.setString(2, password);
				ps.setString(3, name);
				ps.setString(4, surname);
				ps.setString(5, email);
				
				int rows = ps.executeUpdate();
				if (rows!=1) { // Proverit tochno dolgno vozvrachat' 1 ???
					System.out.println("oshibka dobavleniya");
				}		
				
				userInfo = new UserInfo();
				userInfo.setLogin(login);
				userInfo.setName(name);
				userInfo.setSurname(surname);
				userInfo.setEmail(email);
				
				
				ps = con.prepareStatement("SELECT role FROM users WHERE login=?;");
				ps.setString(1, login);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					userInfo.setRole(rs.getString("role"));
				} else {
					System.out.println("Oshibka dobavleniya");
				}
				
			} else {
				System.out.println("polzovatel s takim imenem uge est'");
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
		
		return userInfo;
	}

	@Override
	public UserInfo edit(UserEditInfo userEditInfo) throws DAOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserInfo userInfo = null;
		
		String login = userEditInfo.getLogin();
		String passwordNew = userEditInfo.getPasswordNew();
		String passwordOld = userEditInfo.getPasswordOld();
		String name = userEditInfo.getName();
		String surname = userEditInfo.getSurname();
		String email = userEditInfo.getEmail();
		
		try {
			
			try {
				con = connectionPool.takeConnection();
			} catch (ConnectionPoolException e) {
				e.printStackTrace();
			}
			
			ps = con.prepareStatement("SELECT password FROM users WHERE login=?");
			ps.setString(1, login);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				if (!rs.getString("password").equals(passwordOld)) {
					System.out.println("Paroli ne shodyatsy");
					// return userInfo; /// придумать как сделать!!!
				}
				
				ps = con.prepareStatement("UPDATE users SET login=?, password=?, name=?, surname=?, email=? WHERE login=?;");
				ps.setString(1, login);
				ps.setString(2, passwordNew);
				ps.setString(3, name);
				ps.setString(4, surname);
				ps.setString(5, email);
				ps.setString(6, login);
				
				int rows = ps.executeUpdate();
				if (rows!=1) {
					System.out.println("oshibka dobavleniya");
				}
				userInfo = new UserInfo();
				userInfo.setLogin(login);
				userInfo.setName(name);
				userInfo.setSurname(surname);
				userInfo.setEmail(email);
				
				ps = con.prepareStatement("SELECT role FROM users WHERE login=?;");
				ps.setString(1, login);
				
				rs = ps.executeQuery();
				if (rs.next()) {
					userInfo.setRole(rs.getString("role"));
				
				} else {
					System.out.println("Oshibka dobavleniya");
				}	
				
			} else {
				//////////// придумать!
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
		return userInfo;
	}

}
