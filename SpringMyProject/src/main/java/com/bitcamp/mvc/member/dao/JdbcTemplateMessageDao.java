package com.bitcamp.mvc.member.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.mvc.member.model.Message;
import com.bitcamp.mvc.member.model.Regi;

public class JdbcTemplateMessageDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Regi selectById(String id) {

		Regi resultObj = null;
		String sql = "select * from regi where id=?";

		resultObj = jdbcTemplate.queryForObject(sql, new RegiRowMapper(), id);

		return resultObj;

	}

	public int insert(Message message) {
		int resultCnt = 0;
		String sql = "insert into guestbook_message values(message_id_seq.NEXTVAL, ?, ?, ?)";
		resultCnt = jdbcTemplate.update(sql, message.getGuestName(), message.getPassword(), message.getMessage());

		return resultCnt;
	}

	public int selectCount() {
		int resultCnt = 0;
		String sql = "select * from guestbook_message";
		List<Message> result = jdbcTemplate.query(sql, new MessageRowMapper());

		resultCnt = result.size();

		return resultCnt;

	}

	public List<Message> selectList(int firstRow, int endRow) {

		String sql = "select message_id, guest_name, password, message " + " from ( "
				+ " select rownum rnum, message_id, guest_name, password, message " + " from ( " + " select * "
				+ " from guestbook_message m " + " order by m.message_id desc " + " ) " + " where rownum <= ? " + " )"
				+ " where rnum >= ? ";
		List<Message> messageList = jdbcTemplate.query(sql, new MessageRowMapper(), endRow, firstRow);

		return messageList;

	}

	public int delete(int messageId) {
		int resultCnt = 0;

		String sql = "delete from guestbook_message where message_id = ?";

		resultCnt = jdbcTemplate.update(sql, messageId);
		return resultCnt;
	}

	public Message select(int messageId) {

		String sql = "select * from guestbook_message where message_id=?";
		Message message = null;

		message = jdbcTemplate.queryForObject(sql, new MessageRowMapper(), messageId);
		return message;
	}

	public int insert(Regi regi) throws ParseException {
		int resultCnt = 0;
		String sql = "insert into regi values(?,?,?,?,?,?,?,?)";

		// 문자열 -> Date 개게로 변환
		// 1. String -> java.util.Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date hdate = format.parse(regi.getBirthdate());
		// 2. java.util.Date -> java.sql.Date
		Date sql_hdate = new Date(hdate.getTime());

		resultCnt = jdbcTemplate.update(sql, regi.getId(), regi.getPwd(), regi.getPwd1(), regi.getName(),
				regi.getPhoto(), regi.getJob(), sql_hdate, regi.getSal());
		return resultCnt;

	}

	public int select(String id) {

		Regi regi = null;
		String sql = "select * from regi where id=?";

		regi = jdbcTemplate.queryForObject(sql, new RegiRowMapper(), id);
		if (regi != null) {
			return 1;
		}
		return -1;
	}

	public List<Regi> getuser() {
		String sql = "select * from regi";

		List<Regi> listRegi = jdbcTemplate.query(sql, new RegiRowMapper());

		return listRegi;

	}
}
