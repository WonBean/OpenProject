package com.bitcamp.mvc.member.model;

import org.springframework.web.multipart.MultipartFile;

public class Regi {
	private String id;
	private String pwd;
	private String pwd1;
	private String name;
	private MultipartFile photoFile;
	private String photo;
	private String job;
	private String birthdate;
	private int sal;

	public Regi() {
		super();
	}

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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}
	
	public boolean isMatchPassword(String pwd) {

		return pwd.equals(pwd) ? true : false;
	}

	@Override
	public String toString() {
		return "Regi [id=" + id + ", pwd=" + pwd + ", pwd1=" + pwd1 + ", name=" + name + ", photoFile=" + photoFile
				+ ", photo=" + photo + ", job=" + job + ", birthdate=" + birthdate + ", sal=" + sal + "]";
	}
	
	

}
