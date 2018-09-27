package com.beans;

public class User {
	
	private int userID;
	private String username;
	public static String staticUsername="John_123";
	private String password;
	private String name;
	private String emailID;
	private Long contactInfo;
	
	public User() {
		//userID=1001;
		username="admin";
		name="Citicorp India";
		password="admin123";
		emailID="citicorp@citi.com";
		contactInfo=9999999999l;
	}

	public User(String username, String name,String password, String emailID, Long contactInfo) {
		super();
		
		this.username = username;
		this.password = password;
		this.name = name;
		this.emailID = emailID;
		this.contactInfo = contactInfo;
	}
	
	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Long getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(Long contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", emailID=" + emailID
				+ ", contactInfo=" + contactInfo + "]";
	}
	
	

}
