package com.java.circle;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.circle.command.CCommand;
import com.java.circle.command.CListCommand;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
<<<<<<< HEAD
||||||| merged common ancestors
	

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

=======
	

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
*/
}
