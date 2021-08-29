# HTML(21.05.21)
인사관리 시스템 
Http://localhost/sample/hr/main.jsp
Main.jsp
	- 주요메뉴
		▪ 부서관리
		▪ 사원관리
		▪ 직종관리
		▪ 기타
	- 부서관리
		▪ Dept/main.jsp
			§ 주요 메뉴
				□ 부서목록 조회
				□ 새 부서 등록
				□ 부서정보 변경
				□ 부서정보 삭제
		▪ Dept/list.jsp
			§ 전체 부서 목록 표시 
				□ 부서명을 클릭하면 detail.jsp의 실행을 요청하기
		Dept/form.jsp
			§ 새 부서 등록 폼 표시
		▪ Dept/add.jsp
			§ 새 부서정보 등록
		▪ Dept/modifyform.jsp
			§ 부서정보 변경 폼 제공
		▪ Dept/remove.jsp
			§ 부서정보 삭제
		▪ Dept/detail.jsp
			§ 해당 부서의 정보 및  부서에 소속된 사원 목록 제공 
	- 사원관리
		▪ Emp/main.jsp
			§ 주요메뉴
				□ 전체사원 목록
				□ 사원정보 검색
				□ 새 사원 등록
				□ 사원정보 변경
				□ 사원정보 삭제 
		emp/list.jsp
			- 전체 사원 목록 제공
		emp/search.jsp
			- 사원 정보 검색 결과 제공
		emp/detail.jsp
			- 사원 상세정보 제공
		emp/form.jsp
			- 새 사원정보 등록 폼 제공
		emp/add.jsp
			- 새 사원정보 등록
		emp/modifyform.jsp
			- 사원정보 변경 폼 제공
		emp/modify.jsp
			- 사원정보 변경
		emp/remove.jsp
			- 사원정보 삭제

