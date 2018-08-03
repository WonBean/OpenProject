package com.bitcamp.op.member.service;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.bitcamp.op.member.model.MemberVo;

public class SimpleMailSenderService {

	@Autowired
	JavaMailSender mailSender;

	public void simpleMailSend(MemberVo member, HttpServletRequest request) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("horo6711@gmail.com");
		message.setTo(member.getMemberId());
		message.setSubject("안녕하세요. 회원가입을 축하합니다.");
		message.setText("축~!!");

		mailSender.send(message);

		System.out.println("발송 완료");

	}

	public void htmlMailSend() {

		MimeMessage message = mailSender.createMimeMessage();

		try {
			// 제목설정
			message.setSubject("[안내] 회원 가입 안내", "utf-8");

			// 내용 구성 ( HTML )
			String html = "<h1>안녕하세요 회원님</h1> 회원 가입을 진심으로 감사드립니다.<br>" + " 재 방문을 원하실 경우 아래 링크를 클릭해 주세요. <br><br>"
					+ "<a href=\"http://www.daum.net\">사이트 바로가기</a>";
			// 내용 설정
			message.setText(html, "utf-8", "html");

			// 보내는 사람의 메일 설정
			message.setFrom(new InternetAddress("horo6711@naver.com"));

			// 받는 사람의 메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress("horo6711@naver.com"));

			mailSender.send(message);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}

	public void fileMailSend() {
		MimeMessage message = mailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			messageHelper.setSubject("[공지] 악성코드가 있습니다.");
			String html = "<strong>안녕하세요</strong>꾸룩꾸룩";
			messageHelper.setText(html, true);
			messageHelper.setFrom("horo6711@gmail.com", "호로");
			messageHelper.setTo(new InternetAddress("horo6711@naver.com", "horo", "utf-8"));

			DataSource source = new FileDataSource("C:\\Users\\HB04-23\\Downloads\\설명.txt");
			messageHelper.addAttachment(MimeUtility.encodeText("설명.txt", "UTF-8", "B"), source);
			
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
			return;
		} catch (Throwable e) {
			e.printStackTrace();
			return;
		}
	}
}
