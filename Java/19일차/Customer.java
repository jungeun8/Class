package collection.map.message;

public class Customer {
	
	private String name;		// 고객명 
	private String[] messages;		//메세지수신동의종류, "sms", "katalk", "email"
	
	public Customer() {}

	public Customer(String name, String[] message) {
	
		this.name = name;
		this.messages = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessage(String[] message) {
		this.messages = message;
	}
	

}
