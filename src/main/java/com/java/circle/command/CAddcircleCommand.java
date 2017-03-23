package com.java.circle.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;

public class CAddcircleCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		System.out.println("addcircleCommand");
		
		if(request.equals(null))
			System.out.println("request is null");
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		param.put("name", request.getParameter("name"));
		param.put("univ_id", request.getParameter("univ_id"));
		param.put("circle_category_id", request.getParameter("category"));
		param.put("intro", request.getParameter("intro"));
		param.put("image", request.getParameter("image"));
		
		CDao dao = new CDao();
		
		int circle_id = dao.addCircle(param);
		model.addAttribute("circle_id", circle_id);
		
	}

}
