# Java(21.04.13)
값의 출력 및 변수 생성값의 출력 및 변수 생성
Java.io : 입출력 기능 
Java.net : 네트워크 어플리케이션을 만들때 사용되는 것 
Java nio: 좀 더 성능 좋은 입출력기능  
Java.util: 클래스들이 모여있음 

API(Application Programming Interface)
	- 프로그래밍 언어, 라이브러리, 프레임워크가 제공하는 기능
	- API가 제공하는 기능을 제어(사용)할 수 있게 만든 인터페이스
Java API

Objet
	- Java.lang package 안에 들어있음
	- 모든 클래스의 최상의 클래스 
	- 명시적으로 extends를 사용해서 부모클래스를 지정하지 않으면 무조건 extends 
	Objet로 간주된다.
	- 모든 객체는 Objet의 메소드를 사용할 수 잇다.
	- Objet에는 객체와 관련된 필수기능들이 구현되어 있다.
	
	w Boolean equals(Object obj)
		- 현재 객체와 전달받은 객체가 동일한 객체인지 여부를 반환한다.
		- 맞으면 true 틀리면 falsse
		- 객체들의 주소값(참조값)을 비교한다.
		- 재정의 기능 
	w Int hashCode()
		- 현재 객체의 해시코드값을 반환한다.
		- 재정의 기능 
	w String toString()
		- 현재 객체에 대한 간단한 정보를 제공한다.
		- 클래스 이름@16진수 해시코드 
		- 재정의 기능 
	w Class<?> getClass()
	- 현재 클래스에 대한 설명서 정보를 제공한다.
	w Object clone()
	- 현재 객체를 복제한 복사본을 생성해서 제공한다.
	
final  
	final 변수 - 값변경 금지 
	final 메소드 - 하위클래스 재정의 금지 
	final 클래스 - 이 클래스를 상속받아서 하위클래스를 작성할 수 없음 
	
StringBuilder와 StringBuffer
	- 임시저장소(버퍼)를 가지고 있어서, append(다양한 타입의 데이터)로 새로운 객체 생성없이 임시저장소에 데이터를 저장할 수 있다.
	- 임시저장소에 저장된 데이터는 toString()메소드를 실행해서 문자열(String)로 제공받을 수 있다.
	- StringBuilder가 처리 속도가 더  빠름 , StringBuffer가 멀티쓰레드 환경에서 데이터를 안전하게 저장 
	
Wapper클래스
	- 기본자료형 타입에 대응되는 클래스이다.
	- 기본자료형 값을 가지고 있는 객체를 만들 수 있다.
	- Java.lang 페키지에 정의되어 있다.
![Uploading image.png…]()
