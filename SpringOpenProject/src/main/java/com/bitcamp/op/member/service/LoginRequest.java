package com.bitcamp.op.member.service;

public class LoginRequest {

	private String memberId;
	private String memberPassword;

	public LoginRequest() {
	}

	public LoginRequest(String memberId, String memberPassword) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
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

	@Override
	public String toString() {
		return "LoginRequest [memberId=" + memberId + ", memberPassword=" + memberPassword + "]";
	}

	
	
}
