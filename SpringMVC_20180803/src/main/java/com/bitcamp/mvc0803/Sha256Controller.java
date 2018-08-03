package com.bitcamp.mvc0803;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class Sha256Controller {
	
	@Autowired
	Sha256 sha;
	
	@Autowired
	AES256Util aes;

	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,
			@RequestParam("pwd") String pwd,
			Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		

		System.out.println("암호화 전 id: "+id);
		System.out.println("암호화 전 pwd: "+pwd);
		
		System.out.println("---------------------------");
		
//		id=sha.encrypt(id);
//		pwd=sha.encrypt(pwd);
		id=aes.encrypt(id);
		pwd=aes.encrypt(pwd);
		
		System.out.println("암호화 후 id: "+id);
		System.out.println("암호화 후 pwd: "+pwd);
		
		System.out.println("---------------------------");
		
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		
		String id1=aes.decrypt(id);
		String pwd1=aes.decrypt(pwd);
		
		model.addAttribute("id1", id1);
		model.addAttribute("pwd1", pwd1);
		
		System.out.println("복호화 후 id1: "+id1);
		System.out.println("복호화 후 pwd1: "+pwd1);
		
		return "login";
		
	}
}
