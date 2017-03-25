package com.java.circle.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUserCircle;

@Repository
public class CircleManageService implements CircleManageMapper{

	
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public CDtoCircle showCircle(String circle_id) {
		// TODO Auto-generated method stub
		
		CDtoCircle result = new CDtoCircle();
		CircleManageMapper dao = sqlSession.getMapper(CircleManageMapper.class);
		result = dao.showCircle(circle_id);
		
		return result;
	}

	@Override
	public CDtoUserCircle showMyAuthInThisCircle(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		
		CDtoUserCircle result = new CDtoUserCircle();
		
		
		CircleManageMapper dao = sqlSession.getMapper(CircleManageMapper.class);
		result = dao.showMyAuthInThisCircle(param);
		
		return result;
	}

}
