package com.caoc.test.spring.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author caochen
 */
public class DebitAccountEventPublisher {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public <T> void sendMqMsg(ExchangeAwareEvent<T> msg) {
		applicationEventPublisher.publishEvent(msg);
	}

}
