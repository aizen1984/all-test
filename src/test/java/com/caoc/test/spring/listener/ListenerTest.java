package com.caoc.test.spring.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
public class ListenerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void testListener() {
		NotifyEvent notifyEvent = new NotifyEvent("object", "abc@qq.com", "this is content");
		webApplicationContext.publishEvent(notifyEvent);

	}
}
