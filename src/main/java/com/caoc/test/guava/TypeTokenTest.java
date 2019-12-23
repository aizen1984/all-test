package com.caoc.test.guava;

import com.caoc.test.spring.listener.NotifyEvent;
import com.google.common.reflect.TypeToken;
import org.springframework.context.ApplicationEvent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeTokenTest {
	public static void main(String[] args) {
		TypeToken<? extends ApplicationEvent> token = TypeToken.of(ApplicationEvent.class);
		ParameterizedType type = (ParameterizedType) token.getSubtype(NotifyEvent.class).getType();
		Type[] para = type.getActualTypeArguments();
		System.out.println(para);
	}
}
