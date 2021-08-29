<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트 함수</title>
<script type="text/javascript">
	
	// 전역변수와 지역변수 
	/* 
	   전역변수 
		- 모든 함수에서 사용가능한 변수
		- 전역변수의 정의 
			* 함수의 바깥에서 정의된 변수 
			* 함수의 내부에서 var 키워드 없이 정의된 변수 
		지역변수 
			- 변수가 정의된 그 함수 내부에서만 사용가능한 변수 
			- 지역변수 정의 
				* 함수의 내부에서 var 키워드를 사용해서 정의 
	
	*/
	
	// 전역변수 정의하기 
	var globalVar = 1000;
	
	function f1(){
		// 전역변수 정의하기 
		carName = "제네시스";
		
		// 지역변수 정의하기 
		var owner = "홍길동"
		
		console.log('전역변수값 출력', globalVar);
		console.log('전역변수값 출력', carName);
		console.log('지역변수값 출력', owner);
	}
	
	function f2(){
		console.log('전역변수값 출력', globalVar);
		console.log('전역변수값 출력', carName);
		// console.log('지역변수값 출력', owner);	// 오류 발생, 다른 함수의 지역변수를 접근 불가 
	}
	
	f1();
	f2();
	
	/*
		변수 호이스팅의 예 
		
		// 개발자가 정의한 함수 
		function test(){
			var name = "홍길동";
			var kor = 100;
			var eng = 90;
			var math = 90;
				
			var total = kor + eng + math;
			var average = Math.trunc(total/3);
	     
	      if(average >= 90){
	    	  var scoreGrade = 'A';
	    	  var message = "장학금 지급대상입니다.";}
	      
	      // 자바스크립트가 실재로 실행하는 코드 
	      function test(){
	    	  // 모든 변수가 호이스팅된다. 
	    	  // 호이스팅된 변수는 전부 undefined 값을 가지고 있다.
	    	  // 호이스팅된 변수들은 함수내의 모든 위치에서 사용할 수 있다.
	    	  var name, kor, eng, math, total, average, scoreGrade, message;
	    	  
	    	  name = "홍길동";
	 		 kor = 100;
	 		 eng = 90;
	 		 math = 90;
	 		
	 	     total = kor + eng + math;
	 	     average = Math.trunc(total/3);
	 	     
	 	     if(average >= 90){
	    	   scoreGrade = 'A';
	    	   message = "장학금 지급대상입니다.";}
	      }
	    
		
	}
	*/
	
	// 변수 끌어올리기(변수 호이스팅)
	function hoisting(){
		var name, kor, eng, math, total, average, scoreGrade, message;
		/*
			변수 끌어올리기 
				- 함수내에서 선언된 모든 지역변수는 그 변수의 선언위치와 상관없이
				  함수의 첫번째 수행문보다 앞으로 끌어올려진다. 
				- 자바스크립트에서 지역변수으 스코프(사용범위)는 함수다. 
		*/
		
		
		// 지역변수 선언 
		 name = "홍길동";
		 kor = 100;
		 eng = 90;
		 math = 90;
		
	     total = kor + eng + math;
	     average = Math.trunc(total/3);
	    
	    if(average >= 90){
	    	 scoreGrade = 'A';
	    	 message = "장학금 지급대상입니다.";
	    	
	    }
	    console.log('평균', average, '성적', scoreGrade, '메시지', message);
	}
	
	// 변수 끌어올리기 함수 실행 
	hoisting();
	
	// 변수 끌어올리기가 일어나지 않게 하기 
	// 변수 선언시 var대신 let 키워드를 사용한다.
	// let으로 선언된 변수의 스코프는 블록이다. 
	function disableHoisting(){
		
		//console.log("이름", name, "국어점수", kor)
		
		let name = "홍길동";
		let kor = 100; 
		let eng = 90; 
		let math = 90; 
		let total = kor + eng + math;
		let average = Math.trunc(total/3);
		
		if(average >= 90){
			let scoreGrade = 'A';
			let message = "장학금 지급대상입니다.";
	    	
	    }
		// let으로 선언된 변수는 블록을 벗어난 곳에서는 사용할 수 없다. 
		// console.log('평균', average, '성적', scoreGrade, '메시지', message);
	}
	disableHoisting();
	
</script>
</head>
<body>
	<h1>자바스크립트 함수</h1>
	<p>실행결과는 브라우저 콘솔에서 확인</p>

</body>
</html>