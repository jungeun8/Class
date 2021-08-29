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
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/context-aop.xml");
		
		ProductService productService = context.getBean(ProductService.class);
		UserService userService = context.getBean(UserService.class);
		
		List<Product> products = productService.getAllProductList();
		productService.addProducts(31, 100);
		
		User user = userService.getUserDetail("hong");
		userService.removeUser("hong");
	}
}
