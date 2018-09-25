package com.beans;

import java.sql.Timestamp;

public class MarketRates {

	public static double USDMarketRate=0.5;
	public static double EURMarketRate=0.6;
	public static double GBPMarketRate=0.7;
	private Timestamp timestamp;
	
	public MarketRates()
	{
		timestamp=null;
	}
	
	public MarketRates(Timestamp timestamp)
	{
		this.timestamp = timestamp;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "MarketRates [timestamp=" + timestamp + "]";
	}

	
}
