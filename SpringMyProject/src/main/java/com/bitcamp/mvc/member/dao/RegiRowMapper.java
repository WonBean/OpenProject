package com.bitcamp.mvc.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.mvc.member.model.Message;
import com.bitcamp.mvc.member.model.Regi;

public class RegiRowMapper implements RowMapper<Regi> {

	@Override
	public Regi mapRow(ResultSet rs, int rowNum) throws SQLException {
		Regi regi = new Regi();
		regi.setId(rs.getString(1));
		regi.setPwd(rs.getString(2));
		regi.setPwd1(rs.getString(3));
		regi.setName(rs.getString(4));
		regi.setPhoto(rs.getString(5));
		regi.setJob(rs.getString(6));
		regi.setBirthdate(rs.getString(7));
		regi.setSal(rs.getInt(8));
		return regi;
	}

}
