package com.bitcamp.mvc.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bitcamp.mvc.member.dao.JdbcTemplateMessageDao;
import com.bitcamp.mvc.member.model.Regi;

public class RegisterInsertService {

	@Autowired
	JdbcTemplateMessageDao memberDao;

	public int insert(Regi regi, HttpServletRequest request) throws Exception {
		int result = 0;

		// 저장용 파일이름 , 물리적저장, DB 저장용
		String imgName = "";

		// 물리적인 저장

		// 1. 저장 경로 설정
		String uploadUri = "/uploadFile/memberPhoto";
		// 2. 시스템의 물리적인 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		// 사용자의 업로드 파일을 물리적으로 저장
		if (!regi.getPhotoFile().isEmpty()) {
			// imgName =
			// System.currentTimeMillis()+memberVo.getPhotoFile().getOriginalFilename();
			imgName = regi.getId() + "_" + regi.getPhotoFile().getOriginalFilename();
			// cool + _ + mini.jpg

			// 저장
			regi.getPhotoFile().transferTo(new File(dir, imgName));

			// DB에 저장할 파일 이름을 SET
			regi.setPhoto(imgName);
		}

		result = memberDao.insert(regi);

		return result;
	}

}