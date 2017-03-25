package com.java.circle.dao;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.circle.dto.CDtoUniv;

@Repository
public class CircleService implements CircleMapper{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addCircle(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		CircleMapper dao = sqlSession.getMapper(CircleMapper.class);
		int result = dao.addCircle(param);
		System.out.println(result);
		return result;
	}

	@Override
	public int checkAddcircle(String name) {
		// TODO Auto-generated method stub
		CircleMapper dao = sqlSession.getMapper(CircleMapper.class);
		int result = dao.checkAddcircle(name);
		return result;
	}

	@Override
	public CDtoUniv showUnivInfo(String account) {
		// TODO Auto-generated method stub
		CircleMapper dao = sqlSession.getMapper(CircleMapper.class);
		CDtoUniv result = dao.showUnivInfo(account);
		return result;
	}

	
}
