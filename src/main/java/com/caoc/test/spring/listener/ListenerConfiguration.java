package com.caoc.test.spring.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author caochen
 */

@Configuration
public class ListenerConfiguration {
	@Value("${le.front.threadpool.core.size}")
	private Integer corePoolSize = 20;

	@Value("${le.front.threadpool.max.size}")
	private Integer maxPoolSize = 50;

	@Value("${le.front.threadpool.keep.alive.seconds}")
	private Integer keepAliveSeconds = 60;

	@Value("${le.front.threadpool.queue.capacity}")
	private Integer queueCapacity = 50;

	@Value("${le.front.threadpool.await.seconds}")
	private Integer awaitSeconds = 10;

	@Bean("listenerExecutor")
	public ThreadPoolTaskExecutor getAsyncTreadPollTaskExecutor() {
		return getThreadPoolTaskExecutor(corePoolSize, maxPoolSize, keepAliveSeconds, queueCapacity, "frontSync-", awaitSeconds);
	}

	private ThreadPoolTaskExecutor getThreadPoolTaskExecutor(Integer coreLogPoolSize, Integer maxLogPoolSize, Integer keepLogAliveSeconds, Integer queueLogCapacity, String s, Integer awaitLogSeconds) {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(coreLogPoolSize);
		executor.setMaxPoolSize(maxLogPoolSize);
		executor.setKeepAliveSeconds(keepLogAliveSeconds);
		executor.setQueueCapacity(queueLogCapacity);
		executor.setThreadNamePrefix(s);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setAwaitTerminationSeconds(awaitLogSeconds);
		executor.initialize();
		return executor;
	}


}
