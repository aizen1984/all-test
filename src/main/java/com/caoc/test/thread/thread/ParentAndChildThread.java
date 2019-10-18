package com.caoc.test.thread.thread;

import com.rabbitmq.tools.json.JSONUtil;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParentAndChildThread extends ThreadLocal {

	public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	public static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "begin");
		threadLocal.set("threadLocal");
		inheritableThreadLocal.set("inheritableThreadLocal");
		IntStream.range(0, 10).forEach(i ->
				new Thread(() -> {
					System.out.println("current thread is " + Thread.currentThread().getName() + "-" + threadLocal.get()
							+ "-" + inheritableThreadLocal.get());
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}).start());
		System.out.println(Thread.currentThread().getName() + "end");
	}
}
