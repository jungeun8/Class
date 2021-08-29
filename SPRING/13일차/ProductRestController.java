package com.sample.web.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.service.ProductService;
import com.sample.vo.Product;

@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

	@Autowired ProductService productService;
	
	// 실제 요청URL /spring-mvc/rest/products
	@GetMapping
	public ResponseEntity<List<Product>> list() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	// 실제 요청URL /spring-mvc/rest/products/31
	@GetMapping("/{no}")
	public ResponseEntity<Product> detail(@PathVariable("no") int productNo) {
		Product product = productService.getProductDetail(productNo);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
}
