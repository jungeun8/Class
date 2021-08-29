# Java(21.4.14)
값의 출력 및 변수 생성값의 출력 및 변수 생성

	w 기본자료형값을 문자열로 변환하기
String.valueOf(값) --> "값"

	w 문자열을 기본자료형값으로 변환하기
Byte.parseByte(문자열) --> byte값
Integer.parseInt(문자열) --> int값
Double.parseDouble(문자열) --> double값 

날짜 데이터 포맷
simpleDateFormat

제네릭
	- 소스 레벨에서 데이터 타입이 결정되지 않고, 별칭(타입파라미터:<T>)만 지정한다.
	// 설계도 
	- Class Box<T>{
		T t ;
	}
	- 정의
		- 클래스 내부에서 사용할 데이터 타입을 소스코드에서 지정하지 않고,
		클래스 외부에서 지정하는 기법이다.
		- 소스코드에서는  public class 클래스명<타입피라미터>{
				타입피라미터 변수;
		}
		와 같은 형식으로 설계한다.
		** 타입피라미터는 보통 영어 대문자를 사용한다.
		** 타입피라미터는 1개 이상 지정할 수 있다.
		** 객체 생성 시 타입피라미터의 위치에 실제로 사용할 타입을 지정하면 생성된 객체는 해당 타입으로 
		    변경되어 있다.
	- 목적
		- 배열처럼 다양한 타입의 객체를 다루는 클래스를 설계할 때 사용한다. 
		- 자바에서는 객체를 여러개 저장하는 콜랙션 클래스들이 대표적인 예다.
		ArrayList<E>, HashSet<E>, TreeSet<E>, Stack<E>, vector<E>, LinkedList<E>
	- 장점
		- 타입피라미터로 지정한 타입의 객체만 저장된다.(타입안정성)
		- 어떤 타입의 객체를 저장할 목적으로 생성했는지 바로 파악이 가능하다. (코드 가독성 증가)
		- 프로그램 실행 전, 컴파일 과정에서 타입오류가 체크된다.
		- 형변환의 번거로움이 사라진다.
	
	- 사용예
		ArrayList<Prouduct> products = new ArrayList<Product>();
		ArrayList<Order> orders = new ArrayList<Order>{};
		ArrayList<Book>books = new ArrayList<Book>();
		HashSet<Team> teams = new  HashSet<Team>();
