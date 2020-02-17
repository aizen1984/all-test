package com.caoc.test.jvm.settings;

import java.util.concurrent.TimeUnit;

/**
 * 堆的最大和初始设定大小
 */
public class XmxAndXmsTest {
	/**
	 * -Xmx5M -Xms1M XX:+PrintGCDetails -verbose:gc
	 * <p>
	 * XX:+PrintGCDetails  gc详细信息 在idea中调用不好使
	 * -verbose:gc 控制台打印
	 *
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		byte[] b;
		System.gc();
		System.out.print("xmx");
		System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
		System.out.print("xms");
		System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
		System.out.print("total");
		System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

//		while (true) {
//
//			 b = new byte[1 * 1024 * 1024];
//			TimeUnit.MILLISECONDS.sleep(1000);
//			System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
//		}
		//-Xmx20M -Xms20M  -Xmn1M -verbose:gc -XX:SurvivorRatio=2
		//-Xmx20M -Xms20M  -Xmn7M -verbose:gc -XX:SurvivorRatio=2
		// 2代表  总数 1：2 分成3分   3分之二为eden  六分之一为form 六分之一为to
		// -Xss 栈的空间 一般几百K
		for (int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}

	}
}
