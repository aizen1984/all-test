package com.caoc.test.spring.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author caochen
 */
public class GenericsEvent<T> extends ApplicationEvent {

	public GenericsEvent(T source) {
		super(source);
	}

	@Override
	public T getSource() {
		return (T) super.getSource();
	}
}
