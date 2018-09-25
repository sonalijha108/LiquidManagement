package com.services;

import com.beans.AccountData;
import com.beans.User;
import com.daos.Dao;
import com.daos.DaoImpl;

public class ServiceImpl implements Service{

	@Override
	public User loginUser(String userName, String password) {
		Dao dao=new DaoImpl();
		User user=new User();
		user=dao.LoginDao(userName, password);
		System.out.println(user);
		if(user==null) {
			System.out.println("no such user ..... inside service");
			return null;
		}
			
		if(userName.equals(user.getUsername())&&password.equals(user.getPassword()) ){
			User.staticUsername=userName;
			return user;
		}
		else
			return null;
		
		
	}

	@Override
	public boolean isUserAdded(AccountData user) {
		Dao dao=new DaoImpl();
		int rowsAdded=dao.addUser(user);
		System.out.println("Rows added: "+rowsAdded);
		if(rowsAdded>0)
			return true;
		return false;
	}

	@Override
	public AccountData getCurrentBalanceService() {
		Dao dao=new DaoImpl();
		
		return dao.getCurrentBalance();
	}

	@Override
	public boolean isUserAdded(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
