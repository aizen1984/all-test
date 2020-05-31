package com.caoc.test.thread.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadState {
	public static void main(String[] args) {

	}

	static class TimeWaiting implements Runnable{
		@SneakyThrows
		@Override
		public void run() {
			synchronized (TimeWaiting.class) {
				while (true) {
					TimeWaiting.class.wait();
				}
			}
		}
	}

	static class Blocked implements Runnable{

		@SneakyThrows
		@Override
		public void run() {
			synchronized (Blocked.class) {
				while (true) {
					TimeUnit.SECONDS.sleep(100);
				}
			}
		}
	}


	static class SleepUtils{
		public static final void second(long seconds) {
			try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException e) {
			}

		}
	}
}
