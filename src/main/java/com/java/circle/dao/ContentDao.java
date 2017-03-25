package com.java.circle.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.java.circle.dto.CDtoUser;

public class ContentDao{
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public ContentDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<CDtoUser> showList() {
		String query = "select * from board order by mId desc";
		ArrayList<CDtoUser> dtos = (ArrayList<CDtoUser>) template.query(query, new BeanPropertyRowMapper<CDtoUser>(CDtoUser.class));
		return dtos;
	}
	
}
