// java.util 패키지에 위치한 Scanner.class를 사용하기 위해서 가져온다.
// Scanner 설계도(클래스)는 키보드, 파일 등으로부터 입력된 내용을 읽어올 수 있는 기능을 제공한다.

import java.util.Scanner;

public class Example1 {
	
	public static void main(String[] args) {
		
	// System.in은 표준압력장치다.
	// 시스템에서 표준압력장치는 키보드를 말한다.
		
	// Scanner sc는 Scanner 설계도로 만든 객체의 주소값을 담는 변수 sc를 생성한다.
	// new Scanner (System.in)은 표준입력장치로 입력하는 내용을 읽어오는 Scanner객체를 생성한다.
	// Scanner sc = new Scanner(System.in)은 표준입력장치로 입력한 내용을 Scanner 객체를 생성한 후, 그 객체의 주소값을 sc에 대입하라.
	// sc는 생성된 객체의 공개된 속성과 기능을 사용할 때 필요한 리모콘 역할을 수행한다.
	// sc를 통해서만 생성된 객체에 접근/사용 할 수 있다.
	// sc.nextInt(); sc.next(); sc.nextDouble(); sc.nextLine() 등의 수행문으로 
	// 입력된 값을 읽어올 수 있다.
	
	Scanner sc = new Scanner(System.in);
		
	 System.out.println("이름을 입력하세요");
	String value = sc.nextLine();
	
	
	 System.out.println("입력된 이름: " + value);
		
		
	 System.out.println("나이를 입력하세요");
	 int value2 = sc.nextInt();
	 
	 System.out.println("입력된 이름: " + value);
	 System.out.println("입력된 나이: " + value2);
		
		
		
		
		
	}
}
