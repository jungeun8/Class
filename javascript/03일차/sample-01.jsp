<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  	<title>Bootstrap 4 Example</title>
  	<meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>jQuery 연습하기</h1>
	
	<h3>jQuery는?</h3>
	<p>강력한 선택자함수를 제공한다.</p>
	<p>HTML 문서를 조작할 수 있는 다양한 메소드를 제공한다.</p>
	<p>이벤트처리의 일관된 방식으로 아주 쉽게 처리할 수 있다.</p>
	<p>Ajax 처리를 아주 쉽게 구현할 수 있다.</p>

</div>

<script type="text/javascript">
	//jQuery의 $()함수 실행하기 
	
	// 선택자를 매개변수 인자로 전달해서 실행하기 
	$('p').css("color","red");
	
	// 함수를 매개변수 인자로 전달해서 실행하기 
	$(function(){
		// 웹페이지가 준비되었다 -> 웹브라우저가 html문서를 해석해서 html dom객체를 생성하고, 
		//						화면에 표시학시 직전인 싯점이다.
		// 					-> html dom객체의 생성이 완료되었기 때문에
		//						$()함수로 엘리먼트를 선택하고, 조작하고, 이벤트핸들러를 일레먼트에 등록하는
		//						작업등을 수행하기 딱 좋은 시점이다.
		console.log("웹페이지가 준비되면 자동으로 실행된다.")
	})

	/*
		$('p')는 html 문서에서 모든 p태그(엘리먼트)를 검색해서 jquery집합객체로 반환한다.
		-jquery 집합객체에는 검색된 모든 p엘리먼트가 포함되어 있다.
		-jquery 집합객체에는 검색된 모든 p엘리먼트를 조작하거나, 스타일을 변경할 수 있는 다양한
		 메소드를 가지고 있다.
		 
		 
		 jQuery 집합객체의 대략적인 구성(실제 jQuery집합객체랑 다름)
		 {
			elements:[p, p, p ,p]
			css:function(){검색된 엘리먼트의 스타일를 변경하는메소드},
			hide:function(){검색된 엘리먼트를 화면에 보이지 않게 하는 메소드},
			show:function(){검색된 엘리먼트를 화면에 표시하는 메소드},
			remove:function(){검색된 엘리먼트를 화면에서 삭제하는 메소드},
			text:function(){검색된 엘리먼트의 텍스트 컨텐츠를 반환하는 메소드},
			html:function(){검색된 엘리먼트의 html 컨텐츠를 반환하는 메소드},
			... 다양한 메소드가 있다. 
		 }
	
		
		// jQuery 집합객체 1과 jQuery 집합객체 2는 같은 객체다.
		// 대부분의 jQuery 집합객체의 메소드들은 메소드를 실행하고 나면, jQuery집합객체를 다시 반환한다.
		var jQuery집합객체1 = $("p");
		var jQuery집합객체2 = jQuery 집합객체1.css('color', 'red');
	 	jQuery집합객체2.click(function(){alert("클릭됨");});
		
		$("p").css('color', 'red').click(function(){alert("클릭됨");});
		
		jQuery 집합객체.메소드명()
		jQuery 집합객체.css('color', 'red');
		
	*/
</script>
</body>
</html>
