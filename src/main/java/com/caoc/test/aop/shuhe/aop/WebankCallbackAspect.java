package com.caoc.test.aop.shuhe.aop;

import com.caoc.test.aop.shuhe.base.AbstractReq;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class WebankCallbackAspect {
	@Around(value = "within(com.caoc.test.aop.shuhe.base.WebankCallable)" + "&& args(*,input,..)")
	public Object doWithAopTest(ProceedingJoinPoint thisJoinPoint, String input) {
		AbstractReq abstractReq;
		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
		methodSignature.getParameterTypes();
		return null;
	}

	/**
	 * within对类
	 * annotation对方法
	 *
	 * @param thisJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "@within(com.caoc.test.aop.shuhe.base.WebankCallable)")
	public Object doWithAopTest(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		AbstractReq abstractReq;
		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
		methodSignature.getParameterTypes();
		return thisJoinPoint.proceed(thisJoinPoint.getArgs());
	}

	@Around(value = "@within(com.caoc.test.aop.shuhe.base.WebankCallable)&&"
			+ "execution(public com.caoc.test.aop.shuhe.base.AbstractResp+ *.*(com.caoc.test.aop.shuhe.base.AbstractReq+,String,..))"
			+ "&& args(*,input,..)")
	public Object doWithAopTest2(ProceedingJoinPoint thisJoinPoint, String input) throws Throwable {
		AbstractReq abstractReq;
		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
		methodSignature.getParameterTypes();
		return thisJoinPoint.proceed(thisJoinPoint.getArgs());
	}
}
