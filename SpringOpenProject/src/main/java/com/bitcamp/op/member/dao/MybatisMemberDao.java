package com.bitcamp.op.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.op.member.model.MemberVo;

public class MybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberVo selectById(String userId) {
		System.out.println("mybatisDao SelectById 실행....................");
		
		Object obj = sqlSessionTemplate.selectOne("com.bitcamp.op.mapper.mybatis.MemberMapper.selectById", userId);
		System.out.println(obj);
		
		return (MemberVo) obj;
	}
	

	public int insertMember(MemberVo member) {
		
		System.out.println("mybatisDao insertMember 실행....................");
		
		return sqlSessionTemplate.update("com.bitcamp.op.mapper.mybatis.MemberMapper.insertMember", member);
	}
	
	
	
	
	
	
}
