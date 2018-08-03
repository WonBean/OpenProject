package com.bitcamp.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.op.member.model.MemberVo;

public class MemberRowMapper implements RowMapper<MemberVo> {

	@Override
	public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVo memberVo = new MemberVo();
		memberVo.setmIdx(rs.getInt(1));
		memberVo.setMemberId(rs.getString(2));
		memberVo.setMemberPassword(rs.getString(3));
		memberVo.setMemberPhoto(rs.getString(4));
		memberVo.setMemberName(rs.getString(5));
		return memberVo;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
