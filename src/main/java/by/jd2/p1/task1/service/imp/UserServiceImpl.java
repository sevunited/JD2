package by.jd2.p1.task1.service.imp;

import by.jd2.p1.task1.bean.UserEditInfo;
import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.bean.UserLoginationInfo;
import by.jd2.p1.task1.bean.UserRegistrationInfo;
import by.jd2.p1.task1.dao.DAOException;
import by.jd2.p1.task1.dao.DAOProvider;
import by.jd2.p1.task1.dao.UserDAO;
import by.jd2.p1.task1.service.ServiceException;
import by.jd2.p1.task1.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public UserInfo authorization(UserLoginationInfo userLogInfo) throws ServiceException {
		//validation!!!
		if(userLogInfo.getLogin() == null || "".equals(userLogInfo.getLogin())) {
			throw new ServiceException("emptyLogin");
		}
//		if(password == null || "".equals(password)) {
//			//����� �������� ������ �������� ��������� �������
//			throw new ServiceException("emptyPassword");
//		}	
		
		
		
		DAOProvider provider = DAOProvider.getInstanse();		
		UserDAO userDAO = provider.getUserDAO();
		UserInfo userInfo = null;
		
		try {
			
			userInfo = userDAO.authorization(userLogInfo);
			//��������� ���� ����� ������������ ��� ��� �� ����������
		} catch(DAOException e) {
			throw new ServiceException("error message", e);
		}
		
		return userInfo;
	}

	@Override
	public UserInfo registration(UserRegistrationInfo userRegInfo)  throws ServiceException {
		if(userRegInfo.getLogin() == null || "".equals(userRegInfo.getLogin())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration login");
		}
		if(userRegInfo.getPassword() == null || "".equals(userRegInfo.getPassword())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration password");
		}	
		if(userRegInfo.getName() == null || "".equals(userRegInfo.getName())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration name");
		}	
		if(userRegInfo.getSurname() == null || "".equals(userRegInfo.getSurname())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration surname");
		}			
		if(userRegInfo.getEmail() == null || "".equals(userRegInfo.getEmail())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration email");
		}		
		
		DAOProvider provider = DAOProvider.getInstanse();		
		UserDAO userDAO = provider.getUserDAO();
		
		UserInfo userInfo = null;
		
		try {
			
			userInfo = userDAO.registration(userRegInfo);
			System.out.println("vernulis v service");
			//System.out.println("����� � �������, ����� DAO - ���������: " + nameUser);
			//��������� ���� ����� ������������ ��� ��� �� ����������
		} catch(DAOException e) {
			throw new ServiceException("error message", e);
		}	
		
		
		return userInfo;
	}

	@Override
	public UserInfo edit(UserEditInfo userEditInfo) throws ServiceException {
		
		System.out.println(userEditInfo.toString());
		
		if(userEditInfo.getLogin() == null || "".equals(userEditInfo.getLogin())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration login");
		}
		if(userEditInfo.getPasswordNew() == null || "".equals(userEditInfo.getPasswordNew())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration password");
		}	
		if(userEditInfo.getPasswordOld() == null || "".equals(userEditInfo.getPasswordOld())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration password");
		}		
		
		
		if(userEditInfo.getName() == null || "".equals(userEditInfo.getName())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration name");
		}	
		if(userEditInfo.getSurname() == null || "".equals(userEditInfo.getSurname())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration surname");
		}			
		if(userEditInfo.getEmail() == null || "".equals(userEditInfo.getEmail())) {
			//����� �������� ������ �������� ��������� �������
			throw new ServiceException("error registration email");
		}		
		
		DAOProvider provider = DAOProvider.getInstanse();		
		UserDAO userDAO = provider.getUserDAO();
		
		UserInfo userInfo = null;
		
		try {
			
			userInfo = userDAO.edit(userEditInfo);
			System.out.println("vernulis v service");
			//System.out.println("����� � �������, ����� DAO - ���������: " + nameUser);
			//��������� ���� ����� ������������ ��� ��� �� ����������
		} catch(DAOException e) {
			throw new ServiceException("error message", e);
		}
	
		
		return userInfo;
	}

}
