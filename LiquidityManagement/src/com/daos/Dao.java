package com.daos;



import java.util.List;

import com.beans.AccountData;
import com.beans.CashFlow;
import com.beans.ForexRates;
import com.beans.MarketRates;
import com.beans.User;

public interface Dao {
	AccountData LoginDao(String userName,String password);
	int addUser(AccountData user);
	AccountData getCurrentBalance();
	int addCashflowDao();
	int addMarketRatesDao(int rowsAdded);
	int addForexRatesDao(int rowsAdded);}
