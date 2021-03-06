# Database
데이터베이스 문제
1. 기본 SQL
	- 테이블의 모든 행, 모든 열을 선택
		select *
		from departments

	- 테이블의 모든행, 특정 열을 선택
		select department_id, location_id
		from departments

	- 산술연산자(+ - * / ) 사용하기
		select last_name, salary, salary * 12
		from employees

	- 별칭 사용하기
		select last_name as name, commission_pct as comm
		from employees

		select last_name as "name", salary*12 as "annual salary"
		from employees

	- 연결 연산자 사용하기
		select first_name || job_id 
		from employees

		select first_name || ', ' || last_name as full_name
		from employees

	- 중복행 제거하기
		select distinct department_id
		from employees;

2. 데이터의 제한 및 정렬
	- 90번 부서에서 일하는 사원 조회하기
		select employee_id, last_name, job_id, department_id
		from employees
		where department_id = 90 
		* where절을 사용해서 조건을 제시하기

	- 이름이 'Whalen'인 사원 조회하기
		select last_name, job_id, department_id
		from employees
		where last_name = 'Whalen'
		* 문자열은 홑따옴표로 감싸기

	- 급여를 3000달러 이상 받는 사원 조회하기
		select last_name, salary
		from employees
		where salary >= 3000
		* 비교연산자(> < >= <= !=)를 사용해서 조건을 제시하기
	
	- 급여를 2500달러 이상 3500달러 이하로 받는 사원 조회하기
		select last_name, salary
		from employees
		where salary between 2500 and 3500
		* between A and B를 사용하면 A값과 B값 범위에 속하는 값을 가진 행을 검색한다.

	- 10번, 20번, 30번 부서에 소속된 사원 조회하기
		select employee_id, last_name, salary, department_id
		from employees
		where department_id in (10, 20, 30)
		* in 연산자를 사용하면 제시된 값에 속하는 행을 검색한다.

	- 이름이 'S'로 시작하는 사원 조회하기
		select first_name
		from employees
		where first_name like 'S%'
		* like 연산자와 와일드카드( _ % )를 사용하면 지정된 패턴과 일치하는 값을 가진 행을 검색한다.

	- 관리자가 지정되지 않은 부서 조회하기
		select department_id, department_name
		from departments
		where manager_id is null
		* is null은 제시된 컬럼이 null값을 가진 행을 검색한다.
	
	- 커미션을 받는 사원 조회하기
		select last_name, job_id, salary, commission_pct
		from employees
		where commission_pct is not null
		* is not null은 제시된 컬럼이 null이 아닌 값을 가진 행을 검색한다.

	- 급여를 10000불 이상받고, 직종이 "MAN'으로 끝나는 사원 조회하기
		select employee_id, last_name, job_id, salary
		from employees
		where salary >= 10000
		and job_id like '%MAN'
		* 논리연산자(and or not)을 사용하면 두 가지 이상의 조건을 결합해서 행을 검색할 수 있다.

	- 10번, 20번, 40번 부서에 소속되지 않은 사원 조회하기
		select employee_id, last_name, department_id
		from employees
		where department not in (10, 20, 40)
	
	- 50번 부서의 사원을 급여를 기준으로 오름차순으로 정렬해서 조회하기
		select employee_id, last_name, salary
		from employees
		where department_id
		order by salary asc
		* order by 절을 사용하면 제시된 표현식을 기준으로 행을 정렬할 수 있다.
		* 오름차순 asc, 내림차순 desc, 정렬방식을 지정하지 않으면 오름차순이다.
	
	- 급여를 10000달러 이상 받는 사원들을 부서번호순 오름차순, 급여순으로 내림차순 정렬해서 조회하기
		select employee_id, last_name, department_id, salary
		from employees
		where salary >= 10000
		order by department_id asc, salary desc
		* order by 절에 두 개 이상의 컬럼을 기준으로 행을 정렬시킬 수 있다.


3. 함수
	- 오늘을 기준으로 근무개월 수를 계산하기
		select employee_id, last_name, hire_date, months_between(sysdate, hire_date) as "근무 개월 수"
		from employees
		* months_between(date1, date2) - 두 날짜간의 개월수를 계산한다.
	
	- 오늘을 기준으로 10일 전에 입사한 사원을 조회하기
		select employee_id, last_name, hire_date
		from employees
		where hire_date >= (sysdate - 10)
		* 날짜 + 숫자, 날짜 - 숫자는 지정된 숫자만큼 이후 혹은 이전 날짜를 반환한다.
	
	- 오늘을 기준으로 90번 부서에 소속된 사원들의 근무일수 조회하기
		select employee_id, last_name, hire_date, sysdate - hire_date as "근무일 수"
		from employees
		where department_id = 90
		* 날짜 - 날짜는 두 날짜간의 일 수를 계산한다.

	- 입사일을 '년-월-일' 형식으로 조회하기
		select employee_id, last_name, to_char(hire_date, 'yyyy-mm-dd')
		from employees
		* to_char(날짜, 형식)은 날짜를 지정된 형식의 문자열로 반환한다.

	- 2000년도에 입사한 사원 조회하기
		select employee_id, last_name, hire_date
		from employees
		where to_char(hire_date, 'yyyy') = '2000'
		* to_char(날짜, 형식)은 날짜를 지정된 형식의 문자열로 반환한다.

	- 2001년 상반기에 입사한 사원 조회하기
		select employees_id, last_name, hire_date
		from employees
		where hire_date >= to_date('2001/01/01', 'yyyy/mm/dd') 
		and hire_date < to_date('2001/07/01', 'yyyy/mm/dd')
		* to_date('문자열', '패턴') 패턴과 같은 순서로 날짜를 문자열로 표시하면 데이터타입으로 변환한다.

	- 사원의 실제 급여를 조회하시오, 실제급여는 급여에 커미션을 반영한 급여다.
		select employee_id, last_name, salary, commission_pct, salary + salary*nvl(commission_pct, 0) as "실제 급여"
		from employees
		* nvl(널값이 예상되는 컬럼, 대체값)은 컬럼의 값이 null이면 지정된 대체값으로 null값을 대체한다.
		* commission_pct는 null을 가지고 있는 컬럼이기 때문에 nvl() 함수 없이 salary + salary*commission_pct 로 계산하면 
		  commission_pct가 null인 사원의 실제급여가 null로 계산된다. nvl()함수를 사용해서 commission_pct가 null인 경우 0으로 값을 대체시켜서 계산했다.

	- 급여를 15000달러 이상 받으면 10% 급여인상, 10000달러 이상 받으면 15% 급여인상, 그외는 20% 급여가 인상된 값을 조회하기
		select employee_id, last_name, 
			case
				when salary >= 15000 then 1.10*salary
				when salary >= 10000 then 1.15*salary
				else 1.20*salary
			end as "인상된 급여"
		from employees
		* case when 표현식을 사용하면 if ~ else if ~ else 형식의 조건부 조회를 구현할 수 있다.

	- 부서번호가 10번인 사원 10% 급여인상, 20번인 사원 15% 급여인상, 그외 20% 급여가 인상된 값을 조회하기
		select employe_id, last_name,
			decode(department,  10, 1.10*salary,
					   20, 1.15*salary,
					   1.20*salary)
		from employees
		* decode()함수를 사용하면  if ~ else if ~ else 형식의 조건부 조회를 구현할 수 있다.
		* decode(표현식, 비교값1, 계산식1, 비교값2, 계산식2, 계산식3)함수는 표현식의 값이 비교값1과 일치하면 계산식1의 실행결과를 출력하고, 
		  비교값2와 일치하면 계산식2의 실행결과를 출력하고, 일치하는 경우가 없으면 계산식3의 실행결과를 출력한다.
		* decode()함수는 표현식과 비교값이 equal 비교만을 수행한다.

4. 조인
	- 조인은 여러 테이블에서 데이터를 조회할 때 사용한다.
	  * 어떤 경우에는 같은 테이블끼리 조인해야 하는 경우도 있는데 이를 자체 조인(self join)이라고 한다.
	- 테이블을 조인하는 select문을 작성할 때는 컬럼이름에 테이블 이름을 나타내는 접두어를 붙이면 테이터베이스 엑세스 기능이 향상된다.
	- 여러 테이블에 동일한 컬럼명이 있는 경우에는 컬럼이름에 테이블 이름을 나타내는 접두어를 붙여야 한다.
	- n개의 테이블을 조인하려면 n-1개의 조인 조건이 필요한다.
	- 조인 수행절차
		1. 구현내용에서 필요한 데이터가 어느 테이블에 있는지를 확인한다.
		2. 위에서 확인된 테이블들의 각 행을 조인할 때 사용할 조인 조건을 확인한다.
		   * 조인 조건은 A 테이블의 어떤 컬럼과 B 테이블의 어떤 컬럼이 서로 같은 값을 가지고 있는 컬럼인지를 확인하고
		     그 값이 같은 값을 가지는 경우만 A테이블의 행과 B테이블의 행이 조인되도록한다.
		3. 위에서 확인된 테이블을 from 절에 나열하고,  위에서 확인되 조인조건을 where절에 나열한다.
	
	- 사원아이디, 사원이름, 사원이 소속된 부서번호와 부서이름을 조회하기
		select A.employee_id, A.last_name, A.department_id, B.department_name
		from employees A, departments B
		where A.department_id = B.department_id
		* 1. 테이블 확인하기
			사원아이디, 사원이름, 부서번호는 employees 테이블, 부서이름은 departments 테이블
		  2. 조인조건 확인하기
			사원테이블의 부서번호와 부서테이블의 부서번호가 일치하는 행끼리 조인
	
	- 부서아이디, 부서이름, 부서담당자아이디, 부서담당자 이름 조회하기
		select A.department_id, A.department_name, A.manager_id, B.last_name
		from departments A, employees B
		where A.manager_id = B.employee_id
		* 1. 테이블 확인하기
			 부서아이디, 부서이름, 부서담당자 아이디는 department 테이블, 부서담당자 이름은 employees 테이블
		  2. 조인조건 확인하기
			부서테이블의 부서담당자사원아이디와 사원테이블의 사원아이디가 일치하는 행끼리 조인

	- 사원의 아이디, 사원이름, 소속부서 아이디, 소속부서이름, 소속부서가 위치한 도시 조회하기
		select A.employee_id, A.last_name, A.department_id, B.department_name, C.city
		from employees A, departments B, locations C
		where A.department_id = B.department_id 
		and B.location_id = C.location_id
		* 1. 테이블 확인하기
			사원아이디, 사원이름, 소속부서 아이디는 employees 테이블, 소속부서이름은 departmets 테이블, 도시는 locations 테이블
		  2. 조인조건 확인하기
			부서이름을 가져오기 위해서 사원테이블의 부서번호와 부서테이블의 부서번호가 일치하는 행끼리 조인하고, 
			그 부서가 위치한 도시를 가져오기 위해서 부서테이브l  위치아이디와 위치테이블의 위치아이디가 같은 행끼리 조인한다.

	- 부서아이디, 부서이름, 부서담당자아이디, 부서담당자 이름, 그 부서가 위치한 도시 조회하기
		select A.department_id, A.department_name, A.manager_id, B.last_name, C.city
		from departments A, employees B, locations C
		where A.manager_id = B.employee_id
		and A.location_id = C.location_id
		* 1. 테이블 확인하기
			 부서아이디, 부서이름, 부서담당자 아이디는 department 테이블, 부서담당자 이름은 employees 테이블, 도시는 locations 테이블
		  2. 조인조건 확인하기
			담당자 이름을 가져오기 위해서 부서테이블의 부서담당자사원아이디와 사원테이블의 사원아이디가 일치하는 행끼리 조인하고,
			그 부서가 위치한 도시를 가져오기 위해서 부서테이브l  위치아이디와 위치테이블의 위치아이디가 같은 행끼리 조인한다.
	
	- 사원 아이디, 사원이름, 보스 아이디, 보스 이름 조회하기
		select E.employee_id "사원아이디", E.last_name "사원이름", E.manager_id "보스아이디", B.last_name "보스이름"
		from employees E, employees B
		where E.manager_id = B.employee_id
		* 1. 테이블 확인하기
			사원아이디, 사원이름, 보스아이디(manager_id)는 employees 테이블, 보스이름은 employees 테이블 <-- 보스(관리자도 직원이기 때문에)
			* 같은 테이블을 조인하는 셀프조인이다.
		  	* 셀프조인인 경우는 두 테이블을 각각 사원역할 테이블과 보스 역할 테이블로 임의로 구분한다.
			* 여기는 employees E는 사원, employees B는 보스 테이블이다.
		  2. 조인조건 확인하기
			보스이름을 가져오기 위해서 사원테이블의 manager_id(그 사원의 보스아이디임)과 보스 테이블의 employee_id가 같은 행끼리 조인한다.

5. 데이터 조작
	- 새로운 행 추가
		insert into 테이블명 (컬럼명, 컬럼명, 컬럼명, ...)
		values(값, 값, 값, ...)

		- 새로운 부서정보 추가
			insert into departments (department_id, department_name, manager_id, location_id)
			values (210, '영업부', null, 1700)
		

	- 행 삭제
		delete from 테이블명
		where 삭제조건

		- 210번 부서정보 삭제
			delete from departments
			where department_id = 210

	- 컬럼값 변경
		update 테이블명
		set
			컬럼명 = 값,
			컬럼명 = 값,
			컬럼명 = 값
		where 변경조건

		- 90번 부서의 부서명, 담당자, 위치아이디 변경하기
		update departments
		set
			department_name = '기술1팀',
			manager_id = 100,
			location_id = 1700
		where department_id = 90

6. 시퀀스 
	- 시퀀스 생성하기
		create sequence book_seq;

	- 시퀀스 값 조회하기
		select book_seq.nextval from dual
	
	- 시퀀스 값을 행추가할 때 사용하기
		insert into books (book_no, book_title, book_author, book_price)
		values (book_seq.nextval, '이것이 자바다', '신용권', 35000)

7. TOP-N 분석과 분석함수
	- TOP-N 분석은 조건에 맞는 최상위 레코드 n개 혹은 최하위 레코드 n개를
		  조회하는 쿼리다.
		- 사용예)
			* 급여를 가장 많이 받는 사원 3명
			* 가장 최근에 입사한 사원 5명
			* 최근 3개월동안 가진 많이 판매된 상품 10 가지
			* 판매실적이 가장 높은 영업사원 3명
		- 형식
			SELECT ROWNUM, column, column, column
			FROM   (SELET column, column, column
                                FROM table
				ORDER BY 분석대상컬럼이 정렬기준이된다)
			WHERE	ROWNUM <= N
			* 인라인뷰 :  order by절을 사용해서 데이터를 원하는 순서로 정렬한다.
			* ROWNUM : 서브쿼리에서 반환되는 각 행에 1부터 시작하는 순번을 할당한다.
			* WHERE절 : 최종적으로 반환될 행의 갯수를 지정한다.
	- 분석함수
		- 테이블의 데이터를 특정 용도로 분석하여 결과를 반환하는 함수
		- 종류
			- 순위 함수 : RANK, DENSE_RANK, ROW_NUMBER
			- 집계 함수 : SUM, MIN, MAX, AVG, COUNT
		- 형식
			SELECT 분석함수([컬럼]) OVER ([PARTITION BY 컬럼] [ORDER BY 컬럼])
			FROM 테이블명
			* OVER : 분석함수임을 나타내는 키워드
			* PARTITION BY : 계산 대상을 그룹화한다.
			* ORDER BY : 정렬한다.

		* 그룹함수와 분석함수의 차이
			- 그룹함수 : 테이블 전체 혹은 그룹당 결과가 하나 반환된다.
				select sum(salary)	select department_id, sum(salary)
				from employees;		from employees 
							group by department_id;
				* 테이블당 하나		* 부서당 하나

			- 분석함수 : 행마다 결과가 하나 반환된다.
				select first_name, sum(salary) over()
				from employees;
				* 전체 사원들의 급여 총액이 행마다  표시
		
				select first_name, sum(salary) over (partition by department_id)
				from employees;
				* 각 부서별 급여 총액이 행마다 표시

8. 권한
	- 특정 SQL을 실행할 수 있는 권리
	- 시스템 권한
		- 데이터베이스를 엑세스 할 수 있는 권한
		- 데이터베이스 관리자만 시스템권한을 부여/회수할 수 있다..
		- 대표적인 시스템 권한
			* CREATE SESSION : 데이터베이스에 연결할 수 있는 권한
			* CREATE TABLE   : 테이블을 생성할 수 있는 권한
	- 객체 권한
		- 데이터베이스 객체의 내용을 조작할 수 있는 권한
		- 사용자가 소유하고 있는 데이터베이스 객체를 다른 사용자들이 엑세스하거나 
		  조작할 수 있게 하는 권한
		- 객체와 객체에 따른 권한
		-------------------------------------------------------------------------
		객체권한	테이블		뷰		시퀀스		프로시저
		-------------------------------------------------------------------------
		ALTER		O				O
		INDEX		O
		EXECUTE								O
		DELETE		O		O
		INSERT		O		O
		SELECT		O		O		O
		UPDATE		O		O
		-------------------------------------------------------------------------
	
	* 사용자는 시스템권한과 객체권한이 필요한다
	롤(Role)
		- 사용자에게 부여할 수 있는 관련 권한을 하나로 묶어서 그룹화하고 이름을 부여한 것
		- 롤을 사용하면 권한의 부여, 회수, 유지관리가 쉬워진다.
		- 일반 사용자에게 부여되는 필수적인 롤
			* connect role
				- 오라클에 접속할 수 있는 세션 생성 권한.
			* resource role
				- PL/SQL을 사용할 수 있는 권한
				- 테이블을 생성하거나 조회할 수 있는 권한
				- 가장 일반적인 권한들을 가지고 있다
				- 일반사용자를 사용자를 생성하면 보통 connect, resource 롤을 부여한다.
			* dba role
				- 모든 시스템권한이 부여된 롤
				- 데이터베이스 관리자에게만 부여해야 함

	스키마(Schema)
		- 테이블, 뷰, 시퀀스 등과 같은 여러 객체들의 집합이다.
		- 데이터베이스 사용자가 스키마를 소유하고 있으며, 사용자의 이름과 동일한 이름을 갖는다.
		- 다른 사용자가 소유하고 있는 객체를 엑세스할 때는 반드시 스키마를 명시해야 한다.
		- 작성예)
			* hta 사용자가 hr이 소유하고 있는 employees를 조회하기
			  select *
		 	 from hr.employees;
	


	사용자 생성
		- 데이터베이스 관리자는 사용자를 생성할 수 있다.
		- CREATE USER 사용자명
         	  IDENTIFIED BY 비밀번호;
	사용자 비밀번호 변경
		- 데이터베이스 관리자는 사용자의 암호를 변경할 수 있다.
		- ALTER USER 사용자명
	  	  IDENTIFIED BY 새비밀번호;
	사용자 삭제
		- DROP USER 사용자명;


사용자에게 시스템 권한 부여하기
	- GRANT 시스템권한, 롤, ... TO 사용자명;
사용자에게서 시스템 권한 회수하기
	- REVOKE 시스템권한, 롤, ... FROM 사용자명;


소유자가 다른 사용자에게 객체권한 부여하기
	- 소유자는 자신에 객체에 대한 특정 권한을 다른 사용자에게 부여할 수 있다.
	- GRANT 객체권한(컬럼명, 컬럼명)
 	  ON 객체명
	  TO 다른 사용자;
소유자가 다른 사용자에게 부여한 객체권한 회수하기
	- REVOKE 객체권한, ...
	  ON 객체명
	  FROM 다른사용자, ...

