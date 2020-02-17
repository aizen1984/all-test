package com.caoc.test.memoryLeak;

import java.util.HashMap;
import java.util.Map;

public class TestHashMapMemoryLeak {
	static Map<String, Object> map = new HashMap<>();

	/**
	 * 测试需要修改参数
	 * vm
	 * -Xms3m -Xmx3m -XX:+HeapDumpOnOutOfMemoryError
	 *
	 * jps
	 * jconsole
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		while (true) {
			map.put("1", "1");
			count++;
			if (count % 1000 == 0) {
				System.out.println("map size " + map.size());
				System.out.println("Free memory after count " + count + " is " + getFreeMemory() + "MB");
				sleep(1000);
			}
		}
	}

	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory() / (1024 * 1024);
	}

	public static void sleep(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
