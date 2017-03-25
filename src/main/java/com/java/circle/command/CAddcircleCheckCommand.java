package com.java.circle.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;

public class CAddcircleCheckCommand implements CCommand{
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		/*
		Map<String, Object> map = model.asMap(); 
		//Map<String,Object> dataMap =  (Map<String, Object>) map.get("account"); //param의 값을 가져온다
		
		System.out.println("addcircleCheck()");

		String name = map.get("name").toString();
		
		CDao dao = new CDao();
		int n = dao.checkAddcircle(name);
		
		model.addAttribute("check", n);
		*/
	}

}
