# javascript(06.69)
jquery	
	- 경량의 자바스크립트 라이브러리
	- 크로스 브라우징을 지원
	- CSS3 선택자를 지원
	- 장점
	- 강력한 선택자를 지원
	- HTML DOM을 조작하는 다양한 메소드를 지원
	- 스타일을 쉽게 조작할 수 있다.
	- 애니메이션 효과 구현
	- 단순한 이벤트 처리
	- 쉬운 AJAX 처리
	- Write less, Do more
	- 강력한 선택자 : 쉽게 엘리먼트를 찾을 수 있다.
	- 메소드가 묵시적 반복을 수행한다.
	- 메소드체이닝을 지원한다.
	- jquery 라이브러리 설치
	- jquery 소스 다운받아서 설치하기
	1. jquery.com에서 소스를 다운받아서 프로젝트에 저장한다.
	2. HTML문서나 JSP에서 해당 위치에 저장된 소스를 
	<script src="jquery-3.4.1.min.js"></script> 태그를 사용해서 
	해당 페이지에 포함시킨다.
	- CDN을 이용하기
	CDN(Content Delivery Network)으로 부터 jquery 라이브를 받아서 사용한다.
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	* 사용자로부터 가장 가까운 CDN서버로부터 라이브러리를 가져온다.
	* 웹 서버의 트래픽을 감소시킨다.
	$() 함수 사용법
	- $("selector")
	* selector 표현식에 해당하는 엘리먼트를 검색한다.
	* jquery집합객체를 반환한다.
	* jquery집합객체 = 검색된 엘리먼트 + 다양한 메소드
	- $(function() { ... })
	* HTML Document객체가 준비되면 함수가 자동으로 실행된다.
	* $(document).ready(function() { ... })와 같은 싯점에 실행된다.
	- $(document객체) 혹은 $(element객체)
	* $("#box") 함수의 실행결과 ----> jQuery집합객체[검색된 엘리먼트 + 좋은 메소드]
	* var el = document.getElementById("box");
	el ----> 태그정보 + 허접한 메소드
	$(el) ----> jQuery집합객체[el + 좋은 메소드] 
	- $("html태그")
	* 작성된 html태그에 해당하는 엘리먼트 객체를 생성하고,
	생성된 엘리먼트를 포함하는 jQuery집합객체[생성된 엘리먼트 + 좋은 메소드]를 반환한다.
	* $("<p>연습입니다.</p>") --> jQuery집합객체[p엘리먼트 + 좋은 메소드]
	$("<p>연습입니다.</p>").css("color", 'red').click(function() { ... });
	jQuery Selector
	- jQuery 라이브러리에서 가장 중요한 부분이다.
	- HTML문서에서 엘리먼트를 조작하기 위해서 반드시 선행되어야 하는 작업은 
	조작대상이 되는 엘리먼틀 선택하는 작업 <---- jQuery Selector를 활용하면 간단해진다.
	- 모든 jQuery 작업의 시작은 $(select)함수로부터 시작한다.
	- jQuery Selector 표현식
	-----------------------------------------------------------------------------------------------------------------------
	표현식 예제 설명
	-----------------------------------------------------------------------------------------------------------------------
	기본선택자
	* $("*") 모든 엘리먼트 선택
	#id $("#box") id="box"인 엘리먼트 선택
	.class $(".btn") class="btn"인 모든 엘리먼트 선택
	tag $("p") 모든 P 엘리먼트 선택
	tag,tag,tag $('h1,h2,h3') 모든 h1, h2, h3 엘리먼트 선택 
	----------------------------------------------------------------------------------------------------------------------- 
	필터선택자
	:first $("p:first") 첫번째 P엘리먼트 선택
	:last $("p:last") 마지막번째 P엘리먼트 선택
	:even $("p:even") 짝수번째 P엘리먼트 선택
	:odd $("p:odd") 홀수번째 P엘리먼트 선택
	-----------------------------------------------------------------------------------------------------------------------
	자식, 자손, 형제 선택자
	parent > child $("div > p") div의 자식 중에서 모든 P엘리먼트 선택
	parent descendant $("div p") div의 후손 중에서 모든 P엘리먼트 선택
	element + next $("div + p") div 바로 아랫동생 P엘리먼트 선택
	element ~ siblings $("div ~ p") div 동생들중에서 P엘리먼트 선택
	-----------------------------------------------------------------------------------------------------------------------
	자식 필터선택자
	:first-child $("p:first-child") p엘리먼트 중에서 장남인 모든 P엘리먼트 선택
	:last-child $("p:last-child") p엘리먼트 중에서 막내자식인 모든 P엘리먼트 선택
	:nth-child(n) $("p:nth-child(2)") p엘리먼트 중에서 둘째 자식인 모든 P엘리먼트 선택
	-----------------------------------------------------------------------------------------------------------------------
	순서 필터선택자
	:eq(index) $("p:eq(0)") p엘리먼트 중에서 0번째 P엘리먼트 선택
	:gt(index) $("p:gt(2)") p엘리먼트 중에서 2번째 다음의 모든 P엘리먼트 선택
	:lt(index) $("p:lt(2)") p엘리먼트 중에서 2번째 이전의 모든 P엘리먼트 선택
	-----------------------------------------------------------------------------------------------------------------------
	기타 필터선택자
	:contains(text) $("p:contains('안녕')") p엘리먼트 중에서 '안녕'이라는 텍스트를 포함하고 있는 모든 P엘리먼트 선택
	:has(selector) $("div:has(p)") div엘리먼트 중에서 p엘리먼트 가지고 있는 모든 div엘리먼트를 선택
	:not(selector) $("p:not(:last-child)") p엘리먼트 중에서 막내가 아닌 모든 p엘리먼트를 선택
	----------------------------------------------------------------------------------------------------------------------- 
	속성 선택자
	[attr] $('[src]') src속성을 가지고 있는 모든 엘리먼트 선택
	[attr=value] $('[type="date"]') type속성값이 date인 모든 엘리먼트 선택
	[attr!=value] $('[type!="hidden"]') type속성값이 hidden이 아닌 모든 엘리먼트 선택
	[attr^=value] $('[href^="http"]') href속성값이 http로 시작하는 모든 엘리먼트 선택
	[attr$=value] $('[href$=".pdf"]') href속성값이 .pdf로 끝나는 모든 엘리먼트 선택
	[attr*=value] $('[alt*="모자"]') alt속성값에 '모자'가 포함되는 모든 엘리먼트 선택
	[attr~=value] $('[alt~="모자"]') alt속성값에 '모자'가 분리된 단어로 포함되어 있는 모든 엘리먼트 선택
	------------------------------------------------------------------------------------------------------------------------
	폼 선택자
	:input $(":input") 모든 폼요소엘리먼트(input,select,textarea)를 선택
	:text $(":text") 모든 <input type="text"> 엘리먼트 선택
	:password $(":password") 모든 <input type="password"> 엘리먼트 선택
	:radio $(":radio") 모든 <input type="radio"> 엘리먼트 선택
	:checkbox $(":checkbox") 모든 <input type="checkbox"> 엘리먼트 선택
	:file $(":file") 모든 <input type="file"> 엘리먼트 선택
	:submit $(":submit") 모든 <input type="submit"> 엘리먼트 선택
	:reset $(":reset") 모든 <input type="reset"> 엘리먼트 선택
	:selected $(":selected") select엘리먼트에서 선택된 option 엘리먼트를 선택
	:checked $(":checked") 라디오버튼, 체크박스에 체크된 엘리먼트만 선택
	:enabled $(":enable") 활성화된 모든 폼요소 엘리먼트 선택
	:disabled $(":disable") 비활성화된 모든 폼요소 엘리먼트 선택
	------------------------------------------------------------------------------------------------------------------------ 
	기타 필터 선택자
	:animated $(":animated") 현재 애니메이션효과가 실행중인 엘리먼트 선택 
	:focus $(":focus") 현재 포커스를 가지고 있는 엘리먼트 선택
	:empty $('p:empty') p엘리먼트 중에서 컨텐츠를 가지고 있지 않는 p엘리먼트 선택
	:hidden $(":hidden") display:none 로 설정돼서 화면에 표시되지 않는 모든 엘리먼트 선택
	:visible $(":visible") 현재 화면에 표시되고 있는 모든 엘리먼트 선택
	------------------------------------------------------------------------------------------------------------------------
	이벤트 처리
	* 엘리먼트에서 특정 이벤트 발생시 실행될 콜백함수를 구현하고, 엘리먼트에 부착시키는 처리
	* 다양한 방법들
	<button onclick="fn()"> 
	function fn() { ... }
	<button id="btn"> 
	document.getElementById('btn').onclick = function() { ... }
	<button id="btn"> 
	document.getElementById("btn").addEventListener('click', function() { ... })
	* jQuery는 브라우져의 종류에 상관없이 일관된 방식으로 이벤트처리가 가능하도록 추상화된
	이벤트 처리관련 메소드를 제공한다.
	* jQuery 집합객체의 이벤트 관련 API
	- 메소드
	$(selector).on('이벤트명', 콜백함수)
	선택된 엘리먼트에서 지정한 이벤트가 발생할 때 마다 콜백함수가 실행된다.
	$(container).on('이벤트명', selector, 콜백함수) 
	container로 지정된 엘리먼트안에
	selector로 검색되는
	현재 존재하거나 미래에 추가될 엘리먼트에서 
	지정한 이벤트가 발생할 때마다 콜백함수가 실행된다. 
	* container : 이벤트 처리 대상이 되는 엘리먼트를 후손으로 가지는 엘리먼트를 지정한다.
	* selector : 이벤트 처리 대상이 되는 엘리먼트
	$(selector).one('이벤트명', 콜백함수)
	선택된 엘리먼트에서 지정한 이벤트가 발생하면 단 한 번만 콜백함수가 실행된다.
	$(selector).off('이벤트명')
	선택된 엘리먼트에서 지정된 이벤트와 관련된 이벤트처리를 삭제한다.
	$(selector).trigger('이벤트명')
	선택된 엘리먼트에서 지정된 이벤트가 발생되게 한다.
	* 각 이벤트의 편리메소드를 콜백없이 실행하면 해당 이벤트를
	발생시키는 trigger가 된다.
	* 각각의 이벤트마다 이벤트명으로 된 편리메소드가 있다.
	* click(cb) 엘리먼트를 클릭했을 때 콜백 실행
	dbclick(cb) 엘리먼트를 더블클릭했을 때 콜백 실행
	keydown(cb) 엘리먼트(입력필드)에서 키보드를 누를 때 콜백 실행
	keypress(cb) 엘리먼트에서 키보드가 완전이 눌러졌을 콜백 실행
	* keyup(cb) 엘리먼트에서 키보드가 다시 올라올 때 콜백 실행(입력필드에 값이 표시)
	mouseenter(cb) 엘리먼트의 경계범위 안으로 마우스 포인트가 진입했을 때 콜백 실행 
	mouseleave(cb) 엘리먼트의 경계범위 밖으로 마우스 포인트가 빠져나갈 때 콜백 실행
	mouseover(cb) 엘리먼트 위에 마우스 포인트가 위치할 때 콜백 실행
	mouseout(cb) 엘리먼트 위에서 마우스 포인트가 나갈 때 콜백 실행
	mousemove(cb) 엘리먼트 위에서 마우스 포인트를 움직일 때 마다 콜백 실행
	focus(cb) 엘리먼트(폼입력요소)가 포커스를 획득했을 때 콜백 실행
	blur(cb) 엘리먼트(폼입력요소)가 포커스를 잃을 때 콜백 실행
	* change(cb) 엘리먼트(select, radio, checkbox)의 값(선택된/체크된 값)이 변할 때 마다 콜백 실행
	* submit(cb) 폼엘리먼트의 입력값들이 서버로 제출될 때 콜백 실행
	load(cb) 페이지의 로딩이 완료됐을 때 콜백 실행
	ready(cb) Document객체가 준비됐을 때 콜백 실행
	resize(cb) 브라우저의 윈도사이즈가 변할 때 마다 콜백 실행
	* scroll(cb) 스크롤바가 움직일 때 마다 콜백 실행
	* hover(cb1, cb2) mouseenter와 mouseleave를 한 번에 처리하는 메소드
	cb1은 mouseenter, cb2는 mouseleave일 때 콜백 실행
	* jQuery 이벤트처리에서 기본동작 수행을 방해하기
	- 방법 1
	$("#my-form").submit(function(event) {
	if (유효성체크실패) {
	// 메세지 표시
	// 해당 입력요소로 포커스 이동
	event.preventDefault(); // 기본동작 수행 방해
	return; // 즉시 종료
	}
	if (유효성체크실패) {
	// 메세지 표시
	// 해당 입력요소로 포커스 이동
	event.preventDefault(); // 기본동작 수행 방해
	return; // 즉시 종료
	}
	});
	- 방법 2
	$("#my-form").submit(function(event) {
	if (유효성체크실패) {
	// 메세지 표시
	// 해당 입력요소로 포커스 이동
	return false;
	}
	return true;
	});
	* jQuery에서 이벤트핸들러함수(콜백함수, 이벤트리스너함수)가 
	false값을 반환하면 해당 엘리먼트에서 그 이벤트와 관련된 기본동작이
	실행되지 않는다.
	* return false는 event.preventDefault()와 동일한 효과를 발휘한다.
	* 이벤트핸들러함수에서 this는 이벤트를 발생시킨 바로 그 엘리먼트객체가 들어있다.
	- this로 이벤트가 발생된 엘리먼트 객체를 전달받을 수 있다.
	- this에는 엘리먼트객체가 들어있기 때문에 jQuery의 기능을 사용할 수 없다.
	- $(this)함수를 실행해서 엘리먼트를 포함하고 있는 jQuery집합객체를 획득한다.
	* Event객체
	* 이벤트핸들러함수(콜백함수)는 발생된 이벤트에 관한 주요 정보를 가지고 있는 
	Event객체를 전달받을 수 있다.
	$(selector).on('이벤트명', function(event) { ... })
	* 주요 API
	- Property
	event.type 이벤트이름 반환
	event.target 이벤트를 발생한 엘리먼트 객체
	event.which 키보드나 마우스의 키값
	event.pageX 이벤트가 발생한 곳의 x좌표 반환
	event.pageY 이벤트가 발생한 곳의 y좌표 반환
	event.preventDefault() 해당 이벤트에 대한 그 엘리먼트의 기본동작 실행 방해
	event.stopPropagation() 이벤트 버블링을 중지시킨다.
	event.stopImmediatePropagation() 엘리먼트의 다른 핸들러 실행을 중지시킨다.
	HTML DOM 조작
	* 엘리먼트, 엘리먼트의 속성, 엘리먼트의 컨텐츠를 조회/변경/추가/삭제 작업과 관련된
	기능을 제공한다.
	* 조회기능
	$(selector).text() 엘리먼트의 텍스트컨텐츠를 반환(태그가 제외된)
	$(selector).html() 엘리먼트의 HTML컨텐츠를 반환(태그가 포함된)
	$(selector).val() 폼입력요소의 값을 반환
	$(selector).prop(name) 엘리먼트의 프로퍼티값을 반환(checked, disabled, readOnly 등)
	$(selector).attr(name) 엘리먼트의 속성값을 반환(name, id, class, type, src, href, alt, title ... 등)
	* 조회기능은 반환값으로 텍스트를 반환하기 때문에 메소드 체이닝을 이어갈 수 없다.
	* 변경기능
	$(selector).text(textContent) 엘리먼트의 텍스트 컨텐츠를 변경한다.
	$(selector).html(htmlContent) 엘리먼트의 HTML 컨텐츠를 변경한다.
	$(selector).val(value) 폼입력요소의 값을 변경한다.
	$(selector).prop(name, value) 엘리먼트의 프로퍼티값을 변경한다.
	$(selector).attr(name, value) 엘리먼트의 속성값을 변경한다.
	* 변경기능은 반환값으로 $(selector)실행결과로 획득된 jQuery집합객체를 다시 반환한다.
	* 변경기능을 실행한 후에는 연속해서 jQuery집합객체의 메소드를 이어서 실행할 수 있다.
	* 추가기능
	$(selector).append() 엘리먼트의 맨마지막 자식요소로 추가된다.
	$(selector).prepend() 엘리먼트의 첫번째 자식요소로 추가된다.
	$(selector).after() 엘리먼트의 동생으로(뒤에) 추가된다.
	$(selector).before() 엘리먼트의 형으로(앞에) 추가된다.
	* 추가기능도 메소드 체이닝을 이어갈 수 있다.
	* 삭제기능
	$(selector).remove() 엘리먼트를 삭제한다.(자식요소도 같이 삭제된다.)
	$(selector).empty() 엘리먼트는 남아있고 자식요소들만 삭제만 삭제된다.
	* 삭제기능도 메소드 체이닝을 이어갈 수 있다.
	* 클래스 조작(스타일 조작)
	$(selector).addClass(classname) 엘리먼트에 지정된 클래스를 추가한다.
	$(selector).removeClass(classname) 엘리먼트에서 지정된 클래스를 삭제한다. 
	$(selector).toggleClass(classname) 엘리먼트에서 지정된 클래스를 토글시킨다.
	$(selector).hasClass(classname) 엘리먼트가 지정된 클래스를 가지고 있는지 여부를 반환한다.(true/false)
	* hasClass()기능을 제외하고 나머지는 메소드 체이닝을 이어갈 수 있다.
	* addClass(), removeClass(), toggleClass()는 클래스를 조작함으로써 
	그 클래스명으로 정의된 스타일이 해당 엘리먼트에 적용되게하거나, 적용된 것을
	취소시키기 위해서 사용한다.
	* css 조작
	$(selector).css(name) 엘리먼트에서 지정된 이름의 css값을 조회한다.
	$(selector).css(name, value) 엘리먼트의 css를 변경한다.
	$(selector).css({name:value, name:value}) 엘리먼트에 여러 종류의 css를 한번에 변경한다.
	* 주의: 실제 프로젝트에서 개발자가 css()메소드로 css값을 직접 조작하는 것은 지양해야 한다.
	* css(name)기능을 제외하고 나머지는 메소드 체이닝을 이어갈 수 있다.
	HTML DOM 돌아다니기
	* 현재 선택된 엘리먼트를 기준으로 다른 엘리먼트와의 관계를 활용해서 특정 엘리먼트를 검색하는 것이다.
	* 부모, 조상 검색 메소드
	$(selector).parent() selector로 검색된 엘리먼트의 부모 엘리먼트를 선택
	$(selector).parents() selector로 검색된 엘리먼트의 모든 조상 엘리먼트를 선택
	$(selector1).parents(selector2) selector1으로 검색된 엘리먼트 조상중에서 selector2에 해당하는 모든 조상 엘리먼트들 선택
	$(selector1).closest(selector2) selector1으로 검색된 엘리먼의 조상중에서 selector2에 해당되는 가장 가까운 조상 엘리먼트 선택
	* 자식, 자손 검색 메소드
	$(selector).children() selector의 검색된 엘리먼트의 모든 자식 엘리먼트를 선택
	$(selector1).find(selector2) selector1으로 검색된 엘리먼트의 후손 엘리먼트 중에서 selector2에 해당하는 모든 후손 엘리먼트 선택
	* 형제 검색 메소드
	$(selector).prev() selector로 검색된 엘리먼트의 바로 윗 형 엘리먼트 선택
	$(selector).prevAll() selector로 검색된 엘리먼트의 모든 형 엘리먼트들 선택
	$(selector).next() selector로 검색된 엘리먼트의 바로 아래 동생 엘리먼트 선택
	$(selector).nextAll() selector로 검색된 엘리먼트의 모든 동생 엘리먼트들 선택
	$(selector).siblings() selector로 검색된 엘리먼트의 모든 형제 엘리먼트들 선택
	* 필터 메소드
	$(selector1).filter(selector2) selector1으로 검색된 엘리먼트 중에서 selector2에 해당하는 모든 엘리먼트 선택
	$(selector).filter(콜백) selector로 검색된 엘리먼트 중에서 콜백함수가 true를 반환하는 모든 엘리먼트 선택 
	* 콜백함수
	function(index) { ... }
	* 콜백함수는 selector로 검색된 엘리먼트의 갯수만큼 실행된다.
	* 콜백함수는 실행될 때마다 this로 검색된 엘리먼트를 하나씩 순서대로 전달받는다.
	* 콜백함수가 true를 반환한 것만 최종적으로 선택된다.
	$(selector).first() selector로 검색된 엘리먼트 중에서 첫번째 엘리먼트 선택
	$(selector).last() selector로 검색된 엘리먼트 중에서 마지막번째 엘리먼트 선택
	$(selector).eq(index) selector로 검색된 엘리먼트 중에서 index번째 엘리먼트 선택 
	$(selector1).has(selector2) selector1으로 검색된 엘리먼트 중에서 selector2를 후손으로 가지고 있는 엘리먼트 선택
	$(selector1).not(selecotr2) selector1으로 검색된 엘리먼트 중에서 selector2에 해당하지 않는 엘리먼트 선택
	* 기타 필터 메소드
	$(selector1).필터메소드1(selector2).조작함수() selector1으로 검색된 엘리먼트 중에서 selector2에 해당하는 엘리먼트 검색 후 조작함수 실행
	.end() 필터메소드1() 실행 전 상태로 되돌아간다.
	.필터메소드2(selector3).조작함수() selector1으로 검색된 엘리먼트 중에서 selector3에 해당하는 엘리먼트 검색 후 조작함수 실행
	* end()는 맨 마지막에 실행된 필터메소드 실행 이전 상태로 jQuery결합집합의 상태가 되돌아간다. 
	$(selector1).is(selector2) selector1으로 선택된 엘리먼트가 selector2에 해당하는 true를 반환한다.
	$(selector).index() selector로 선택된 엘리먼트가 부모로부터 몇번째 엘리먼트인지를 반환한다.(0번부터 시작하는 숫자)
	jQuery 기타함수
	each()
	* 선택자와 같이 사용되는 each()
	* 선택자로 선택된 엘리먼트를 반복처리할 때 사용한다. 
	$(selector).each(콜백함수)
	* selector로 선택된 엘리먼트의 갯수만큼 콜백함수가 실행된다.
	* 콜백함수
	function(index, element) { ... }
	* index는 엘리먼트의 인덱스
	* element는 선택된 엘리먼트가 순서대로 전달된다.
	* index, element는 전부 생략가능하다.
	* 콜백함수내의 this에는 선택된 엘리먼트가 순서대로 전달된다.
	* 배열과 같이 사용되는 each()
	* 자바스크립의 배열의 각 요소를 반복처리할 때 사용한다.
	* 자바스크립트 배열의 forEach()와 동일하다.
	$.each(배열, 콜백함수)
	* 배열에 저장된 요소의 갯수만큼 콜백함수가 실행된다.
	* ajax 실행결과로 획득된 데이터가 JSON배열인 경우 그 데이터를 처리하기 위해 
	주로 사용된다.
	* 콜백함수
	function(index, item) { ... }
	* index는 아이템의 저장위치
	* item은 배열의 요소가 순서대로 전달된다.
	* index, item은 전부 생략가능하다.
	* 콜백함수내의 this에는 배열의 요소가 순서대로 전달된다.
	jQuery의 AJAX 처리
	* jQuery는 AJAX 처리를 위한 다양한 메소드를 지원한다.
	* jQuery의 AJAX는 text, html, xml, json, jsop 타입의 응답데이터를 처리할 수 있다.
	* 주요 메소드
	$.get(URL, data, function(data, status, xhr) { ... }, dataType)
	* GET 방식의 AJAX요청을 처리한다.
	* URL - 데이터를 제공하는 서버의 URL
	* data - 요청할 때 서버로 보내지는 데이터
	* function - 성공적인 응답이 왔을 때 실행될 콜백함수
	* data - 서버가 보낸 응답데이터
	* status - 응답처리 상태값(거의 사용하지 않음)
	* xhr - XMLHttpRequest 객체(거의 사용하지 않음)
	* dataType - 응답데이터의 컨텐츠 타입을 지정한다.
	* "text" - plain text
	* "json" - json 형식의 데이터 -> javascript 배열, 객체 변환 후 반환
	* "xml" - xml 형식의 데이터 -> XML Document객체로 변환 후 반환
	* "jsonp" - 다른 사이트의 서버로부터 데이터를 요청할 때 사용된다.
	$.post(URL, data, function(data, status, xhr) { ... }, dataType)
	* POST 방식의 Ajax요청을 처리한다
	$.getJSON(URL, data, function(data, status, hxr) { ... })
	* 응답컨텐츠가 JSON일 때 사용한다.
	$.ajax({name:value, name:value, ...})
	* AJAX 처리에 필요한 다양한 값을 name/value의 쌍으로 설정된 객체를 전달받는다.
	* 설정가능한 값
	type - 요청방식 ("GET", "POST")
	url - 요청URL
	data - 서버로 보내는 데이터
	작성예 - "name=value&name=value" 
	- {name:value, name:value}
	contentType - 서버로 보내는 데이터의 컨텐츠 타입
	기본값 : "application/x-www-form-urlencoded"
	JSON형식 : "application/json"
	dataType - 서버로부터 제공받는 응답데이터의 타입
	"text", "xml", "json", "jsonp"
	beforeSend - ajax요청을 보내기 직전에 실행할 함수
	function(xhr) { ... }
	success - ajax요청이 성공했을 때 실행할 함수
	error - ajax요청이 실패했을 때 실행할 함수
	complete - ajax요청이 완료되었을 때 실행할 함수(성공, 실패와 상관없이)
	* 글로벌 ajax 지원 메소드 
	$(document).ajaxStart(function() { ... })
	ajax요청이 시작되면 실행될 콜백함수 지정
	$(document).ajaxSend(function(event, xhr, options) { ... })
	ajax요청을 보내기 전에 실행될 콜백함수 지정
	$(document).ajaxSucess(function(event, xhr, options) { ... })
	ajax요청에 대한 성공적인 응답이 왔을 때 실행될 콜백함수 지정
	$(document).ajaxError(function(event, xhr, options, ex) { ... })
	ajax요청에 대한 실패 응답이 왔을 때 실행될 콜백함수 지정
	$(document).ajaxComplete(function(event, xhr, options) { ... })
	ajax요청이 완료되었을 때 실행될 콜백함수 지정
	* ajax helper 메소드
	$.param(object)
	* javascript 객체나 배열을 쿼리스트링으로 변환한다.
	* 작성예
	var obj = {name:"홍길동", tel:"010-1111-1111", mail:"hong@gmail.com"}
	$.param(obj) ---> "name=홍길동&tel=010-1111-1111&mail=hong@gmail.com"
	$(selector).serialize()
	* 폼의 입력값을 쿼리스트링으로 변환한다.
	* 작성예
	<form id="searchform">
	이름 : <input type="text" name="username" /> <-- 홍길동 입력
	나이 : <input type="text" name="userage" /> <-- 30 입력
	</form>
	$("#searchform").serialize() ---> "username=홍길동&userage=30"

