package com.caoc.test.spring.bean;

import lombok.Data;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationBeanDefinitionDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AnnotationBeanDefinitionDemo.class);
		applicationContext.refresh();
		System.out.println(applicationContext.getBean(config.class));
		System.out.println(applicationContext.getBean(User.class));


		applicationContext.close();

	}





	@Configuration
	public static class config {
		@Bean(name = {"user1,user2"})
		public User getUser() {
			User user = new User();
			user.setUserId("1");
			user.setUserName("hello46");
			return user;
		}
	}


	@Data
	public static class User {
		private String userId;
		private String userName;
	}
}
