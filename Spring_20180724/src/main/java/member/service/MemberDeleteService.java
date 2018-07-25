package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;

public class MemberDeleteService {

	@Autowired
	@Qualifier("newDao")
	Dao dao;

	// 의존 설정을 set 메서드를 통해서 주입하는 형태
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	/*
	 * MybatisDao dao;
	 * 
	 * public void setDao(MybatisDao dao) { this.dao = dao; }
	 */

	public void deleteMember(String id) {
		dao.delete(id);
	}

}
