package member.dao;

import member.model.Member;

public class MemberDao implements Dao {

	@Override
	public void insert(Member member) {
		System.out.println("MemberDao");
		System.out.println("회원 정보가 입력되었습니다.");
		System.out.println(member);
		
	}

	@Override
	public void delete(String id) {
		System.out.println("MemberDao");
		System.out.println(id + " : 회원 데이터가 삭제되었습니다.");
			
	}

	
	
	
	
	
	
}
