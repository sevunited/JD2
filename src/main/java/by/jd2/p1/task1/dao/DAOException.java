package by.jd2.p1.task1.dao;

public class DAOException extends Exception{

	private static final long serialVersionUID = 2989472732025325614L;
	
	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
