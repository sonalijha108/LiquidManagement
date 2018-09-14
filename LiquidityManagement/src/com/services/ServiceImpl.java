package com.services;

import com.beans.User;
import com.daos.Dao;
import com.daos.DaoImpl;

public class ServiceImpl implements Service{

	@Override
	public User loginUser(String userName, String password) {
		Dao dao=new DaoImpl();
		User user=new User();
		user=dao.LoginDao("admin", "admin123");
		System.out.println(user);
		if(user==null) {
			System.out.println("no such user ..... inside service");
			return null;
		}
			
		if(userName.equals(user.getUsername())&&password.equals(user.getPassword()) ){
			return user;
		}
		else
			return null;
	}

}
