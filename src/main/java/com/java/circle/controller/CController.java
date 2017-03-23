package com.java.circle.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.circle.command.CCircleCheckCommand;
import com.java.circle.command.CCommand;
import com.java.circle.command.CListCommand;
import com.java.circle.command.CSignupCheckCommand;
import com.java.circle.command.CSignupCommand;
import com.java.circle.command.CUnivCircleListCommand;

@Controller
public class CController {
	CCommand command = null;
	Model myModel = null;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showMain(){
		return "main";
	}

	@RequestMapping(value = "/signin_view", method = RequestMethod.GET)
	public String showSignin(){		
		return "signin_view";
	}
	
	@RequestMapping(value = "/signin_view", method = RequestMethod.POST)
	public String showSigninPost(){		
		System.out.println("여기는 signin post 버전");
		return "signin_view";
	}

	@RequestMapping(value = "/signup_view", method = RequestMethod.GET)
	public String showSignup(Locale locale, Model model) {
		return "signup_view";
	}
	
	//TEST용
	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public String list(Model model) {
		System.out.println("list()");
		
		command = new CListCommand();
		command.execute(model);
		
		System.out.println(model.asMap().get("list").toString());
		return "user_list";
	}
	//
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignup(HttpServletRequest request, Model model){
		
		System.out.println("doSignup()");
		
		model.addAttribute("request", request);
		command = new CSignupCommand();
		command.execute(model);
		
		return "signup_welcome"; //가입하고 나면 로그인 화면으로 -> 웰컴페이지로 가게 수정
	}

	
	//회원가입할 떄 아이디 중복체크
	@RequestMapping(value="/check_signup",method=RequestMethod.POST)
	@ResponseBody
	public String checkSignup(HttpServletRequest request, Model model){
		
		System.out.println("checkSignup()");

		String account = request.getParameter("account");
		//request 의 값을 model 에 추가해주기
		model.addAttribute("account", account);
		
		command = new CSignupCheckCommand();
		command.execute(model);
		
		
		return model.asMap().get("check").toString();
	}
	
	//우선 로그인 여부를 이 때 검사하고, check_Circle 로 넘어간다.
	@RequestMapping(value="/check_signin_ok")
	public String check_SigninOk(HttpServletRequest request, Model model){
		System.out.println("check_SignOk()");
		return "redirect:/check_circle";
	}
	
	//로그인이 되지 않았을 경우 post로, 로그인이 이미 된 경우 get 방식으로 넘어간다. 
	//이 함수의 경우는 그 두 방식 모두 틀리지않고 완전 기능이 구현됐기 때문에 굳이 구분이 있을 필요가 있나 싶어서 method 를 우선 없애줬음...
	//위의 check_SigninOk 함수도 마찬가지로 별다른 역할 차이가 없어서 없애줌...
	@RequestMapping(value="/check_circle")
	public String check_Circle(Model model){
		
		System.out.println("checkCircle()");
		//System.out.println("version:Post");
		
		String account=null;
		//현재 시큐리티로 로그인 된 정보를 가져온다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		account = authentication.getName();
		
		model.addAttribute("account", account);
	
		command = new CCircleCheckCommand();
		command.execute(model);
		
		System.out.println(model.asMap().get("circleList").toString());
		
		if(model.asMap().get("circleList").toString().equals("[]")) //동아리 정보가 없다는 뜻
			return "redirect:nocircle_view";
		else{
			return "redirect:circle_view";
		}
	}
	
	
	//로그인 후 가입한 동아리가 없을 때 
	@RequestMapping(value = "/nocircle_view", method = RequestMethod.GET)
	public String goNoCircle(Model model){
		System.out.println("noCircleView()");
		
		String account=null;
		//현재 시큐리티로 로그인 된 정보를 가져온다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		account = authentication.getName();
		model.addAttribute("account", account);
		
		command = new CUnivCircleListCommand();
		command.execute(model);
		
		return "nocircle_view";
	}
	
	@RequestMapping(value = "/circle_view", method = RequestMethod.GET)
	public String goCircle(Model model){
		model.addAttribute("circleList",myModel.asMap().get("circleList")); //동아리 정보넣어주기		
		
		return "circle_view";
	}
	

	
}

