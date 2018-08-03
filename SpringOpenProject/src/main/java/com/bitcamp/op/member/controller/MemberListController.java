package com.bitcamp.op.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.model.MemberListView;
import com.bitcamp.op.member.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService memberListService;

	@RequestMapping("/member/memberList")
	public String getMemberList(@RequestParam(value="page", defaultValue="1") int pageNumber, Model model) throws SQLException {
				
		MemberListView memberListView = null;
		
		memberListView = memberListService.getListView(pageNumber);
		
		model.addAttribute("listView", memberListView); 
		
		return "member/memberList";
		
	}
}
