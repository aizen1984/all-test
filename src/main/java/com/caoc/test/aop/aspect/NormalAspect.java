package com.caoc.test.aop.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class NormalAspect {

	@Pointcut("execution(public * com.caoc.test.aop.domain.MathCalculator.*(..))")
	private void pointCut() {
	}


	@Before(value = "pointCut()")
	public void logStart(JoinPoint joinPoint) {
		System.out.println("logStart >>>" + joinPoint.getSignature().getName()
				+ ">>>" + Arrays.toString(joinPoint.getArgs()));
	}

	@After(value = "com.caoc.test.aop.aspect.NormalAspect.pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println("logEnd >>>" + joinPoint.getSignature().getName()
				+ ">>>" + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(value = "execution(public * com.caoc.test.aop.domain.MathCalculator.*(..))", returning = "object")
	public void logReturn(Object object) {
		System.out.println("logReturn >>>" + object);
	}

	@AfterThrowing(value = "execution(public * com.caoc.test.aop.domain.MathCalculator.*(..))", throwing = "object")
	public void logException(Exception object) {
		System.out.println("logException >>>" + object);
	}


}
