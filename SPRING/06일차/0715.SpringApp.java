package com.sample.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.ProductService;
import com.sample.service.UserService;
import com.sample.vo.Product;
import com.sample.vo.User;

public class SpringApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/context.xml");
		
	
		UserService userService = context.getBean(UserService.class);
		User user = userService.getUserDetail("hong1234");
		System.out.println(user);
		
		User user2 =User.builder().id("hong1512").password("zxcv1234").name("홍길똥")
				.email("hong1512").phoneNumber("010-1234-1234").build();//
		userService.addNewUser(user2);
	}

}
