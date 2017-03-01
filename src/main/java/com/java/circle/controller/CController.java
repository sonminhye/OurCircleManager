package com.java.circle.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.circle.command.CCommand;
import com.java.circle.command.CListCommand;
import com.java.circle.command.CSignupCommand;

@Controller
public class CController {
	CCommand command = null;

	@RequestMapping("/main")
	public String showMain(){
		return "main";
	}

	@RequestMapping("/signin_view")
	public String showSignin(){
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
}
