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
<div class="mb-3">
<h1>json 응답데이터, xml 응답데이터 처리하기</h1>
</div>

<div class="row">
	<div class="col">
		<form class="from-inline boder bg-light p-2" id="from-search-1">
			<label class="mr-2">조회일자: </label>
			<input type="date" class="from-control mr-2" id="date-boxoffice-1" />
			<button type="button" class="btn btn-outline-primary btn-sm" id="btn-boxoffice-1">조회</button>
		</form>
		<div class="mt-3 bordder bg-list p-2">
		<h4>박스오피스 순위</h4>
		<table class="table" id="table-boxoffice-1">
			<colgroup>
				<col width="10%">
				<col width="50%">
				<col width="20%">
				<col width="20%">
			</colgroup>
		<thead>
			<tr>
				<td>순위</td>
				<td>제목</td>
				<td>개봉일자</td>
				<td>예매율</td>
				
			</tr>
		</thead>
		<tbody></tbody>
		</table>
		
		</div>
	</div>
	<div class="col"></div>
</div>

</div>
<script type="text/javascript">
$(function() {
   
	 $("#btn-boxoffice-1").click(function(){
		 var dateString = $("#date-boxoffice-1").val();
	      if (!dateString) {
	         alert("조회날짜를 입력하세요!");
	         return false;
		 }
	      if (!isBeforeDate(dateString)) {
	          alert("조회날짜는 오늘보다 이전날짜만 가능합니다.");
	          return false;
	       }
	      
	   // 조회된 날짜에서 -를 제거한다. "2021-07-05" -> "20210705"
	      dateString = dateString.replace(/-/g, '');
		  var url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
	      $.getJSON(url, {key:"f5eef3421c602c6cb7ea224104795888", targetDt:dateString})
	      		.done(function(data){
	      			var boxofficeList = boxoffice.boxOfficeResult.dailyBoxOfficeList;
	      			$.each(boxofficeList, function(index, item){
	      				
	            		var $tr = $("<tr></tr>");
	            		$("<td></td>").text(item.rank).appendTo($tr);
	            		$("<td></td>").text(item.movieNm).appendTo($tr);
	            		$("<td></td>").text(item.openDt).appendTo($tr);
	            		$("<td></td>").text(item.salesShare).appendTo($tr);
	            		
	            		$tbody.append($tr);
	            	})
	      		})
	      		.fail(function(){
	      			alert("오류가발생했습니다.")
	      		})
	      		.always(function(){
	      			
	      		})
	 })
   
   // 오늘 자정의 유닉스타임을 반환한다.
   function getTodayTime() {
      var now = new Date();
      
      var year = now.getFullYear();
      var month = now.getMonth();
      var date = now.getDate();
      
      var today = new Date(year, month, date);
      return today.getTime();
   }
   
   // 선택한 날짜의 유닉스타임을 반환한다.
   function getSearchTime(dateString) {
      var date = new Date(dateString);
      return date.getTime();
   }
   
   // 선택한 날짜가 오늘보다 이전인지 여부를 반환한다.
   function isBeforeDate(dateString) {
      return getTodayTime() > getSearchTime(dateString);
   }
})
</script>
</body>
</html>
