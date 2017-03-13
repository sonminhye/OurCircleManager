package com.java.circle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CCircleController {
	
	@RequestMapping(value = "/circle_main", method = RequestMethod.GET)
	public String showMain(){
		return "circle_main";
	}
}
