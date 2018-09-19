package com.services;

import java.util.List;
import com.beans.*;

public interface Service {
	User loginUser(String user, String password);
	boolean isUserAdded(User user);
	boolean addRandomCashflow(List<CashFlow> cashflow);
}
