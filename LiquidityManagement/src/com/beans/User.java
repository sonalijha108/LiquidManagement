package com.beans;

public class User {
	private String username;
	private String password;
	private String name;
	private String emailID;
	private int contactInfo;
	
	public User() {
		username="admin";
		name="Citicorp India";
		password="admin123";
		emailID="citicorp@citi.com";
		contactInfo=99999999;
	}

	public User(String username, String name,String password, String emailID, int contactInfo) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.emailID = emailID;
		this.contactInfo = contactInfo;
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

	public int getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(int contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", emailID=" + emailID
				+ ", contactInfo=" + contactInfo + "]";
	}
	
	

}
