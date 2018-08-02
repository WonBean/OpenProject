package com.bitcamp.mvc.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.mvc.member.dao.JdbcTemplateMessageDao;

public class IdCheckService {
	
	@Autowired
	JdbcTemplateMessageDao memberDao;

	public int idcheck(String id) throws Exception {

			int count = memberDao.select(id); // id를 통해 해당 회원찾기

			return count;

	}
}
