package com.utilities;

import java.util.Calendar;
import java.util.Random;
import com.beans.*;
import com.daos.Dao;
import com.daos.DaoImpl;
import com.services.*;

public class RandRateGenerator{

	public void generateRandomRates()
	{	
		Dao dao=new DaoImpl();
		while(true)
		{
			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
			
			// MARKET RATE GENERATION
			MarketRates.USDMarketRate = GenerateRandomRates(-1.0,1.0);
			MarketRates.EURMarketRate = GenerateRandomRates(-1.0,1.0);
			MarketRates.GBPMarketRate = GenerateRandomRates(-1.0,1.0);
			dao.addMarketRatesDao(0);
			
			// FOREX RATE GENERATION
			ForexRates.EURUSDRate = GenerateRandomRates(1.0,1.5);
			ForexRates.EURGBPRate = GenerateRandomRates(1.0,1.5);
			ForexRates.GBPUSDRate = GenerateRandomRates(1.0,1.5);
			dao.addForexRatesDao(0);
			/*Service service=new ServiceImpl();
			market_count = service.addRates(new MarketRates(USD_marketRate,EUR_marketRate,GBP_marketRate,currentTimestamp),market_count);
			forex_count = service.addRates(new ForexRates(EURUSDRate,EURGBPRate,GBPUSDRate,currentTimestamp),forex_count);*/
			
			
		}
	}
	
	public double GenerateRandomRates(double min,double max)
	{
		Random r = new Random();
		double rate = min + (max - min) * r.nextDouble();
		rate = Math.round(rate * 100.0) / 100.0;
		return rate;
	}	
	
}
