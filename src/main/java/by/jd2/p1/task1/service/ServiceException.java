package by.jd2.p1.task1.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = -4924589489819852335L;
	
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

}
