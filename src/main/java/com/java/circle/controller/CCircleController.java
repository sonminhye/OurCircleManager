package com.java.circle.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.circle.command.CAccountUnivInfoCommand;
import com.java.circle.command.CAddcircleCheckCommand;
import com.java.circle.command.CAddcircleCommand;
import com.java.circle.command.CCommand;

import com.java.circle.command.CGetCircleInfoCommand;
import com.java.circle.command.CUserAuthCheckCommand;

@Controller
public class CCircleController {
	CCommand command = null;
	
	@RequestMapping(value = "/addcircle_view", method = RequestMethod.GET)
	public String goAddCircle(Model model){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("유저이름 = " + user.getUsername());

		model.addAttribute("account", user.getUsername());
		
		command = new CAccountUnivInfoCommand(); 
		command.execute(model);
		
		return "addcircle_view";
	}
	
	
	//동아리 만들 떄 이름 중복체크
	@RequestMapping(value="/check_addcircle",method=RequestMethod.POST)
	@ResponseBody
	public String checkSignup(HttpServletRequest request, Model model){
		
		System.out.println("checkAddCircle()");

		String name = request.getParameter("name");
		//request 의 값을 model 에 추가해주기
		model.addAttribute("name", name);
		
		command = new CAddcircleCheckCommand();
		command.execute(model);	
		
		return model.asMap().get("check").toString();
	}
	
	
	@RequestMapping(value ="/addcircle", method = RequestMethod.POST)
	public String doSignup(HttpServletRequest request, Model model){
		
		System.out.println("doAddCircle()");
		
		model.addAttribute("request", request);
		command = new CAddcircleCommand();
		command.execute(model);
		//to do:동아리 만듦과 동시에 해당 유저도 가입되게 해야함(cUser_Circle테이블에 추가해야함)
		String uri = "redirect:/circle_main?circle_id=" + model.asMap().get("circle_id").toString();
		System.out.println(uri);
		
		return uri; //to do:해당 동아리의 메인으로 가게 
	
	}
	
	
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
