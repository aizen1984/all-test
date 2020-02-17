package com.caoc.test.jvm.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PermOOMTest {
	/**
	 * 先设置配置大小
	 * 失败 java8 参数不是这个
	 * -XX:MaxPerSize=2M
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		while (true) {
			list.add(UUID.randomUUID().toString().intern());
		}


	}
}
