package com.caoc.test.thread.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WrongInit {
	private Map<Integer, String> students;

	public WrongInit() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				students = new HashMap<>();
				students.put(1, "王小美");
				students.put(2, "钱二宝");
				students.put(3, "周三");
				students.put(4, "赵四");
			}
		}).start();
	}

	public Map<Integer, String> getStudents() {
		return students;
	}

	public static void main(String[] args) throws InterruptedException {
		WrongInit multiThreadsError6 = new WrongInit();
		TimeUnit.SECONDS.sleep(1);
		System.out.println(multiThreadsError6.getStudents().get(1));

	}
}
