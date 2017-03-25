package com.java.circle.command;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;
import com.java.circle.dto.CDtoCircle;

public class CGetCircleInfoCommand implements CCommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		/*
		CDao dao = new CDao();
		
		String circleid = model.asMap().get("circle_id").toString();
		
		CDtoCircle dto = dao.showCircle(circleid);
		
		model.addAttribute("dto", dto);
		*/
	}

}
