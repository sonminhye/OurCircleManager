package com.java.circle.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.circle.command.CCircleCheckCommand;
import com.java.circle.command.CCommand;
import com.java.circle.command.CListCommand;
import com.java.circle.command.CSigninCheckCommand;
import com.java.circle.command.CSignupCommand;

@Controller
public class CController {
	CCommand command = null;


	@RequestMapping("/signin_view")
	public String goSignin(){
		return "signin_view";
	}

	@RequestMapping(value = "/signup_view")
	public String showSignup(Locale locale, Model model) {
		return "signup_view";
	}
	
	@RequestMapping("/user_list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new CListCommand();
		command.execute(model);
		
		return "user_list";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignup(HttpServletRequest request, Model model){
		
		System.out.println("doSignup()");
		
		model.addAttribute("request", request);
		command = new CSignupCommand();
		command.execute(model);
		
		return "signin_view";
	}
	
	
	@RequestMapping(value="/signin_check",method=RequestMethod.POST)
	@ResponseBody
	public String checkSignin(@RequestBody HashMap<String,Object> param, Model model){
		
		System.out.println("checkSignin()");
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		//request 의 값을 model 에 추가해주기
		model.addAttribute("param", param);
		command = new CSigninCheckCommand();
		command.execute(model);
		
		return model.asMap().get("check").toString();
	}
	
	@RequestMapping(value="/check_circle",method=RequestMethod.POST)
	@ResponseBody
	public String checkCircle(@RequestBody HashMap<String,Object> param, Model model){
		
		System.out.println("checkCircle()");
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		//request 의 값을 model 에 추가해주기
		model.addAttribute("param", param);
		command = new CCircleCheckCommand();
		command.execute(model);
		
		if(model.asMap().get("circle").toString().equals("[]")) //동아리 정보가 없다는 뜻
			return "nocircle_view";
		else
			return "circle_view";
	
	}
	
	@RequestMapping("/nocircle_view")
	public String goNocircle(){
		return "nocircle_view";
	}
	
	@RequestMapping("/circle_view")
	public String goCircle(){
		return "circle_view";
	}
	
}
