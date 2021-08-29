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
	<div id="box">
		<p class="prev">컨탠츠</p>
		<p class="prev">컨탠츠</p>
		<p class="prev">컨탠츠</p>
	</div>
	
<script type="text/javascript">
	$("#box").append("<p>append1</p>");
	$("<p>append2</p>").appendTo($('#box'));
	
	$("#box").prepend("<p>prepend1</p>");
	$("<p>prepend2</p>").prependTo($('#box'));
</script>
</body>
</html>