package com.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.beans.AccountData;
import com.beans.ForexRates;
import com.daos.DaoImpl;

public class TestAddForexRates {

	@Test
	public void testaddForexRate_positive()
	{
		DaoImpl dao=new DaoImpl();
		int expected=1;
		 ForexRates FR=new ForexRates();
		 int r=0;
		int actual=dao.addForexRatesDao(r);
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	public void testaddForexRate_negative()
	{
		DaoImpl dao=new DaoImpl();
		int expected=0;
		 ForexRates FR=new ForexRates();
		 int r=0;
		int actual=dao.addForexRatesDao(r);
		assertEquals(expected, actual);
		
		
	}
	
	
}
