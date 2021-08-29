# Java
값의 출력 및 변수 생성값의 출력 및 변수 생성
Java: 프로그래밍언어, 개발
Sql: 데이터베이스
HTML, CSS: 웹문서 작성(정적),
JSP: 동적인 웹문서
Java script/ jQuery: 현재 페이지를 조작
Spring: 전자정부표준프레임워크의 기반 기술



자바의 특징
	- 운영체제 독립적이다.(운영체제와 상관없이 이용할 수 있는 것) 
      	그래서 번역기가 한번 과정을 거치기때문에 c언어보다는 속도가 느리다. 
      	엄청난 속도를 요구하는 곳(게임 등) 이런 곳은 안쓰임. 
      	소스코드: 개발자가 작성한 프로그램, 개발자가 이해하기 쉽도록
      	보통 운영체제 독립적이지 않은 것은 c언어, c++
      	바이트코드: 가상머신이 이해할 수 있는 코드로 구성된 실행파일
     	 자바가상머신(jvm): 바이트코드를 운영체제가 알아들을 수 있도록 바꿔주는 것-기계어코드
     	 안드로이드 가상머신: 스위프트
	Q. 가상머신을 사용하지 않는 언어 os별로 개발자가 문법, 구조 등을 다르게 코딩해야하는가?
 
	- 객체지향(객체기반) 프로그래밍 언어이다. (객체 (제품, 부품) <--> 설계도)
      	프로그램 개발시- 재사용성이 굉장히 높음 프로그램. 구현 단위가 각각의 독립적의 기능을 하는 것이 
      	모여서 하나의 큰 프로그램을 만든다.
 
 	- 자동 메모리 관리를 지원한다. (Garbage collector 프로그램이 가상머신안에 돌고 있다) 알아서 청소해줌
	- 배우기 쉽다.
	- 네트워크 관련 프로그램을 쉽게 개발할 수 있다.
	- 멀티스레드를 지원하는 프로그램을 쉽게 개발할 수 있다.
	  (스레드: 프로그램을 실행시키는 흐름)
	- 동적 로딩을 지원한다.
	- 다양한 오픈소스 및 커뮤니티가 존재한다.(stack over flow: 개발자들의 질문 공간)
 
자바개발도구(Java Devlopment Kit: JDK) 설치
	- 자바개발도구, 자바가상머신, 자바필수 라이브러리 등이 함께 설치된다.
	LTS: 안정화
	-java.sun.com
	-java se 11 설치
 
	java. exe: running jaca virtual-> run java application
	javac.exe: source file-> bytecode file
 
 
통합개발환경(IDE) 프로그램 설치
	- Eclipse www.eclipse.org  다운
 
설정: 상단바 윈도우-preference-왼쪽 상단 encoding적기-workspace- 아래쪽
-utf-8설정-apply- 사이드에서  css 선택 utf-8 설정 동일- html파일도 동일-jsp동일
상단바 윈도우-preference-왼쪽 상단 font적기- appearnce-coloer amd fonts- basic-txt font consolas, 11pt맞추기
-여기까지 준비완료-
 
사이드 create a project 클릭- 자바프로젝트- java-basic로 이름- 모둘명 그냥 넘어가기 - ok
 
[코딩]
 
사이드- java basic- src- 오른쪽new- java class- 이름: Hello- 실행
public class Hello {
	
	public static void main(String[] args) {
		
	}
	
}-> 선언<main작성 후 ctrl+space누르면 선언문 시작>
 
	System.out.println();-> 실행문
 
오른쪽 버튼 - run as-java application
 
주석: "//" 뒤는 실행 안됨 
	//System.out은 컴퓨터의 표준 출력장치를 말한다.(대체로 모니터를 말한다.)
	// println(값)은 메소드다.(메소드는 이름이 있는 수행문의 블록이다. 메소드는 특정한 기능을 실행한다.)
	// println(값)은 지정된 값을 출력장치로 출력한다.
	 main 메소드의 일반적인 형태.  클래스를 구성하는게 메소드이다.  설계도 안에 메소드는 여러개일 수 있다. 메소드 밖에는 수행문이 올수 없다. 무조건 안에 위치해야함.
	메소드의 이름은 동사형, 변수는 명사형 전부 소문자로 시작 하지만 두 단어가 합쳐지면 뒤에 단어 첫글자를 대문자로(ex. todayBestsellerBookNo)-> 카멜표현식
	/*도 뒤는 실행 안됨 public static void main(String[] args)는 자바 가상머신이 프로그램을 실행할 때 처음으로 실행하는 부분이다. 프로그램 실행시 진입점이 되는 곳이다.
	자바가상머신과 미리 약속된 부분이기 때문에 항상 똑같이 적어야 한다. public static void main(String[] args){여기 안에는 수행문; 적기!!}
	public class Hello는 설계도(클래스)이다. 한 개의 설계도(클래스)로 만들어진 프로그램이다. 설계도의 일반적인 형태-> public class 클래스명{}
	class : 설계도임을 나타내는 키워드. public class Hello는 Hello라는 이름을 가진 공개된 설계도(클래스)
	void: 비어있다. 결과 값이 없다 소모됨. 
	
 
	public static void main(String[ ] args) {
		System.out.println("홍길동"); //문자열 출력하기
		System.out.println(40); //정수  출력하기
		System.out.println(181.5); //실수  출력하기
		System.out.println(72.6);  //실수  출력하기
		System.out.println('A'); //문자  출력하기
		System.out.println(); //빈줄 출력
 
	}
 
	값의 종류
	- 정수값: byte, short, int, long
	- 실수값: float, double
	- 문자값: char
 	- 논리값(불린값): boolean -둘중에 하나만 정할수 있을때 사용
	변수는 유일한 것. 중복될 수 없다.  
 
클래스, 설계도 이름은 무조건 대문자로 시작
main작성 후 ctrl+space 선언문 
변수는 쌍 따옴표 사용하지 않기 왜냐하면 고유한 것이기 때문에 
src(소스파일,개발자가 작성)—->bin(class파일 가상 머신용 설계도, bytecode)로 변경할때 jdk/bin/javac.exe가 변경해줌
