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
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/context-mybatis.xml");
		
//		ProductService service = context.getBean(ProductService.class);
//		List<Product> products = service.getAllProductList();
//		
//		for(Product product : products) {
//			System.out.println("상품번호 : " + product.getNo());
//			System.out.println("상품명 : " + product.getName());
//			System.out.println("카테고리 : " + product.getCategory());
//			System.out.println("메이커 : " + product.getMaker());
//			System.out.println("가격 : " + product.getPrice());
//			System.out.println("할인가 : " + product.getDiscountPrice());
//		}
		
		UserService userService = context.getBean(UserService.class);
		
		User user = new User();
		user.setId("hong1000");
		user.setName("홍길동");
		user.setPassword("zxcv1234");
		user.setEmail("hong1000@gmail.com");
		user.setPhoneNumber("01012345678");
		
		userService.addNewUser(user);
	}
}
