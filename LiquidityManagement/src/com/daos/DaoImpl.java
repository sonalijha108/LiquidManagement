package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import com.beans.AccountData;
import com.beans.CashFlow;
import com.beans.ForexRates;
import com.beans.MarketRates;
import com.beans.User;
import com.connection.MyConnection;
import com.utilities.RandCashFlowGenerator;

public class DaoImpl implements Dao{

	@Override
	public AccountData LoginDao(String userName, String password) {
		AccountData user=new AccountData();
		System.out.println("here");
		Connection conn=MyConnection.openConnection();
		System.out.println("there");
		String getUser="select * from USERS where USERNAME=?";
		try {
			PreparedStatement pstatement=conn.prepareStatement(getUser);
			pstatement.setString(1, userName);
			ResultSet set=pstatement.executeQuery();
			while(set.next()) {
			user.setUsername(set.getString(2));
			user.setName(set.getString(3));
			user.setPassword(set.getString(4));
			user.setEmailID((set.getString(5)));
			user.setContactInfo(set.getLong(6));
			user.setUSD_NotionalBalance(set.getDouble(7));
			user.setEUR_NotionalBalance(set.getDouble(8));
			user.setGBP_NotionalBalance(set.getDouble(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int addUser(AccountData user) {
		int rowsAdded=0;
		System.out.println("here");
		Connection conn=MyConnection.openConnection();
		System.out.println("there");
		String addUsers="insert into USERS values(?,?,?,?,?,?,?,?)";
		try {
			
				PreparedStatement pstatement=conn.prepareStatement(addUsers);
				pstatement.setString(1, user.getUsername());
				pstatement.setString(2, user.getName());
				pstatement.setString(3, user.getPassword());
				pstatement.setString(4, user.getEmailID());
				pstatement.setLong(5, user.getContactInfo());
				pstatement.setDouble(6, user.getUSD_NotionalBalance());
				pstatement.setDouble(7, user.getEUR_NotionalBalance());
				pstatement.setDouble(8, user.getGBP_NotionalBalance());

				rowsAdded=pstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}
	
	@Override
	public int addCashflowDao(List<CashFlow> cashflows)
	{
		
		int NoOfCashFlows = cashflows.size();
		int rowsAdded=0;
		Connection conn=MyConnection.openConnection();
		for(int i=0;i<NoOfCashFlows;i++)
		{
			String addCashFlow="insert into CASHFLOW values(?,?,?,?,?)";
			try {
					PreparedStatement pstatement=conn.prepareStatement(addCashFlow);
					//pstatement.setInt(1, CashFlow.cashFlows.get(i).getTradeID());
					//pstatement.setString(2, CashFlow.cashFlows.get(i).getClientName());
					pstatement.setInt(1, cashflows.get(i).getClientID());
					pstatement.setString(2, cashflows.get(i).getCurrency());
					pstatement.setString(3,cashflows.get(i).getInout());
					pstatement.setDouble(4, cashflows.get(i).getAmount());
					pstatement.setTimestamp(5, cashflows.get(i).getTimestamp());
					rowsAdded += pstatement.executeUpdate();
					
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rowsAdded;
	}

	@Override
	public int addMarketRatesDao(int rowsAdded) 
	{
		Connection conn=MyConnection.openConnection();
		String addMarketRates="insert into MARKET_RATES values(?,?,?,?)";
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
			try {
					PreparedStatement pstatement=conn.prepareStatement(addMarketRates);
					pstatement.setDouble(1, MarketRates.USDMarketRate);
					pstatement.setDouble(2, MarketRates.EURMarketRate);
					pstatement.setDouble(3, MarketRates.GBPMarketRate);
					pstatement.setTimestamp(4, currentTimestamp);
					rowsAdded += pstatement.executeUpdate();
					
				} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return rowsAdded;
	}

	@Override
	public int addForexRatesDao(int rowsAdded) 
	{
		Connection conn=MyConnection.openConnection();
		String addMarketRates="insert into FOREX_RATES values(?,?,?,?)";
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
			try {
					PreparedStatement pstatement=conn.prepareStatement(addMarketRates);
					pstatement.setDouble(1, ForexRates.EURUSDRate);
					pstatement.setDouble(2, ForexRates.EURGBPRate);
					pstatement.setDouble(3, ForexRates.GBPUSDRate);
					pstatement.setTimestamp(4, currentTimestamp);
					rowsAdded += pstatement.executeUpdate();
					
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return rowsAdded;
	}
	@Override
	public AccountData getCurrentBalance() {
		AccountData accountData=new AccountData("John_123", "John123", "John", "john@citi.com", 7865456732l, 0,0,0);
		System.out.println("herehere");
		
		double inflowOutflowDifference_USD=0.0;
		double inflowOutflowDifference_EUR=0.0;
		double inflowOutflowDifference_GBP=0.0;
		Connection conn=MyConnection.openConnection();
		String getInflow=" select cashflow.CURRENCY, sum(Cashflow.AMOUNT) from Cashflow join Users on Cashflow.Client_ID=Users.User_ID where Cashflow.Inout='IN' and Users.Username=? group by Cashflow.Currency";
		String getOutflow="select cashflow.currency, sum(Cashflow.Amount) from Cashflow join Users on Cashflow.Client_ID=Users.User_ID where Cashflow.Inout='OUT' and Users.Username=? group by Cashflow.Currency";
		String getInitialBalance="select Notional_GBP, Notional_EUR, Notional_USD from Users where Username=?";
		try {
			PreparedStatement statement;
			statement=conn.prepareStatement(getInflow);
			statement.setString(1, User.staticUsername);
			System.out.println(statement);
			ResultSet set=statement.executeQuery();
			while(set.next()) {
				if((set.getString(1)).equals("USD")) {
					inflowOutflowDifference_USD=set.getDouble(2);
					System.out.println("USD Inflow total"+inflowOutflowDifference_USD);
				}
				else if((set.getString(1)).equals("GBP")) {
					inflowOutflowDifference_GBP=set.getDouble(2);
					System.out.println("GBP Inflow total"+inflowOutflowDifference_GBP);
				}
				else if((set.getString(1)).equals("EUR")) {
					inflowOutflowDifference_EUR=set.getDouble(2);
					System.out.println("EUR Inflow total"+inflowOutflowDifference_EUR);

				}
			}
			
			statement=conn.prepareStatement(getOutflow);
			statement.setString(1, User.staticUsername);
			System.out.println(statement);
			ResultSet set1=statement.executeQuery();
			while(set1.next()) {
				if((set1.getString(1)).equals("USD")) {
					System.out.println("USD Outflow total: "+set1.getDouble(2));
					inflowOutflowDifference_USD=inflowOutflowDifference_USD-set1.getDouble(2);
					
					System.out.println("USD Notional balance final"+inflowOutflowDifference_USD);
				}
				else if((set1.getString(1)).equals("GBP")) {
					System.out.println("GBP Outflow total: "+set1.getDouble(2));
					inflowOutflowDifference_GBP=inflowOutflowDifference_GBP-set1.getDouble(2);
					
					System.out.println("GBP Notional balance final"+inflowOutflowDifference_GBP);
				}
				else if((set1.getString(1)).equals("EUR")) {
					System.out.println("EUR Outflow total: "+set1.getDouble(2));
					inflowOutflowDifference_EUR=inflowOutflowDifference_EUR-set1.getDouble(2);
					
					System.out.println("EUR Notional balance final"+inflowOutflowDifference_EUR);
				}
			}
			System.out.println("EUR Difference"+inflowOutflowDifference_EUR);
			statement=conn.prepareStatement(getInitialBalance);
			statement.setString(1, User.staticUsername);
			System.out.println(statement);
			ResultSet set2=statement.executeQuery();
			while(set2.next()) {
				accountData.setGBP_NotionalBalance(set2.getDouble(1)+inflowOutflowDifference_GBP);
				accountData.setEUR_NotionalBalance(set2.getDouble(2)+inflowOutflowDifference_EUR);
				accountData.setUSD_NotionalBalance(set2.getDouble(3)+inflowOutflowDifference_USD);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("acountdata"+accountData);
		return accountData;
		
	}
	
	

}
