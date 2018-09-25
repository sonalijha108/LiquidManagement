package com.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CashFlow {

	public static List<CashFlow> cashFlows=new ArrayList<>();
	public int tradeID;
	private int clientID;
	private String currency;
	private String inout;
	private double amount;
	private Timestamp timestamp;
	
	public CashFlow() 
	{
		clientID = 1001;
		currency = "USD";
		amount = 500.00;
		inout = "IN";
	}
	
	public CashFlow(int tradeID,int clientID, String currency, String inout, double amount, Timestamp timestamp) 
	{
		this.tradeID = tradeID;
		this.clientID = clientID;
		this.currency = currency;
		this.amount = amount;
		this.inout = inout;
		this.timestamp = timestamp;
	}

	public int getTradeID() {
		return tradeID;
	}

	public void setTradeID(int tradeID) {
		this.tradeID = tradeID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int i) {
		this.clientID = i;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInout() {
		return inout;
	}

	public void setInout(String inout) {
		this.inout = inout;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CashFlow [tradeID=" + tradeID + ", clientID=" + clientID + ", currency=" + currency + ", inout=" + inout
				+ ", amount=" + amount + ", timestamp=" + timestamp + "]";
	}
	
	
}
