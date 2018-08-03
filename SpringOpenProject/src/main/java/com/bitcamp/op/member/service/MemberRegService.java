package com.bitcamp.op.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.op.member.dao.MemberDaoInterface;
import com.bitcamp.op.member.dao.MybatisMemberDao;
import com.bitcamp.op.member.model.MemberVo;



public class MemberRegService {
	
	//@Autowired   
	//MemberDao memberDao;
	
	//@Autowired
	//JdbcTemplateMemberDao memberDao;
	
	//@Autowired
	//MybatisMemberDao memberDao;
	
	@Autowired
	SqlSessionTemplate template;
	
	private MemberDaoInterface memberDao;
	

	@Transactional
	public int RegMember(MemberVo memberVo, HttpServletRequest request) throws Exception {
		
		memberDao = template.getMapper(MemberDaoInterface.class);
		
		
		
		int result = 0;		
		//Connection conn = null;
		// 저장용 파일이름 , 물리적저장, DB 저장용
		String imgName = "";

		// 물리적인 저장		
		// 1. 저장 경로 설정
		String uploadUri = "/uploadFile/memberPhoto";
		// 2. 시스템의 물리적인 경로 
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);
		System.out.println(dir);
		
		// 사용자의 업로드 파일을 물리적으로 저장
		if(!memberVo.getPhotoFile().isEmpty()) {
			//imgName = System.currentTimeMillis()+memberVo.getPhotoFile().getOriginalFilename();
			imgName = memberVo.getMemberId()+"_"+memberVo.getPhotoFile().getOriginalFilename();
			// cool + _ + mini.jpg
			
			// 저장
			memberVo.getPhotoFile().transferTo(new File(dir, imgName));
			
			// DB에 저장할 파일 이름을 SET
			memberVo.setMemberPhoto(imgName);
		}
		
		
		
		//try {
			//conn = ConnectionProvider.getConnection();
			//result = memberDao.insertMember(conn, memberVo);
		
		
		System.out.println("입력 전 mIdx : " + memberVo.getmIdx());
		
		
		result = memberDao.insertMember(memberVo);
		
		
		System.out.println("입력 후 mIdx : " + memberVo.getmIdx());
		
			
		//} finally {
		//	JdbcUtil.close(conn);
		//}

		return result;
	}

	
	
	
	
	
	
	
	
}
