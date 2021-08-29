package day3;

public class StaticMethodSample {
	
	// 맴버변수, 인스턴스변수, 프로퍼티
	int x;
	int y;
	
	// 맴버메소드, 인스턴스메소드 
	// 멤버메소드는 멤버변수를 사용할 수 있는 메소드다.
	// 멤버메소드는 멤버변수와 상호작용하는 메소드다.
	void plus() {
		System.out.println(x + y);
	}
	
	void minus() {
		System.out.println(x - y);
	}
	// 맴버메소드는 다른 멤버메소드를 사용할 수 있다.
	void calculate() {
		plus(); 
		minus();
	}
	// 맴버메소드는 다른 멤버메소드와 다른 static 메소드를 사용할 수 있다. 
	void calculate2() {
		plus();
		minus();
		plus2(300, 500);		// 멤버메소드에서 static메소드를 호출할 때 멤버변수값을 전달 할 수 있다.
		minus2(x,y);	    	// 멤버메소드에서 static메소드를 호출할 때 멤버변수값을 전달 할 수 있다.
	}
	// 클래스메소드, static메소드 , 정적메소드 
	// static 메소드는 멤버변수를 사용할 수 없다. 
	// static 메소드는 멤버변수와 상호작용할 수 없다. 
	static void plus2(int x, int y) {		// 상호작용이 안되니까 값을 받아와야함 
		System.out.println(x + y);
	}
	static void minus2(int x, int y) {
		System.out.println(x - y);
	}
	// static 메소드는 다른 멤버메소드를 사용할 수 없다.
	// static 메소드는 다른 static메소드만 사용할 수 있다.
	static void calculate3() {
		//plus();
		//minus();
		plus2(10,20);
		minus2(30,40);
	}
	
	

}
