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
  	
  	<style type="text/css">
	div{
		border: 1px solid black;
		padding: 16px;
		margin: 15px;
	}
	.prev{
		color:gray;
	}
	
</style>

</head>
<body>
<div class="container">
	<h1>HTML BOM조작하기</h1>
		<div id="box-1">
				<p class="prev">컨탠츠</p>
				<p class="prev">컨탠츠</p>
				<p class="prev">컨탠츠</p>
		</div>
</div>
<script type="text/javascript">
	$("#box-1").append("<p>append1</p>");
	$("#box-1").append("<p>append2</p>");
	$("#box-1").append("<p>append3</p>");
	
</script>
</body>
</html>
