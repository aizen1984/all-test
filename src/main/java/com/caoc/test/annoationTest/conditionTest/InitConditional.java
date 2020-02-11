package com.caoc.test.annoationTest.conditionTest;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class InitConditional implements Condition {
	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		boolean flag = conditionContext.getBeanFactory().containsBean("amazonTest");
		return true;
	}
}
