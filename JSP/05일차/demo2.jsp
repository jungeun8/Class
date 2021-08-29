<%@page import="com.sample.vo.Sample"%>
<%@page import="com.sample.dao.SampleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 연습 2</h1>
	<%
	SampleDao sampleDao = new SampleDao();
	Sample sample = sampleDao.getSample();
	%>
	
	<h3>상품정보</h3>
	<table border = "1" style="width: 90%;">
	<tr>
	<th>상품번호</th><td><%=sample.getNo() %></td>
	<th>등록일</th><td>2020.01.01</td>
	</tr>
	<tr>
	<th>상품명</th><td>10원</td>
	<th>제조사</th><td>100</td>
	</tr>
	<tr>
	<th>가격</th><td>10원</td>
	<th>재고현황</th><td>100</td>
	</tr>
	</table>
</body>
</html>