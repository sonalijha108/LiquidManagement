package com.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.beans.AccountData;
import com.daos.DaoImpl;

public class TestGetCurrentBalance {

	@Test
	public void testgetCurrentbalance_positive() {
		DaoImpl dao=new DaoImpl();
		AccountData Ad_expected=new AccountData("John_123", "John123", "John", "john@citi.com", 7865456732l, -1500d, 2000d,4000d);
		AccountData Ad_actual;
		Ad_actual=dao.getCurrentBalance();
		assertNotNull(Ad_actual);
		assertTrue(Ad_expected.getEUR_NotionalBalance()== Ad_actual.getEUR_NotionalBalance());
		assertTrue(Ad_expected.getUSD_NotionalBalance()== Ad_actual.getUSD_NotionalBalance());
		assertTrue(Ad_expected.getGBP_NotionalBalance()== Ad_actual.getGBP_NotionalBalance());
		
		
		
		
	}

}
