package com.sample.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.sample.exception.MallBusinessException;

@Component
@Aspect
public class RunningTimeCheckAdvice {

	/*
	 * ProceedingJoinPoint 객체
	 * 	- 공통기능이 적용되는 대상객체, 대상메소드에 대한 정보를 포함하고 있는 객체다.
	 * 	- 공통기능이 적용되는 대상 메소드를 실행할 수 있는 기능을 가지고 있는 객체다. 
	 * 	- Around advice는 advice내부에서 대상 메소드를 실행하는 수향문을 작성한다.
	 * 	- Around advice는 대상메소드를 실행하는 수행문의 전/후, catch블록, finally블록에서 각각 수행문을 작성
	 * 
	 */
	@Around("within(com.sample.service.*Service)")
	public Object runningTimeCheck(ProceedingJoinPoint joinPoint) {
		
		StopWatch stopWatch = null;
		try {
			// 대상 메소드 실행 전 수행할 수행문 - before advice
			stopWatch = new StopWatch();
			stopWatch.start();
			
			Object returnValue = joinPoint.proceed();		// 대상 메소드를 실행하는 수행문 
			
			// 대상 메소드 정상 종료 후 수행할 수행문 - after returning advice 
			
			return returnValue;
		}catch(Throwable cause) {
			// 대상 메소드에서 예외 발생 후 수행할 수행문 - after throwing advice 
			
			throw new MallBusinessException("오류발생",cause);
		}finally {
			// 대상메소드가 실행된 후 수행할 수행문 - after advice
			stopWatch.stop();
			long runningTime = stopWatch.getTotalTimeMillis();
			System.out.println("메소드 시간: " +runningTime+ "밀리초");
			
		}
	}
}
