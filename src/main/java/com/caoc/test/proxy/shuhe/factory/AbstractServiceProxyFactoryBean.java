package com.caoc.test.proxy.shuhe.factory;

import com.google.common.reflect.Reflection;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;

public abstract class AbstractServiceProxyFactoryBean<T> implements FactoryBean<T> {

	public abstract InvocationHandler getHandler();

	public abstract Class<T> getType();

	@Override
	public Class<?> getObjectType() {
		return getType();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public T getObject() {
		return Reflection.newProxy(getType(), getHandler());
	}

}
