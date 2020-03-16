package com.caoc.test.proxy.shuhe.aop;

import com.caoc.test.aop.shuhe.base.AbstractResp;
import com.caoc.test.proxy.shuhe.entity.OrgOpenAcctApplyResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
@Slf4j
@Component
public class WebankHttpInvocationHandler implements InvocationHandler {
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
//		System.out.println("proxy->" + proxy);
		String methodName = method.getName();
		final AbstractResp resp = new OrgOpenAcctApplyResp();
		resp.setRetCode("200");
		System.out.println("java 动态代理");
		return resp;
	}
}
