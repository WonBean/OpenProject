package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.model.MemberListView;
import com.bitcamp.op.member.model.MemberVo;

public class MemberListService {

	@Autowired
	private MemberDao memberDao;

	// 한 페이지에 보여줄 메시지의 수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;

	public MemberListView getListView(int pageNum) throws SQLException {

		Connection conn = null;
		MemberListView listView = null;
		

		int currentPageNumber = 1;

		if (pageNum > 0) {
			currentPageNumber = pageNum;
		}
		
		conn = ConnectionProvider.getConnection();
		

		// 전체 게시물의 개수
		int messageTotalCount = memberDao.selectCount(conn);	
		
		System.out.println("전체 게시물 개수 : "+messageTotalCount);
		
		// 게시물의 리스트
		List<MemberVo> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		
		if(messageTotalCount > 0) {
			firstRow = (currentPageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
			endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1 ;
			messageList = memberDao.selectList(conn, firstRow, endRow);
		} else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		
		return  new MemberListView(
				messageList, 
				messageTotalCount, 
				currentPageNumber, 
				MESSAGE_COUNT_PER_PAGE, 
				firstRow, endRow);
		
		
		
		


	}

}
