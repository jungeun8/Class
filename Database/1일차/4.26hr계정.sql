--departments 테이블의 모든 행, 모든 칼럼 조회하기 
select*
from departments;

-- employee테이블의 모든 행, 모든 칼럼 조회하기
select*
from employees;

-- jobs 테이블의 모든 행, 모든 칼럼 조회하기
select*
from jobs;
-- locations 테이블의 모든 행, 모든 칼럼 조회하기 
select* 
from locations;

-- 테이블에서 지정된 칼럼만 조회하기 
-- employees 테이블에서 사원아이디, 이름, 급여를 조회하기 
select employee_id, first_name, salary  -- select 절
from employees;                         -- from 절

--employees 테이블에서 사원아이디, 이름, 직종아이디 조회하기
select employee_id, first_name, job_id
from employees;

--departments 티에블에서 부서아이디, 부서명 조회하기
select department_id, department_name
from departments;
--jobs 테이블에서 직종아이디, 최소급여, 최대급여 조회하기 
select job_id, min_salary, max_salary
from jogs;

--locations 테이블에서 위치아이디, 주소, 도시명 조회하기 
select location_id, street_address, city
from locations;

--employees 테이블에서 소속부서아이디, 상사의 사원아이디, 사원의 이름 조회하기
select department_id, manager_id, first_name
from employees;

-- 조회결과에 중복된 값이 있을 떄 중복 된 행을 제거하고 조회하기 
-- employees에 등록된 사원들이 종사하는 직종의 아이디를 조회하기 
select distinct job_id
from employees;

-- employees에 등록된 사원들의 소속부서 아이디를 조회하기 
select distinct department_id
from employees;

-- jobs_history 테이블을 조회해서 직종이 변경된 적이 있는 사원의 아이디를 조회하기 
select distinct employee_id
from job_history;

-- 연결 연산자를 이용해서 두 개이상의 칼럼값을 붙여서 조회하기 
select employee_id, first_name, last_name, first_name||' '|| last_name
from employees; 

-- 조회결과에 별칭을 붙여서 조회하기

select employee_id, first_name || ''|| last_name as full_name
from employees;

select employee_id, first_name || ''|| last_name full_name
from employees;

select employee_id as id, first_name ||''|| last_name as name
from employees;

-- 사칙 연산자 사용하기 
-- employees 테이블에서 사원아이디, 이름, 주급, 월급 조회하기 
select employee_id, first_name, salary, salary*4 salary_of_month
from employees;
-- jobs 테이블에서 직종아이디, 최소급여, 최대급여, 최소급여와 최대급여의 차이를 조회 
select job_id, min_salary, max_salary, max_salary - min_salary as salay_gap
from jobs;
-- where 절을 이용해서 조회되는 행을 제한하기
-- 사원아이디가 100인 사원의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from emlpoyees
where employee_id = 100;

-- 이름이 Steven인 사원의 사원아이디, 이름, 직종아이디, 급여를 조회하기
Select employee_id, first_name, job_id, salary
from employees
where first_name = 'Steven';        -- 텍스트값은 대소문자를 구분한다.

-- 급여가 3000이하인 사원의 사원아이디, 이름, 직종아이디, 급여를 조회하기
select employee_id, first_name, job_id, salary
from employees
where salary <= 2500;

-- 급여를 15000이상인 사원의 사원아이디, 이름, 직종아읻, 급여를 조회하기
select employee_id,  first_name, job_id, salary
from employees
where salary >= 15000;

-- 급여가 10000이상인 사원의 이름, 급여를 조회하기
-- 조회결과는 이름에 대한 오름차순으로 정렬하기 
select first_name, salary
from employees
where salary >= 10000
order by first_name asc;

-- 급여가 10000이상인 사원의 이름, 급여를 조회하기
-- 조회결과는 급여에 대한 내림차순으로 정렬하기 
-- 급여가 동일한 경우 이름순으로 오름차순 정렬하기 
select first_name, salary
from employees
where salary >= 10000
order by salary desc, first_name asc;
