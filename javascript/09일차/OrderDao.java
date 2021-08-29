package com.sample.di.demo1;

public class OrderDao {
	
	public void insertOrder() {
		System.out.println("주문정보를 저장합니다.");
	}
	public void cancleOrder() {
		System.out.println("주문정보를 취소합니다.");
	}

	public void getOrderListByUserId() {
		System.out.println("나의 주문내역을 반환한다.");
	}
}
