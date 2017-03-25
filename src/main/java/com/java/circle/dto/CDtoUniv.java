package com.java.circle.dto;

public class CDtoUniv {
	int univ_id;
	String name;
	
	public CDtoUniv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CDtoUniv(int univ_id, String name) {
		super();
		this.univ_id = univ_id;
		this.name = name;
	}

	public int getUniv_id() {
		return univ_id;
	}

	public void setUniv_id(int univ_id) {
		this.univ_id = univ_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
