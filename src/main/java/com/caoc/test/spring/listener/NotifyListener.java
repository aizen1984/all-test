package com.caoc.test.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author caochen
 */
@Component
public class NotifyListener implements ApplicationListener<NotifyEvent> {

	@Override
	public void onApplicationEvent(NotifyEvent notifyEvent) {
		System.out.println("邮件地址" + notifyEvent.getEmail());
		System.out.println("邮件内容" + notifyEvent.getContent());
	}
}
