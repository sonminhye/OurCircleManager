package com.java.circle.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.circle.command.CCommand;
import com.java.circle.command.CListCommand;

@Controller
public class CController {
	CCommand command = null;
	

	@RequestMapping("/signin_view")
	public String goSignin(){
		return "signin_view";
	}

	@RequestMapping(value = "/signup_view")
	public String signup(Locale locale, Model model) {
		return "signup_view";
	}
	
	@RequestMapping("/user_list")
	public String list(Model model) {
		System.out.println("list()");
		
		command = new CListCommand();
		command.execute(model);
		
		return "user_list";
	}
}
