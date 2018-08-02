package com.bitcamp.mvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestMessageController {
	@RequestMapping(value = "/guestmessage/list.xml")
	@ResponseBody
	public GuestMessageList listXml() {
		return getMessageList();
	}

	@RequestMapping(value = "/guestmessage/list.json")
	@ResponseBody
	public GuestMessageList listJson() {
		return getMessageList();
	}

	private GuestMessageList getMessageList() {
		List<GuestMessage> messages = Arrays.asList(new GuestMessage(1, "메시지", new Date()),
				new GuestMessage(2, "메시지2", new Date()));
		return new GuestMessageList(messages);
	}
}