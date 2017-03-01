package com.java.circle.dto;

public class CDtoCircle {
	int circle_id;
	String name;
	int membercount;
	
	public CDtoCircle(int circle_id, String name, int membercount, int univ_id) {
		super();
		this.circle_id = circle_id;
		this.name = name;
		this.membercount = membercount;
		this.univ_id = univ_id;
	}
	
	public int getCircle_id() {
		return circle_id;
	}
	public void setCircle_id(int circle_id) {
		this.circle_id = circle_id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getMembercount() {
		return membercount;
	}
	public void setMembercount(int membercount) {
		this.membercount = membercount;
	}
	public int getUniv_id() {
		return univ_id;
	}
	public void setUniv_id(int univ_id) {
		this.univ_id = univ_id;
	}
	int univ_id;
}
