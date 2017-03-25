package com.java.circle.command;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;
import com.java.circle.dto.CDtoUserCircle;

public class CUserAuthCheckCommand implements CCommand {

	//동아리의 내에서 유저가 어떠한 권한을 가지고 있는지를 가져오는 기능
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		/*
		String account = model.asMap().get("account").toString();
		String circle_id = model.asMap().get("circle_id").toString();
		
		CDao dao = new CDao();
		CDtoUserCircle dto = dao.showMyAuthInThisCircle(account, circle_id);
		
		
		
		model.addAttribute("myAuthInThisCircle", dto);
		
		*/
	}
	
}
