package com.caoc.test.jvm.stopWorld;

import java.util.HashMap;

public class MyThread extends Thread {
	HashMap<Long, byte[]> map = new HashMap<>();

	/**
	 *  -Xmx512M -Xms512M -XX:+UseSerialGC -Xmn1m -XX:PretenureSizeThreshold=50 -XX:MaxTenuringThreshold=1
	 */
	@Override
	public void run() {
		try {
			while (true) {
				if (map.size() * 512 / 1024 / 1024 >= 450) {
					System.out.println("total:"+ Runtime.getRuntime().totalMemory()/1024/1024);
					System.out.println("free:"+ Runtime.getRuntime().freeMemory()/1024/1024);
					System.out.println("max:"+ Runtime.getRuntime().maxMemory()/1024/1024);
					System.out.println("=======准备清理=========" + map.size() * 512 / 1024 / 1024);
					map.clear();
				}

				for (int i = 0; i < 1000; i++) {
					map.put(System.nanoTime(), new byte[480]);
				}
				Thread.sleep(2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyThread myThread  = new MyThread();
		myThread.run();
	}
}
