package com.bitcamp.mvc.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mvc.member.service.LoginRequest;
import com.bitcamp.mvc.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	@Autowired
	MemberLoginService memberLoginService;

	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm() {			
		return "member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processLogin(HttpServletRequest request, 
			@RequestParam("id") String memberId,
			@RequestParam("pwd") String memberPassword,
			LoginRequest loginRequest,
			Model model
			) throws SQLException {		
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//////////////////////////////////////////////////////
		
		// model 처리 
		memberLoginService.login(request, id, pwd);
		
		
		////////////////////////////////////////////////////
		
		
		
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberPassword", memberPassword);
		model.addAttribute("loginChk", true);
		
		
		return "member/loginDeal";
	}
	
	
	
	
	
	
}
