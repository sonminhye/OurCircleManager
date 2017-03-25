package com.java.circle.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUniv;

public class UserService implements UserMapper{
	public void signup(HashMap<String,String> param){
		
	}
	
	//회원가입시 아이디 중복체크
	public int checkSignup(String account){
		
	}
	
	//해당 account가 가입한 동아리 리스트
	public ArrayList<CDtoCircle> showMyCircle(String account){
		
	}
	
	//해당 account가 속한 학교에 있는 동아리 목록
	public ArrayList<CDtoCircle> showUnivCircle(String account){
		
	}
	
	//해당 account가 속한 학교 정보
	public CDtoUniv showUnivInfo(String account){
		
	}
}
