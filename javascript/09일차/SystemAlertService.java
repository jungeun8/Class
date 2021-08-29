package com.sample.di.demo3;

public class SystemAlertService {

	private MessageSender messageSender;
	
	public void setMessagerSender(MessageSender messagerSender) {
		this.messageSender = messagerSender;
	}
	
	public void alert(String errorType, String errorMessage, String propramName) {
		
		messageSender.sendMessage(errorType, errorMessage, propramName, "관리자");
		
		// MessageSender 인터페이스를 구현한 객체를 주입받아서 system 장애내용을 
		// 관리자에게 발송한다.
		// 1. MessageSender 인터페이스를 구현한 객체를 주입받아서 저장하는 멤버변수 정의하기 
		// 2. 의존성 주입에 사용되는 setter 메소드 정의하기 
		// 3. alert() 메소드 구현하기 
		//		MessageSendert 멤버변수에 주입된 객체의 senderMessage() 메소드를 실행해서
		// 		시스템 장애내용을 관리자에게 발송시키는 코드 구현
		//		title은 erroType, content는 erroMessage, from은 programName, to는 관리자로 한다.
		// 4. context-di-demo3.xml에 systemalertservice를 스프링의 빈으로 등록하기 
		// 5. systemAlertService의 messagerSender에 kakaomessagesender를 주입한다.
		// 6. spring App에서 스프링 컨테이너에서 systemalertservice객체를 찾아서 시스템 장애내용을 발송한다.
		
	}
	
	// 스프링 컨테이너를 사용함(의존성 주입을 사용함)
	// 1. 의존성 주입을 받은 객체를 저장하는 멤버변수를 정의한다.
	private SmsMessageSender sms;
		
	// 2. 의존성 주입에 활용할 setter 메소드를 정의한다.
	public void setSms(SmsMessageSender sms) {
		this.sms = sms;
	}
}
