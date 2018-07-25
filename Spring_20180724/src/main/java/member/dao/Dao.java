package member.dao;

import member.model.Member;

public interface Dao {
	
	void insert(Member member);
	void delete(String id);

}
