package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.op.member.model.MemberVo;
import com.bitcamp.op.member.service.MemberRegService;
import com.bitcamp.op.member.service.SimpleMailSenderService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {

	@Autowired
	MemberRegService memberRegService;

	@Autowired
	SimpleMailSenderService mailSenderService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		String viewName = "member/memberRegForm";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processLogin(MemberVo member, HttpServletRequest request) throws Exception {
		String viewName = "member/memberReg";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);

		int insertCnt = memberRegService.RegMember(member, request);

		modelAndView.addObject("insertCnt", insertCnt);

		// 회원가입 알림 메일 발송
		mailSenderService.simpleMailSend(member, request);

		return modelAndView;
	}

}
