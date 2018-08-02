package com.bitcamp.mvc.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMypageController {

	@RequestMapping("member/myPage")
	public String getMypage() {
		
		return "member/myPage";
	}
	
	
	
	
	
}
