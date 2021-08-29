-- 급여가 10000이상 15000이하인 사원의 아이디, 이름, 급여를 조회하기
select employ_id, first_name, salary
from employees
where salary >= 10000 and salary <= 15000;

-- 소속부서 아이디가 50번이고, 급여를 3000이상 받는 사원의 아이디, 이름, 급여를 조회하기 
select employee_id, first_name, salary
from employees
where department_id = 50 and salary>= 3000;

-- 직종 아이디가 SH_CLERK이고, 급여를 4000이상 받는 사원의 아이디, 이름, 급여를 조회하기 
select employee_id, first_name, salary
from employees
where job_id = 'SH_CLERK' and salary > 4000;

-- 자신의 상사가 101번이거나 102번인 사원의 아이디, 이름, 직종아이디, 상사의 아이디를 조회하기
select employee_id, first_name, job_id, manager_id
from employees
where  manager_id = 101 or manager_id = 102;

-- 자신의 상사가 101번이거나 102번인 사원의 아이디, 이름, 직종아이디, 상사의 아이디를 조회하기
select employee_id, first_name, job_id, manager_id
from employees
where  manager_id in (101, 102);

-- 소속부서 아이디가 30번이거나 60번이면서 급여를 5000이상 받는 사원의 아이디,
-- 이름, 급여, 소속부서어이디를 조회하기
select employee_id, first_name, salary
from employees
where department_id in(30, 60) and salary >= 5000;

-- is null, is not null을 이용해서 컬럼의 값이 null인 것과 null이 아닌 것을 구분해서 조회하기
-- departments 테이블에서 등록된 부서 중에서 부서관리자가 지정되지 않은 부서의 아이디,
-- 부서명, 관리자 아이디를 조회하기 
select department_id, department_name, manager_id
from departments
where manager_id is null;

--employees테이블에 등록된 사원들 중에서 커미션을 받는 사원의 아이디, 이름, 급여, 커미션 조회하기 
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null;

-- employees 테이블에 등록된 사원들 중에서 커미션을 받고, 급여를 10000이상 받는 사원의 아이디, 
-- 이름, 급여, 커미션을 조회하기
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null and salary >= 10000;

-- employees 테이블에 등록된 사원들 중에서 커미션을 받고, 급여를 10000이상 받는 사원의 아이디, 
-- 이름, 급여, 커미션을 조회하기(커미션에 대한 오름차순으로 정렬)
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null and salary >= 10000
order by commission_pct asc;

-- employee 테이블에서 사원번호가 110번 이상 120번 이하인 사원의 사원아이디, 이름 조회
select employee_id, first_name
from employees
where employee_id >= 110 and employee_id<=120;

select employee_id, first_name
from employees
where employee_id between 110 and 120;

-- employees 테이블에서 직송 아이디에 CLERK를 포함하고 있는 사원의 아이디, 이름, 직종아이디 조회
select employee_id, first_name, job_id
from employees
where job_id like '%CLERK';

-- employees 테이블에 등록된 사원중에서 소속부서 아이디가 30, 50, 60, 80이 
-- 아닌 사원의 아이디, 이름, 부서아이디를 조회하기 
select employee_id, first_name, department_id
from employees
where depart_id not in (30, 50, 60, 80)
order by department_id asc;

-- 모든 부서정보를 조회하기
select* 
from departments;
-- 모든 부서소재지정보를 조회하기
select *
from locations;
-- 모든 직종정보를 조회하기
select*
from jobs;

-- 직종정보 테이블에서 직종아이디, 최소급여, 최대급여를 조회하기
select job_id, min_salary, max_salary
from jobs;

-- 부서정보 테이블에서 부서아이디, 부서명을 조회하기
select department_id, department_name
from departments;

-- 사원정보 테이블에서 사원아이디, 이름, 입사일, 직종아이디, 급여를 조회하기
select employee_id, first_name, hire_date, job_id, salary
from employees;

-- 사원정보 테이블에서 사원아이디가 100번인 사원의 이름, 전화번호, 이메일, 입사일, 급여를 조회하기
select first_name, phone_number, email, hire_date, salary
from employees
where employee_id = 100;

-- 사원정보 테이블에서 100번 사원을 상사로 두고 있는 사원들의 이름, 입사일, 직종아이디 조회하기
select first_name, hire_date, job_id
from employees
where manager_id = 100;

-- 직종테이블에서 직종 최소급여가 10000 이상인 직종의 아이디, 제목, 최소급여, 최대급여를 조회하기
select job_id, job_title, min_salary, max_salary
from jobs
where min_salary >= 10000;

-- 사원테이블에서 커미션을 받는 사원 중 급여를 5000이하 받는 사원의 아이디, 이름, 직종, 급여를 조회하기 
select employee_id, first_name, jobs_id, salary
from employees
where commition_pct is not null and salary <= 5000;
-- 사원테이블에서 직종이 'MAN'이나 'MGR'로 끝나는 사원중에서 급여를 10000이하 받는 사원의 아이디, 
-- 이름, 직종아이디, 급여를 조회하기
select employee_id, first_name, job_id, salary
from employees
where (job_id like '%MAN' or job_id like '%MGR') and salary <= 10000;

-- 사원정보테이블에서 커미션을 받는 사원중에서 147번 사원을 상사를 두고 있으면서, 급여를 10000이상 받는
-- 사원의 아이디, 사원이름, 급여, 커미션을 조회하기
select employee_id, first_name, salary, commition_pct
from employees
where commition_pct is not null and manager_id = 147 and salary >= 10000;

-- 사원정보테이블에서 101번과 102번이 상사로 정해진 사원들의 아이디, 이름, 상사아이디를 조회하기
select employee_id, first_name, manager_id
from employees
where manager_id in (101, 102);

-- 사원정보테이블에서 소속부서가 결정되지 않은 사원의 아이디, 이름, 직종아이디를 조회하기
select employee_id, first_name, job_id
from employees
where department_id is null;

-- 사원정보테이블에서 60번 부서에 소속된 사원들의 아이디, 이름, 월급, 연봉을 조회하기
-- (salary는 월급이다. 연봉은 별칭을 부여한다.)
select employee_id, first_name, salary, salary*12 annual_salary
from employees 
where department_id = 60;

-- 문자함수 연습하기
-- lower(컬럼명 혹은 표현식)- 소문자로변환 
-- upper(컬럼명 혹은 표현식) - 대문자로 변환  
-- substr(컬럼명 혹은 표현식, 시작위치, 개수) - 시작위치에서 개수만큼 잘라서 반환 
-- length(컬럼명 혹은 표현식)   - 문자열의 길이 반환 
-- instr(칼럼명 혹은 표현식, '문자') - 지정된 문자의 위치를 반환(인덱스는 1부터 시작)
-- instr(칼럼명 혹은 표현식, '문자', 시작위치, n번째)- 지정된 시작위치부터 문자를 검색했을 때 n번째로 등장하는 위치를 반환 
-- lpad(칼럼명 혹은 표현식, 길이, '문자')- 지정된 길이보다 짧으면 부족한 길이만큼 지정된 문자를 왼쪽에 채운다.
-- rpad(칼럼명 혹은 표현식, 길이, '문자')- 지정된 길이보다 짧으면 부족한 길이만큼 지정된 문자를 오른쪽에 채운다.
-- trim(칼럼명 혹은 표현식) - 불필요한 좌우 공백을 제거한다.
-- replace(칼럼명 혹은 표현식, '찾는문자', '대체할 문자') - 문자를 찾아서 지정된 문자로 대체한다.
select lower('Hello World'),
        upper('Hello World'), 
        substr('Hello World', 3),
        substr('Hello World', 1, 1),
        substr('Hello World', 3, 4),
        length('Hello World'), --11글자
        lengthb('Hello World'),  --11byte
        length('안녕하세요'),    --5글자 
        lengthb('안녕하세요'),   --15byte
        instr('010-1111-2222', '-'),   -- 4
        instr('02)1234-5678', ')'),    -- 3
        instr('700)1234-4566', ')'),    --4
        lpad('100', 10, '0'),       -- 0000000100
        lpad('12345', 10,'0'),      -- 0000012345
        replace('hello', 'l', '*')  -- he**o
from dual;

-- employees 테이블에서 이름에 'tay'가 포함되는 사원을 조회하기 
select firtst_name
from employees
where lower(first_name) like '%tay&';

-- employees 테이블에서 'MAN'이나 'MGR'로 끝나는 직종을 가진 사원의 이름 직종아이디 조회하기
select first_name, job_id
from employees
where substr(job_id, 4) in ('MAN', 'MGR'); -- substr('SA_MAN', 4) -> 'MAN'

select first_name, job_id
from employees
where job_id like '%MAN' or job_id like '%MGR';

-- employees 테이블에서 사용자 아이디, 이름, 원래전화번호, 전화번호 조회하기
-- (전화번호의 2번째 구분점부터 조회)
select employee_id, first_name, phone_number, substr(phone_number, instr(phone_number, '.', 1, 2)+ 1) short_phone_number
-- instr(phone_number, '.', 1, 2)첫번째 부터 찾았는데 2글짜 점을 뜻함 
-- instr(phone_number, '.', 5) 5번째 부터 점을 찾는다.
from employees;

-- employees 테이블에서 사용자번호, 이름, 이메일을 조회하기
-- (단, 이메일의 첫2글자는 **로 바꾸기)
select employee_id, first_name, email,
    replace(email, subsrt(email,1 ,2), '**')
from employees;

select replace('aaabbaabb', substr('aaabbaabb', 3, 2), '**'),
   replace(substr('aaabbaabb', 1, 4), substr('aaabbaabb', 3, 2), '**') || substr('aaabbaabb', 5)
from dual;