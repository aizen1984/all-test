package com.caoc.test.aop.shuhe.service;

import com.caoc.test.aop.shuhe.base.AbstractReq;
import com.caoc.test.aop.shuhe.base.MyResp;
import com.caoc.test.aop.shuhe.base.WebankCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan("com.caoc.test.aop")
public class MyTestAopService {


//	@WebankCallable
	public MyResp testAop(AbstractReq req, String input) {
		MyResp myResp = new MyResp();
		myResp.setAbstr("11");
		myResp.setRetCode("200");
		myResp.setRetMsg("success");
		System.out.println("input->" + input);
		return myResp;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(MyTestAopService.class);
		applicationContext.refresh();
		MyTestAopService myTestAopService = (MyTestAopService) applicationContext.getBean("myTestAopService");
		MyTestAopService2 myTestAopService2 = (MyTestAopService2) applicationContext.getBean("myTestAopService2");
		myTestAopService2.testAop(new AbstractReq(), "myTestAopService2");
		myTestAopService.testAop(new AbstractReq(), "myTestAopService");
		applicationContext.close();
	}
}
