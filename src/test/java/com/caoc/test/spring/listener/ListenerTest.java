package com.caoc.test.spring.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListenerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void testListener() {
		NotifyEvent notifyEvent = new NotifyEvent("object", "abc@qq.com", "this is content");
		webApplicationContext.publishEvent(notifyEvent);

	}
}
