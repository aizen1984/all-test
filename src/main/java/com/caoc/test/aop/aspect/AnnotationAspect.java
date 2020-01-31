package com.caoc.test.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {
	/**
	 *  单独的 within不可
	 *  单独的 annotation可以
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(com.caoc.test.aop.annotation.MyAop)" +
					" ||@within(com.caoc.test.aop.annotation.MyAop)")
	public Object annotationTest(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("AnnotationAspect>>>" + pjp.toString());
		return pjp.proceed();
	}
}
