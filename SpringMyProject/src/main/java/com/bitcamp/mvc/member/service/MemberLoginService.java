package com.bitcamp.mvc.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.mvc.member.dao.JdbcTemplateMessageDao;
import com.bitcamp.mvc.member.model.Regi;

public class MemberLoginService {

	@Autowired
	JdbcTemplateMessageDao memberDao;

	public boolean login(HttpServletRequest request, String id, String pwd) throws SQLException {
		
		boolean result = false;
		HttpSession session = request.getSession(false);
		

			Regi regi = memberDao.selectById(id);

			if (regi != null && regi.isMatchPassword(pwd)) {
				session.setAttribute("signedUser", regi);
				System.out.println("로그인 성공");
				result = true;
			}
		

	return result;
}

}
