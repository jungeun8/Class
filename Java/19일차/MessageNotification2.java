package collection.map.message;

import java.util.HashMap;

public class MessageNotification2 {

	HashMap<String, MessageSender> messageSenders = new HashMap<String, MessageSender>();
	
	public MessageNotification2() {
		// HashMap<String, MessageSender> 객체에 MessagerSender 인터페이스를 구현한 객체를 저장한다.
		messageSenders.put("sms", new SmsMessagerSender());
		messageSenders.put("katalk", new KakaoTalkMessageSender());
		messageSenders.put("Email", new EmailMessageSender());
		
	}
	
	public void notice(Customer customer, String from, String title, String content) {
		String[] messageTypes = customer.getMessages();
		/*
		 * messageTypes배열에서는 "sms", "katalk", "mail" 등 값이 1개 이상 들어 있다.
		 * 향상된 for문을 이용해서 messageTypes배열에서 messageType으로 하나씩 값을 받아온다.
		 * messageTypes변수에는  "sms", "katalk", "mail"중 하나가 저장되어 있다.
		 * messageSenders가 참조하는 HashMap객체에서 messageTypes변수에 저장된 값을 key로 
		   MessageSender인터페이스 구현객체를 가져온다.
		 * sender 참조변수에는 SmsMessagerSender, KakaoTalkMessageSender, EmailMessageSender 객체들 
		 * 주소값 중 하나가 대입된다.
		 * sender.sendmessage(보내는 사람, 받는 사람, 제목, 내용);을 실행하면
		 * sender 참조변수가 실제로 참조하고 있는 객체의 sendMessage() 메소드가 실행된다.
		 * 
		 */
		
		for(String messageType : messageTypes) {
			// HashMap객체에서 messageType변수에 저장된 값을 key로 MessageSender 구현 객체를 조회
			MessageSender sender = messageSenders.get(messageType);
			// sender 참조변수가 현재 참조하고 있는 MessageSender류 객페의 sendMessage() 메소드가 실행된다.
			sender.sendMessage(from, customer.getName(), title, content);
		}
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
