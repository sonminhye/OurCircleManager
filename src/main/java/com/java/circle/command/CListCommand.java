package com.java.circle.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.java.circle.dao.CDao;
import com.java.circle.dto.CDto;

public class CListCommand implements CCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		CDao dao= new CDao();
		ArrayList<CDto>dtos =  dao.showList();
		
		model.addAttribute("list", dtos);
		
	}

}