package com.cruds.service;

import com.cruds.db.UserDAO;
import com.cruds.entity.User;

public class UserService {
	
	public static User authenticate(String userName, String pwd )
	{
		UserDAO dao = new UserDAO();
		return dao.authenticate(userName, pwd);
	}

	public static boolean addUser(User u)
	{
		UserDAO dao = new UserDAO();
		return dao.addUser(u);
	}

}
