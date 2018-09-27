package com.beans;

public class AccountData extends User{
	
	private double USD_NotionalBalance;
	private double GBP_NotionalBalance;
	private double EUR_NotionalBalance;
	
	public AccountData( String username,  String password,String name, String emailID, Long contactInfo,double uSD_NotionalBalance,double eUR_NotionalBalance, double gBP_NotionalBalance) {
		super(username, name, password, emailID, contactInfo);
		USD_NotionalBalance = uSD_NotionalBalance;
		GBP_NotionalBalance = gBP_NotionalBalance;
		EUR_NotionalBalance = eUR_NotionalBalance;
	}
	public AccountData() {
	}
	@Override
	public String toString() {
		return "AccountData [USD_NotionalBalance=" + USD_NotionalBalance + ", GBP_NotionalBalance=" + GBP_NotionalBalance + ", EUR_NotionalBalance="
				+ EUR_NotionalBalance + ", toString()=" + super.toString() + "]";
	}

	public double getUSD_NotionalBalance() {
		return USD_NotionalBalance;
	}
	public void setUSD_NotionalBalance(double uSD_NotionalBalance) {
		USD_NotionalBalance = uSD_NotionalBalance;
	}
	public double getGBP_NotionalBalance() {
		return GBP_NotionalBalance;
	}
	public void setGBP_NotionalBalance(double gBP_NotionalBalance) {
		GBP_NotionalBalance = gBP_NotionalBalance;
	}
	public double getEUR_NotionalBalance() {
		return EUR_NotionalBalance;
	}
	public void setEUR_NotionalBalance(double eUR_NotionalBalance) {
		EUR_NotionalBalance = eUR_NotionalBalance;
	}
}
