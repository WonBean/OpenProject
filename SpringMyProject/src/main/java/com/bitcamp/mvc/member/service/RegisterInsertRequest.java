package com.bitcamp.mvc.member.service;

public class RegisterInsertRequest {
	private String id;
	private String pwd;
	private String pwd1;
	private String name;
	private String photo;
	private String job;
	private String birthdate;
	private int sal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "RegisterInsertRequest [id=" + id + ", pwd=" + pwd + ", pwd1=" + pwd1 + ", name=" + name + ", photo="
				+ photo + ", job=" + job + ", birthdate=" + birthdate + ", sal=" + sal + "]";
	}

}
