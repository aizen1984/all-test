package com.caoc.test.annoationTest.conditionTest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBean(AmazonTest.class)
public class WelcomeController {
	public void testWelcome(){
		String appProperties = "appProperties";
		String globalProperties = "globalProperties";
		System.out.println(appProperties);
		System.out.println(globalProperties);
	}
}
