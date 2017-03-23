package com.java.circle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.circle.command.CGetCircleInfoCommand;
import com.java.circle.command.CUserAuthCheckCommand;

@Controller
public class CCircleController {
	
	@RequestMapping(value = "/circle_main", method = RequestMethod.GET)
	public String showMain(Model model, HttpServletRequest request){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String account = authentication.getName();
		
		model.addAttribute("circle_id",request.getParameter("circle_id")); 
		model.addAttribute("account", account);
		
		CGetCircleInfoCommand command = new CGetCircleInfoCommand();		//동아리 메인 페이지 정보들 가져오기
		command.execute(model);
		
		CUserAuthCheckCommand command2 = new CUserAuthCheckCommand();      //이 동아리 내에서의 나의 권한 가져오기.
		command2.execute(model);
		
		return "circle_main";
	}
}
