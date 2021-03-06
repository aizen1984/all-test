package com.caoc.test.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FactoryBeanLearn implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return new FactoryBeanServiceImpl();
	}

	@Override
	public Class<?> getObjectType() {
		return FactoryBeanService.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
