package com.caoc.test.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundBeanAspect {

	@Around("bean(mathCalculator)")
	public Object aroundBeanMethod(ProceedingJoinPoint pjp) throws Throwable {
		String name = ((MethodSignature) pjp.getSignature()).getMethod().getName();
		System.out.println("AroundBeanAspect >>>" + name);
		return pjp.proceed();
	}
}
