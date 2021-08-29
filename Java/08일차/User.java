package day3;

public class User {

	int no;
	String name;
	String id;
	String password;
	String email;
	String tel;
	int age;
	String address;
	boolean isMarried;
	
	/*
	 * 생성자(constructor)
	 * 		객체 생성 직후에 바로 실행되는 메소드다. 
	 * 		 * 객체를 생성하는 메소드가 절대 아님 
	 * 		객체 생성 직후에 수행할 작업을 생성자 메소드에 정의할 수 있다.
	 * 		 * 객체의 초기화 작업 - 객체의 맴버변수의 값을 초기화하는 작업이다.
	 * 						 - 객체의 멤버변수에 값을 대입하는 작업이다. 
	 * 		 * 맴버메소드의 실행 전 반드시 수행햐야하는 전처리 작업 
	 * 		new 생성자()와 같이 객체 생성할 때만 사용할 수 있는 메소드다. 
	 * 		 * new 키워드와만 사용할 수 있다. 
	 * 		생성자 메소드의 조건(객체 생성 직후에 바로 실행되는 메소드의 조건)
	 * 		 생성자 메소드의 이름이 반드시 클래스의 이름과 동일해야 한다.
	 * 		 생성자 메소드는 반환타입이없다. 
	 */
	
	// 기본 생성자 메소드(Default Constructor)
	//	- 매개변수가 하나도 없는 생성자 
	// 	- 컴파일러가 자동으로 추가하는 생성자 
	// 		User.java를 User.class로 변환할 때 
	// 		User.java에 정의된 생성자가 없으면 public User(){}를 자동으로 추가한다. 
	public User() {
		System.out.println("기본 생성자 실행됨");	
		// 객체의 초기화 작업 
		// 객체가 생성되면, 번호, 이름, 아이디, 비빌번호, 주소 , 결혼여부 등의 값을 아래의 값으로 초기화한다.
		no = 9999;
		name = "홍길동";
		id = "hong";
		password = "zxcv1234";
		email = "";
		tel = "";
		age = 0;
		address = "서울";
		isMarried = false;
	}
	
	// 생성자 중복정의
	// User(int, String, String, String)을 매개변수로 가지는 생성자 메소드 중복정의함.
	User(int paramNo, String paramName, String paramId, String paramPassword){
		no = paramNo;
		name = paramName;
		id = paramId;
		password = paramPassword;
		
	}
	
	void displayUserInfo(){
		System.out.println("번호: " + no);
		System.out.println("이름: " + name);
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + password);
		System.out.println("이메일: " + email);
		System.out.println("전화번호: " + tel);
		System.out.println("나이: " + age);
		System.out.println("주소: " + address);
		System.out.println("결혼여부: " + isMarried);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
