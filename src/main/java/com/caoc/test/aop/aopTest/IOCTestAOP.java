package com.caoc.test.aop.aopTest;

import com.caoc.test.aop.domain.MathCalculator;
import com.caoc.test.aop.req.CalReq;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.caoc.test.aop")
public class IOCTestAOP {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(IOCTestAOP.class);
		applicationContext.refresh();
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
//		mathCalculator.div(10, 1);
		mathCalculator.div2(CalReq.builder().id(1).name("46").build());
		applicationContext.close();

	}
}
