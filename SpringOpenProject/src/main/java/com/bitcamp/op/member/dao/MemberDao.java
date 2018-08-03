package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.model.MemberVo;

public class MemberDao {

	public MemberVo selectById(Connection conn, String userId) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql_select = "select * from member where memberId=?";
		MemberVo member = null;
		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = makeMemberFromResultSet(rs);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return member;
	}

	private MemberVo makeMemberFromResultSet(ResultSet rs) throws SQLException {
		MemberVo memberVo = new MemberVo();
		memberVo.setmIdx(rs.getInt(1));
		memberVo.setMemberId(rs.getString(2));
		memberVo.setMemberPassword(rs.getString(3));
		memberVo.setMemberPhoto(rs.getString(4));
		memberVo.setMemberName(rs.getString(5));
		return memberVo;
	}

	public int insertMember(Connection conn, MemberVo memberVo) throws SQLException {
		int insertCnt = 0;
		PreparedStatement pstmt = null;
		String sql_insert = "insert into member (mIdx, memberId, memberPassword, memberPhoto, memberName ) values (member_seq.nextval, ?,?,?,?) ";

		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, memberVo.getMemberId());
			pstmt.setString(2, memberVo.getMemberPassword());
			pstmt.setString(3, memberVo.getMemberPhoto());
			pstmt.setString(4, memberVo.getMemberName());
			insertCnt = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return insertCnt;
	}
	
	


	public int selectCount(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from member";

		try {
			stmt = conn.createStatement();
			// int totalCnt = stmt.executeUpdate(sql);

			rs = stmt.executeQuery(sql);

			rs.next();
			return rs.getInt(1);

		} finally {
			JdbcUtil.close(stmt);
		}
	}

	public List<MemberVo> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> messageList = null;
		String sql = "select midx, memberid, memberpassword, memberphoto, membername " 
				+ " from ( "
				+ " select rownum rnum, midx, memberid, memberpassword, memberphoto, membername  " 
				+ " from ( " 
				+ " select *  from member m  order by m.memberid desc " 
				+ " ) " 
				+ " where rownum <= ? " 
				+ " )"
				+ " where rnum >= ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				messageList = new ArrayList<MemberVo>();
				do {

					messageList.add(makeMemberFromResultSet(rs));

				} while (rs.next());

			} else {
				messageList = Collections.emptyList();
			}

			return messageList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public MemberVo selectByIdx(Connection conn, int mIdx) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql_select = "select * from member where mIdx=?";
		MemberVo member = null;

		try {
			pstmt = conn.prepareStatement(sql_select);
			pstmt.setInt(1, mIdx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = makeMemberFromResultSet(rs);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return member;
	}

	public int editMember(Connection conn, MemberVo memberVo) throws SQLException {

		PreparedStatement pstmt = null;
		
		String sql_update = "update member set "
				+ " memberName = ? , memberPhoto = ? "
				+ " where mIdx=?";
		
		int editCnt = 0;

		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, memberVo.getMemberName());
			pstmt.setString(2, memberVo.getMemberPhoto());
			pstmt.setInt(3, memberVo.getmIdx());
			editCnt = pstmt.executeUpdate();
			
		} finally {			
			JdbcUtil.close(pstmt);
		}
		return editCnt;
	}

	public int deleteByIdx(Connection conn, int mIdx) throws SQLException {

		PreparedStatement pstmt = null;
		
		String sql_update = "delete from member  where mIdx=?";
		
		int deleteCnt = 0;

		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, mIdx);
			deleteCnt = pstmt.executeUpdate();
			
		} finally {			
			JdbcUtil.close(pstmt);
		}
		return deleteCnt;
	}

}
