<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
	jstl 태그 라이브러리중 core 태그 라이브러리를 jsp 페이지에 포함시키기 	
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<div class="row">
		<div class="col-12 mb-3">
			<h3>out 태그</h3>
			<div>${test1 }</div>
			<div><c:out value="${text1 }" /></div>
			<div>${test2 }</div>
			<div><c:out value="${text2 }" /></div>
		</div>
		</div>
	</div>
</body>
</html>
