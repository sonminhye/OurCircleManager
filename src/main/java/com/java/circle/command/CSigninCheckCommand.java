package com.java.circle.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;

public class CSigninCheckCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap(); 
		Map<String,Object> dataMap =  (Map<String, Object>) map.get("param"); //param의 값을 가져온다
		
		String account = dataMap.get("account").toString();
		String password = dataMap.get("password").toString();
		
		CDao dao = new CDao();
		int n = dao.checkSignin(account, password);
		
		model.addAttribute("check", n);
	}

}
