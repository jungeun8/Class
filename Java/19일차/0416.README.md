# Java(21.04.16)
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
![Uploading image.png…]()
