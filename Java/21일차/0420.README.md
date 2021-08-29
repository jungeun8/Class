# Java(21.04.20)
값의 출력 및 변수 생성값의 출력 및 변수 생성
// 해당 메소드에서 발생이 예상되는 모든 예외에 대한 예외처리를 위임함다.
	Public void method1() throws FileNotFoundException  IOException ParasedException SQLException{}
	예외발생실행문1;  //  FileNotFoundException
	예외발생실행문2; // IOException
	예외발생실행문3; //ParasedException
	예외발생실행문4; // SQLException
	
	// 해당 메소드에서 발생이 예상되는 예외들 중에서 상속관계에 있는 예외(  IOException, FileNotFoundException
	// )가  있는 경우, 부모타입에 대한 예외처리를 위임하면 한번에 2가지 예외에 대해서 예외처리를 위임할 수 있다.
	Public void method1() throws  IOException, ParasedException, SQLException
		예외발생실행문1;  //  FileNotFoundException
		예외발생실행문2; // IOException
		예외발생실행문3; //ParasedException
		예외발생실행문4; // SQLException
		
	// 해당 메소드에서 발생이 예상되는 모든 예외들의 최상위 부모예외()에 대한 에외처리를 위임하면
	// 그 메소드에서 발생하는 모든 예외에 대한 예외처리를 위임할 수 있다. 
	Public void method1() throws  Exception{
	
	예외발생실행문1;  //  FileNotFoundException
	예외발생실행문2; // IOException
	예외발생실행문3; //ParasedException
	예외발생실행문4; // SQLException
	}
	
	Throw : 예외 관계발생 
	Throws: 예외 떠 넘기기 
