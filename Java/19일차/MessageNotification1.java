package collection.map.message;

public class MessageNotification1 {

	private KakaoTalkMessageSender katalk = new KakaoTalkMessageSender();
	private EmailMessageSender email = new  EmailMessageSender();
	private SmsMessagerSender sms = new SmsMessagerSender();
	
	public void notice(Customer customer, String from, String title, String content) {
		String[] messageTypes = customer.getMessages();
		for(String messageType : messageTypes) {
			if("sms".equals(messageType)) {
				sms.sendMessage(from, customer.getName(), title, content);
			}else if ("katalk".equals(messageType)) {
				katalk.sendMessage(from, customer.getName(), title, content);
			}else if ("mail".equals(messageType)) {
				email.sendMessage(from, customer.getName(), title, content);
			}
		}
	}
	
}
