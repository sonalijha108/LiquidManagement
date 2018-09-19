package com.daos;

import java.util.List;
import com.beans.*;

public interface Dao {
	User LoginDao(String userName,String password);
	int addUser(User user);
	int addRandomCashflowDao(List<CashFlow> cashflow);
}
