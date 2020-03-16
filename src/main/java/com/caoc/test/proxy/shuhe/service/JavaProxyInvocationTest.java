package com.caoc.test.proxy.shuhe.service;

import com.caoc.test.proxy.shuhe.entity.OrgOpenAcctApplyReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan("com.caoc.test.proxy")
@Service
public class JavaProxyInvocationTest {
	@Autowired
	WebankHttp webankHttp;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(JavaProxyInvocationTest.class);
		applicationContext.refresh();

		JavaProxyInvocationTest javaProxyInvocationTest = (JavaProxyInvocationTest) applicationContext.getBean("javaProxyInvocationTest");
		javaProxyInvocationTest.webankHttp.orgOpenAcctApply(new OrgOpenAcctApplyReq());
		applicationContext.close();
	}

}
