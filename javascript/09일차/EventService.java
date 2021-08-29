package com.sample.di.demo3;

import com.sample.di.demo1.BookDao;
import com.sample.di.demo1.OrderDao;

public class EventService {
	
	//MessageSender 인터페이스를 구현한 객체를 의존성 주입으로 전달받아서 저장하는 변수 
	private MessageSender messageSender;
	
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	// 이벤트 공지 기능 
	public void noticeEvnet(String title, String content) {
		messageSender.sendMessage(title, content, title, content);
		
	}
	
	
	// 스프링 컨테이너를 사용함(의존성 주입을 사용함)
	// 1. 의존성 주입을 받은 객체를 저장하는 멤버변수를 정의한다.
	private KakaoMessageSender kakao;
		
	// 2. 의존성 주입에 활용할 setter 메소드를 정의한다.
	public void setKakao(KakaoMessageSender kakao) {
		this.kakao = kakao;
	}

}