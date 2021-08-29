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
	<h1>HTML DOM 조작하기</h1>
	<p>텍스트 컨텐츠, html 컨텐츠, 폼의 입력값, 엘리먼트의 프로퍼티 값 조회</p>
		<div id="box-1">
			<h3>.text(), .html()로 텍스트 컨텐츠, html 컨텐츠 조회하기</h3>
			<p>jQuer 연습하기</p>
			<p><strong>jQuery</strong>연습하기</p>
		</div>
		<div id="box-2">
			<h3>폼 입력요소</h3>
			<form>
			이름: <input type="text" name="username" id="user-name" value="홍길동"><br/>
			비번: <input type="password" name="userpwd" id="user-pwd" value="zxcv1234"><br/>
			성별: <input type="radio" name="usergender" id="user-gender-female" value="여자" checked>여성
				 <input type="radio" name="usergender" id="user-gender-male" value="남자">남성<br/>
			기술: <input type="text" name="userskill" id="user-career" value="java">자바
				 <input type="text" name="userskill" id="user-career" value="db" checked>데이터베이스
			 	 <input type="text" name="userskill"  id="user-career" value="python">파이썬<br/>
			경력: <select name="career">
				<option value="1">1년이상</option>
				<option value="3">3년이상</option>
				<option value="5" selected="selected">5년이상</option>
				<option value="7">7년이상</option>
			</select><br/>
			메모: <textarea id="user-memo" name="usermemo"></textarea><br/>
			</form>
		</div>
		
		<div class="box-3">
			<div class="row">
				<div class="col-3">
					<img src="images/1.jpg" class="img-thumbnail" id="image-gallary" alt="곰돌이">
				</div>
			</div>
		</div>
		
		<div class="box-4">
		<h3>비활성화 여부, 읽기전용 여부, 체크여부 조회하기</h3>
			<input type="text" id="form-element-1" disabled readonly>
			<input type="text" id="form-element-2" disabled>
			<input type="text" id="form-element-3" readonly>
			<input type="checkbox" id="form-element-4" checked>
			<input type="checkbox" id="form-element-5" disabled readonly>
			<button type="button" id="form-element-6" disabled></button>
			<button type="button" id="form-element-7"></button>
		</div>
	</div>
<script type="text/javascript">
	$("div").css({border:'1px solid black', padding:'10px', margin:"10px"})
	// box-1의 p엘리먼트의 텍스트 컨텐츠 읽어오기
	var textContent1 = $("#box-1 p:eq(0)").text();
	var textContent2 = $("#box-1 p:eq(1)").text();
	console.log("첫번째 텍스트 컨텐츠", textContent1);
	console.log("두번째 텍스트 컨텐츠", textContent2);
	
	// box-1의 p엘리먼트의 html 컨텐츠 읽어오기
	var htmlContent1 = $("#box-1 p:eq(0)").html();
	var htmlContent2 = $("#box-1 p:eq(1)").html();
	console.log("첫번째 html 컨텐츠", htmlContent1);
	console.log("두번째 html 컨텐츠", htmlContent2);
	
	////////////////////////////////
	// 폼 입력값 조회하기 
	// 입력필드의 값 조회하기 
	var name = $("#user-name").val();
	// 비밀번호 필드 값 조회 (int type="10")
	var pwd  = $("#user-pwd").val();
	// 경력 조회 (select)
	var career  = $("#user-career").val();
	// 메모조회하기 (textarea)
	var memo  = $("#user-memo").val();
	// 체크된 성별의 값 조회하기 
	var gender = $(':radio[name=usergender]:checked').val();
	
	//////////////////////////////////
	// 속성값 조회하기 
	var imageSrc = $("#image-gallary").attr("src");
	var imagedClass=$("#image-gallary").attr("class");
	var imageId=$("#image-gallary").attr("id");
	var iamgeAlt=$("#image-gallary").attr("alt");
	
	/////////////////////////////////
	// 비활성화 여부 조회하기 
	var isDisabled1 = $('#form-element-1').prop("disabled");
	var isDisabled2 = $('#form-element-2').prop("disabled");
	var isDisabled3 = $('#form-element-3').prop("disabled");
	var isDisabled4 = $('#form-element-4').prop("disabled");
	var isDisabled5 = $('#form-element-5').prop("disabled");
	var isDisabled6 = $('#form-element-6').prop("disabled");
	var isDisabled7 = $('#form-element-7').prop("disabled");
	
	// 읽기전용여부
	var isReadOnly1 = $("#form-element-1").prop("readOnly");
	var isReadOnly2 = $("#form-element-2").prop("readOnly");
	var isReadOnly3 = $("#form-element-3").prop("readOnly");
	var isReadOnly4 = $("#form-element-4").prop("readOnly");
	var isReadOnly5 = $("#form-element-5").prop("readOnly");
	var isReadOnly6 = $("#form-element-6").prop("readOnly");
	var isReadOnly7 = $("#form-element-7").prop("readOnly");
	
	// 체크여부
	var ischecked1 = $("#form-element-1").prop("checked");
	var ischecked2 = $("#form-element-2").prop("checked");
	var ischecked3 = $("#form-element-3").prop("checked");
	var ischecked4 = $("#form-element-4").prop("checked");
	var ischecked5 = $("#form-element-5").prop("checked");
	var ischecked6 = $("#form-element-6").prop("checked");
	var ischecked7 = $("#form-element-7").prop("checked");
	
</script>
</body>
</html>
