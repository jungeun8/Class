# Java (21.3.24)
값의 출력 및 변수 생성값의 출력 및 변수 생성
Scanner
	입력장치로부터 입력한 내용을 읽어오는 기능을 가진 객체이다.
	주요 메소드
	int nextInt( )
		입력한 값을 읽어서 정수로 반환한다.
		int value = scanner.nextInt();
	long nextLong( )
		입력한 값을 읽어서 정수로 반환한다.
		long value = scanner.nextLong();
	double nextDouble( )
		입력한 값을 읽어서 실수로 반환한다.
	boolean nextBoolean( )
		입력한 값을 읽어서 불린값으로 반환한다.
	String next( )
		입력한 값을 읽어서 문자열(String)로 반환한다.
	String nextLine( )
		입력한 값을 읽어서 문자열(String)로 반환한다.

위에서 나열한 모든 메소드는 입력장치를 통해서 입력이 완료될 때 실행된다. (입력이 완료될때까지 대기한다.)

조건문(분기문)

if (조건식) {
	// 조건식이 ture로 판정되면 블록내 수행문이 실행된다.
  } 
If : ~라면 
if문은 제어문을 작성할 때 사용한다.
If 사용하면 특정한 수행문을 실행되게 하거나 실행되지 않게 할 수 있다.
if문에는 수행문의 실행여부를 결정지을 조건식이 필요하다.
if문의 조건식은 수행결과가 boolean값인 연산식이어야 한다.
검사 조건이 여러가지인 경우 if 다음으로 else if를 쓰고 마지막에는 else를 사용!!

* 변수의 스코프(Scope: 범위)
	- Java에서 변수의 스코프는 그 변수가 선언된 블록이다.
	- 변수는 그 변수가 선언된 블록내에서만 사용할 수 있다. 
	- 블록을 닫는 괄호를 만나면, 변수는 즉시 사라진다.

반복문
반복문은 특정한 수행문을 반복해서 실행하는 구문이다.
반복문은 제시된 조건이 true인 경우 블록내의 수행문을 반복 실행한다.
For, while, do ~ while 구문을 사용한다.
반복횟수를 알고 있을 때는 for문, 그렇지 않은 경우는 while문을 사용한다.

for문은 초기화식, 조건식, 증감식, 코드블록으로 구성되어있다.
수행횟수를 알고 있을 때
초기화식에서 선언한 변수는 조건식, 증감식 및 for문의 블록내에서만 사용가능하다.

for(초기화식; 조건식; 증감식){
 조건식이 true인 동안 수행할 수행문;
}
