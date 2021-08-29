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
	<h1>이벤트처리</h1>
	
		<div>
			<input type="number" value="1" class="w-50"><button class="btn btn-outline-primary">버튼1</button>
			<input type="number" value="1" class="w-50"><button class="btn btn-outline-primary">버튼2</button>
			<input type="number" value="1" class="w-50"><button class="btn btn-outline-primary">버튼3</button>
			<input type="number" value="1" class="w-50"><button class="btn btn-outline-primary">버튼4</button>
		</div>
</div>

<script type="text/javascript">
	$('button').on('click', function(){
		// jQuery 이벤트핸들러함수의 this에는 언제나 이벤트를 발생시킨 그 엘리먼트가 들어있다. 
		// this에는 엘리먼트 객체가 들어있다. jQuery객체가 아니다. 
		// this.css('color' , 'red') 엘리먼트가 들어있고 함수가 들어있지 않아서 실행 안된다.
		// this에 대하여 $(this)를 실행하면 this에 들어있는 엘리먼트와 그 엘리먼틀르 조작하는 조작함수가 포함된
		// jQuery객체가 반환된다.
		// * this.jQuery조작합수() <-- 오류 
		// * $(this)jQuery조작합수() <-- 가능
		$(this).prop('disabled', true)
				.prev().val(10000);
	})
	
//	var x = $('button');	// x에는 jQuery객체(button 엘리먼트 +  조작함수)가 들어있다. 
	
	</script>
</body>
</html>
