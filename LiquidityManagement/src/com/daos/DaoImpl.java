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
	public int addCashflowDao()
	{
		RandCashFlowGenerator r = new RandCashFlowGenerator(30, 100, 1000);
		CashFlow.cashFlows = r.GenerateRandomCashFlow();
		int NoOfCashFlows = CashFlow.cashFlows.size();
		int rowsAdded=0;
		Connection conn=MyConnection.openConnection();
		for(int i=0;i<NoOfCashFlows;i++)
		{
			String addCashFlow="insert into CASHFLOW values(?,?,?,?,?)";
			try {
					PreparedStatement pstatement=conn.prepareStatement(addCashFlow);
					//pstatement.setInt(1, CashFlow.cashFlows.get(i).getTradeID());
					//pstatement.setString(2, CashFlow.cashFlows.get(i).getClientName());
					pstatement.setInt(1, CashFlow.cashFlows.get(i).getClientID());
					pstatement.setString(2, CashFlow.cashFlows.get(i).getCurrency());
					pstatement.setString(3, CashFlow.cashFlows.get(i).getInout());
					pstatement.setDouble(4, CashFlow.cashFlows.get(i).getAmount());
					pstatement.setTimestamp(5, CashFlow.cashFlows.get(i).getTimestamp());
					rowsAdded += pstatement.executeUpdate();
					
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		CashFlow.cashFlows=null;
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
				// TODO Auto-generated catch block
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
		AccountData accountData=new AccountData(0, 0, 0, null, null, null, null, null);
		double inflowOutflowDifference_USD=0.0;
		double inflowOutflowDifference_EUR=0.0;
		double inflowOutflowDifference_GBP=0.0;
		/*Connection conn=MyConnection.openConnection();
		String getInflow="select Cashflows.Currency, sum(Cashflows.Amount) from Cashflows join Users on Cashflows.Client_ID=Users.Client_ID where Cashflows.Inflow_outflow='IN' && Clients.Username=? group by Currency";
		String getOutflow="select Cashflows.Currency, sum(Cashflows.Amount) from Cashflows join Users on Cashflows.Client_ID=Users.Client_ID where Cashflows.Inflow_outflow='OUT' && Clients.Username=? group by Currency";
		String getInitialBalance="select Notional_GBP, Notional_EUR, Notional_USD from Clients where Client_ID=?";
		try {
			PreparedStatement statement;
			statement=conn.prepareStatement(getInflow);
			statement.setString(1, User.staticUsername);
			ResultSet set=statement.executeQuery();
			while(set.next()) {
				if((set.getString(1)).equals("USD"))
					inflowOutflowDifference_USD=set.getDouble(2);
				else if((set.getString(1)).equals("GBP"))
					inflowOutflowDifference_GBP=set.getDouble(2);
				else if((set.getString(1)).equals("EUR"))
					inflowOutflowDifference_EUR=set.getDouble(2);
			}
			statement=conn.prepareStatement(getOutflow);
			statement.setString(1, User.staticUsername);
			ResultSet set1=statement.executeQuery();
			while(set1.next()) {
				if((set1.getString(1)).equals("USD"))
					inflowOutflowDifference_USD-=set1.getDouble(2);
				else if((set1.getString(1)).equals("GBP"))
					inflowOutflowDifference_USD-=set1.getDouble(2);
				else if((set1.getString(1)).equals("EUR"))
					inflowOutflowDifference_USD-=set1.getDouble(2);
			}
			statement=conn.prepareStatement(getInitialBalance);
			statement.setString(1, User.staticUsername);
			ResultSet set2=statement.executeQuery();
			while(set2.next()) {
				accountData.setGBP_current(set2.getDouble(1)+inflowOutflowDifference_GBP);
				accountData.setEUR_current(set2.getDouble(2)+inflowOutflowDifference_EUR);
				accountData.setUSD_current(set2.getDouble(3)+inflowOutflowDifference_USD);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return (new AccountData(300.00, 300.80, 400.80, "citi", "CITI", "citi123", "citi@citi.com", 9999999999L));
		
	}
	
	

}
