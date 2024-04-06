package com.ECommerce.ScratchCard.Entity;

public class User {
	
	private int ID;
	private String userID;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String password;
    
    
	public User(int iD, String userID, String firstName, String lastName, boolean isActive, String password) {
		super();
		ID = iD;
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
		this.password = password;
	}
	
    
    public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
		
}
