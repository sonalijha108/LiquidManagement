package com.beans;

public class CashFlow {

	private String customerID;
	private String tradeID;
	private String currency;
	private double amount;
	private boolean buysell;
	
	public CashFlow() 
	{
		customerID = "ABC";
		tradeID = "XYZ";
		currency = "USD";
		amount = 500.00;
		buysell = true;
	}
	
	public CashFlow(String customerID, String tradeID, String currency, double amount, boolean buysell) 
	{
		this.customerID = customerID;
		this.tradeID = tradeID;
		this.currency = currency;
		this.amount = amount;
		this.buysell = buysell;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public String getTradeID() {
		return tradeID;
	}
	
	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public boolean isBuysell() {
		return buysell;
	}
	
	public void setBuysell(boolean buysell) {
		this.buysell = buysell;
	}

	@Override
	public String toString() {
		return "CashFlow [customerID=" + customerID + ", tradeID=" + tradeID + ", currency=" + currency + ", amount="
				+ amount + ", buysell=" + buysell + "]";
	}
	
}
