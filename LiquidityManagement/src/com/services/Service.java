package com.services;

import com.beans.AccountData;
import com.beans.User;

public interface Service {
	User loginUser(String user, String password);
	boolean isUserAdded(User user);
	AccountData getCurrentBalanceService();
	public boolean isUserAdded(AccountData user);
}
