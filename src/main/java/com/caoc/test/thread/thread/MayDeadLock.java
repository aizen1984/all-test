package com.caoc.test.thread.thread;

public class MayDeadLock {
	Object o1 = new Object();
	Object o2 = new Object();

	public void thread1() throws InterruptedException {
		synchronized (o1) {
			Thread.sleep(1);
			synchronized (o2) {
				System.out.println("thread1 准备上2把锁");
			}
		}
	}


	public void thread2() throws InterruptedException {
		synchronized (o2) {
			Thread.sleep(1);
			synchronized (o1) {
				System.out.println("thread1 准备上2把锁");
			}
		}
	}

	public static void main(String[] args) {
		MayDeadLock mayDeadLock = new MayDeadLock();
		new Thread(()->{
			try {
				mayDeadLock.thread1();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(()->{
			try {
				mayDeadLock.thread2();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
