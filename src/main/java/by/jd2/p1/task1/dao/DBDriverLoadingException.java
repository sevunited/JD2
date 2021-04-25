package by.jd2.p1.task1.dao;

public class DBDriverLoadingException extends RuntimeException {
	private static final long serialVersionUID = -763014329561382074L;

	public DBDriverLoadingException() {
		super();
	}

	public DBDriverLoadingException(String message) {
		super(message);
	}

	public DBDriverLoadingException(Exception e) {
		super(e);
	}

	public DBDriverLoadingException(String message, Exception e) {
		super(message, e);
	}
}
