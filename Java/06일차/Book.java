package day1;

public class Book {

	
		// 필드 정의하기(제목, 저자, 출판사, 가격)
		// 생성된 객체 고유한 속성(값)을 저장하는 멤버변수가 된다.
		String title;
		String writer;
		String publisher;
		int price; 
		int discountPrice;
		
		// 메소드 정의하기
		// 생성된 객체의 고유한 기능이 된다.
		// 메소드는 생성된 객페의 모든 필드값을 사용할 수 있다.
		void viewBookInfo() { // void: 반환기능
			System.out.println("제목: "+ title);
			System.out.println("저자: "+ writer);
			System.out.println("출판서: "+ publisher);
			System.out.println("가격: "+ price);
			System.out.println("할인가격: " + discountPrice);
		}
		
		
		
		
	
}
