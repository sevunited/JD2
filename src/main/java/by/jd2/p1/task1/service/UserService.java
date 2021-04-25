package by.jd2.p1.task1.service;

import by.jd2.p1.task1.bean.UserEditInfo;
import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.bean.UserLoginationInfo;
import by.jd2.p1.task1.bean.UserRegistrationInfo;

public interface UserService {
	UserInfo authorization(UserLoginationInfo userLogInfo) throws ServiceException;
	UserInfo registration(UserRegistrationInfo userRegInfo) throws ServiceException;
	UserInfo edit(UserEditInfo user) throws ServiceException;
	

}
