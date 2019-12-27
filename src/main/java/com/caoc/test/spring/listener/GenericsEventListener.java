package com.caoc.test.spring.listener;

import com.alibaba.fastjson.util.TypeUtils;
import com.google.common.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author caochen
 */
public abstract class GenericsEventListener<T> implements ApplicationListener<GenericsEvent<T>>, InitializingBean {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private Class<?> genericType;

	@Override
	public void afterPropertiesSet() throws Exception {
		genericType = getGenericTypeClass();
	}

	private Class<?> getGenericTypeClass() {
		TypeToken<? extends GenericsEventListener> token = TypeToken.of(getClass());
		ParameterizedType type = (ParameterizedType) token.getSupertype(GenericsEventListener.class).getType();
		Type[] types = type.getActualTypeArguments();
		return TypeUtils.getClass(types[0]);
	}


	@Override
	public void onApplicationEvent(GenericsEvent<T> event) {
		T source = event.getSource();
		if (genericType.isAssignableFrom(source.getClass())) {
			onEvent(source);
		}
	}


	protected abstract void onEvent(T t);

	@ComponentScan(basePackages = "com.caoc.test",
			includeFilters =
			@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = GenericsEventListener.class))
	@Configuration
	public static class Config {
		@Bean
		public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(
				@Qualifier("listenerExecutor") ThreadPoolTaskExecutor threadPoolExecutor, LoggingErrorHandler handler) {
			final SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
			simpleApplicationEventMulticaster.setTaskExecutor(threadPoolExecutor);
			simpleApplicationEventMulticaster.setErrorHandler(handler);
			return simpleApplicationEventMulticaster;
		}
	}


}
