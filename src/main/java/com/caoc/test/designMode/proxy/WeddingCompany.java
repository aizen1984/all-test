package com.caoc.test.designMode.proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeddingCompany implements ProxyInterface {

	ProxyInterface proxyInterface;

	@Override
	public void marry() {
		System.out.println("我们是婚庆公司的");
		System.out.println("我们在做结婚前的准备工作");
		System.out.println("节目彩排...");
		System.out.println("礼物购买...");
		System.out.println("工作人员分工...");
		System.out.println("可以开始结婚了");
		proxyInterface.marry();
		System.out.println("结婚完毕，我们需要做后续处理，你们可以回家了，其余的事情我们公司来做");
	}
}
