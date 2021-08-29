# Java(21.04.19)
값의 출력 및 변수 생성값의 출력 및 변수 생성
Collection<E> 인터페이스
	- 모든 자료구조 클래스가 반드시 포함해야할 기능이 설계되어 있는 인터페이스 
	- add(E e), contains(Object obj), isEmpty(), clear(), size(), remove(Object obj)
List<E>
	- 순서가 유지되는 자료구조 클래스가 반드시 포함해야할 기증이 설계되어 있는 인터페이스
	- add(int index, E e),get(int index), remove(int index) , set(int index, E e)
	- 구현클래스
		- ArrayList<E>, LinkedList<E>, Vector<E>, Stack<E>
Set<E>
	- 중복저장이 허용되지 않는 자료구조 클래스가 반드시 포함해야할 기능이 설계되어 있는 인터페이스 
	- Collection<E> 인터페이스의 추상메소드 상속
	- 구현클래스 
		- HashSet<E>, TreeSet<E>
		• TreeSet<E>는 Comparable<E>를 구현한 객체에 대해서 오름차순으로 정렬되어 저장한다.
	
Map<K, V> 인터페이스
	- Key와 value의 값이 저장 key와 value의 한묶음이 Entry이다.
	- 타입파라미터가 2개이다.
	- Key는 보통 String 타입이다. 
	- 담는 것은 put, 꺼내는 것은 get
	- key와 value의 쌍으로 데이터를 저장하는 자료구조 클래스가 반드시 포함해야할 기능이 설계되어 있는 인터페이스
	- Key는 중복을 허용하지 않는다. 
	- 구현클래스
	 HashMap<k, v>, HashTable<k, v>, Properties
	• Properties는 key 와 value가 무조건 String인 Map의 구현클래스이다.
	- 주요 사용 목적 
	• 구현체가 여러개일경우, 가변적일 경우 사용 
Stack : push/pop
Queue: offer/poll
Map: put/get

=======================4/19============================
TreeSet<E> :  오름차순 정렬
Map<K, V> :  저장할 데이터가 가변성이 높은 데이터
		  저장할 데이더가 key, value의 쌍으로 연결된 데이터
		  저장된 데이터를 빠르게 검색 
		  Hashmap<K, V>
		  값이 가변적일 때, if문을제거 
		
		
예외처리가 필요한 메소드

반환타입 메소드명(타입 변수명, 타입 변수명, … ) throws 예외클래스명{
	사용자의 잘못된 사용으로 오류가 발생할 가능성이 있는 코드
}

예외처리란?
 프로그램 실행시 발생할 수 있는 에러에 대비하는 것으로 프로그램의 비정상종료를 막고 실행 상태를 유지하는 것이다.

에러의 종류
에러
	- 시스템, 운영체제, JVM의 잘못으로 발생되는 것
	- 개발자가 해결할 수 있는 문제가 아님
	- 예외처리 대상이 아님
	
예외
	- 예외는 개발자의 코딩실수나 사용자의 잘못된 프로그램 사용으로 발생하는 오류다.
	- 예외는 예외처리를 통해서 비정상적인 종류를 예방할 수 있다.
	- 예외는 UncheckedException으로 구분한다.

 UncheckedException
	- UncheckedException클래스와 자식 클래스들이다.
	- 주로 개발자의 코딩 실수로 발생되는 오류들이다.
	- 컴파일러가 예외처리 여부를 체크하지 않는다.

Try ~ catch구문
	- catch블록 아래로 내려갈수록 조상 클래스  타입 변수명 작성
웹 애플리케이션 프로젝트에서 예외처리
	- 오류발생시 에러페이지의 실행결과를 응답컨텐츠 보낸다.
	- 각각의 오류 상황에 맞게 에러페이지를 미리 작성해 두고, 
	- 오류가 발생하면 그 상황에 맞는 에러페이지가 실행되도록 설정한다.
	- 예외처리를 각각의 개별 클래스에서 처리하기보다는 한 곳에서 일괄처리하는 경우가 많다.
![Uploading image.png…]()
