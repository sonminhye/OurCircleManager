package com.java.circle.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;

public class CSignupCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		if(request.equals(null))
			System.out.println("request is null");
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("account", request.getParameter("account"));
		param.put("password", request.getParameter("password"));
		param.put("name", request.getParameter("name"));
		param.put("auth", request.getParameter("auth"));
		param.put("univ", request.getParameter("univ"));
		
		CDao dao = new CDao();
		
		dao.signup(param);
		
	}

}
