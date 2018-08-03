package com.bitcamp.op.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.LoginRequest;
import com.bitcamp.op.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	@Autowired
	MemberLoginService memberLoginService;

	/*
	@RequestMapping("/member/loginForm")
	public String getLoginForm() {			
		return "member/memberLoginForm";
	}
	*/
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm() {			
		return "member/memberLoginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processLogin(HttpServletRequest request, 
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPassword") String memberPassword,
			LoginRequest loginRequest,
			Model model
			) throws SQLException {		
		
		String id = request.getParameter("memberId");
		String pw = request.getParameter("memberPassword");
		
		//////////////////////////////////////////////////////
		
		// model 처리 
		memberLoginService.login(request, id, pw);
		
		
		////////////////////////////////////////////////////
		
		
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberPassword", memberPassword);
		model.addAttribute("loginChk", true);
		
		
		return "member/memberLogin";
	}
	
	
	
	
	
	
}
