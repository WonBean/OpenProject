package com.bitcamp.mvc0802;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestMessageApiController {
	
	@RequestMapping("/guestMessage/list.xml")
	@ResponseBody
	public GuestMessageList listXml() {
		List<GuestMessage> messages = new ArrayList<GuestMessage>();
		messages.add(new GuestMessage(1, "안녕하세요", new Date()));
		messages.add(new GuestMessage(2, "문의", new Date()));
		messages.add(new GuestMessage(3, "긴급", new Date()));
		
		return new GuestMessageList(messages);
	}

	@RequestMapping("/guestMessage/list.json")
	@ResponseBody
	public GuestMessageList listJson() {
		List<GuestMessage> messages = new ArrayList<GuestMessage>();
		messages.add(new GuestMessage(1, "안녕하세요", new Date()));
		messages.add(new GuestMessage(2, "문의", new Date()));
		messages.add(new GuestMessage(3, "긴급", new Date()));
		
		return new GuestMessageList(messages);
	}

	
	
	
	
	
	
	
	
	
	
	
}
