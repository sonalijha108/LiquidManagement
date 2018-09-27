package com.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.beans.AccountData;
import com.daos.DaoImpl;

public class Testlogin {

	@Test
	public void testLogin_positive() {
	 DaoImpl dao=new DaoImpl();
		AccountData user_expected=new AccountData("admin","admin123","Citi","citi@citi.com",9305111111l,1000d,2000d,300d);
	String u="admin";
	String p="admin123";
		
		AccountData user_actu=dao.LoginDao(u,p);
		assertNotNull(user_actu);
		assertTrue(user_expected.getUsername().equals(user_actu.getUsername()));
		assertEquals(user_expected.getPassword(),user_actu.getPassword());
		
		
	}
	@Test
	public void testLogin_negative() {
	 DaoImpl dao=new DaoImpl();
		AccountData user_expected=new AccountData("ad","ad123","Citi123","citi@citi.com",9305111111l,1000d,2000d,300d);
	String u="admin";
	String p="admin123";
		
		AccountData user_actu=dao.LoginDao(u,p);
		assertNotNull(user_actu);
		assertEquals(user_expected.getUsername(), user_actu.getUsername());
	//	assertEquals("testing book",book_actu.getBookName());
		assertTrue(user_expected.getPassword().equals(user_actu.getPassword()));
		
		
	}
	
	
    

}
