<%@page import="java.util.Map"%>
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
<%
	Map<String, Object> map1 = (Map<String, Object>)request.getAttribute("req2");
	Map<String, Object> map2 = (Map<String, Object>)session.getAttribute("ses2");
	Map<String, Object> map3 = (Map<String, Object>)application.getAttribute("app2");
%>
	<div class="row">
		<div class="col-12">
			<table class="table">
				<tr>
					<th>Request Scope</th><td><%=map1 %></td>
				</tr>
				<tr>
					<th>Session Scope</th><td><%=map2 %></td>
				</tr>
				<tr>
					<th>Application Scope</th><td><%=map3 %></td>
				</tr>
			</table>
		</div>
	
	</div>
</div>
</body>
</html>
