package by.jd2.p1.task1.bean;

public class UserLoginationInfo implements java.io.Serializable{
	
	private static final long serialVersionUID = 152908628820072128L;
	
	private String login;
	private String password;
	
	public UserLoginationInfo(){
		super();
	}
	
	public UserLoginationInfo(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLoginationInfo other = (UserLoginationInfo) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserLoginationInfo [login=" + login + ", password=" + password + "]";
	}

	
}
