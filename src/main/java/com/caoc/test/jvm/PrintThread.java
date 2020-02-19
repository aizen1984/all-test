package com.caoc.test.jvm;

import lombok.SneakyThrows;

public class PrintThread extends Thread {

	public static final long startTime = System.currentTimeMillis();

	@SneakyThrows
	@Override
	public void run() {
		while (true) {
			long t = System.currentTimeMillis() - startTime;
			System.out.println("time:" + t);
			Thread.sleep(100);
		}
	}

	public static void main(String[] args) {
		PrintThread thread = new PrintThread();
		thread.run();
	}
}
