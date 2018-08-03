package com.bitcamp.op.member.service;

public class MemberRegRequest {

	private String memberId;
	private String memberPassword;
	private String memberName;

	public MemberRegRequest() {
	}

	public MemberRegRequest(String memberId, String memberPassword, String memberName) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "MemberRegRequest [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ "]";
	}
	
	

}
