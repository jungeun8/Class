# Database
데이터베이스 요약
SQL
	- Structured Query Language
	- 구조화된 질의 언어
	- DBMS의 데이터에 엑세스하는 명령어다.
	- 종류
		SELECT : 데이터 조회
		DML(Data Manipulation Language:데이터 조작어)
			INSERT, UPDATE, DATE, MERGE
		DDL(Data Definition Language:데이터 정의어)
			CREATE, DROP, ALTER, RENAME, TRUNCATE
		DCL(Data Control Language:데이터 제어어)
			COMMIT, ROLLBACK, SAVEPOINT

select 문
	- 테이블의 데이터를 조회하는 명령문이다.
	- 조회 기능
		- 프로젝션 : 조회결과로 반환되는 열(컬럼)을 사용자가 선택할 수 있다.
		- 선택 : 조회결과로 반환되는 행을 다양한 조건으로 제한할 수 있다.
		- 조인 : 두 개 이상의 테이블을 연결해서 각 테이블에 저장된 데이터를 한 번에 가져올 수 있다.

	- 가장 기본적인 조회 기능
		- 테이블의 모든 행과 모든 열을 조회하기
			SELECT *
			FROM   테이블명;

		- 테이블에서 특정 컬럼을 선택해서 조회하기
			SELECT 컬럼명, 컬럼명, 컬럼명, ...
			FROM   테이블명;

		- 산술연산자(+, -, *, /) 사용하기
			SELECT 컬럼명 + 10, 컬럼명 + 컬럼명, (컬럼명*2) + 컬럼명, ...
			FROM   테이블명;
			* 산술연산자를 사용하는 산술식에 NULL값이 포함되어 있으면 
			  연산결과는 항상 NULL이다.
			* 오라클에서 NULL은 값이 결정되지 않았다는 의미다.
		- 별칭(Alias) 정의하기
			* 컬럼명의 이름을 변경한다.(단, 테이블의 컬럼명이 변경되는 것은 아니다.)
			* 계산식이 포함된 컬럼에 적절한 이름을 붙일 때 유용하다.
			* 별칭은 컬럼명 바로 뒤에 적는다. 컬럼명과 별칭 사이에 AS 키워드를 사용할 수 있다.
			* 별칭에 특수문자, 공백이 포함되는 경우 ""를 사용해야 한다.
			SELECT 컬럼명 별칭, 컬럼명 AS 별칭, ...
			FROM   테이블명
		- 중복행없이 조회하기
			SELECT DISTINCT 컬럼명, 컬럼명, ...
			FROM   테이블명
			* DISTINCT 키워드는 제시된 컬럼의 값이 동일한 행은 한 번만 조회한다.
	- 선택되는 행의 제한
		SELECT 컬럼명, 컬럼명, 컬럼명, ...
		FROM   테이블명
		WHERE  조건식;
		* 조건식의 연산결과가 true로 판정되는 행만 선택된다.
		* 비교 연산자
			=				같다
			>				크다
			>=				크거나 같다
			<				작다
			<=				작거나 같다
			<>				같지않다
			!=				같지않다
			between 하한값 and 상한값	값의 범위에 포함(하한값, 상한값도 포함)	
			in (값1, 값2, 값3, ...)         제시된 값들 중에서 하나라도 일치한 것
			like 문자패턴			문자패턴과 일치하는 것
				* 와일드 카드
					%	0개 이상의 문자
					_	문자 하나
			is null				null값인 것
			in not null			null값이 아닌 것		
		* 조건식
			where  컬럼명  비교연산자  값
			where  연산식  비교연산자  값
			where  연산식  비교연산자  연산식
			작성예)
				where salary > 6000;
				where department_id = 70;
				where salary*12 > 50000;
				where manager_id is not null;
				where department_id in (10, 20)
				where job_id in ('AD_PRES', 'AD_VP');
		* 논리 연산자
			and	조건식의 모든 조건이 true일 때 true를 반환한다.
			or	조건식의 조건 중 하나라도 true일 때 true를 반환한다.
			not	조건식의 연산결과를 반전시키다.
		* 논리 연산자가 포함된 조건식
			where 컬럼명 비교연산자 값 and 컬럼명 비교연산자 조건식
			작성예)
				where department_id = 60 and salary >= 5000;
				where department_id = 50 and job_id like '%MAN';
				where salary >= 10000 and salary <= 20000;
				where department_id in (50, 60, 70) and salary > 15000;
				
	- 정렬하기
		* ORDER BY 절을 사용하면 행을 정렬할 수 있다.
		* ORDER BY 절은 SELECT문의 가장 끝에 위치한다.
		* ORDER BY 절에서는 정렬조건으로 컬럼명, 연산식, 별칭, 컬럼의 순번을 지정할 수 있다.
		* ORDER BY 절
			SELECT 컬럼명, 컬럼명, 컬럼명
			FROM   테이블명
			[WHERE 조건식]
			[ORDER BY 정렬조건 ASC|DESC]

- 오라클 내장함수
	- 단일행 함수
		- 행 당 하나의 결과를 반환한다.
		- 조회된 각 행에 대해서 함수가 실행된다.
		- 중첩해서 사용할 수 있다.
		- 종류
			문자함수
				LOWER(표현식)
					소문자로 변환 후 반환한다.
				UPPER(표현식)
					대문자로 변환 후 반환한다.
				LENGTH(표현식)
					문자의 길이를 반환한다.
				CONCAT(표현식1, 표현식2)
					문자를 이어붙여서 반환한다.
				SUBSTR(표현식, 시작위치)
					시작위치에서 끝까지 잘라낸 문자를 반환한다.
				SUBSTR(표현식, 시작위치, 길이)
					시작위치에서 지정된 길이만큼 잘라낸 문자를 반환한다.
				INSTR(표현식, '문자')
					지정된 문자가 등장하는 위치를 반환한다.(1부터 시작)
				LPAD(표현식, 길이, '문자')
					지정된 길이보다 짧으면 모자란 갯수만큼 왼쪽에 지정된 문자를 붙여서 반환한다.
				RPAD(표현식, 길이, '문자')
					지정된 길이보다 짧으면 모자란 갯수만큼 오른쪽에 지정된 문자를 붙여서 반환한다.
				TRIM(표현식)
					불필요한 공백을 제거한 후 반환한다.
				REPLACE(표현식, '변경할 문자', '새문자')
					문자를 찾아서 새문자로 바꾼 다음 반환한다.
			숫자함수
				ROUND(표현식, 숫자)
					지정된 숫자의 자리수까지 반올림한다.
				TRUNC(표현식, 숫자)
					지정된 숫자의 자리만 남기고 나머지는 버린다.
				MOD(숫자1, 숫자2)
					숫자1에 대한 숫자2의 나머지값을 반환한다.
				* ROUND와 TRUNC에서 숫자값이 양수면 소숫점 자리수를 나타내고,
							     0이면 1의 자리수
							     음수면 10의 자리수 이상을 나타낸다.
			날짜함수
				SYSDATE
					매개변수값이 필요없어서 괄호는 생략하고 사용한다.
					시스템의 현재 날짜와 시간정보를 반환한다.
				MONTHS_BETWEEN(날짜, 날짜)
					두 날짜사이의 개월 수를 반환한다.
				ADD_MONTHS(날짜, 숫자)
					날짜에 숫자만큼 경과된 개월 수의 날짜를 반환한다.
				ROUND(날짜)
					가장 가까운 날짜로 반올림한다.
				TRUNC(날짜)
					가장 가까운 날짜에 맞춰 버려진다.
				NEXT_DAY(날짜, 요일)
					지정된 날짜를 기준으로 다음 번 해당 요일의 날짜를 반환한다.
					요일: 1-일요일, 2-월요일, ..., 7-토요일
				LAST_DAY(날짜)
					지정된 날짜가 속해있는 달의 마지막 날짜를 반환한다.
				시간과 관련된 연산
					DATE + 숫자 = 숫자만큼 경과된 DATE
					DATE - 숫자 = 숫자만큼 이전의 DATE
					DATE - DATE = 두 날짜간의 간격을 일 단위로 반환 
					* 날짜관련 연산을 할 때는 TRUNC()를 사용해서 
                                          날짜에서 시분초를 0으로 만든 다음 연산을 수행하자.
			변환함수
				TO_CHAR(날짜, '포맷형식')
					날짜를 지정된 포맷형식의 텍스트로 반환한다.
				TO_DATE(문자, '패턴형식')
					문자가 지정된 패턴형식으로 작성되어 있으면 날짜로 변환해서 반환한다.
				TO_CHAR(숫자, '포맷형식')
					숫자를 지정된 포맷형식의 텍스트로 반환한다.
				TO_NUMBER(문자, '패턴형식')
					문자가 지정된 패턴형식으로 작성되어 있으면 숫자로 변환해서 반환한다.
				* 날짜형식 기호
					YYYY	네자리 년도
					MM	월
					DD	일
					DAY	요일
					AM	오전/오후
					HH	12시간제
					HH24	24시간제
					MI	분
					SS	초
				* 숫자형식 기호	
					9	숫자를 표시한다.
					0	0을 강제로 표시한다.
					,	천단위 구분자를 표시한다.
					.	소숫점을 표시한다.
			기타함수
				NVL(표현식, 값)
					표현식의 값이 NULL이 아니면 표현식의 값이 반환되고,
					표현식의 값이 NULL이면 지정된 값이 반환된다.
					* 표현식의 값의 타입과 대체할 값의 타입은 동일해야 한다.
				NVL2(표현식, 값1, 값2)
					표현식의 값이 NULL이 아니면 값1이 반환되고,
					표현식의 값이 NULL이면 값2가 반환된다.
					* 값1과 값2의 타입은 동일해야 한다.
				DECODE(표현식, 값1, 결과값1
					       값2, 결과값2
					       값3, 결과값3
						    결과값4)
					표현식의 값이 값1과 일치하면 결과값1이 반환되고,
						      값2와 일치하면 결과값2가 반환된다.
						      표현식과 일치하는 값이 존재하지 않으면 결곽값4가 반환된다.
				CASE
					WHEN 조건식1 THEN 결과값1
					WHEN 조건식2 THEN 결과값2
					ELSE 결과값3
				END
					조건식1이 TRUE면 결과값1이 최종값이 되고,
					조건식2가 TRUE면 결과값2가 최종값이 된다.
					모든 조건식이 FALSE로 판정되면 결과값3이 최종값이 된다.
			* 표현식은 컬럼이름 혹은 연산식을 말한다. 

	- 다중행 함수
		- 행 집합에 적용되며, 각 그룹당 하나의 결과를 반환한다.
		- 행 집합은 테이블 전체 또는 그룹화된 테이블이다.
		- 합계, 평균, 최대값, 최소값, 분산, 표준편차 등을 구할 수 있다.

- 여러 테이블에서 데이터 조회하기
	- 테이블 조인하기
		- 조회할 데이터가 2개 이상의 테이블에 흩어져서 존재하는 경우 테이블의 조인이 필요하다.
		- 테이블 조인 방법
			select ~ 
			from 테이블1, 테이블2, ...
			* from절에 조인할 테이블을 나열하면 된다.
			* 테이블1의 모든 행과 테이블2의 모든 행이 결합된다.
			* 테이블1의 행갯수 x 테이블2의 행갯수 만큼의 행이 조회된다.
		- 조인 조건을 활용해서 서로 관련있는 행들끼리 결합된 행만 조회하기
			select ~
			from 테이블1 A, 테이블2 B
			where A.컬럼명 = B.컬럼명;	// 조인 조건 
			* n개의 테이블을 조인하면 n-1개 이상의 조인 조건이 필요하다.
	- 테이블 조인의 종류
		- 등가조인
			두 테이블의 컬럼값이 동일한 값을 가지고 있을 때 사용한다.
			조인조건에 동등연산자(=)를 사용한다.
			예)	외래키			     기본키
				-------------------------------------------------------- 
				employees의 department_id와  departments의 department_id : 부서번호를 가짐
			   	employees의 job_id와         jobs의 job_id			: 직종번호를 가짐
				departments의 manager_id와   employees의 employee_id	: 직원번호를 가짐
				departments의 location_id와  locations의 location_id	: 위치번호를 가짐
			예)
				select A.first_name, A.salary, B.department_name
				from employees A, departments B 
				where A.department_id = B.department_id;
				* 직원의 소속부서아이디와 부서의 부서아이디가 같은 값을 가진 행끼리 조인시킨다.

			* 주로 기본키와 외래키를 조인의 보조수단으로 포함한다.
			* 기본키는 행을 대표하는 값을 포함하고 있는 컬럼이다.
			* 외래키는 다른 테이블의 특정 컬럼값을 참조하는 값만을 가지는 컬럼이다.
		- 비 등가조인
			동등연산자(=)가 아닌 다른 연산자를 포함하는 조인조건을 사용한다.
			예)
				employees의 salary와 job_grades의 lowest_sal, highest_sal
			* 비등가 조인은 주로 값이 특정범위내에 속하는 행끼리 조인시킨다.
			* 급여등급, 고객등급 등과 같이 특정 범위에 속할 때 해당 등급을 가진 행과 조인시킨다.
			예)
				select A.first_name, A.salary, B.gra
				from employees A, job_grades B
				where A.salary >= B.lowest_sal and A.salary <= B.highest_sal;
				* 급여가 최소급여와 최대급여 사이인 행들끼리만 조인시킨다.
				* 동등연산자(=) 대신 >, >=, <, <= 와 같은 연산자가 사용되는 조인이다.
		- 자체조인
			동일한 테이블을 서로 조인 시키는 것이다.
			예)
				employees의 manager_id와 employees의 employee_id
				* 각 사원의 관리자 이름을 찾기 위해서는 employees 테이블끼리 조인해야 한다.
				* 자체 조인을 할 때는 테이블을 각각 직원용, 관리자용으로 구분해서 조인을 시킨다.
				* 직원의 정보는 직원용 employees에서 관리자정보는 관리자용 employees에서 조회한다.
			예)
				select emp.first_name 직원명, emp.salary 직원급여
					mgr.first_name 관리자명, mgr.salary 관리자급여
				from employees emp, employees mgr
				where emp.manager_id = mgr.employee_id;
				* 같은 테이블을 자체조인할 때는 각 테이블을 적절한 별칭을 붙이는 것이 좋다.
 				* 값을 조회할 때 혼동되지 않도록 주의가 필요하다.
			* 자체 조인이 필요한 정보는 주로 조직정보, 메뉴정보, 카테고리정보 등이 자체조인이 필요한 테이블들이다.
			* 이런 테이블들은 거의 대부분 하나의 테이블 안에 상위정보와 하위정보가 같이 있다.
		- 포괄조인
			조인조건을 만족시키지 못하는 행도 조회결과에 포함시키는 조인이다.
			* 포괄조인을 사용하면 조인조건을 만족하지 않는 행도 조회된다.
			* 포괄조인 연산자는 (+) 이다.
			* 포괄조인 연산자는 하나 이상의 null행을 생성한다.
			* 포괄조인 연산자는 null 행이 필요한 조인옆에 붙인다.
			예)
				departments의 manager_id와 employees의 employee_id
				* 부서의 담당자정보를 조회하기 위해서 employees와 조인한다.
				* departments의 manager_id값이 null인 행은 employees의 어느 행과도 조인되지 않는다.
				* employees측이 null행이 필요한 테이블이기 때문에 조인조건에서 employees측에 (+)를 붙인다.
			예)
				select A.department_id, A.department_name, B.first_name
				from departments A, employees B
				where A.manager_id = B.employee_id(+);
				* A의 manager_id는 null값을 가진 행이 있다.
				* B의 employee_id는 null값을 가진 행이 없다.
				* B측이 null 행이 필요한 곳이다.
	- 테이블 조인시 주의사항
		- 테이블을 조인할 때는 컬럼의 이름이 같은 것끼리 조인하는 것이 아니라,
		  같은 성질의 값을 가졌거나, 서로 관련있는 값을 가진 컬럼을 조인조건에 사용해야 한다.
		- 테이블을 조인할 때는 조회결과에 포함되는 값들을 어느 테이블에서 획득할 수 있는지 
		  확인하는 것이 첫번째로 할 일이다.
		- 테이블을 조인할 때는 조인작업을 할 때마다 해당 테이블을 from절에 포함시켜야 한다.
		  * 직원의 정보, 직원의 소속부서정보, 직원의 소속부서의 관리자정보를 조회할 때,
		    직원과 소속부서정보의 획득을 위해서 employees와 departments가 필요하고,
		    소속부서의 관리자 정보를 획득하기 위해서 employees가 또 필요한다.
		    select 직원.first_name, 직원.salary, 소속부서.department_name, 소속부서관리자.first_name
		    from employees 직원, departments 소속부서, employees 소속부서관리자 
		    where 직원.department_id = 소속부서.department_id
		    and 소속부서.manager_id = 소속부서관리자.employee_id

- 그룹함수(다중행 함수)를 사용해서 데이터 집계하기
	- 그룹함수
		- 그룹함수는 행 집합에 작용해서 그룹 당 하나의 결과를 생성하는 함수다.
		  * 행 집합은 테이블 전체 또는 그룹화된 테이블의 행들이다.
		  * 그룹함수는 2번까지만 중첩될 수 있다.
		- 그룹함수의 종류
			count(* | [distinct] 컬럼명) : 행의 갯수를 반환한다.
			min(컬럼명) : 최소값을 반환한다.			
			max(컬럼명) : 최대값을 반환한다.
			sum(컬럼명) : 합계를 반환한다.
			avg(컬럼명) : 평균을 반환한다.
	- 데이터 그룹 생성하기
		- group by 절을 사용하면 테이블의 행을 더 작은 그룹으로 나눌 수 있다.
		  * group by 절
		    select 표현식, 그룹함수(컬럼)
		    from  테이블
		    [where 조건식]
		    [group by 표현식]
		    [order by 컬럼 ASC|DESC]
		    * 표현식은 컬럼명 혹은 연산식이다.
		    * group by 절에는 컬럼의 별칭을 사용할 수 없다.
		    * select 절에 그룹함수와 같이 사용할 수 있는 표현식은
                      group by 절에 정의된 표현식만 가능하다.
		    * select 절에서 표현식을 사용하지 않으면, 개별 그룹에 대한 결과를 확인할 수 없다.
		    * where 절을 사용하면 그룹으로 나누기 전에 불필요한 행을 제거할 수 있다.
		      단, where 절에서는 그룹함수를 사용할 수 없다.
		    * group by 절에 하나 이상의 표현식을 사용해서 테이블의 행을 그룹화할 수 있다.
		      예)
			select department_id, job_id, count(*)
			from employees
			group by department_id, job_id
			* department_id를 기준으로 먼저 그룹화를 한 후, 그 그룹내에서 다시 job_id를
                          기준으로 그룹화를 한다.
	- 데이터 그룹에 대한 그룹함수 수행 결과에서 행을 제한하기
		- having 절을 사용하면 그룹함수 수행 결과에서 행을 제한할 수 있다.(그룹 결과 제외)
		  * having 절에서는 그룹함수를 사용할 수 있다.
		- 그룹 결과가 제외되는 절차
		  1. 행이 그룹화된다.
		  2. 그룹화된 집합에 그룹함수가 적용된다.
	   	  3. having 절의 조건식과 일치하는 그룹결과만 표시된다.
		  * having 절은 반드시 group by 절과 같이 사용된다.
                    (group by 없이 단독으로 having만 사용하는 것은 불가능하다.)
		- having 절
		    select 표현식, 그룹함수(컬럼)
		    from  테이블
		    [where 조건식]
		    [group by 표현식]
		    [having 조건식]
		    [order by 컬럼 ASC|DESC]

- 서브쿼리
	- 서브쿼리는 다른 SELECT문에 삽입된 SELECT문을 말한다.
	- where절, having절, from절에 서브쿼리를 포함시킬 수 있다.
          * 서브쿼리는 보통 where절이나 having절에 포함된 SELECT문을 말한다.
	- 서브쿼리
		select 컬럼명, 컬럼명, ...
		from 테이블명
		where 표현식 연산자 (select 컬럼명
                                     from 테이블명
                                     [where 조건식])
		* 서브쿼리는 메인 쿼리의 where절의 조건식에서 사용될 값을 질의하는 내부 SQL문이다.
		* 서브쿼리는 메인 쿼리보다 먼저 실행된다.
		* 서브쿼리의 실행결과는 메인쿼리의 조건식에서 사용된다.
		* 서브쿼리는 괄호로 묶는다.
		* 서브쿼리는 연산자의 오른쪽에 위치한다.
		* 단일행 서브쿼리는 단일행 연산자를 사용하고, 다중행 서브쿼리는 다중 행 연산자를 사용한다.
		  * 단일행 서브쿼리는 서브쿼리 실행결과 한 행만 조회되는 서브쿼리다.
		  * 다중행 서브쿼리는 서브쿼리 실행결과 여러 행이 조회되는 서브쿼리다.
		  * 단일행 서브쿼리 연산자
			= != > >= < <=
		  * 다중행 서브쿼리 연산자 
			in any all

- JDBC(Java DataBase Connectivity)
	- 자바에서 데이터베이스에 엑세스할 수 있도록 하는 표준을 정의해놓은 것이다.
	- java.sql과 javax.sql 패키지에 JDBC관련 표준이 정의된 인터페이스와 클래스가 위치하고 있다.
	- JDBC에서 정의한 표준(데이터베이스 엑세스 기술 표준)은 
          각 데이터베이스시스템을 개발한 업체가 그 표준을 구현해서 제공하고 있다.
	  이를, JDBC Driver라고 부른다.

- JDBC 표준 API
	java.sql.Connection 인터페이스
		* 데이터베이스와 연결을 담당하는 객체다.
		* SQL을 데이터베이스로 전송하고, 실행결과를 반환받기 위해서는 데이터베이스와의 연결상태가 유지되어야 한다.
		* DriverManager의 getConnection(url, username, password) 메소드를 실행해서 획득한다.
		* 주요 메소드
			void commit()
				INSERT, UPDATE, DELETE 구문 실행결과를 영구적으로 DB에 반영시킨다.
			void rollback()
				INSERT, UPDATE, DELETE 구문 실행결과의 DB 반영을 취소시킨다.
			void close()
				데이터베이스와의 연결을 해제한다.
			Statement createStatement()
				SQL전송을 담당하는 Statement객체를 반환한다.
			PreparedStatement prepareStatement(String sql)	
				SQL전송을 담당하는 PreparedStatement객체를 반환한다.	
	java.sql.Statement 인터페이스
		* SQL의 실행과 결과값 반환을 담당하는 객체다.
		* Statement는 보안문제로 사용하지 않는다.
	java.sql.PreparedStatement 인터페이스
		* SQL의 실행과 결과값 반환을 담당하는 객체다.
		* 주요 메소드
			int executeUpdate()
				INSERT, UPDATE, DELETE 구문을 실행시키고, 반영된 행의 갯수를 반환한다.
			ResultSet executeQuery()
				SELECT 구문을 실행시키고, 조회결과를 ResultSet에 담아서 반환한다.
			void close()
				이 객체와 관련된 데이터베이스와 JDBC Resource를 해제시킨다. 
			void setInt(int index, int value)
				SQL 구문에서 지정된 순번의 ?에 정수값을 치환시킨다.
			void setLong(int index, long value)
				SQL 구문에서 지정된 순번의 ?에 정수값을 치환시킨다.
			void setDouble(int index, double value)
				SQL 구문에서 지정된 순번의 ?에 실수값을 치환시킨다.
			void setString(int index, String value)
				SQL 구문에서 지정된 순번의 ?에 문자열값을 치환시킨다.
			void setDate(int index, Date value)
				SQL 구문에서 지정된 순번의 ?에 날짜값을 치환시킨다.
	java.sql.ResultSet 인터페이스
		* SELECT 구문 실행결과로 획득된 테이블의 데이터를 포함하고 있는 객체다.
		* 획득된 데이터를 조회할 수 있는 다양한 메소드를 제공한다.
		* 주요 메소드
			boolean next()
				현재 위치에서 커서를 다음 행으로 이동시킨다.
				행이 존재하면 true, 존재하지 않으면 false를 반환한다.	
			void close()
				이 객체와 관련된 데이터베이스와 JDBC Resource를 해제시킨다.
			int getInt(String columnName)
				커서가 위치한 행에서 지정된 컬럼명의 값을 반환한다.
			long getLong(String columnName)
				커서가 위치한 행에서 지정된 컬럼명의 값을 반환한다.
			double getDouble(String columnName)
				커서가 위치한 행에서 지정된 컬럼명의 값을 반환한다.
			String getString(String columnName)
				커서가 위치한 행에서 지정된 컬럼명의 값을 반환한다.
			Date getDate(String columnName)
				커서가 위치한 행에서 지정된 컬럼명의 값을 반환한다.		
	java.sql.ResultSetMetaData 인터페이스
		* SELECT 구문 실행결과로 획득된 테이블의 데이터에 대한 컬럼명, 컬럼타입 정보를 포함하고 있는 객체다.
		* 개발에서 사용할 일 없음, SqlDeveloper, 쿼리박스 등의 제품을 구현할 때 주로 사용됨
	java.sql.Driver 인터페이스
		* 모든 JDBC 드라이버가 반드시 구현해야 하는 인터페이스다.
		* 개발에서 사용할 일 없음, 데이터베이스시스템 제조사가 사용함.
	java.sql.DriverManager 클래스
		* JDBC driver에 대한 관리 서비스를 제공하는 객체다.
		* JDBC driver의 등록, 해제, 등록된 JDBC driver를 이용한 데이터베이스 연결을 지원한다.
		* 주요 메소드
			Connection getConnection(String url, String username, String password)
				지정된 url이 가르키는 데이터베이스와 연결된 Connection객체를 반환한다.
	javax.sql.DataSource 인터페이스 
		* 모든 Connection Pool 구현 클래스가 반드시 구현해야 하는 인터페이스다.
		* Connection Pool은 지금 설명안할 꺼임
		* 주요 메소드
			Connection getConnection()
				Connection Pool에서 Connection을 반환한다.

- 데이터 조작어
	- 테이블에 새 행 추가
	- 테이블의 기존 행 수정
	- 테이블에서 기존 행 삭제
	- INSERT 구문
		insert into 테이블명 [(컬럼명[, 컬럼명, ...])]
		values               (값 [, 값, ...])
		* 컬럼명을 생략하는 경우 테이블의 컬럼 순서에 맞게 값을 나열해야하고, 값을 생략할 수 없다.
		* 컬럼명을 나열하는 경우 나열된 컬럼에 맞게 값을 나열해야 한다.
                * 컬럼명을 나열하는 경우 생략된 컬럼에 대해서는 null값이 저장되거나, default로 설정된 기본값이 저장된다.
		* null 값을 저장하기
			- 컬럼을 나열할 때 해당 컬럼을 생략하면 그 컬럼에는 null값이 저장된다.
			- values 절에서 값을 나열할 때 명시적으로 null을 값으로 적는다.
		* 날짜값 저장하기
			- 시스템의 현재 날짜/시간 정보 저장
				SYSDATE
			- 특정날짜 및 시간값 저장
				'2020/04/25', '2020-03-12', '2020-04-25 12:23:11'
				to_date('2020/03/31', 'yyyy/mm/dd')
				to_date('2020/03/31 16:31:10', 'yyyy/mm/dd hh24:mi:ss')
		* 일련번호 저장하기
			- 시퀀스로부터 일련번호를 인출해서 저장하기
				시퀀스명.nextval
		* 오류사항
			- not null로 지정된 컬럼에 값을 누락한 경우
			- 데이터 타입이 불일치하는 경우
			- 값의 길이가 컬럼에 지정된 데이터 길이보다 큰 경우
			- 중복값을 허용하지 않는 기본키(Primary key), 고유키(Unique) 컬럼에 중복된 값이 저장되는 경우
			- 외래 키(Foreign  key) 제약 조건에 위배되는 값을 저장할 때(해당 컬럼에 저장되는 값이 다른 외부 컬럼에 이미 존재하는 값만 저장을 허락하는 경우) 
			- 체크 제약조건에 외배되는 값을 저장할 때
		* 다른 테이블에서 행을 복사해서 저장하기
			insert into 대상테이블명 (컬럼명, 컬럼명, ...)
			select 컬럼명, 컬럼명, ...
			from 원본테이블명
			[where 조건식]
			* 대상 테이블의 컬럼명과 원본 테이블의 컬럼명이 일치할 필요는 없다.
			* 원본 테이블과 대상 테이블의 각각의 컬럼타입이 일치하기만 하면 된다.
	- UPDATE 구문
		update 테이블명
		set
			컬럼명 = 값 [, 컬럼명 = 값, ...]
		[where 조건식]
		* where 절을 생략하면 모든 행에서 해당 컬럼의 값이 지정된 값으로 변경되어 버린다.
		* 특별한 경우가 아니면 where절을 사용해서 조건식을 만족하는 행만 선택해서 컬럼값을 변경한다.
		* 서브쿼리를 사용해서 획득값으로 컬럼의 값을 변경하는 것도 가능하다.
			update 테이블명
			set
				컬럼명 = (select 컬럼명
                                          from 테이블명
                                          [where 조건식])
			* 서브쿼리는 단일행 서브쿼리만 가능하다.
		* 오류 사항
			- insert문의 오류 사항과 동일하다.
			- 자식테이블에 자식레코드(해당 컬럼의 값을 참조하는 행)가 존재하면 컬럼의 값을 변경할 수 없다.
			- 자식테이블에서 부모테이블의 값을 참조하는 컬럼의 값을 부모테이블에 존재하지 않는 값으로 변경할 수 없다.
	- DELETE 구문
		delete from 테이블명
		[where 조건식]
		* where절을 생략하면 테이블의 모든 행이 삭제된다.
		* 특별한 경우가 아니면 where절을 사용해서 조건식을 만족하는 행만 선택해서 삭제한다.
		* 오류 사항
			- 자식테이블에 자식레코드가 존재하는 행은 삭제할 수 없다.
	- MERGE 구문
		테이블에서 조건에 따라 데이터를 갱신하거나, 추가하는 기능을 제공한다.
		행이 존재하면 UPDATE를 수행하고, 새로운 행일 경우 INSERT를 수행한다.
		merge int 대상테이블명 별칭
		using 원본테이블 별칭
		on (조인 조건식)
		when matched then
			update set
			대상테이블컬럼명 = 원본테이블컬럼명,
			대상테이블컬럼명 = 원본테이블컬럼명,
			대상테이블컬럼명 = 원본테이블컬럼명
		when not matched then
			insert (대상컬럼명, 대상컬럼명, ...)
			values (원본컬럼명, 원본컬럼명, ...)
- 트랜잭션 처리하기
	- 트랜잭션은 데이터의 일관성을 보장한다.
	- 트랜잭션은 여러 번의 DML작업(INSERT, UPDATE, DELETE)을 하나의 논리적인 작업단위로 묶어준다.
	- 트랜잭션은 서로 관련있는 DML작업의 결과가 전부 데이터베이스에 반영되게 하거나,
          전부 데이터베이스 반영이 취소되게 하기 위해서 사용되는 기능이다.
	- DML작업의 결과는 트랜잭션 단위로 데이터베이스 반영 및 취소가 일어난다.
	- 트랜잭션의 시작
		* 첫번째 DML SQL 문이 실행될 때 시작된다.
		* commit 또는 rollback 명령어가 실행되는 경우 시작된다.
		* 시스템에 장애가 발생한 경우 시작된다.
		- 트랜잭션의 시작 및 종료 예
			INSERT문 실행 	--- 첫번째 트랜잭션 시작, 새로운 작업그룹(1번 작업그룹)이 시작, INSERT문의 실행결과가 1번 작업그룹에 포함
			INSERT문 실행	--- 실행결과가 1번 작업그룹에 포함
			SELECT문 실행	--- 해당사항없음
			UPDATE문 실행	--- 실행결과가 1번 작업그룹에 포함
			* 1번작업그룹 -> INSERT, INSERT, UPDATE 작업결과가 포함되어 있음
			COMMIT 실행 	--- 1번 작업그룹에 포함된 작업결과가 영구적으로 데이터베이스반영, 첫번째 트랜잭션 종료, 두번째 트랜잭션 시작, 새로운 작업그룹(2번 작업그룹)이 시작
			
			UPDATE문 실행	-- 실행결과가 2번 작업그룹에 포함
			INSERT문 실행	-- 실행결과가 2번 작업그룹에 포함
			INSERT문 실행	-- 실행결과가 2번 작업그룹에 포함
			CREATE문 실행	-- 해당사항 없음
			DROP문   실행	-- 해당사항 없음
			DELETE문 실행	-- 실행결과가 2번 작업그룹에 포함	
			SELECT문 실행	-- 해당사항 없음
			* 2번 작업그룹 -> UPDATE, INSERT, INSERT, DELETE 작업결과가 포함되어 있음
			ROLLBACK 	-- 2번 작업그룹에 포함된 작업결과의 DB 반영이 전부 취소된다. 두번째 트랜잭션 종료, 세번째 트랜잭션 시작, 새로운 작업그룹(3번 작업그룹)이 시작
	- 트랜잭션 제어 명령어
		- COMMIT
			* 작업그룹에 포함된 모든 데이터 변경 내용을 영구적으로 데이터베이스 저장한다.
			* 현재 트랜잭션을 종료한다.
			* 새로운 트랜잭션을 시작한다.
		- SAVEPOINT name
			* 현재 트랜잭션 내에 저장지점을 표시한다.
		- ROLLBACK
			* 작업그룹에 포함된 모든 데이터 변경 내용을 버린다.
			* 현재 트랜잭션을 종료한다.
			* 새로운 트랜잭션을 시작한다.
		- ROLLBACK TO SAVEPOINT name
			* 현재 트랜잭션에 지정된 저장지점으로 롤백한다.
			* 저장지점 이후에 작업그룹에 포함된 모든 데이터 변경내용 및 저장지점을 버린다.
	- 트랜잭션 제어 명령어와 관련된 데이터 상태
		- COMMIT/ROLLBACK 실행 이전의 데이터 상태
			* 데이터를 이전 상태로 되돌릴 수 있다.
			* 현재 사용자는 SELECT문을 사용해서 DML 작업 결과를 확인할 수 있다.
			* 다른 사용자는 DML의 작업 결과를 확인할 수 없다.
			* 현재 사용자가 작업 중인 행들을 잠금처리하기 때문에 다른 사용자는 그 행의 데이터를 변경할 수 없다.
		- COMMIT 실행 후
			* 데이터 변경 내용이 데이터베이스 영구적으로 저장된다.
			* 모든 사용자가 변경내용을 조회할 수 있다.
			* 행 잠금이 해제되어 다른 사용자가 행을 조작할 수 있다.
		- ROLLBACK 실행 후
			* 데이터 변경 내용이 전부 취소된다.
			* 데이터가 이전 상태로 복구된다.
			* 행 잠금이 해제된다.
- 오라클의 주요 데이터베이스 객체
	* 데이터베이스 객체는 오라클이 제공하는 여러 유형의 데이터구조를 말한다.
	- 테이블
		* 데이터베이스의 기본 데이터 저장단위다.
		* 행과 열로 구분되어 있다.
	- 뷰
		* 가상의 테이블이다.
		* 하나 이상의 테이블의 데이터로 구성된 가상의 테이블이다.
	- 시퀀스
		* 일련번호 생성기다.
	- 인덱스
		* 데이터 조회 성능을 향상시켜준다.
		* 테이블의 데이터에 대한 색인을 가지고 있다.
	- 동의어
		* 데이터베이스 객체에 대한 다른 이름을 제공한다.
- 테이블 생성 및 관리
	- 테이블 생성
	  create table [schema.]테이블명 (
		컬럼명 데이터타입 [default 기본값],
		컬럼명 데이터타입 [default 기본값], 
		...
	  );
	- 오라클 데이터 타입
		* VARCHAR2(size)
			- 가변길이 문자 데이터
			- size: 1 ~ 4000
			- 사람이름, 주소, 이메일, 상품이름, 제목, 회사명, ...
		* CHAR(size)
			- 고정길이 문자 데이터
			- size: 1 ~ 2000
			- 학번, 주민번호, 우편번호, 신용카드번호, ...
		* NUMBER(p, s)
			- 숫자 데이터
			- p는 총 숫자 갯수
			- s는 소숫점 이하 숫자 갯수
		* DATE
			- 날짜 및 시간 데이터
		* CLOB(Character Large OBject)
			- 대용량 가변길이 문자 데이터
			- 최대길이 4GB
			- 블로그의 글, 신문기사, 책의 내용, 나무위키의 글, ...
		* TIMESTAMP
			- 날짜 및 시간 데이터, 소숫점이하 초단위 값까지 저장
		* LONG
			- 가변길이 문자 데이터
			- 최대길이 2GB
			- 단점
			  * 테이블당 하나만 사용할 수 있다.
			  * 제약조건을 정의할 수 없다.
			  * group by 또는 order by 절에 포함시킬 수 없다.		
		* BLOB(Binary Large OBject)
			- 바이너리(이진) 데이터
			- 최대길이 4GB
			- 사진, 동영상, 파일, ...
		* ROWID
			- 테이블에서 행(row)의 고유주소를 나타내는 64진수 숫자 데이터
			- ROWID는 오브젝트번호 + 상대파일번호 + 블록번호 + 데이터번호로 구성되어 있다.
			- 예) 
			    AAAE64AAEAAAAFsAAA
			    오브젝트번호: AAAE64 
			    상대파일번호: AAE 
			    블록번호    : AAAAFs 
			    데이터번호  : AAA
	- 테이블의 이름 변경학
		RENAME 이전테이블명 TO 새테이블명;
	- ALTER TABLE의 이용할 컬럼 추가/수정/삭제하기
		- 컬럼추가
			ALTER TABLE 테이블명
			ADD (컬럼명 데이터타입 [DEFAULT 값]);
			* 컬럼명으로 지정한 새로운 컬럼이 추가된다.
		- 컬럼수정
			ALTER TABLE 테이블명
			MODIFY (컬럼명 데이터타입 [DEFAULT 값]);
			* 컬럼명으로 지정한 컬럼의 데이터타입, 길이, 기본값 등을 변경할 수 있다.
			* 기존에 저장된 데이터가 변경하려는 데이터타입과 맞지않거나,
                          기존에 저장된 데이터의 길이보다 컬럼의 사이즈를 짧게 변경하는 경우 에러가 발생한다.
		- 컬럼삭제
			ALTER TABLE 테이블명
			DROP 컬럼명;
			* 삭제된 컬럼은 복구할 수 없다.
	- 테이블 삭제하기
		DROP TABLE 테이블명
		* 삭제된 테이블은 복구할 수 없다.
		* 테이블의 모든 구조 및 데이터가 삭제됨.
		* 테이블의 모든 인덱스(색인)가 삭제됨
	- 테이블 절단하기
		TRUNCATE TABLE 테이블명;
		* 테이블의 모든 행을 제거한다.
		* 해당 테이블이 사용하던 저장공간을 해제시킨다.
		* TRUNCATE를 사용한 행 제거작업은 복구할 수 없다.
- 무결성제약조건
	- 테이블에 유효하지 않은 데이터가 입력되는 것을 방지하기 위해서 정의하는 것이다.
	  * 테이블에 새로운 행이 추가될 때, 행의 값이 변경될 때, 행이 삭제될 때 마다 정의된 제약조건을 위배하지 않는지 검사한다.
	- 무결성 제약조건의 종류
		----------------------------------------------------------------------------------------
		제약조건		설명		
		----------------------------------------------------------------------------------------
		NOT NULL		지정된 컬럼이 NULL값을 포함하지 못하도록 한다.
					예) 사용자명, 비밀번호, 배송지주소 등
		----------------------------------------------------------------------------------------
		UNIQUE			지정된 컬럼은 테이블의 모든 행에서 고유한 값을 가져야 한다.
					NULL값이 대입될 수는 있다.
					예) 주민번호, 이메일, 사용자아이디 등
		----------------------------------------------------------------------------------------
		PRIMARY KEY		지정된 컬럼은 테이블의 각 행을 고유하게 식별할 수 있어야 한다.
					지정된 컬럼은 고유한 값을 가져야 되고, NULL값을 포함할 수 없다
					테이블에서 행을 대표하는 컬럼에 PRIMARY KEY 제약조건을 정의함
					보통 일련번호 발생기로부터 획득한 값을 사용한다.
					예) 학번, 사원번호, 부서번호 등
		----------------------------------------------------------------------------------------
		FOREIGN KEY		지정된 컬럼은 참조된 테이블의 컬럼과 외래키 관계를 설정한다.
					지정된 컬럼에 입력되는 값은 참조된 테이블의 컬럼에 존재하는 
					값만 유효한 값으로 인정된다.
					예) 
					직원테이블의 부서아이디는 부서테이블의 부서아이디를 참조한다.
					직원테이블의 직종아이디는 직종테이블의 직종아이디를 참조한다.
					부서테이블의 관리자아이디는 직원테이블의 직원아이디를 참조한다.
					직원테이블의 매니저아이디는 직원테이블의 직원아이디를 참조한다.
		----------------------------------------------------------------------------------------
		CHECK			지정된 컬럼은 제시된 조건식이 true로 판정되는 값만 입력된다.
					예)
					성적은 0.0 ~ 4.5사이의 값만 입력되어야 한다.
					합격여부는 '합격', '불합격' 둘 중 하나만 입력되어야 한다.
					성별은 '남', '여' 둘 중 하나만 입력되어야 한다.
					가격은 0보다 큰 값만 입력되어야 한다.
					생일은 오늘보다 이전 날짜의 값만 입력되어야 한다.
		----------------------------------------------------------------------------------------
	- 제약조건 정의하기
		- 컬럼제약조건 레벨
			create table 테이블명 (
				컬럼명 데이터타입 [default 값] [컬럼제약조건],
				컬럼명 데이터타입 [default 값] [컬럼제약조건],
				...
			)
			* 하나의 컬럼에 대해서 제약조건을 지정한다.
			* NOT NULL 제약조건은 컬럼제약조건으로만 지정할 수 있다.
			* 컬럼제약조건
				컬럼명 데이터타입 [CONSTRAINT 제약조건별칭] 제약조건
				* 제약조건별칭은 생략할 수 있다.
		- 테이블제약조건 레벨
			crate table 테이블명 (
				컬럼명 데이터타입 [default 값],
				컬럼명 데이터타입 [default 값],
				...,
				[테이블제약조건]
			)
			* 하나 이상의 컬럼에 대해서 제약조건을 지정할 수 있다.
			* NOT NULL 제약조건을 제외한 모든 제약조건을 지정할 수 있다.
			* 테이블제약조건
				[CONSTRAINT 제약조건별칭] 제약조건 (컬럼명, ...)
		- 제약조건 정의하기
			* NOT NULL 제약조건
			  create table users (
				username varchar2(100)                       NOT NULL, 
				userpwd varchar2(100) CONSTRAINT user_pwd_nn NOT NULL,
				...
			  )
			  * 컬럼제약조건 레벨로만 정의할 수 있다.
			* UNIQUE 제약조건
			  create table users (
				userid    varchar2(100)                          UNIQUE,
				useremail varchar2(256) CONSTRAINT user_email_uk UNIQUE,
			  )
			  create table users (
				userid    varchar2(100),
				useremail varchar2(256),
				UNIQUE (userid),
				CONSTRAINT user_email_uk UNIQUE (useremail)
			  )
                          * UNIQUE 제약조건은 테이블 전체 행에서 해당 컬럼의 값에 중복된 값을 허용하지 않는다.
			  * UNIQUE 제약조건만 지정된 컬럼의 경우 NULL값이 입력되는 것은 상관없다.
			* PRIMARY KEY 제약조건
			  create table users (
				user_no number(10)                       PRIMARY KEY,
				user_no number(10) CONSTRAINT user_no_pk PRIMARY KEY,
			  )
			  create table users (
				user_no number(10),
				PRIMARY KEY (user_no),
				CONSTRAINT user_no_pk PRIMARY KEY (user_no)
			  )
			  * PRIMARY KEY 제약조건은 테이블당 하나만 가능하다.
                          * 두 개 이상의 컬럼을 조합해서 PRIMARY KEY 제약조건을 지정할 수도 있다.
			* FOREIGN KEY 제약조건
			  create table orders (
				user_no number(10)                            REFERENCES users (user_no),
				book_no number(10) CONSTRAINT order_bookno_fk REFERENCES books (book_no),
			  )
			  create table orders (
				user_no2 number(10) ,
				book_no2 number(10) ,
				FOREIGN KEY (user_no2) REFERENCES users (user_no),
				CONSTRAINT orders_bookno_fk FOREGIN KEY(book_no2)
					REFERENCES books (book_no)
			  )
			  * 외래키 user_no2의 값은 users테이블의 user_no 컬럼을 참조한다.
			  * 외래키 book_no2의 값은 books테이블의 book_no 컬럼을 참조한다.
			  * 외래키가 참조하는 컬럼은 반드시 PRIMARY KEY, UNIQUE 제약조건이 지정된 컬럼이어야 한다.
			* CHECK 제약조건
			  create table products (
				price number(7,0)                             CHECK (price >= 0),
			        sold_out char(1)                              CHECK (sold_out in ('Y', 'N')),
				stock number(5,0) CONSTRAINT product_stock_cc CHECK (stock >=0)
			  )
			  * 가격은 0원 이상만 입력할 수 있다.
			  * 절판여부는 'Y', 'N' 중에 하나만 입력할 수 있다.
			  * 재고는 0개 이상만 입력할 수 있다.
			  create table course_registrations (
				period    char(6),	-- 202001, 201902
				student_no number(6,0),
				course_no number(6,0),
				score char(1),
				CONSTRAINT course_reg_uk UNIQUE (period, student_no, course_no),
				CONSTRAINT course_score_cc CHECK (score in ('A', 'B', 'C', 'D', 'F'))
			  )
			  * 학기, 학번, 과정번호가 동일한 행은 존재할 수 없다.
			  * 학점은 'A', 'B', 'C', 'D', 'F' 값들만 허용된다.
- 뷰의 생성 및 이용
	- 뷰는 하나 이상의 테이블을 이용해서 만든 가상의 테이블이다.
	- 물리적인 저장공간을 사용하지 않는다.
	- 목적
		* 복잡한 SQL 구문을 쉽게 작성하기 위해
		* 동일한 데이터로부터 다양한 결과를 얻기 위해
		* 데이터의 엑세스를 제한하기 위해
	- 뷰의 생성
	  CREATE OR REPLACE VIEW 뷰이름 
	  AS SELECT 컬럼, 컬럼, 컬럼
             FROM 테이블명
	     [WHERE 조건식]
	     [GROUP BY 컬럼]
	     [HAVING 조건식]
	  [WITH READ ONLY]
	  * WITH READ ONLY 옵션이 지정된 뷰는 DML(INSERT, UPDATE, DELETE)작업을 수행할 수 없다.
	  예) 
	     부서아이디와 부서별사원수를 포함하고 있는 가상의 테이블
	     create or replace view dept_emp_count_view
	     as select department_id, count(*)
                from employees
                where department_id is not null 
                group by department_id;

	     사원아이디, 이름, 급여, 연봉을 포함하고 있는 가상의 테이블
	     create or replace view emp_salary_view
	     as select employee_id, first_name, salary, 
                       salary*4*12 + salary*nvl(commission_pct, 0)*4*12 annual_salary
                from employees;

	     사원아이디, 이름, 급여, 급여등급을 포함하고 있는 가상의 테이블
	     create or replace view emp_salary_grade_view
	     as select A.employee_id, A.first_name, A.salary, B.gra 
                from employees A, job_grades B
		where A.salary >= B.lowest_sal and A.salary <= B.highest_sal;
	- 뷰의 삭제
	  DROP VIEW 뷰이름;
- 인라인 뷰
	- SQL문 안에서 정의된 뷰다.
	- SELECT문의 FROM 절에 정의된 서브쿼리를 인라인 뷰라고 부른다.
	- 인라인뷰는 SQL문이 실행되는 동안만 존재하고, 즉시 사라져버린다.
	- 인라인 뷰 작성하기
	  SELECT 컬럼명, 컬럼명, ...
	  FROM (SELECT 컬럼명, 컬럼명, ...
                FROM 테이블명) A, 테이블명 B
	  WHERE A.컬럼명 = B.컬럼명
	  * FROM 절에 정의된 서브쿼리의 실행결과를 가상의 테이블로 취급한다.
 	  * 테이블의 데이터를 가공해서 조회한 것(SELECT 문, 인라인뷰, 가상의 테이블)과 
            다른 테이블을 조인해야 되는 경우 많이 사용한다.
	- 예)
		전체 직원 중에서 자신이 소속된 부서의 평균급여보다 급여를 적게 받는 사원의 
		사원 아이디, 이름, 급여, 부서아이디, 부서의 평균급여를 조회하기
		select A.employee_id, A.first_name, A.salary, B.deptid, B.avg_salary
		from employees A, (select department_id         deptid
                          		, trunc(avg(salary))  avg_salary
                   		   from employees 
                                   where department_id is not null 
                                   group by department_id) B
		where A.department_id = B.deptid
		and A.salary < B.avg_salary
		order by A.employee_id asc;

		부서아이디, 부서명, 부서별 사원수, 도시명을 출력하기
		select A.department_id, A.department_name, B.city, C.cnt
		from departments A, locations B, (select department_id dept_id, count(*) cnt
                                  		  from employees 
                                  		  group by department_id) C
		where A.location_id = B.location_id
		and A.department_id = C.dept_id
		order by A.department_id asc;
	- Top-N 분석
		- Top-N 분석 SQL문은 테이블에서 조건에 맞는 
                  최상위 레코드 n개 또는 최하위 레코드 n개를 조회하는 시나리오에 유용하다.
		  예) 회사의 최상위 소득자 3명, 가장 최근에 입사한 신입사원 4명, 
		      최근 6개월동안 가장 많이 팔린 제품 3가지, 가장 평점이 높은 상품 10개
		- Top-N 분석 SQL문
		  select ROWNUM, 컬럼명, 컬럼명, ...
		  from (select 컬럼명, 컬럼명, ...
                        from 테이블명
			[where 조건식]
			order by Top-N분석컬럼)
		  where ROWNUM <= N;
		  * ROWNUM : 조회된 순서대로 순번을 부여하는 오라클의 키워드다.
	- 분석함수 사용하기
		- ROW_NUMBER() OVER([partition by 컬럼명] order by 컬럼명 [asc|desc])
			순번을 부여한다.
			* 특정 컬럼의 값을 기준으로 범위별로 나눠서 조회할 때 주로 사용된다.
		- RANK()       OVER([partition by 컬럼명] order by 컬럼명 [asc|desc])
			랭킹을 부여한다.
		- DENSE_RANK() OVER([partition by 컬럼명] order by 컬럼명 [asc|desc])
			랭킹을 부여한다.
		- 분석함수 SQL 문
		select 컬럼명, 컬럼명, ...
		from (select ROW_NUMBER() OVER(order by 컬럼명) 별칭, 컬럼명, 컬럼명, ...
                      from 테이블명
		      [where 조건식])
		[where 별칭을 이용하는 조건식]
- 시퀀스
	- 고유번호(일련번호)를 생성하는 데이터베이스 객체다.
      	  * 고유번호를 자동으로 생성한다.
	  * 테이블의 기본 키 값으로 사용된다.
	  * 여러 사용자가 공유할 수 있다.
	- 시퀀스 생성
		CREATE SEQUENCE 시퀀스명
			[START WITH n]				-- 기본값 1
			[INCREMENT BY n]			-- 기본값 1
			[{MAXVALUE n | NOMAXVALUE}]		-- 기본값 NOMAXVALUE
			[{MINVALUE n | NOMINVALUE}]		-- 기본값 NOMINVALUE
			[{CYCLE | NOCYCLE}]			-- 기본값 NOCYCLE
			[{CACHE n | NOCACHE}]			-- 기본값 CACHE 20
		* 아래의 옵션을 설정하지 않으면, 1씩 증가, 1부터 시작, 캐시를 사용
	- 주요 함수
		nextval
			새로운 일련번호를 반환한다.
		currval
			현재 시퀀스의 일련번호값을 반환한다.
			currval을 실행하려면 해당 시퀀스에 대해서 nextval이 실행되어야 한다.
	- 시퀀스 삭제
		DROP SEQUENCE 시퀀스명;
	- 시퀀스 수정
		ALTER SEQUENCE 시퀀스명
			[INCREMENT BY n]
			[{MAXVALUE n | NOMAXVALUE}]
			[{MINVALUE n | NOMINVALUE}]
			[{CYCLE | NOCYCLE}]
			[{CACHE n | NOCACHE}]
		* START WITH n 값은 수정할 수 없다.
		* 시퀀스를 다른 번호로 다시 시작하려면 시퀀스를 삭제한 후 다시 생성해야 한다.	
- 인덱스
	- SQL문의 검색 속도를 향상시키기 위해서 사용한다.
	- ROWID를 사용하여 데이터의 위치를 빠르게 찾을 수 있기 때문에 디스크 I/O를 줄일 수 있다.
	- 인덱스의 생성
		CREATE INDEX 인덱스명
		ON 테이블명 (컬럼명, ...);
		
		CREATE INDEX 인덱스명
		ON 테이블명 (연산식);
	- 인덱스의 생성 방법에 따른 구분
		* 자동 : 테이블 생성시 PRIMARY KEY 또는 UNIQUE 제약조건을 정의하면 
                         해당 컬럼에 대해서 인덱스가 자동으로 생성된다. 
		* 수동 : CREATE INDEX 명령문을 사용해서 인덱스를 생성하는 것
	- 인덱스 생성이 필요한 경우
		* WHERE 절 또는 조인 조건에서 해당 컬럼이 자주 사용되는 경우
		* 컬럼에 다양한 값이 포함된 경우(사람의 이름, 이메일, 전화번호 ..)
		* 컬럼에 NULL값이 많이 포함된 경우
		* 큰 테이블에서 실행되는 대부분의 SQL문에 대해서 2%내외의 행이 검색되는 경우

- 사용자 엑세스 관리
	- 데이터베이스는 다중 사용자 환경이다.
	- 데이터베이스 엑세스 및 사용에 대한 보안 유지가 필요하다.
		* 데이터베이스 엑세스 제어
		* 데이터베이스 특정 객체에 대한 엑세스 제어
	- 권한
		* 특정 SQL문을 실행할 수 있는 권리
		* 데이터베이스 관리자는 사용자에게 데이터베이스 및 데이터베이스 객체에 대한 엑세스권한 부여할 수 있다.
		* 데이터베이스 객체의 주인은 다른 사용자가 데이터베이스 객체의 내용을 조작할 수 있는 권한을 부여할 수 있다.
		* 권한의 종류
			- 시스템 권한: 데이터베이스를 엑세스할 수 있는 권한
			- 객체 권한: 데이터베이스 객체의 내용을 조작할 수 있는 권한
	- 롤
		* 사용자에게 부여할 수 있는 관련 권한을 하나로 묶어 그룹화한 것
		* 롤을 사용하면 권한의 부여 및 박탈 등 유지관리가 쉬워진다.
		* 대표적인 롤
			- connect 롤
				데이터베이스에 연결할 수 있는 권한
				create session
			- resource 롤
				일반사용자에게 부여되는 관련 시스템권한의 묶음
				create table, create sequence, create view, ...
			- dba 롤
				데이터베이스 관리자에게 부여되는 관련 시스템권한의 묶음
				create user, drop user, grant, revoke, ...
	- 사용자 생성
		* 데이터베이스 관리자는 새로운 사용자를 생성할 수 있다.
		* CREATE USER 사용자명 IDENTIFIED BY 비밀번호;
	- 사용자에게 시스템 권한 부여하기
		* 데이터베이스 관리자는 사용자에게 시스템 권한을 부여할 수 있다.
		* GRANT 시스템권한, 시스템권한, 시스템권한, ...
                  TO 사용자명;
		* GRANT 롤, 롤, ...
		  TO 사용자명;
	- 사용자에게 부여된 시스템권한 박탈하기
		* 데이터베이스 관리자는 사용자가 가진 시스템 권한을 박탈할 수 있다.
		* REVOKE 시스템권한, 시스템권한, 시스템권한, ...
	  	  FROM 사용자명;
		* REVOKE 롤, 롤, ...
		  FROM 사용자명;
- 객체 권한 관리	
	- 소유자는 객체에 대한 모든 권한을 갖는다.
	- 소유자는 자신의 객체에 대한 특정 권한을 다른 사용자에게 부여할 수 있다.
	- 데이터베이스 객체마다 다른 객체권한을 가지고 있다.
	- 객체권한의 종류
		-----------------------------------------------------------------
		객체권한	테이블		뷰	시퀀스		프로시저
		-----------------------------------------------------------------
		SELECT		O		O	O	
		-----------------------------------------------------------------		
		INSERT		O		O
		-----------------------------------------------------------------
		UPDATE		O		O
		-----------------------------------------------------------------
		DELETE		O		O
		-----------------------------------------------------------------
		ALTER		O			O
		-----------------------------------------------------------------
		REFERENCES	O		O
		-----------------------------------------------------------------
		EXECUTE							O
		-----------------------------------------------------------------
	- 다른 사용자에게 객체권한 부여하기
		* GRANT 객체권한, 객체권한, 객체권한, ...
		  ON    객체명
		  TO    사용자명, 사용자명;
		* GRANT 객체권한, 객체권한, ...
		  ON    객체명
		  TO    PUBLIC;
		  * 모든 사용자에게 엑세스 권한을 부여할 때 PUBLIC 키워드를 사용한다.
		* GRANT 객체권한, 객체권한, ...
		  ON    객체명
		  TO    사용자명, ...
	          WITH  GRANT OPTION; 
		  * 객체 권한을 부여받은 사용자에게 객체권한을 부여할 수 있는 권한을 제공한다.
	- 부여된 객체권한 취소하기
		* REVOKE 객체권한, 객체권한, ...
		  ON     객체명
                  FROM   사용자명;

- 데이터베이스 사전테이블(Dictionary 테이블, 데이터사전)
	* 데이터베이스 시스템이 데이터베이스 객체, 사용자, 제약조건 등의 정보를 보관하는 테이블
	* 주요  사전테이블(데이터사전)
		- USER_TABLES		: 사용자가 생성한 모든 테이블 객체 정보
		- USER_VIEWS		: 사용자가 생성한 모든 뷰 객체 정보
		- USER_SEQUENCES	: 사용자가 생성한 모든 시퀀스 객체 정보
		- USER_CONSTRAINTS	: 사용자가 정의한 모든 제약조건 정보
		- USER_INDEXES		: 사용자가 생성한 모든 색인 객체 정보
		- USER_SYNONYMS		: 사용자가 생성한 모든 동의어 객체 정보
		- USER_USERS		: 사용자의 정보
- 집합 연산자
	* 두 개 이상의 SELECT문의 조회 결과를 하나로 결합시킨다.
	* 종류
		- SQL1  UNION      SQL2
			SQL1과 SQL2의 조회 결과를 중복을 제거한 후 반환한다.
			첫번째 컬럼에 조회결과가 오름차순 정렬된다.
		- SQL1  UNION ALL  SQL2
			SQL1과 SQL2의 조회 결과를 중복을 포함하여 반환한다.
		- SQL1  INTERSECT  SQL2
			SQL1과 SQL2의 조회결과에 공통으로 포함된 행만 반환한다.
		- SQL1  MINUS      SQL2
			SQL1의 조회결과에서 SQL1의 조회결과를 제외한 행만 반환한다.
	* 집합 연산자 사용시 지침
		- SQL1과 SQL2의 컬럼 갯수가 동일해야 한다.
		- SQL1과 SQL2의 각각의 컬럼별 데이터타입이 동일해야 한다.
		- SQL1과 SQL2의 컬럼의 이름은 같지 않아도 상관없다.
		- UNION, UNION ALL, INTERSECT는 SQL1과 SQL2의 순서가 달라져도 결과가 동일하다.

- 고급 서브쿼리
	- 다중 열 서브쿼리
		* 서브쿼리가 여러 행 및 여러 열을 반환한다.
		* select column1, column2, ...
                  from table
                  where (column, column) in (select column, column
                                             from table
			                     where 조건식)
		* 연산자는 in을 사용한다.
	- 스칼라 서브쿼리
		* 스칼라 서버쿼리는 1행 1열의 값만 반환한다.
		* 스칼라 서버쿼리를 실행하면 값 하나가 획득된다.
		* 사용가능한 곳
			select절, from절, where절에서 연산자의 왼쪽,
			insert문의 values절, update문의 set절,
			case와 decode의 조건식 및 표현식
		* 사용예)
		  -- 사원아이디, 이름, 급여, 평균급여와의 차이를 조회하기
		  select employee_id, first_name, salary,
                         (select avg(salary) from employees) - salary gap
                  from employees;
		  -- 부서아이디, 부서명, 해당부서의 사원수를 조회하기
		  select outter.department_id, outter.department_name,
                        (select count(*)
                         from employees inner 
                         where inner.department_id = outter.department_id) cnt
                  from departments outter;

	- 상호관련 서브쿼리
		* 조회된 행의 단위로 서브쿼리가 사용된다.
		* 서브쿼리가 외부 쿼리의 모든 행에 대해서 한번씩 실행된다.
		* select column, column, ...
	          from table1 OUTER
		  where column 연산자 (select column
                                       from table2 INNER
				       where INNER.column = OUTER.column);
		* 사용예
		  -- 소속부서의 평균급여보다 급여를 많이 받는 사원의 이름, 급여를 조회하기
		  select outter.first_name, outter.salary
		  from employees outter
      		  where outter.salary  > (select avg(inner.salary)
                        		  from employees inner
                                          where inner.department_id = outter.department_id);
		  -- 외부 SQL이 실행되어서 행을 가져온다.(후보행)
		  -- 후보행의 행마다 outter.department_id값을 가져와서 서브쿼리를 실행한다.
		  -- 서브쿼리의 결과값을 사용해서 후보행을 검증한다.
		  -- 검증을 통과한 행만 최종 결과로 출력된다
	- exists
		* 서브쿼리 실행결과 조회된 행이 있는지 여부를 확인하는 연산자다.
		* 서브쿼리 실행 중 조건을 만족하는 행이 존재하면 즉시 true를 반환하고, 검색을 중단한다.
		* 사용예
		  -- 부하직원이 있는 직원 조회하기
		  select *
                  from employees 상사
                  where exists (select 1 
                                from employees 부하
                                where 부하.manager_id = 상사.employee_id); 
		  * 서브쿼리에서는 값을 조회하는 것이 목적이 아니기 때문에 보통 상수값을 적는다.
		  * exists 연산자는 서브쿼리에서 행이 검색되면 true값을 반환한다.

- 계층 검색
	* 자료트리 구조의 가지는 데이터들 사이에 존재하는 관계를 찾아서 계층을 만들고, 
          부모->자손, 자손->부모 방향으로 데이터를 조회하는 것
	* select [level], column, column, ...
	  from table
	  [where 조건식]
	  [start with 조건식]
          [connect by prior 조건식]
	  * level : 계층 검색에서 제공하는 컬럼, 각 행에 대해서 어느 계층에 속하는지를 숫자값으로 반환
	  * start with : 계층 검색의 시작점을 지정한다.
          	start with employee_id = 100
	  * connect by prior : 부모-자식관계에 있는 컬럼을 지정한다.
          	connect by prior 부모키 = 자식키 : 위에서 아래로 검색
		connect by prior 자식키 = 부모키 : 아래에서 위로 검색

- 절차형 SQL
	* PL/SQL(Procedural Language extension to SQL)
		- SQL도 다른 프로그래밍 언어처럼 절차지향적 프로그램을 작성할 수 있다.
		- 특징
			* DBMS 내부에서 실행된다.
			* BEGIN/END의 블록구조로 프로그램을 모듈화할 수 있다.
			* 조건문, 반복문 등을 사용해서 연속적인 SQL 작업을 수행할 수 있다.
	* 프로시저(Prodecure)
		- 특정 작업을 수행하는, 이름을 가진 PL/SQL 블록이다.
		- 매개변수를 받을 수 있고, 재사용할 수 있는 PL/SQL 블록이다.
		- 보통 연속적인 작업 혹은 실행단계가 복잡한 트랜잭션(SQL작업)을 수행하기 위해서 생성한다.
	* 함수(Function)
		- 프로시저와 동일하게 절차형 SQL을 활용하여 일련의 SQL 작업을 처리하고,
                  그 처리결과를 단일값으로 반환할 수 있는 절차형 SQL이다 
	* 트리거(Trigger)
		- 특정 테이블에 데이터의 추가, 수정, 삭제 등의 데이터변경 이벤트가 발생하면
                  DBMS에서 자동으로 실행되도록 구현된 프로그램을 말한다.

- 프로시저
	* 문법
	  CREATE OR REPLACE PROCEDURE 프로시저명
	  (변수명 IN 데이터타입,
	   변수명 OUT 데이터타입, ...)
	  IS
		--변수 선언
		변수명 데이터타입;
		변수명 데이터타입 := 값;
	  BEGIN
		SQL 문자, PL/SQL 제어문장	
		...
	  END;
	* 실행하기
	  EXECUTE 프로시저명(값, 값);
	* 작성예
	-----------------------------------------------------------------------------------------------
	// 사원 아이디를 전달받아서 사원의 급여를 인상시킨다.
	CREATE OR REPLACE PROCEDURE update_salary
	(i_emp_id IN number) 
	IS
    	-- 변수 정의한다.
    	-- 변수      변수의 데이터타입
    	--           employees의 salary 컬럼의 데이터타입과 동일한 데이터타입으로 변수 선언
    	v_emp_salary employees.salary%type; -- 사원의 급여
    	v_update_rate number(3, 2);          -- 급여 인상률

	BEGIN
    	-- SQL 문장, PL/SQL 구문을 작성

    	-- 전달받은 직원아이디에 해당하는 직원의 급여를 조회한다.
    	-- 조회된 직원의 급여를 위해서 선언한 v_emp_salary에 대입한다.
   	SELECT SALARY 
    	INTO v_emp_salary
    	FROM EMPLOYEES
    	WHERE EMPLOYEE_ID = i_emp_id;

    	-- 직원의 급여에 따라서 인상률을 결정하기
    	-- 20000달러 이상 10%, 10000달러 이상 15%, 그외 20% 인상
    	IF v_emp_salary >= 20000 THEN v_update_rate := 0.1;
    	ELSIF v_emp_salary >= 10000 THEN v_update_rate := 0.15;
    	ELSE v_update_rate := 0.2;
    	END IF;

    	-- 급여를 인상시키기
    	UPDATE EMPLOYEES 
    	SET
        	SALARY = SALARY + TRUNC(SALARY*v_update_rate)
    	WHERE
        	EMPLOYEE_ID = i_emp_id;

    	-- DB에 영구적으로 반영시키기
    	COMMIT;

	END;
	-----------------------------------------------------------------------------------------------
- 함수
	* 문법
	CREATE OR REPLACE FUNCTION 함수명
	(변수명 IN 데이터타입,
         변수명 IN 데이터타입, ...)
	
	-- 함수가 반환하는 값의 타입을 지정한다.
	RETURN 데이터타입

	IS
		변수명 데이터타입;
	BEGIN
		PL/SQL 블록
		-- 리턴문이 반드시 존재해야 한다.
		RETURN 변수;
	END;
	* 작성예
	-----------------------------------------------------------------------------------------------
	// 부서아이디를 전달받아서 부서에 소속된 사원수를 반환한다.
	CREATE OR REPLACE FUNCTION GET_EMP_COUNT
	(i_dept_id IN NUMBER)

    	RETURN NUMBER
	IS
    	v_emp_count NUMBER(3, 0);
	BEGIN
    	SELECT COUNT(*)
    	INTO v_emp_count 
    	FROM EMPLOYEES 
    	WHERE DEPARTMENT_ID = i_dept_id;

    	RETURN v_emp_count;
	END;
	-----------------------------------------------------------------------------------------------
	// 사원 아이디를 전달받아서 연봉을 반환한다.
	CREATE OR REPLACE FUNCTION GET_ANNUAL_SALARY
    	(i_emp_id IN NUMBER)    -- 직원아이디를 매개변수로 전달받는다.
    	RETURN NUMBER           -- 이 함수의 반환값은 숫자값이다.
    
    	IS
       		v_salary         employees.salary%type;             -- 급여
        	v_comm           employees.commission_pct%type;     -- 커미션
        	v_annual_salary  employees.salary%type;             -- 연봉

    	BEGIN
        	-- 직원아이디에 해당하는 직원의 급여와 커미션을 조회해서 v_salary와 v_comm에 저장한다.
        	SELECT SALARY, NVL(COMMISSION_PCT, 0)
        	INTO v_salary, v_comm
        	FROM EMPLOYEES 
        	WHERE EMPLOYEE_ID = i_emp_id;

        	-- 커미션이 반영된 연봉을 계산해서 변수에 대입한다.
        	v_annual_salary := v_salary*12 + trunc(v_salary*v_comm)*12;

        	-- 변수에 저장된 값을 반환한다.
        	return v_annual_salary;
    	END;
	-----------------------------------------------------------------------------------------------
	// 총연봉을 반환한다, 커서 사용
	CREATE OR REPLACE FUNCTION GET_TOTAL_ANNUAL_SALARY
	RETURN NUMBER

	IS
    	v_total_salary      number := 0;
    	v_salary            employees.salary%type;
    	v_comm              employees.commission_pct%type;
    	v_annual_salary     employees.salary%type;

    	-- 커서 선언
    	CURSOR emp_list IS
    	SELECT SALARY, NVL(COMMISSION_PCT, 0) COMM
    	FROM EMPLOYEES;

	BEGIN
    	-- 커서를 FOR문에서 실행시킨다.
    	-- FOR 변수명 IN 커서명 LOOP
    	--    수행문;
    	-- END LOOP;
    	FOR emp IN emp_list LOOP
        	v_salary        := emp.salary;
        	v_comm          := emp.comm;
        	v_annual_salary := v_salary*12 + trunc(v_salary*v_comm)*12;
        	v_total_salary  := v_total_salary + v_annual_salary;
    	END LOOP;

    	RETURN v_total_salary;
	END;
	-----------------------------------------------------------------------------------------------
	// 전달받은 부서아이디에 해당하는 부서의 총 연봉을 반환한다. 파라미터가 필요한 커서 사용
	CREATE OR REPLACE FUNCTION GET_DEPT_TOTAL_SALARY
    	(i_dept_id IN NUMBER) 
    
    	RETURN NUMBER
    
    	IS
       		v_salary          employees.salary%type;
        	v_comm            employees.commission_pct%type;
        	v_annual_salary   employees.salary%type;
        	v_total_salary    NUMBER := 0;

        	-- 파라미터가 필요한 커서
        	-- 커서 실행에 필요한 파라미터를 정의한다.
        	CURSOR emp_list(param_dept_id NUMBER) IS
        	SELECT SALARY, NVL(COMMISSION_PCT, 0) COMM
        	FROM EMPLOYEES
        	WHERE DEPARTMENT_ID = param_dept_id;    

    	BEGIN
        	-- FOR문을 사용해서 파라미터가 있는 커서 실행하기
        	FOR emp IN emp_list(i_dept_id) LOOP
            	v_salary        := emp.salary;
            	v_comm          := emp.comm;
            	v_annual_salary := v_salary*12 + trunc(v_salary*v_comm)*12;
            	v_total_salary  := v_total_salary + v_annual_salary;
        	END LOOP;

        	RETURN v_total_salary;

    	END;
	-----------------------------------------------------------------------------------------------
- 트리거
	* 문법
	CREATE OR REPLACE TRIGGER 트리거명
	BEFORE | AFTER 				-- BEFORE나 AFTER 중 하나를 사용한다.
	INSERT | UPDATE | DELETE ON 테이블명	-- INSERT나 UPDATE나 DELETE 중 하나를 사용한다.
	FOR EACH ROW
	BEGIN
		PL/SQL 구문
	END;
	* 사용
	-----------------------------------------------------------------------------------------------
	// 추천정보가 저장될 때마다 sample_books의 book_likes를 증가시킨다.
	create or replace TRIGGER INCREASE_BOOK_LIKES_TRIGGER 
    	AFTER
   	INSERT ON SAMPLE_BOOK_LIKES
    	FOR EACH ROW
    	BEGIN

        	UPDATE SAMPLE_BOOKS
        	SET
            	BOOK_LIKES = BOOK_LIKES + 1
        	WHERE
            	BOOK_NO = :NEW.BOOK_NO;
    	END;
	-----------------------------------------------------------------------------------------------
	// 주문정보가 저장될 때 마다 sample_book_users의 user_point를 증가시킨다.
	create or replace TRIGGER INCREASE_USER_POINT_TRIGGER 
    	AFTER
    	INSERT ON SAMPLE_BOOK_ORDERS
    	FOR EACH ROW
    
    	DECLARE
        	v_price             sample_book_orders.order_price%type;
        	v_amount            sample_book_orders.order_amount%type;
        	v_deposit_point     sample_book_users.user_point%type;

    	BEGIN

        	v_price         := :NEW.ORDER_PRICE;
        	v_amount        := :NEW.ORDER_AMOUNT;
        	v_deposit_point := trunc(v_price*v_amount*0.02);

        	UPDATE SAMPLE_BOOK_USERS
        	SET
            	USER_POINT = USER_POINT +  v_deposit_point
        	WHERE
            	USER_ID = :NEW.USER_ID;

    	END;
	-----------------------------------------------------------------------------------------------
	// 리뷰정보가 등록될 때마다 sample_books의 book_point를 변경한다.
	create or replace TRIGGER UPDATE_REVIEW_POINT_TRIGGER
    	BEFORE
    	INSERT  ON SAMPLE_BOOK_REVIEWS
    	FOR EACH ROW
    
    	DECLARE
       		v_current_point              NUMBER(2, 1);
       		v_current_row_count          NUMBER;
       
       		v_temp_point                 NUMBER;
       		v_point                      NUMBER(2, 1);
    	BEGIN
        	SELECT BOOK_POINT
        	INTO v_current_point
        	FROM SAMPLE_BOOKS
        	WHERE BOOK_NO = :NEW.BOOK_NO;
        
        	SELECT COUNT(*)
        	INTO v_current_row_count
        	FROM SAMPLE_BOOK_REVIEWS
        	WHERE BOOK_NO = :NEW.BOOK_NO;
        
        	v_temp_point := (v_current_point*v_current_row_count + :NEW.REVIEW_POINT)/(v_current_row_count + 1);
        	v_point := trunc(v_temp_point, 1);
        
        	UPDATE SAMPLE_BOOKS
        	SET
            		BOOK_POINT = v_point
        	WHERE
            		BOOK_NO = :NEW.BOOK_NO;
    	END;
	-----------------------------------------------------------------------------------------------
