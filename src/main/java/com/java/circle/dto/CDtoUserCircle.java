package com.java.circle.dto;

public class CDtoUserCircle {
	
	int circle_id;
	String account;
	String auth;
	
	public CDtoUserCircle(int circle_id, String account, String auth) {
		super();
		this.circle_id = circle_id;
		this.account = account;
		this.auth = auth;
	}
	public int getCircle_id() {
		return circle_id;
	}
	public void setCircle_id(int circle_id) {
		this.circle_id = circle_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	
	
}
