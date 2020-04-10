package com.caoc.test.designMode.observer;

public class Test {
	public static void main(String[] args) {
		XiaoMei xiaoMei = new XiaoMei();
		LaoLi laoLi = new LaoLi();
		LaoWang laoWang = new LaoWang();
		xiaoMei.addPerson(laoLi);
		xiaoMei.addPerson(laoWang);
		xiaoMei.notifyPerson();
	}
}
