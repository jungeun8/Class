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
	<h1>기타 필터 선택자</h1>
	
	<div id="box-1">
		<p>p1</p>
		<p>p2</p>
		<p>p3</p>
		<p>p4</p>
	</div>
	<div id="box-2">
		<p>p5</p>
		<p>p6</p>
		<p>p7</p>
		<p>p8</p>
		<div class="inner-box">
			<p>p9</p>
			<p>p10</p>
			<p>p11</p>
		</div>
		<div class="inner-box">
			<p>p12</p>
			<p>p13</p>
			<p>p14</p>
		</div>
	</div>
</div>
<script type="text/javascript">
	//:first, :last, :first-child, :last-child, :nth-child(n) 활용
	//p1만 선택하는 선택자
	$("p:first").css('color', 'red');
	//p14만 선택하는 선택자
	$("p:last").css('color', 'green');
	//p1, p5, p9, p12를 선택하는 선택자
	$("p:first-child").css('background-color', 'yellow');
	//p4, p11, p14를 선택하는 선택자
	$("p:last-child").css('border', '1px solid blue');
	//p3, p7, p11, p14를 선택하는 선택자.
	$("nth-child(3)").css('text-decoration', 'underline');
	
	//:eq(n), :lt(n), :gt(n) 활용
	//p2만 선택하는 선택자
	$("#box-1 p:eq(1)").css('font-style', 'italic');
	//p1, p2를 선택하는 선택자
	$("#box-1 p:lt(2)").css('font-size', '50px');
	//p3, p4를 선택하는 선택자
	$("#box-1 p:gt(2)").css('font-size', '8px');
	
	//위에 나열된거 전부 활용
	//p9, p12를 선택하는 선택자
	$(".inner-box p:first-child").css('font-weight', 'bold');
	//p9만 선택하는 선택자
	$(".inner-box p:first").css('border', '3px solid red');
	//p3, p7를 선택하는 선택자
	$("p:contains('p3', 'p7')").css('text-decoration', 'line-through');
	</script>
</body>
</html>
