package com.caoc.test.designMode.observer;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LaoLi implements Person {

	private String name = "小李";

	@Override
	public void getMessage(String s) {
		System.out.println(name + "接到了小美打过来的电话，电话内容是：->" + s);
	}
}
