package com.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.beans.AccountData;
import com.daos.DaoImpl;

public class TestAddUser {

	@Test
	public void testaddUser_positive()
	{
		DaoImpl dao=new DaoImpl();
		int expected=1;
		AccountData user=new AccountData("John_123","John123","John","john@citi.com",5534524534l,0,0,0);
		int actual=dao.addUser(user);
		assertEquals(expected, actual);
		
		
	}
	@Test
	public void testaddUser_negative()
	{
		DaoImpl dao=new DaoImpl();
		int expected=0;
		AccountData user=new AccountData("S1234","Sami","123","samita@citi.com",5534524534l,2000d,4000d,700d);
		int actual=dao.addUser(user);
		assertEquals(expected, actual);
		
		
	}
	
	
}
