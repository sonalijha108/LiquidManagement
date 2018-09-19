package com.utilities;

import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.lang3.RandomStringUtils;
import com.beans.CashFlow;
import java.util.List;
import java.util.Random;

public class RandGenerator {
	
	private int NoOfCashFlows;
	private double min;
	private double max;
	List<CashFlow> cashflow = new ArrayList<CashFlow>();
	
	public RandGenerator() 
    {
		NoOfCashFlows = 15;
		min = 100;
		max = 1000;
	}
	
	public RandGenerator(int NoOfCashFlows, double min, double max) 
    {
		this.NoOfCashFlows = NoOfCashFlows;
		this.min = min;
		this.max = max;
	}

	public List<CashFlow> GenerateRandomCashFlow()
    {	
    	Random r = new Random();
    	
    	for(int i=0;i<NoOfCashFlows;i++)
    	{
    		String tradeID = GenerateRandomString(4,false,true);
    		String clientName = GenerateRandomString(8,true,false);
    		String clientID = (GenerateRandomString(2,true,false)).toUpperCase() + GenerateRandomString(3,false,true);
    		
    		String[] curr = {"USD","GBP","EUR"}; 
    		String currency = curr[r.nextInt(3)];
    		
    		double amount = min + (max - min) * r.nextDouble();
    		amount = Math.round(amount * 10000d) / 10000d;
    		
    		String[] bs = {"IN","OUT"}; 
    		String inout = bs[r.nextInt(2)];
    		
    		Calendar calendar = Calendar.getInstance();
    		java.util.Date now = calendar.getTime();
    		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
    		System.out.println(currentTimestamp);
    		
    		cashflow.add(new CashFlow(tradeID,clientName,clientID,currency,amount,inout,currentTimestamp));
    	}
    	
    	return cashflow;
	}
	
	public String GenerateRandomString(int length, boolean useLetters, boolean useNumbers)
	{
		return RandomStringUtils.random(length, useLetters, useNumbers);
	}
	
}

