package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.User;
import com.connection.MyConnection;

public class DaoImpl implements Dao{

	@Override
	public User LoginDao(String userName, String password) {
		User user=new User();
		System.out.println("here");
		Connection conn=MyConnection.openConnection();
		System.out.println("there");
		String getUser="select * from USERS where USERNAME=?";
		try {
			PreparedStatement pstatement=conn.prepareStatement(getUser);
			pstatement.setString(1, userName);
			ResultSet set=pstatement.executeQuery();
			while(set.next()) {
			user.setUsername(set.getString(1));
			user.setName(set.getString(2));
			user.setPassword(set.getString(3));
			user.setEmailID((set.getString(4)));
			user.setContactInfo(set.getInt(5));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		int rowsAdded=0;
		System.out.println("here");
		Connection conn=MyConnection.openConnection();
		System.out.println("there");
		String addUsers="insert into USERS values(?,?,?,?,?)";
		try {
			
				PreparedStatement pstatement=conn.prepareStatement(addUsers);
				pstatement.setString(1, user.getUsername());
				pstatement.setString(2, user.getName());
				pstatement.setString(3, user.getPassword());
				pstatement.setString(4, user.getEmailID());
				pstatement.setInt(5, user.getContactInfo());
				rowsAdded=pstatement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

}
