package com.bitcamp.op.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberVo {

	private int mIdx;
	private String memberId;
	private String memberPassword;
	
	// 파일 업로드 처리를 위한 변수
	private MultipartFile photoFile;
	// DB 데이터 입력을 위한 변수 
	private String memberPhoto;
	
	private String memberName;

	public int getmIdx() {
		return mIdx;
	}

	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
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

	public String getMemberPhoto() {
		return memberPhoto;
	}

	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}

	public boolean isMatchPassword(String pw) {

		return memberPassword.equals(pw) ? true : false;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	@Override
	public String toString() {
		return "MemberVo [mIdx=" + mIdx + ", memberId=" + memberId + ", memberPassword=" + memberPassword
				+ ", photoFile=" + photoFile + ", memberPhoto=" + memberPhoto + ", memberName=" + memberName + "]";
	}
	
	
	

	

}
