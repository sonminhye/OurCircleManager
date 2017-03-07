package com.java.circle.controller;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.circle.command.CCircleCheckCommand;
import com.java.circle.command.CCommand;
import com.java.circle.command.CListCommand;
import com.java.circle.command.CSigninCheckCommand;
import com.java.circle.command.CSignupCheckCommand;
import com.java.circle.command.CSignupCommand;

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
		
		return "signin_view"; //가입하고 나면 로그인 화면으로
	}
	
	//밑에꺼랑 맞춰서 이름을 check_signin 같이 바꾸면 좋을듯..?^_^
	@RequestMapping(value="/check_signin",method=RequestMethod.POST)
	@ResponseBody
	public String checkSignin(@RequestBody HashMap<String,Object> param, HttpServletRequest request, Model model){
		
		System.out.println("checkSignin()");
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		//request 의 값을 model 에 추가해주기
		model.addAttribute("param", param);
		
		command = new CSigninCheckCommand();
		command.execute(model);
		
		
		return model.asMap().get("check").toString();
	}
	
	//회원가입할 떄 아이디 중복체크
	@RequestMapping(value="/check_signup",method=RequestMethod.POST)
	@ResponseBody
	public String checkSignup(@RequestBody HashMap<String,Object> param, HttpServletRequest request, Model model){
		
		System.out.println("checkSignup()");
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		String account = request.getParameter("account");
		//request 의 값을 model 에 추가해주기
		model.addAttribute("account", param);
		
		command = new CSignupCheckCommand();
		command.execute(model);
		
		
		return model.asMap().get("check").toString();
	}
	
	
	
	@RequestMapping(value="/check_circle",method=RequestMethod.POST)
	public String check_Circle(HttpServletRequest request, Model model){
		
		System.out.println("checkCircle()");
		String account=null;
		
		//세션에 추가 (interceptor에서 로그인 여부 체크할 수 있음)
		HttpSession session = request.getSession();
		session.setAttribute("account", request.getParameter("account"));
		
	
		//request 의 값을 model 에 추가해주기
		
		model.addAttribute("account", account);
		
		command = new CCircleCheckCommand();
		command.execute(model);
		model = myModel;
		
		if(model.asMap().get("circleList").toString().equals("[]")) //동아리 정보가 없다는 뜻
			return "nocircle_view";
		else{
			return "circle_view";
		}
	}
	
	@RequestMapping(value = "/nocircle_view", method = RequestMethod.GET)
	public String goNoCircle(Model model){
		
		return "nocircle_view";
	}
	
	@RequestMapping(value = "/circle_view", method = RequestMethod.GET)
	public String goCircle(Model model){
		model.addAttribute("circleList",myModel.asMap().get("circleList")); //동아리 정보넣어주기		
		
		return "circle_view";
	}
	
	@RequestMapping(value = "/addcircle_view", method = RequestMethod.GET)
	public String goAddCircle(){
		return "addcircle_view";
	}
	
	//시큐리티 로그아웃과 관련된 맵핑 함수
	
	@RequestMapping(value="/logout")
	public String logout(Model model){
		System.out.println("로그아웃하렴");
		return "logout";
	}
	
	@RequestMapping(value="/fail")
	public String failed(Model model){
		System.out.println("로긘 실패");
		return "fail";
	}
	
}

