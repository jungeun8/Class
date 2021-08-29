<%--
contentType
	클라이언트로 보내는 응답 컨텐츠의 변환방식(인코딩방식)을 지정한다.
	charset=UTF-8혹은 charset=EUC-KR 일때만 한글 컨텐츠를 제대로 보낼수 있다.
pageEncoding
	jsp파일을 저장할 때 텍스트의 변환방식을 지정한다.
	UTF-8혹은 EUC-KR일 때만 한글이 포함된 텍스트를 저장할 수 있다.
 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
<%--
	선언식
		객체의 멤버변수, 정적변수, 멤버메소드, 정적메소드를 정의할떄 사용한다.
		변수나 메소드에 접근제한자를 앞에 붙일 수 있다.
 --%>
 <%!
 	// 멤버 변수, 정적변수의 선언을 권장하지 않음!!!!!!
 	private int x = 0;
 
 
 /*
 // 맴버변수 선언
 	int count = 0;
 // 멤버메소드 선언 
 	public int getCount(){
	 return count;
 }
	 */
 
 %>
	<%--
		스크립틀릿 : <% 자바코드 작성영역을 만든다. %>
			변수의 선언, 변수의 초기화, 객체 생성, 제어문, 반복문, 메소드 호출 등이 가능하다.
			스크립틀릿안에서 주석은 자바의 주석을 사용한다.
			스크립트릿안에서 작성한 자바코드는 jsp를 java로 변환했을 때
			전부 _jspService(req, res) 메소드 안에 포함한다.
	 --%>
	<%
	
		// 지역 변수 선언하기 
	 	 int y = 0;
		// 변수 선언하기
		String name = "홍길동";
		/*
			객체 생성 및 메소드 실행도 가능하다.
		*/
		// 영업팀의 1-6 월까지 매출현황 
		int[] sales = {1000000, 2000000, 32000000, 540000, 4000000, 1200000};
		
		int totalSales = 0;
		for(int amount : sales){
			totalSales += amount;
		}
		
		// 멤버변수와x와 지역변수y의 값을 1씩 증가시키기 
		x++;
		y++;
		
	%>
	<h1>Hello,JSP!</h1>
	
	<h3><%=name %> 부서 전반기 매출현황</h3>
	<dl>
		<dt>부서명</dt><dd><%=name %>부서</dd>
		<dt>총매출금액</dt><dd><%=totalSales %>원</dd>
	</dl>
	
	<h3>멤버변수와 지역변수의 값 출력해보기</h3>
	<dl>
		<dt>멤버변수</dt><dd><%=x %></dd>
		<dt>지역변수</dt><dd><%=y %></dd>
	</dl>
</body>
</html>
