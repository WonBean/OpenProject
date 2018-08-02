package com.bitcamp.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.mvc.member.model.Regi;
import com.bitcamp.mvc.member.service.RegisterInsertService;

@Controller
@RequestMapping("/member/regi")
public class MemberRegController {
	
	@Autowired
	RegisterInsertService memberRegService;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getLoginForm() {		
		String viewName = "member/regiForm";		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);		
		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processLogin(Regi regi, HttpServletRequest request) throws Exception {
		System.out.println("여기까지");
		String viewName = "member/regiDeal";		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		
		
		int insertCnt = memberRegService.insert(regi, request);
		
		modelAndView.addObject("insertCnt", insertCnt);
		
		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
