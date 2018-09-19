package com.services;

import java.util.List;
import com.beans.*;
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
			return user;
		}
		else
			return null;
	}

	@Override
	public boolean isUserAdded(User user) {
		Dao dao=new DaoImpl();
		int rowsAdded=dao.addUser(user);
		System.out.println("Rows added: "+rowsAdded);
		if(rowsAdded>0)
			return true;
		return false;
	}
	
	@Override
	public boolean addRandomCashflow(List<CashFlow> cashflow)
	{
		Dao dao=new DaoImpl();
		int rows = dao.addRandomCashflowDao(cashflow);
		if(rows == cashflow.size())
		{
			System.out.println(rows+" Rows added succesfully");
			return true;
		}
		
		System.out.println("Random cashflow addition failed");
		return false;
	}

}
