package com.ethan.test.threadLocal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class TestThreadLocal {
    ThreadLocal<Integer> local = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public void getAndAdd() {
        Integer i = local.get();
        System.out.println(Thread.currentThread().getName() + "-" + "value-" + i);
        local.set(i + 1);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        Runnable runnable = () -> testThreadLocal.getAndAdd();

        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);


    }


}
