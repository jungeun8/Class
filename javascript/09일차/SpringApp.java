package com.sample.di.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context-di-demo4.xml");
		
		CloudDatabaseService service = ctx.getBean("service2", CloudDatabaseService.class);
		service.config();
	}
}
