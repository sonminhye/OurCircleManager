package com.java.circle.command;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;
import com.java.circle.dto.CDtoCircle;

public class CCircleCheckCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap(); 
		String account = map.get("account").toString();
		
		CDao dao = new CDao();
		ArrayList<CDtoCircle> dtos = dao.showCircle(account);
		
		model.addAttribute("circleList", dtos);
	}

}
