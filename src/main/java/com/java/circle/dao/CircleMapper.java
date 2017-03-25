package com.java.circle.dao;

import java.util.HashMap;

import com.java.circle.dto.CDtoUniv;

public interface CircleMapper {
	
	public CDtoUniv showUnivInfo(String account); //내가 속한 학교 정보 가져오기
	public int addCircle(HashMap<String,Object> param); //새로운 동아리 추가
	public int checkAddcircle(String name); //동아리만들때 이름 중복 체크

}
