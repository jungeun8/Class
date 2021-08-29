package day5;

public class ContactApp {

	public static void main(String[] args) {
		// 객체의 생성과 멤버변수 초기화  
		Contact c1 = new Contact();
		
		//외부에서 Contact의 멤버변수에 직접 접근하는 코드 
		c1.no = 100;
		c1.name = "홍길동";
		c1.email = "hong@email.com";
		c1.phone = "010-3435-9874";
		
		// 객체의 생성 및 멤버변수 초기화 (생성자 이용)
		Contact c2 = new Contact(200, "이순신", "hee@email.com", "010-2445-1111");
		// 외부에서 Contact의 멤버변수에 직접접근하는 코드 
		System.out.println("번호: " + c2.no);
		System.out.println("이름: " + c2.name);
		System.out.println("이메일: " + c2.email);
		System.out.println("전화번호: " + c2.phone);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
