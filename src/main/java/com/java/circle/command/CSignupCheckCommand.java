package com.java.circle.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;

public class CSignupCheckCommand implements CCommand{
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap(); 
		Map<String,Object> dataMap =  (Map<String, Object>) map.get("account"); //param의 값을 가져온다
		
		String account = dataMap.get("account").toString();
		
		CDao dao = new CDao();
		int n = dao.checkSignup(account);
		
		model.addAttribute("check", n);
	}

}
