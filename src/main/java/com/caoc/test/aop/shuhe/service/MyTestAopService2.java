package com.caoc.test.aop.shuhe.service;

import com.caoc.test.aop.shuhe.base.AbstractReq;
import com.caoc.test.aop.shuhe.base.MyResp;
import com.caoc.test.aop.shuhe.base.WebankCallable;
import org.springframework.stereotype.Service;

@WebankCallable
@Service
public class MyTestAopService2 {
	public MyResp testAop(AbstractReq req, String input) {
		MyResp myResp = new MyResp();
		myResp.setAbstr("11");
		myResp.setRetCode("200");
		myResp.setRetMsg("success");
		System.out.println("input->" + input);
		return myResp;
	}
}
