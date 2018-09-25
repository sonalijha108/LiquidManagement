package com.beans;

import java.sql.Timestamp;

public class ForexRates {
	
	public static double EURUSDRate= 1.5;
	public static double EURGBPRate= 1.4;
	public static double GBPUSDRate= 1.3;
	private Timestamp timestamp;
	
	public ForexRates()
	{
		timestamp=null;
	}
	
	public ForexRates(Timestamp timestamp)
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
		return "ForexRates [timestamp=" + timestamp + "]";
	}

	
}
