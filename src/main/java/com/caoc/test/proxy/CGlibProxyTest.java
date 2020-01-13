package com.caoc.test.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxyTest implements MethodInterceptor {


	private static CGlibProxyTest instance = new CGlibProxyTest();

	public static CGlibProxyTest getInstance() {
		return instance;
	}


	public <T> T getProxy(Class<T> cls) {
		return (T) Enhancer.create(cls, this);
	}

	private void after() {
		System.out.println("after￿￿￿￿");
	}

	private void before() {
		System.out.println("before");
	}


	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		before();
		Object result = methodProxy.invokeSuper(o, args);
		after();
		return result;
	}

	public static void main(String[] args) {
		CGlibProxyTest cGlibProxyTest = CGlibProxyTest.getInstance();
		Hello cglibProxy = cGlibProxyTest.getProxy(HelloImpl.class);
		cglibProxy.sayHello("what");
	}

}
