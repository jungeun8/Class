# WEB
MIME(Multipurpose Internet Mail Extensions) type
	- 클라이언트와 서버간에 주고받는 컨텐츠의 타입을 나타내는 것
	- 구조
		type/subType으로 구성되어 있다.
		- 예시
			text/plain
			text/html
			text/xml
			image/png
			image/jpg
			audio/mp3
			video/mp4
	- 대표적인 타입
		text
			- 인간이 읽을 수 있는 데이터 혹은 문서
		application
			- 모든 종류의 이진(바이너리) 데이터(그림, 영상, 오디오, 압축파일, 워드 등 )
			- 사람이 직접 읽을 수 없는 데이터 혹은 문서
			- 전용의 애플리케이션이 필요함
	- 대표적인 MIME타입
		text/plain 		 
			일반 텍스트 데이터, 텍스트 데이터의 기본값 
		text/html  		 
			HTML 컨텐츠
		text/xml   		 	
			XML 컨텐츠
		application/json 	 
			json 형식의 데이터
		application/octet-stream 
			이진(바이너리) 데이터의 기본값
			타입이 알려지지 않은 이진(바이너리) 데이터를 의미함
			
		multipart/form-data     
			브라우저에서 서버로 폼 입력값을 전송할 때 사용되는 변환방법 중 하나다.
			첨부파일이 있을 때 사용
			[서버로 전송되는 형식]
			----WebKitFormBoundaryQtk5bV9PVWAMOkEI
			Content-Disposition: form-data; name="title"
			휴가신청서

		application/x-www-form-urlencoded
			브라우저에서 서버로 폼 입력값을 전송할 때 사용되는 변환방법 중 하나다.
			첨부파일이 없을 때 사용
			[서버로 전송되는 형식]
			name=value&name=value&name=value 
			
페이징 처리
			
list.jsp
	1. 한 화면에 표시할 행의 갯수 정하기
	2. 요청파라미터에서 요청한 페이지 번호 알아내기
		// 데이터 표시하기
	3. 요청한 페이지에 대한 beginIndex, endIndex 계산하기
	4. 3번에서 계산한 구간에 대한 데이터를 조회해서 화면에 출력하기
		// 페이지번호 표시하기
	5. 전체 데이터갯수 조회하기
	6. 5번에서 조회한 값으로 전체 페이지 갯수 계산하기
	7. for문 사용해서 1부터 마지막페이지번호까지 출력시켜서 링크 만들기
			

