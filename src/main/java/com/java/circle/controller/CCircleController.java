package com.java.circle.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.circle.command.CCommand;
import com.java.circle.dao.CircleManageService;
import com.java.circle.dao.CircleService;
import com.java.circle.dto.CDtoCircle;
import com.java.circle.dto.CDtoUniv;
import com.java.circle.dto.CDtoUserCircle;

@Controller
public class CCircleController {
	CCommand command = null;
	
	@Autowired
	private CircleManageService circleManageService;
	
	@Autowired
	private CircleService circleService;
	
	@RequestMapping(value = "/addcircle_view", method = RequestMethod.GET)
	public String goAddCircle(Model model){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("유저이름 = " + user.getUsername());
		
		CDtoUniv dto = circleService.showUnivInfo(user.getUsername());
		
		model.addAttribute("univ", dto);
		
		//model.addAttribute("account", user.getUsername());
		//command = new CAccountUnivInfoCommand(); 
		//command.execute(model);
		
		return "addcircle_view";
	}
	
	
	//동아리 만들 떄 이름 중복체크
	@RequestMapping(value="/check_addcircle",method=RequestMethod.POST)
	@ResponseBody
	public String checkSignup(HttpServletRequest request, Model model){
		
		System.out.println("checkAddCircle()");

		String name = request.getParameter("name");
		//request 의 값을 model 에 추가해주기
		int n = circleService.checkAddcircle(name);
		
		model.addAttribute("check", n);
		
		//model.addAttribute("name", name);
		//command = new CAddcircleCheckCommand();
		//command.execute(model);	
		
		return model.asMap().get("check").toString();
	}
	
	
	@RequestMapping(value ="/addcircle", method = RequestMethod.POST)
	public String doSignup(HttpServletRequest request, Model model){
		
		System.out.println("doAddCircle()");
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		//CDtoCircle param = new CDtoCircle()
		param.put("name", request.getParameter("name"));
		param.put("univ_id", request.getParameter("univ_id"));
		param.put("circle_category_id", request.getParameter("category"));
		param.put("intro", request.getParameter("intro"));
		param.put("image", request.getParameter("image"));
		
		
		
		circleService.addCircle(param);
		
		//mybatis에서는 내가 파라미터로 넘겨준 map에 pk(auto increment 된 열) 의 값을 넣어준다고 함.
		//그래서 param 에서 circle_id 를 찾아준다
		System.out.println("추가 후 : " + param.get("circle_id"));
		Long circle_id = (Long) param.get("circle_id");
		
		
		//model.addAttribute("request", request);
		//command = new CAddcircleCommand();
		//command.execute(model);
		//to do:동아리 만듦과 동시에 해당 유저도 가입되게 해야함(cUser_Circle테이블에 추가해야함)
		
		String uri = "redirect:/circle_main?circle_id=" + circle_id;
		System.out.println(uri);
		
		return uri; //to do:해당 동아리의 메인으로 가게 
	
	}
	
	
	@RequestMapping(value = "/circle_main", method = RequestMethod.GET)
	public String showMain(Model model, HttpServletRequest request){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String account = authentication.getName();
		String circle_id = request.getParameter("circle_id");
		HashMap<String,String> param = new HashMap<String,String>();
		
		param.put("account", account);
		param.put("circle_id", circle_id);
		
		CDtoCircle dtoCircle = circleManageService.showCircle(circle_id);
		CDtoUserCircle dtoUserCircle = circleManageService.showMyAuthInThisCircle(param);
		
		model.addAttribute("dto", dtoCircle);
		model.addAttribute("myAuthInThisCircle", dtoUserCircle);
		
		//model.addAttribute("circle_id",request.getParameter("circle_id")); 
		//model.addAttribute("account", account);
		
		//CGetCircleInfoCommand command = new CGetCircleInfoCommand();		//동아리 메인 페이지 정보들 가져오기
		//command.execute(model);
		
		//CUserAuthCheckCommand command2 = new CUserAuthCheckCommand();      //이 동아리 내에서의 나의 권한 가져오기.
		//command2.execute(model);
		
		return "circle_main";
	}
	


}
