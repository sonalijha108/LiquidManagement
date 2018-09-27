package com.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.beans.ForexRates;
import com.beans.MarketRates;
import com.daos.DaoImpl;

public class TestAddMarketRates {

	@Test
	public void testaddMarketRate_positive() {
		
		DaoImpl dao=new DaoImpl();
		int expected=1;
		 ForexRates FR=new ForexRates();
		 int r=0;
		int actual=dao.addMarketRatesDao(r);
		assertEquals(expected, actual);
		
		
	}
	
	@Test
	public void testaddMarketRate_negative() {
		
		DaoImpl dao=new DaoImpl();
		int expected=0;
		 MarketRates MR=new MarketRates();
		 int r=0;
		int actual=dao.addMarketRatesDao(r);
		assertEquals(expected, actual);
		
		
	}
	
	

}
