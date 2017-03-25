package com.java.circle.dao;

import java.util.HashMap;

import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUserCircle;

public interface CircleManageMapper {

	public CDtoCircle showCircle(String circle_id);
	public CDtoUserCircle showMyAuthInThisCircle(HashMap<String, String> param);
}
