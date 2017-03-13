package com.java.circle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("circle")
@Controller
public class CCircleController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showMain(){
		return "circle/main";
	}
}
