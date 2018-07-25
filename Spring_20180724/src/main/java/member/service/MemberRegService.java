package member.service;

import org.springframework.beans.factory.annotation.Autowired;

import member.dao.Dao;
import member.dao.MemberDao;
import member.model.Member;

public class MemberRegService {
	
	MemberDao dao ;

	// 의존 객체를 생성자를 통해서 받는다.
	@Autowired
	public MemberRegService(MemberDao dao) {
		this.dao = dao;
	}
	
	public void insertMember(Member member) {
		dao.insert(member);
	}
	
	
	
	
	
	

}
