# Java(21.3.26)
값의 출력 및 변수 생성값의 출력 및 변수 생성
파일복사프로그램 실행
FileCopy.java : 소스파일 작성
javac Filecopy.java : 실행파일 생성하는 명령어 실행 
java Filecopy : 실행파일 실행하는 명령어 실행
* 파일복사인 경우, "원본파일 경로화 이름" , "복사할 경로"
Java FileCopy c:\app\a.txt.  d:\back up
	-java : JVM을 실행시키는 명령어
	-FileCopy :  자바 실행파일의 이름, FileCopy.class이다.
c:\app\a.txt.  d:\back up : 명령행 인자다.
			      프로그램 실행시 String배열을 만들어서 순서대로 저장한 다음 main 메소드의 
		        	      args에 전달된다.
	-위의 명령어를 실행하면 JVM이 FileCopy.class의 main()메소드 실행
	-JVM이 main(String[] args)의 args에 {} 배열을 전달한다.
	-arg는 명령행 인자를 전달받는 변수이다.
	- 명령행 인자는 문자열로 구성된 배열이다.

Public class FileCopy {
	public static void main(String[] args0{
		String src = args[0];			// src에는 “c:\app,a,txt” 대입됨
		String dest = args[1];			// dest에는 “d:\backup” 대입됨

		파일 복사 작업 구현

Public class String {
	// equals() 메소드는 입력으로 전달받늠 다른 문자열과 내용 일치하면 true, 불일치면 false를 반환함.
	//
	// * 대/소문자를 구분한다.
	// Object other : 비교할 다른 문자열
Public boolean equals (Object other) {
}
}

// 객체를 무조건 생성시키고 사용가능, 그러나 static이라는 키워드가 붙으면 생성(new) 안시켜도 됨
