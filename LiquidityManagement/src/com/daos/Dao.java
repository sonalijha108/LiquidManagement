package com.daos;

import com.beans.User;

public interface Dao {
	User LoginDao(String userName,String password);
	int addUser(User user);
	int addRandomCashflowDao(List<CashFlow> cashflow);
}
