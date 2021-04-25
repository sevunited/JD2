package by.jd2.p1.task1.dao.imp;

import by.jd2.p1.task1.dao.DBDriverLoadingException;

public class MySQLDriverLoader {
	private static final MySQLDriverLoader instance = new MySQLDriverLoader();
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new DBDriverLoadingException(e);
		}		
	}
	
	
	private MySQLDriverLoader( ) {}

	public static MySQLDriverLoader getInstance( ) {
		return instance;
	}
}
