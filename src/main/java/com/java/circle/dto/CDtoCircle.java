package com.java.circle.dto;

public class CDtoCircle {
	int circle_id;
	String name;
	int membercount;
	int univ_id;
	int circle_category_id;
	String intro;
	String image;
	
	

	public CDtoCircle(int circle_id, String name, int membercount, int univ_id, int circle_category_id, String intro,
			String image) {
		super();
		this.circle_id = circle_id;
		this.name = name;
		this.membercount = membercount;
		this.univ_id = univ_id;
		this.circle_category_id = circle_category_id;
		this.intro = intro;
		this.image = image;
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
	public void setCircle_category_id(int circle_category_id){
		this.circle_category_id = circle_category_id;
	}
	public int getCircle_category_id(){
		return circle_category_id;
	}
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
