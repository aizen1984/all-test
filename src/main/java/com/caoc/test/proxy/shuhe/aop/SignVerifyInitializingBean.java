package com.caoc.test.proxy.shuhe.aop;

import com.caoc.test.proxy.shuhe.entity.UrlCodeEnum;
import com.caoc.test.proxy.shuhe.service.WebankHttp;
import com.google.common.base.Enums;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Method;

public interface SignVerifyInitializingBean extends InitializingBean {
	Class<?> getType();

	@Override
	default void afterPropertiesSet() {
		final Class<?> type = getType();
		for (Method method : type.getDeclaredMethods()) {
			final String name = getEnumName(method);
			if (StringUtils.isEmpty(name)) {
				continue;
			}
			Enums.getIfPresent(UrlCodeEnum.class, name).or(() -> {
				throw new RuntimeException("dont have method name");
			});

			final Class<?> requestType = method.getParameterTypes()[0];
			final Class<?> returnType = method.getReturnType();
			if (WebankHttp.class.isAssignableFrom(type)) {
				System.out.println("assignableFrom");
			}

		}
	}

	/**
	 * null will always pass the check
	 */
	default String getEnumName(Method method) {
		return method.getName();
	}
}
