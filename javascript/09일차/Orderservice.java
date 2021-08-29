package com.sample.di.demo2;

import com.sample.di.demo1.BookDao;
import com.sample.di.demo1.CustomerDao;
import com.sample.di.demo1.OrderDao;

public class Orderservice {
	
	// 스프링 컨테이너를 사용하기 전 (의존성 주입을 사용하기 전)
	// 의존하는 객체를 필요로하는 OderService가 직접객체를 생성했다.
	// *DAO객체들을 여러 Service에서 개별적으로 생성해서 사용한다.
	// *동일한 DAO객체들이 여러개 존재한다.(메모리 부하 증가)
	//OrderDao orderDao = new OrderDao();
	
	
	// 스프링 컨테이너를 사용하기 전 (의존성 주입을 사용하기 전)
	// 의존하는 객체를 제공해주는 getinstance()메소드를 호출해서 미리 생성해둔 객체를 가져온다.
	// *객체를 하나만 존재한다.(싱글턴 객체, 메모리 부하 감소)
	// * 싱글턴 객체로 사용하기 위한 추가적인 코드를 DAO클래스에 반복적으로 코딩해야한다.
	//OrderDao orderDao = OrderDao.getInstance();

	// 스프링 컨테이너를 사용함(의존성 주입을 사용함)
	// 1. 의존성 주입을 받은 객체를 저장하는 멤버변수를 정의한다.
	private OrderDao orderDao;
	private BookDao bookDao;
	private CustomerDao customerDao;
	
	// 2. 의존성 주입에 활용할 setter 메소드를 정의한다.
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	// 주문하기
	public void order() {
		// 새로운 주문정보 저장 	<--orderDao.insertOrder()
		// 상품의 재고 변경 	<-- bookDao.updateBook()
		// 고객의 포인트 변경 	<-- CustomerDao.updateCustomer()
		System.out.println("책 주문요청을 처리합니다.");
		orderDao.insertOrder();
		bookDao.updateBook();
		customerDao.updateCustomer();	
		
	}
	// 주문취소하기 
	public void cancel() {
		// 주문정보 취소
		// 책의 재고 변경 
		// 고객의 포인트 변경 
		System.out.println("책 주문내용에 대한 취소요청을 처리합니다.");
		orderDao.cancleOrder();
		bookDao.updateBook();
		customerDao.updateCustomer();
			
		}
}
