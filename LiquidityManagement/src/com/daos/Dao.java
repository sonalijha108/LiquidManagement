package com.daos;

import com.beans.User;

public interface Dao {
	User LoginDao(String userName,String password);

}
