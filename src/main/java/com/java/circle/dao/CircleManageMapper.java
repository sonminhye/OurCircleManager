package com.java.circle.dao;

import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUserCircle;

public interface CircleManageMapper {

	public CDtoCircle showCircle(String circle_id);
	public CDtoUserCircle showMyAuthInThisCircle(String account, String circle_id);
}
