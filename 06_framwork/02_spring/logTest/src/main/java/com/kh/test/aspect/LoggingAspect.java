package com.kh.test.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




@Aspect		// Aspect 선언
@Component  // 빈 등록 
public class LoggingAspect {

	// 롬복 없이 로그 객체 사용. Logger 객체 사용
	private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	// * 기본 패키지 경로 내의 모든 메소드를 대상
	@Pointcut("execution(* com.kh.test..*.*(..))")
	private void lPointCut() {}
	
	// * 호출 전 메소드명, 파라미터 정보를 로그로 출력 
	@Before("lPointCut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		  logger.info("method :: {}", joinPoint.getSignature().getName());
		  logger.info("param :: {}", Arrays.toString(joinPoint.getArgs()));		
	}
	
	// * 메소드 실행 시간 추력
	@Around("lPointCut()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();  // 실행 전 시간 측정
		
		Object execute =  joinPoint.proceed();
		
		long end = System.currentTimeMillis();    // 실행 후 시간 측정
		
		logger.info("execution time :: {}", (end - start));
		
		return execute;
	}
	
	
}









