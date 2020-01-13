package com.caoc.test.proxy.spring;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class GreetingAroundAdvice implements MethodInterceptor {


	private void after() {
		System.out.println("after￿￿￿￿");
	}

	private void before() {
		System.out.println("before");
	}

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		before();
		Object result = methodInvocation.proceed();
		after();
		return result;
	}





}
