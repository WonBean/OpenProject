package com.bitcamp.mvc0803;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailSenderController {
	
	@Autowired
	SimpleMailSenderService mailSenderService;
	
	
	@RequestMapping("/mail/simpleMail")
	public String sendMail1() {
		
		// 메일 발송
		mailSenderService.simpleMailSend();
		
		return "sendmail";
	}
	@RequestMapping("/mail/htmlMail")
	public String sendMail() {
		
		// 메일 발송
		mailSenderService.htmlMailSend();
		
		return "sendmail";
	}
	@RequestMapping("/mail/fileMail")
	public String sendMail2() {
		
		// 메일 발송
		mailSenderService.fileMailSend();
		
		return "sendmail";
	}

}
