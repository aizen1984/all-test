package com.caoc.test.spring.factoryBean;

import org.springframework.stereotype.Service;

@Service
public class FactoryBeanServiceImpl implements FactoryBeanService {
	@Override
	public void testFactoryBean() {
		System.out.println("我是FactoryBean的一个测试类。。。。");
	}
}
