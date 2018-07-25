package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

//Advice 클래스
public class ExeTimeAspect {

	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {

		// 공통 코드 : 시작 시간
		long startTime = System.nanoTime();

		try {
			// 핵심 코드 실행
			Object result = joinPoint.proceed(); // 핵심 로직의 메서드 실행 요청
			return result;
		} finally {
			// 공통 코드 : 종료시간
			long endtime = System.nanoTime();

			Signature signature = joinPoint.getSignature();

			System.out.printf("%S.%S 실행 시간 : %d ns \n", joinPoint.getTarget().getClass().getSimpleName(),
					signature.getName(), (endtime - startTime));

		}

	}

}
