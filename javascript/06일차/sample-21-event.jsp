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
	<h1>onchange 이벤트</h1>
	
	<div class="box-1">
		<table class="table" id="table-cart-items">
			<thead>
				<tr>
					<th><input type="checkbox" id="checkbox-all-selected"/></th>
					<th>제품명</th>
					<th>가격</th>
					<th>구매수량</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr id="row-10001">
					<td><input type="checkbox" name="productNo" value="10001"/></td>
					<td>맥북 프로</td>
					<td>2,000,000 원</td>
					<td>1 개</td>
					<td>
						<a href="order?productNo=10001" class="btn btn-primary btn-sm">구매</a>
						<button class="btn btn-warning btn-sm" data-item-no="10001">삭제</button>
					</td>
				</tr>
				<tr id="row-20001">
					<td><input type="checkbox" name="productNo" value="20001"/></td>
					<td>아이팟</td>
					<td>400,000 원</td>
					<td>2 개</td>
					<td>
						<a href="order?productNo=20001" class="btn btn-primary btn-sm">구매</a>
						<button class="btn btn-warning btn-sm" data-item-no="20001">삭제</button>
					</td>
				</tr>
				<tr id="row-10033">
					<td><input type="checkbox" name="productNo" value="10033"/></td>
					<td>애플워치</td>
					<td>600,000 원</td>
					<td>2 개</td>
					<td>
						<a href="order?productNo=10033" class="btn btn-primary btn-sm">구매</a>
						<button class="btn btn-warning btn-sm" data-item-no="10033">삭제</button>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="mt-3">
			<button class="btn btn-secondary btn-sm" id="btn-remove-all-row">전체 삭제</button>
			<button class="btn btn-secondary btn-sm" id="btn-remove-checked-row">선택 삭제</button>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function() {
	// 페이지 로딩시 장바구니 테이블의 모든 체크박스를 체크된 상태로 설정하기
	$("#table-cart-items :checkbox").prop("checked", true);
	
	// 전체 삭제
	$("#btn-remove-all-row").click(function() {
		$("#table-cart-items tbody").empty();
		$("#checkbox-all-selected").prop("checked", false);
	});
	
	// 선택 삭제
	$("#btn-remove-checked-row").click(function() {
		$("#table-cart-items tbody tr:has(:checked)").remove()
		$("#checkbox-all-selected").prop("checked", false);
	})
	
	// 전체 선택/해제 처리하기
	$("#checkbox-all-selected").change(function() {
		var isChecked = $(this).prop("checked");
		
		$("#table-cart-items tbody :checkbox").prop("checked", isChecked);
	});
	
	// 아이템의 체크박스를 선택/해제할 때 전체 선택/해제 버튼에 반영하기
	$("#table-cart-items tbody :checkbox").change(function() {
		changeAllCheckedCheckbox();
	});
	
	// 삭제버튼 클릭시 해당 행을 삭제하기
	$("#table-cart-items tbody .btn-warning").click(function() {
		var itemNo = $(this).data("item-no"); 
		$("#row-" + itemNo).remove();
		
		changeAllCheckedCheckbox();
	});
	
	// 총 체크박스의 갯수와 체크된 체크박스의 갯수를 비교해서 전체 선택/해제 체크박스의 상태를 변경하는 함수
	function changeAllCheckedCheckbox() {
		// 체크박스의 갯수를 조회한다.
		var checkboxAllCount = $("#table-cart-items tbody :checkbox").length;
		// 체크박스가 하나도 없으면 전체 선택/해제 체크박스는 해제상태로 지정하고, 함수실행을 종료한다.
		if (checkboxAllCount == 0) {
			$("#checkbox-all-selected").prop("checked", false);
			return;
		}
		
		// 체크박스 중에서 체크된 체크박스의 갯수를 조회한다.
		var checkedCheckboxCount = $("#table-cart-items tbody :checkbox:checked").length;
		
		// 체크박스의 갯수와 체크된 체크박스의 갯수가 다르면 전체 선택/해제 체크박스를 해제상태로 지정한다.
		if (checkboxAllCount != checkedCheckboxCount) {
			$("#checkbox-all-selected").prop("checked", false);
		} else {
			$("#checkbox-all-selected").prop("checked", true);
		}
	}
})
</script>
</body>
</html>