package com.bitcamp.op.member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.dao.MemberDaoInterface;
import com.bitcamp.op.member.dao.MybatisMemberDao;
import com.bitcamp.op.member.model.MemberVo;



public class MemberLoginService {

	// 1. JDBC
	//@Autowired
	//MemberDao memberDao;
	
	// 2. Spring Framework JdbcTemplate 클래스를 이용한 DAO
	//@Autowired
	//JdbcTemplateMemberDao memberDao;
	
	// 3. Spring + Mybatis 이용한 DAO
	//@Autowired
	//MybatisMemberDao memberDao;
	
	// 4. Spring + Mybatis : 자동 매퍼 생성 시능이용한 DAO ===> 궁극적으로 프로젝트 할때 사용함!!
	@Autowired
	SqlSessionTemplate template;
	
	private MemberDaoInterface memberDao;
	
	public boolean login(HttpServletRequest request, String userId, String userPw) throws SQLException {
		
		memberDao = template.getMapper(MemberDaoInterface.class);
		
		
		
		boolean result = false;
		HttpSession session = request.getSession(false);
		//Connection conn = null;
		

		/*try {*/
			//conn = ConnectionProvider.getConnection();

			//MemberVo memberVo = memberDao.selectById(conn, userId);
			MemberVo memberVo = memberDao.selectById(userId);

			if (memberVo != null && memberVo.isMatchPassword(userPw)) {
				session.setAttribute("loginInfo", memberVo);
				System.out.println("로그인 성공");
				result = true;
			}
		/*} finally {
			JdbcUtil.close(conn);
		}*/

		return result;
	}

}
