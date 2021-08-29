
public class OpDemo7 {

	public static void main(String[] args) {
		
		// 기본자료형의 형변환 
		// 기본자료형 타입의 값을 다른 타입의 값으로 변환하는 것이다.
		// 정수 -> 실수, 실수 -> 정수, 문자 -> 정수, 정수 -> 문자 로 변환하는 것만 가능하다. 
		
		// 
		
		
		// 자동 형변환
		
		int a = 10;      // [0][0 [0] [00001010]
		
		long b = a;      //   [0][0 [0] [00001010] --> [0][0][0][0][0][0][0][00001010]
		float c = a;     // 10 --> 10.0  a에서 복사해온 값이 10.0으로 변환된 후 c체 대입된다.
		double d = a;    //10 --> 10.0 a에서 복사해온 값이 10.0으로 변환된 후 d에 대입된다. 
		
		System.out.println("long타입의 변수 : " +b );
		System.out.println("float타입의 변수 : " + c );
		System.out.println("double타입의 변수 : " +d );
		System.out.println("a의 값 : " + a );
		
		
		int x = 3;
		double y = 4.0;
		//System.out.println(x/y);
		
		System.out.println(3/4);   //0  - 정수/정수 
		
		
		// 수동 형변환
		double x1 = 3.14;
		float l = (float) x1; // --> = (float) x;  // double 타입의 값을 float타입의 값으로 형변환 후 ㅣ에 대입한다.
		long m =  (long) x1;    // double타입의 값을 long 타입의 값으로 형변환 후 m에 대입한다.
		int n = (int) x1;     // double타입의 값을 int 타입의 값으로 형변환 후 n에 대입한다. 
		
		System.out.println("l의 값 : " +l );
		System.out.println("m의 값 : " + m);
		System.out.println("n의 값 : " +n);
		System.out.println("x의 값: " + x1);
		
		
		
		// 평균 계산하기
		int kor = 70;  
		int eng = 100;
		int math = 74;
		int subJectCount = 3;   // 과목 수 
		
		// 소숫점 없는 평균값
		int average = (kor +eng + math)/subJectCount;  //(정수+정수+정수)/정수 --> 정수 
		
		// 소숫점 있는 균값 
		double average2 = (kor +eng + math)/subJectCount;  // 정수 --> 실수로 변환 
		
		// 소숫점 있는 균값 
		double average3 = (kor +eng + math)/ (double) subJectCount;  // 형변환 연산자를 붙이
				
		System.out.println("소숫점이 없는 평균값 : " + average);
		System.out.println("소숫점이 있는 평균값 : " + average2);
		System.out.println("소숫점이 있는 평균값 : " + average3);

		// 문자와 정수간의 형변환
		// int -> char
		// 정수 65에 해당하는 유니코드문자가 변수에 저장된다. 
		//                         유니코드문자		16진수	10진수 
		char ch2 = 65;     //  A<-  \u0041 	  0x41 	 	65
		char ch3 = 44032;  //  가 <- \ uac00    0xac00 	44032
		System.out.println(ch2); 
		System.out.println(ch3);
		
		System.out.println((char) ch2);  //int --> char
		System.out.println((int) 'A');  //char --> int

		
	
		
		
		
		
		
		
	}
	
}
