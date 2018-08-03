package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bitcamp.op.member.model.MemberVo;

public class JdbcTemplateMemberDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public MemberVo selectById(String userId) {

		MemberVo resultObj = null;
		String sql = "select * from member"
				+ " where memberId=?";
		
		// select * from member where memberId=?

		// List<MemberVo> result = jdbcTemplate.query(sql, new MemberRowMapper(),
		// userId);
		// resultObj = result.isEmpty() ? nuinsertMemberinsertMemberll : result.get(0);

		resultObj = jdbcTemplate.queryForObject(sql, new MemberRowMapper(), userId);

		return resultObj;

	}

	public int insertMember(MemberVo member) {

		int resultCnt = 0;
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "insert into member " 
				+ " (mIdx, memberId, memberPassword, memberPhoto, memberName ) "
				+ " values (member_seq.nextval, ?,?,?,?) ";
		
		resultCnt = jdbcTemplate.update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				
				pstmt = con.prepareStatement(sql, new String[] {"mIdx"});
				pstmt.setString(1, member.getMemberId());
				pstmt.setString(2, member.getMemberPassword());
				pstmt.setString(3, member.getMemberPhoto());
				pstmt.setString(4, member.getMemberName());
				
				return pstmt;
			}
		} , keyHolder);
		
		Number keyValue = keyHolder.getKey();
		
		member.setmIdx(keyValue.intValue());
		

		/*resultCnt = jdbcTemplate.update(
				sql, 
				member.getMemberId(), 
				member.getMemberPassword(), 
				member.getMemberPhoto(),
				member.getMemberName());*/
		
		

		return resultCnt;

	}

}
