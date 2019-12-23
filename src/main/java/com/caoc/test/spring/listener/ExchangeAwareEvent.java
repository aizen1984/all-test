package com.caoc.test.spring.listener;

import lombok.Getter;

/**
 * @author caochen
 */
public class ExchangeAwareEvent<T> extends GenericsEvent<T> implements ExchangeAware {

	@Getter
	private final String exchange;


	public ExchangeAwareEvent(T source, String exchange) {
		super(source);
		this.exchange = exchange;
	}

	public Object getBody() {
		return getSource();
	}
}
