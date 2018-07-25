package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.model.Member;
import member.service.MemberDeleteService;
import member.service.MemberRegService;

public class SpringMain {

	// Spring 컨테이너 생성
	private static GenericXmlApplicationContext ctx = null;

	public static void main(String[] args) {

		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		MemberRegService regService = null; // new MemberRegService();
		
		regService = ctx.getBean("memberRegSvc", MemberRegService.class);
		
		regService.insertMember(new Member());
		
		System.out.println("---------------------------");
		
		MemberDeleteService deleteService = ctx.getBean("membeDeleteSvc", MemberDeleteService.class);

		deleteService.deleteMember("cool");

		
		System.out.println("---------------------------");
		
		MemberRegService regService2 = ctx.getBean("memberRegSvc", MemberRegService.class);
		
		System.out.println("MemberRegService 비교 : " + (regService == regService2));
		

		System.out.println("---------------------------");
		
		MemberDeleteService deleteService2 = ctx.getBean("membeDeleteSvc", MemberDeleteService.class);
		
		System.out.println("MemberDeleteService 비교 : " + (deleteService == deleteService2));
		
		
		
		
		
		
		
		
		
	}

}
