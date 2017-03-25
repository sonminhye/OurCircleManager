package com.java.circle.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUniv;
import com.java.circle.dto.CDtoUser;


public interface UserMapper {
	public ArrayList<CDtoUser> showList();
	public void doSignup(HashMap<String, String> param);
	public int checkSignup(String account);//회원가입시 아이디 중복체크
//	public ArrayList<CDtoCircle> showMyCircle(String account);//해당 account가 가입한 동아리 리스트
	public ArrayList<CDtoCircle> showUnivCircle(String account);//해당 account가 속한 학교에 있는 동아리 목록

}
