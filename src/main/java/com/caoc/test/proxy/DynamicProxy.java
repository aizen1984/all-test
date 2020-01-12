package com.caoc.test.proxy;

import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	private Object target;

	public DynamicProxy(Object object) {
		this.target = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}

	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}


	private void after() {
		System.out.println("after￿￿￿￿");
	}

	private void before() {
		System.out.println("before");
	}


	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		DynamicProxy proxy = new DynamicProxy(hello);

		Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
				hello.getClass().getInterfaces(), proxy);

		Hello helloProxy2 = proxy.getProxy();

		helloProxy.sayHello("caoc");
	}


}
