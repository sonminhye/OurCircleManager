package com.java.circle.dto;

public class CDto {
	
	int user_id;
	String account;
	String password;
	String name;
	int auth_id;
	int univ_id;
	
	public CDto(int user_id, String account, String password, String name, int auth_id, int univ_id) {
		super();
		this.user_id = user_id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.auth_id = auth_id;
		this.univ_id = univ_id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public int getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}
	public int getUniv_id() {
		return univ_id;
	}
	public void setUniv_id(int univ_id) {
		this.univ_id = univ_id;
	}
	
}
