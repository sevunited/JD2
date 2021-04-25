package by.jd2.p1.task1.dao;

import by.jd2.p1.task1.bean.UserEditInfo;
import by.jd2.p1.task1.bean.UserInfo;
import by.jd2.p1.task1.bean.UserLoginationInfo;
import by.jd2.p1.task1.bean.UserRegistrationInfo;

public interface UserDAO {
	UserInfo authorization(UserLoginationInfo userLogInfo) throws DAOException;
	UserInfo registration(UserRegistrationInfo userRegInfo) throws DAOException;
	UserInfo edit(UserEditInfo userEditInfo) throws DAOException;

}
