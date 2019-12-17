package com.caoc.test.spring.listener;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class NotifyEvent extends ApplicationEvent {

	private String email;
	private String content;

	public NotifyEvent(Object source, String email, String content) {
		super(source);
		this.email = email;
		this.content = content;
	}
}
