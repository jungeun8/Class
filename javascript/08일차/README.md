# javascript
Json과 xml의 차이 
json 
{boxOfficeResult: {boxofficeType: "일별 박스오피스", 
                   showRange: "20120101~20120101",
                   dailyBoxOfficeList:[{rank:1, movieNe:"미션임파서블", openDt:2011-12-15},
                                       {rank:1, movieNe:"미션임파서블", openDt:2011-12-15},
				                               {rank:1, movieNe:"미션임파서블", openDt:2011-12-15},
                                       {rank:1, movieNe:"미션임파서블", openDt:2011-12-15},
                                       {rank:1, movieNe:"미션임파서블", openDt:2011-12-15}]
                   }
}

var boxofficeList = data.boxOfficeResult.dailyBoxOfficeList
$.each(boxoffceList, function(index, item) {
	var rank = item.rank;
	var name = item.movieNm;
	var openDate = item.openDt
})


xml 다루기
<boxOfficeResult>
	<boxofficeType>일별 박스오피스</boxofficeType>
	<showRange>20120101~20120101</showRange>
	<dailyBoxOfficeList>
		<dailyBoxOffice>
			<rank>1</rank>
			<movieNm>미션임파서블</movieNm>
		</dailyBoxOffice>
		<dailyBoxOffice>
			<rank>2</rank>
			<movieNm>마이 웨이</movieNm>
		</dailyBoxOffice>
	</dailyBoxOfficeList>
</boxOffcieResult>

$(xmlDoc).find('dailyBoxOffice').each(function(index, item) {
	var rank = $(item).find('rank').text();
	var name = $(item).find('movieNm').text();
})
