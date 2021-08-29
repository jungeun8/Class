package com.sample.web.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.service.ProductService;
import com.sample.vo.Product;
import com.sample.vo.User;
import com.sample.web.annotation.LoginUser;

@Controller
@RequestMapping("/product")
public class ProductController {

	// 클래스에대한 로그출력 
		private static Logger logger = LogManager.getLogger(HomeController.class);

	/*
	 * ProductService 인터페이스의 구현객체(ProductServiceImpl)가 주입된다.
	 */
	@Autowired
	private ProductService productService;
	
	/**
	 *  모든 상품목록 요청을 처리하는 요청핸들러 메소드 정의 
	 * @param model 뷰페이지에 전달할 데이터를 담는 객체,HandlerAdapter객체가 Model를 생성해서 전달함 
	 * @return 뷰페이지의 이름 
	 */
	@GetMapping("/list")
	public String products(Model model) {
		// 판매중인 전체 상품정보 조회하기
		List<Product> productList = productService.getAllProducts();
		
		// 뷰 페이지에 상품정보 목록 전달하기
		model.addAttribute("products", productList);
		
		// 뷰페이지로 내부이동하기
		// /WEB-INF/views/product/list.jsp로 내부이동해서 JSP 실행시키기
		return "product/list";
	}
	
	// 실제 요청 URL : localhost/spring-mvc/product/detail?no=100
	@GetMapping("/detail")
	public String details(@RequestParam("no") int productNo, Model model) {
		
		logger.debug("detail() 실행됨");
		logger.info("상품번호" + productNo );
		
		// 상품번호에 해당하는 상품정보 조회 
		Product product = productService.getProductDetail(productNo);
		
		// 뷰페이지에 전달하기 위해서 model객체에 저장하기 
		model.addAttribute("product", product);
		
		
		logger.debug("detail() 종료됨");
		return "product/detail";
	}
	
	@GetMapping("/cart")
	public String cart(@LoginUser User user, Model model) {
		
		logger.debug("cart() 실행됨");
		logger.info("로그인된 사용자 정보" + user );
		if(user == null) {
			throw new RuntimeException("장바구니 조회는 로그인 후 사용가능한 서비스입니다.");
		}
		
		List<Map<String, Object>> items = productService.getMyCartItems(user.getId());
		model.addAttribute("items", items);
		
		logger.debug("cart() 종료됨");
		return "product/cart";
	}
}
