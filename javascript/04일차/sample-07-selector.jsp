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
<h1>기타 필터연산자</h1>
	<table>
		<thead>
			<tr>
				<th>순번</th>
				<th>이름</th>
				<th>휴대번호</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>10</td>
				<td>홍길동</td>
				<td>010-1111-2222</td>
				<td>hong@gmail.com</td>
			</tr>
			<tr>
				<td>20</td>
				<td>김유신</td>
				<td>010-3333-2222</td>
				<td>kim@gmail.com</td>
			</tr>
			<tr>
				<td>30</td>
				<td>이순신</td>
				<td>010-1111-3333</td>
				<td>lee@gmail.com</td>
			</tr>
		</tbody>
	</table>
</div>
<script type="text/javascript">
// 텍스트컨텐츠로 김유신을 포함하고 있는 엘리먼트를 선택하기 
$("td:contains(김유신)").css({'color':'red', 'fontWeight':'bold'});
$("td:contains(김유신)").css({'backgroud-color':'yellow'});

//th태그를 가지고 있는 tr 엘리먼트를 선택하기 
$('tr:has(th)').css('background-color', '#eee');

// th태그를 가지고있지 않은 tr엘리먼트 선택하기 
$('tr:not(:has(th))').css('font-size', '35px');
$('tbody tr').css('font-style', 'italic');
</script>
</body>
</html>
