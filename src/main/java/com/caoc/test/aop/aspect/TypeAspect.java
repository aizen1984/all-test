package com.caoc.test.aop.aspect;

import com.caoc.test.aop.domain.NeedAspectType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TypeAspect {

	@Before("execution(public * com.caoc.test.aop..*(com.caoc.test.aop.domain.NeedAspectType+,..))"
			+ "&& args(needAspectType,..)")
	public void doValidateUid(NeedAspectType needAspectType) {
		System.out.println("TypeAspect >>>" + needAspectType.getClass());
	}
}
