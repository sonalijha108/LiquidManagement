package com.testing;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import com.beans.AccountData;
import com.beans.CashFlow;
import com.beans.User;
import com.daos.DaoImpl;

public class TestDao {

	@Test
	void testLogin_positive() {
		 DaoImpl dao=new DaoImpl();
			User user_expected=new User("admin","Citicorp India","admin123","citicorp@citi.com",9305111111l);
		String u="admin";
		String p="admin123";
			
			User user_actu=dao.LoginDao(u,p);
			assertNotNull(user_actu);
			assertEquals(user_expected.getUsername(), user_actu.getUsername());
		//	assertEquals("testing book",book_actu.getBookName());
			assertTrue(user_expected.getPassword()==user_actu.getPassword());
			
			
		}
	@Test
	void testLogin_negative()
	{
		DaoImpl dao=new DaoImpl();
		
	String u="abc";
	String p="admin123";
		
		User user_actu=dao.LoginDao(u,p);
		assertNotNull(user_actu);
		//assertEquals(null, user_actu.getUsername());
	//	assertEquals("testing book",book_actu.getBookName());
		//assertTrue(null==user_actu.getPassword());
	
		
		
	}
	@Test
	void testaddUser_positive()
	{
		DaoImpl dao=new DaoImpl();
		int expected=1;
		AccountData ad=new AccountData(2000d,5000d,6000d,"SF1234","Samita","12345","samita@citi.com",5534524534l);
		int actual=dao.addUser(ad);
		assertEquals(expected, actual);
		
	}
	@Test
	void testaddUser_negative()
	{
		DaoImpl dao=new DaoImpl();
		int expected=0;
		AccountData ad=new AccountData(2000d,5000d,6000d,"FR456","Amita","12345","samita@citi.com",5534524534l);
		int actual=dao.addUser(ad);assertEquals(expected, actual);
		
	}

	@Test
	void testaddCashflowDao_positive()
	{
		DaoImpl dao=new DaoImpl();
		int expected=1;
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
	
		int actual=dao.addCashflowDao();assertEquals(expected, actual);
	}
	@Test
	void testaddCashflowDao_negative()
	{
		DaoImpl dao=new DaoImpl();
		int expected=0;
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		int actual=dao.addCashflowDao();assertEquals(expected, actual);
	}

	
}
