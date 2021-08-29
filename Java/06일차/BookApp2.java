package day1;

public class BookApp2 {

	public static void main(String[] args) {
		//객체 생성
		
		Book book1 = new Book();
		// 객체의 맴버변수 초기화
		book1.title = "이것이 자바다";
		book1.writer = "신용권";
		book1.publisher = "한빛미디어";
		book1.price = 35000;
		book1.discountPrice = 31400;
		
		//객체의 맴버메소드 호출(실행)
		System.out.println("###참조변수 book1이 참조하는 book객체의 정보 출력");
		book1.viewBookInfo();
		
		// book1 참조변수가 가지고 있는 주소값을 book2 참조변수에 대입한다. 
		// bbok2 참조변수는 book1참조변수와 같은 주소값을 가지게 된다.
		// book2 참조변수는 book1참조변수가 참조하는 객체를 같이 참조하게된다.
		// 즉, 8번째 라인에서 생성된 Book객체를 참조하는 참조변수는 book1과 book2 2개이다.  
		Book book2 = book1;
		System.out.println("###참조변수 book2이 참조하는 Book객체의 정보 출력");
		book2.viewBookInfo();
		
		// book2참조변수가 참조하는 객체의 제목을 변경하기 
		book2.title = "자바의 정석";
		System.out.println("-----------제목변경----------------");
		
		System.out.println("####참조변수 book1이 참조하는 Book객체의 정보 출력");
		book1.viewBookInfo();
		System.out.println("####참조변수 book2이 참조하는 Book객체의 정보 출력");
		book2.viewBookInfo();
		
		// 참조변수가 더이상 객체를 참조하지 못하게 하기
		// 참조변수에 null값을 대입하면 해당 참조변수는 객체의 주소값 대신 null값을 가지게 된다. 
		// null값이 저장된 참조변수는 더이상 객체를 참조할 수 없다.
		// book1dms Book객체와의 연결이 끊어졌다. 
		// * 참조변수의 주소값이 null인 경우는 객체와의 연결이 끊어졌거나 혹은 아직 객체가 연결되지 않은 참조변수다. 
		book1 = null;
		//book1.title = "스프링 인 액선";   // 객체의 맴버변수에 접근할 수 없다.
		//book1.viewBookInfo();     // 객체의 맴버메소드를 실행할 수 없다. 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
