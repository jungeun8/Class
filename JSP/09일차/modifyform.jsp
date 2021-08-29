<%@page import="com.sample.dao.ProductDao"%>
<%@page import="com.sample.vo.Product"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>HTA Mall :: 상품</title>
 	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
<%
	// 1. 요청파라미터에서 상품번호를 조회한다.
	int no = Integer.parseInt(request.getParameter("no"));  
	// 2. ProductDao객체를 획득한다.
	ProductDao pro =  ProductDao.getInstance();
	Product product = pro.getProductByNo(no);
	
	//4. 획득된 상품정보를 각 입력요소의 value속성에 value="<%=product.getXXX() "로 값을 설정한다
	   
%>
<div class="container">
<%
	String navItem = "product";
%>
	<header>
		<%@ include file="../common/header.jsp" %>
	</header>
	<main>
		<div class="row mb-3"> <!-- mb-3은 아래쪽 여백을 3만큼 설정한다. -->
			<div class="col-12">
				<h3 class="border p-3 bg-light">상품 정보 수정폼</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<form method="post" action="modify.jsp" class="border p-3 bg-light">
					<input type="hidden" name="no" value="<%=product.getNo() %>" />
					<div class="form-group">
						<label>상품 카테고리</label>
						<select class="form-control" name="category" >
							<option value="가전제품"<%="가전제품".equals(product.getCategory()) ? "selected" : ""%>> 가전제품</option>
							<option value="가구"<%="가구".equals(product.getCategory()) ? "selected" : ""%>> 가구</option>
							<option value="주방용품"<%="주방용품".equals(product.getCategory()) ? "selected" : ""%>> 주방용품</option>
							<option value="컴퓨터/노트북"<%="컴퓨터/노트북".equals(product.getCategory()) ? "selected" : ""%> selected> 컴퓨터/노트북</option>
							<option value="스마트폰/태블릿"<%="스마트폰/태블릿".equals(product.getCategory()) ? "selected" : ""%>> 스마트폰/태블릿</option>
							<option value="사무용품" <%="사무용품".equals(product.getCategory()) ? "selected" : ""%>> 사무용품</option>
							<option value="기타" <%="기타".equals(product.getCategory()) ? "selected" : ""%>> 기타</option>
						</select>
					</div>
					<div class="form-group">
						<label>상품이름</label>
						<input type="text" class="form-control" name="name" value="맥북 프로"/>
					</div>
					<div class="form-group">
						<label>제조사</label>
						<input type="text" class="form-control" name="maker" value="애플"/>
					</div>
					<div class="form-group">
						<label>가격</label>
						<input type="number" class="form-control" name="price" value="2000000" min="5000" step="1000"/>
					</div>
					<div class="form-group">
						<label>할인가격</label>
						<input type="number" class="form-control" name="discountPrice" value="1800000" min="5000" step="1000"/>
					</div>
					<div class="form-group">
						<label>재고수량</label>
						<input type="number" class="form-control" name="stock" value="90" />
					</div>
					<div class="form-group">
						<label>품절여부</label>
						<div>
							<div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="soldOut" value="N">
                          <label class="form-check-label" >판매중</label>
                     </div>
                     <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="soldOut" value="Y">
                          <label class="form-check-label">품절</label>
                     </div>
						</div>
					</div>
					<div class="text-right">
						<a href="detail.jsp?no=100" class="btn btn-secondary">취소</a>
						<button type="submit" class="btn btn-primary">수정</button>
					</div>
				</form>
			</div>
		</div>
	</main>
	<footer>
		
	</footer>	
</div>
</body>
</html>

