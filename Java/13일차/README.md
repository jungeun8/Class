# Java(21.4.7)
값의 출력 및 변수 생성값의 출력 및 변수 생성
Chart : 부모 객체 chart: 자손 객체
- chart 참조변수가 참조하는 객체는 Chart객체다.
- chart 참조변수가 참조하는 객체가 Chart 객체인경우 “기본차트”가 표시된다.
- chart 참조변수가 참조하는 객체가 MapChart객체의 Chart객체인경우 실제로 생성된 MapChart객체의 재정의된 메소드가 실행되어서 “지도차트”가 표시된다.

- chart참조변수는 실제로 생성된 객체의 종류와 상관없이 클래스형변환 되어서 언제나 Chart객체를 참조한다.
- chart.draw() 메소드를 실행하면 실제로 생성된 객체의 draw() 메소드중에서 최종적으로 재정의된 draw()메소드가  실행된다.

- 상속, 클래스형변환, 메소드재정의를 이용하면 실제로 생성된 객체가 무엇인지 몰라도 그 객체에서 재정의한 메소드가 실행된다.
즉, 객체의 종류와 상관없이 동일한 이름의 메소드를 실행하지만, 실제로  사용하는 객체에 따라서 다른 결과가 발현되는 것이다.

다형성이 적용된 회계프로그램의 장점
다형성이 적용된 회계 프로그램은 소스코드의 변경없이 표시되는 차트의 종류를 변경할 수 있다.
다형성이 적용된 회계 프로그램은 확장성이 높아진다.(chart 참조변수에 새 Chart류 객체만 제공하면 된다.)

추상화
추상화는 객체에서 공통된 속성과 기능을 추출하는 것이다.
자바에서 추상화는 공통된 속성과 기능을 모아서 추상클래스나 인터페이스를 정의하는 것이다.
공통속성은 변수나 상수로 표현하고, 기능은 추상메소드로 표현한다.
추상화를 통해서 하위 클래스들이 구현해야할 공통기능을 정의할 수 있다.
 추상메소드
추상메소드는 공통기능을 추상화하는 메소드다.
추상메소드는 구현부가 없는 메소드다.
추상메소드는 추상클래스와 인터페이스에서만  정의할 수 있다.
일반 클래스(구현클래스)는 추상메소드를 보유할 수 없다.
만약 추상메소드를 상속받았다면 반드시 메소드 재정의를 통해서 구현부가 있는 메소드로 만들어야한다.

값의 출력 및 변수 생성값의 출력 및 변수 생성
인터페이스
사용 목적: 표준화
종류
    - 마크업 인터페이스: 상수, 추상메소드 등이 하나도 없는 인터페이스
	ex. Public intterface Serializable{
			// 아무것도 없음
		}
		public interface Clonable {
			// 아무것도 없음
		}

    - 함수형 인터페이스; 추상메소드를 딱 하나만 가지고 있는 인터페이스
    - 그 외 : 상수, 추상메소드를 한 개 이상 가지고 있는 인터페이스
