<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트의 데이터 타입</title>
<script type="text/javascript">
	// 자바스크립트의 기본자료형 타입 
	// string, number, boolean, null, undefiend
	/*
		string
			- 문자열타입
			- 문자열은 ""나 ''안에 있는 내용이다. 
		number
			- 숫자타입
			- 정수, 실수 모두 하나의 타입으로 다룬다. 
		boolean
			- 불린타입
			- true, false값을 가진다. 
		undefined
			- 변수가 초기화되지 않으면 그 변수는 undefined 타입의 값 undefined를 가진다.     
	*/
	
	// 변수선언하고, 초기화하기
	var no = 10;		// 변수 no는 number 타입의 변수가된다. 
	var name = "홍길동";		// 변수 name는 string 타입의 변수가된다. 
	var isPassed = true;		// 변수 isPassed는 boolean 타입의 변수가된다. 
	var address;	// // 변수 address는 undefined 타입의 변수가된다. 
	
	//자바스크립트에서 변수타입은 변수에 값이 대입되는 순간 결정된다. 
	console.log(typeof(no));
	console.log(typeof(name));
	console.log(typeof(isPassed));
	console.log(typeof(address));
	
	no="가나다라";
	console.log("문자열 대입 후", typeof(no));
	
	no=false;
	console.log("false값 대입 후", typeof(no));
	// 자바스크립트의 변수는 타입이 고정적이지 않다.
	// 변수에 저장되는 값에 따라서 변수의 타입이 동적으로 변한다.
	// 문자열을 담았던 변수에 숫자나, 배열, 불린 타입의 값을 저장하는 것이 가능하다.
	// 단, 하나의 변수를 여러 타입의 값을 담는 용도로 사용하는 것은 절대 절대하면 안된다. 
	
</script>
</head>
<body>
<h1>자바스크립트의 데이터 타입</h1>

</body>
</html>