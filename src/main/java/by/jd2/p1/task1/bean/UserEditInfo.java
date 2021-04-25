package by.jd2.p1.task1.bean;

import java.io.Serializable;

public class UserEditInfo implements Serializable{

	private static final long serialVersionUID = 6301897798077485282L;
	
	private String name;
	private String surname;
	private String login;
	private String passwordOld;
	private String passwordNew;
	private String email;
	
	public UserEditInfo() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

	public String getPasswordNew() {
		return passwordNew;
	}

	public void setPasswordNew(String passwordNew) {
		this.passwordNew = passwordNew;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passwordNew == null) ? 0 : passwordNew.hashCode());
		result = prime * result + ((passwordOld == null) ? 0 : passwordOld.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		UserEditInfo other = (UserEditInfo) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passwordNew == null) {
			if (other.passwordNew != null)
				return false;
		} else if (!passwordNew.equals(other.passwordNew))
			return false;
		if (passwordOld == null) {
			if (other.passwordOld != null)
				return false;
		} else if (!passwordOld.equals(other.passwordOld))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserEditInfo [name=" + name + ", surname=" + surname + ", login=" + login + ", passwordOld="
				+ passwordOld + ", passwordNew=" + passwordNew + ", email=" + email + "]";
	}
	
	
	
	
	
	
}
