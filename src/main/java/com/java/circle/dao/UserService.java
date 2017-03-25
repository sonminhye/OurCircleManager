package com.java.circle.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUniv;
import com.java.circle.dto.CDtoUser;

@Repository
public class UserService implements UserMapper{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<CDtoUser> showList(){
		ArrayList<CDtoUser> result = new ArrayList<CDtoUser>();
		//sqlSession을 통하여 매핑
		UserMapper dao = sqlSession.getMapper(UserMapper.class);
		
		//dao의 메소드명은 UserMapper.xml 의 id와 동일해야함
		result = dao.showList();
		
		return result;
	}
	
	
	@Override
	public ArrayList<CDtoUniv> showUnivList(){
		ArrayList<CDtoUniv> result = new ArrayList<CDtoUniv>();
		UserMapper dao = sqlSession.getMapper(UserMapper.class);
		
		result = dao.showUnivList();
		return result;
		
	}
	
	@Override
	public void doSignup(HashMap<String, String> param){
		UserMapper dao = sqlSession.getMapper(UserMapper.class);
		dao.doSignup(param);
	}
	
	//회원가입시 아이디 중복체크
	@Override
	public int checkSignup(String account){
		UserMapper dao = sqlSession.getMapper(UserMapper.class);
		int rowcount = dao.checkSignup(account);
		
		return rowcount;
	}
	
	//해당 account가 가입한 동아리 리스트
	@Override
	public ArrayList<CDtoCircle> showMyCircle(String account){
		ArrayList<CDtoCircle> result = new ArrayList<CDtoCircle>();
		UserMapper dao = sqlSession.getMapper(UserMapper.class);

		result = dao.showMyCircle(account);
		return result;
	}
	
	//해당 account가 속한 학교에 있는 동아리 목록
	@Override
	public ArrayList<CDtoCircle> showUnivCircle(String account){
		ArrayList<CDtoCircle> result = new ArrayList<CDtoCircle>();
		UserMapper dao = sqlSession.getMapper(UserMapper.class);

		result = dao.showUnivCircle(account);
		return result;
	}
	

}
