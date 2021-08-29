# javascript
Dom 의 특징 
	- 모든 엘리먼트는 객체다.
	- 모든 엘리먼트의 프로퍼티를 정의하고 있다.
	- 엘리먼트를 엑세스하는 메소드를 정의하고 있다.
	- 모든 엘리먼트의 이벤트를 정의하고 있다. 
	
Javascript event
	- Event
		• Html 엘리먼트(태그)에서 생겨나는 것 
		• 이벤트가 생기는 원인 
			- 웹 페이지의 로딩이 완료되었을 때
			- 입력필드의 값이 변경될 때
			- 사용자가 버튼을 클릭했을 때 
			- 사용자가 마우스를 움직일 때
			- 사용자가 키보드를 입력할 때 
			- 사용자가 브라우저 창의 크기를 조절할 때 
			- 사용자가 html문서를 스크롤할 때 
		• 이벤트의 처리 
			- 이벤트 발생이 예상되는 엘리먼트를 선정한다.
			- 해당 엘리먼트와 이벤트 발생시 실행될 함수를 바인딩한다.
			- 이벤트 처리를 통해서 사용자와 상호작용하는 웹 페이지를 제작할 수 있다. 

Element의 텍스트컨텐츠의 조회 및 변경
	<태그>텍스트</태그>
	// 조회
	var content = element.textContent;
	// 변경
	element.textContent = "새 텍스트 컨텐츠";

Element의 HTML 컨텐츠의 조회 및 변경
	<태그0>
		<태그1>텍스트</태그1>
		<태그2>텍스트</태그2>
	</태그0>
	// 조회 element는 태그0이다. 
	var htmlContent = element.innerHTML;	// <태그1>텍스트</태그1><태그2>텍스트</태그2>를 조회한다.
	// 변경
	element.innerHTML = "<태그3>텍스트</태그3><태그4>텍스트</태그4>";

Element의 속성값 추가/조회/변경/삭제
	<tag 속성1="값1" />
	// 추가
	element.setAttribute("속성2", "값2");			// <tag 속성1="값1" 속성2="값2" />
	// 조회
	var attrValue = element.getAttribute("속성1");		
	// 변경
	element.setAttribute("속성1", "값100");			// <tag 속성1="값100" 속성2="값2" />
	// 삭제
	element.removeAttribute("속성1");			// <tag 속성2="값2" />

-----------------------------------------------------------------------------------------
폼 입력요소의 조회 및 변경

입력요소의 값 조회
	var 값 = element.value;
입력요소의 값 변경
	element.value = "값";

라디오버튼, 체크박스의 체크여부 조회하기
	var 체크여부 = element.checked
	// true면 체크, false면 체크해제된 상태임
라디오버튼, 체크박스의 체크여부 변경
	element.checked = true;	// 체크상태로 변경
	element.checked = false;// 체크해제상태로 변경

입력요소의 비활성화 변경
	element.disabled = true; // 비활성화 상태로 변경
	element.disabled = false;// 활성화 상태로 변경

입력요소의 읽기전용 변경 여부
	element.readOnly = true; // 읽기전용으로 변경
	element.readOnly = false;// 편집가능으로 변경

