package com.caoc.test.annoationTest.conditionTest;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(InitConditional.class)
public class AmazonTest {
	public void testGet() {
		System.out.println("testGet Associated");
		System.out.println("hei hei ");
	}
}
