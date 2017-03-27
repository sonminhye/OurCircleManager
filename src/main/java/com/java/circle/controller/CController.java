package com.java.circle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.circle.dao.UserService;
import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUniv;
import com.java.circle.dto.CDtoUser;

@Controller
public class CController {
	Model myModel = null;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showMain(){
		return "main";
	}
	
	//TEST용//////////////
	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public String showList(Model model) {
		System.out.println("list()");
		
		List<CDtoUser> list = userService.showList();
		model.addAttribute("list", list);
		return "user_list";

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
		System.out.println("signup_view");
		//대학교리스트구하기
		List<CDtoUniv> list = userService.showUnivList();
		model.addAttribute("univ", list);
		
		return "signup_view";
	}

	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String doSignup(HttpServletRequest request, Model model){
		
		System.out.println("doSignup()");
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("account", request.getParameter("account"));
		param.put("password", request.getParameter("password"));
		param.put("name", request.getParameter("name"));
		param.put("auth", request.getParameter("auth"));
		param.put("univ", request.getParameter("univ"));
		
		userService.doSignup(param);

		return "signup_welcome"; //가입하고 나면 웰컴페이지로
	}

	
	//회원가입할 떄 아이디 중복체크
	@RequestMapping(value="/check_signup",method=RequestMethod.POST)
	@ResponseBody
	public String checkSignup(HttpServletRequest request, Model model){
		
		System.out.println("checkSignup()");

		String account = request.getParameter("account");

		int rowcount = userService.checkSignup(account);
		return String.valueOf(rowcount);
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
	public String checkCircle(Model model){
		
		System.out.println("checkCircle()");
		//System.out.println("version:Post");
		
		String account=null;
		//현재 시큐리티로 로그인 된 정보를 가져온다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		account = authentication.getName();
		
		List<CDtoCircle> myCircleList = userService.showMyCircle(account);
		List<CDtoCircle> univCircleList = userService.showUnivCircle(account);
		
		if(myCircleList.isEmpty()){  //account의 유저가 가입한 동아리 없을 때
			if(univCircleList.isEmpty()){ //account의 유저가 속한 학교에도 동아리가 없을 때
				return "nounivcircle_view";
			}else{
				model.addAttribute("list", univCircleList);
				return "nocircle_view";
			}
		}else{ //account의 유저가 가입한 동아리 있을 때 : 동아리 목록 출력
			model.addAttribute("list", myCircleList);
			return "circle_view";
		}
		//redirect써주면 해당 주소가 매핑된 메소드로 가게되는데 model을 함께 전달하려면 더 복잡해져서
		//그냥 redirect를 삭제하고 바로 해당주소를 return하게했어용
	}
	
}

