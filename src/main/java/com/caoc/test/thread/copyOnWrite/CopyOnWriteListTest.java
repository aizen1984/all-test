package com.caoc.test.thread.copyOnWrite;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListTest {

	static List<String> list = new CopyOnWriteArrayList<>();

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		for (int i = 0; i < 10; i++) {
			list.add("string" + i);
		}
//		System.out.println(list.size());

		new Thread(() -> {
			while (true) {
				if (list.size() > 0) {
					System.out.println(list.size() - 1);
					String content = list.get(list.size() - 1);

				} else {
					break;
				}
			}
		}).start();

		new Thread(() -> {
			while (true) {
				if (list.size() <= 0) {
					break;
				}
				list.remove(0);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {

			}
		}).start();



	}
}
