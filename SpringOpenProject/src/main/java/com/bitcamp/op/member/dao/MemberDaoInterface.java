package com.bitcamp.op.member.dao;

import com.bitcamp.op.member.model.MemberVo;

public interface MemberDaoInterface {
	
	public MemberVo selectById(String userId);
	public int insertMember(MemberVo member);

}
