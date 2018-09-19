package com.beans;

import java.sql.Timestamp;
import java.util.Calendar;

public class CashFlow {

	public String tradeID;
	private String clientName;
	private String clientID;
	private String currency;
	private String inout;
	private double amount;
	private Timestamp timestamp;
	
	public CashFlow() 
	{
		tradeID = "1234";
		clientName = "Apple";
		clientID = "AM776";
		currency = "USD";
		amount = 500.00;
		inout = "IN";
	}
	
	public CashFlow(String tradeID, String clientName,String clientID, String currency, String inout, double amount, Timestamp timestamp) 
	{
		this.tradeID = tradeID;
		this.clientName = clientName;
		this.clientID = clientID;
		this.currency = currency;
		this.amount = amount;
		this.inout = inout;
		this.timestamp = timestamp;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
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
		return "CashFlow [tradeID=" + tradeID + ", clientName=" + clientName + ", clientID=" + clientID + ", currency="
				+ currency + ", inout=" + inout + ", amount=" + amount + "]";
	}
	
	
}
