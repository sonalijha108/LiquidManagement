package com.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.beans.CashFlow;
import com.daos.DaoImpl;
 
public class TestCashFlow {

	@Test
	public void testAddCashFlow_positive() {
     List<CashFlow> c=new ArrayList();
     Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		DaoImpl dao=new DaoImpl();
        c.add(new CashFlow(1008,"USD","IN",2500,currentTimestamp));
        c.add(new CashFlow(1008,"USD","OUT",4000,currentTimestamp));
        c.add(new CashFlow(1008,"EUR","IN",14000,currentTimestamp));
        c.add(new CashFlow(1008,"EUR","OUT",12000,currentTimestamp));
        c.add(new CashFlow(1008,"GBP","IN",22000,currentTimestamp));
        c.add(new CashFlow(1008,"GBP","OUT",18000,currentTimestamp));
        
	
     int actual=dao.addCashflowDao(c);
     int expected=6;
     assertEquals(expected, actual);
	}
	@Test
	public void testAddCashFlow_negative() {
     List<CashFlow> c=new ArrayList();
     Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		DaoImpl dao=new DaoImpl();

	
     c.add(new CashFlow());
     int actual=dao.addCashflowDao(c);
     int expected=3;
     assertEquals(expected, actual);
	}

     
    	
	

	
}
