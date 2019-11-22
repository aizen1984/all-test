package com.caoc.test.thread.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class FeatureIsWait {

	public static void main(String[] args) {
		List<FutureTask> featureList = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(20);

		IntStream.range(0, 10).forEach(i -> {
			Callable callable = () -> {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				if (i % 2 == 0) {
//					throw new RuntimeException();
//				}
				if (i ==2 ) {
					TimeUnit.SECONDS.sleep(7);
				}
				return i;
			};
			FutureTask futureTask = new FutureTask(callable);
			executorService.execute(futureTask);
			featureList.add(futureTask);
		});


		featureList.parallelStream().forEach(t -> {
			try {
				System.out.println(t.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});

		executorService.shutdown();

	}


}
