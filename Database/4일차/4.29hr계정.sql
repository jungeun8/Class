-- 테이블 조인하기
-- 사원아이디, 사원명, 소속부서아이디, 소속부서명
-- employees 테이블 -> 사원아이디, 사원명, 소속부서아이디 
-- departments 테이블 - 소속부서명 
select employees.employee_id, employees.first_name, employees.department_id, 
        departments.department_name
from employees, departments
where employees.department_id = departments.department_id;

select A.employee_id, A.first_name, A.department_id, B.department_name
from employees A, departments B
where A.department_id = B.department_id;

-- 테이블 조인하기
-- 사원아이디, 이름, 직종아이디, 급여, 직종제목, 직종 최소 급여, 직종 최대 급여 조회하기 
-- employees 테이블 -> 사원아이디, 이름, 직종아이디, 급여 
-- jobs 테이블 -> 직종아이디, 직종제목, 직종 최저급여, 직종 최고급여 
select A.job_id, A.job_title, A.min_salary, A.max_salary, B.employee_id, B.first_name, B.salary
from jobs A, employees B
where A.job_id = B.job_id;


-- 테이블 조인하기
-- 부서관리자가 지정되어있는 부서의 부서아이디, 부서명, 부서관리자 아이디, 부서관리자 이름 조회
-- departments -> 부서아이디, 부서명, 부서관리자 아이디,
--employees -> 부서관리자이름(사원이름)
-- departments의 manager_id는 부서관리자로 지정된 사원의 사원의아이디다.
--departments의 manager_id와 동일한 사원아이디를 가진 사원정보가 조인되어야한다.
select *
from departments A, employeesB
where A.manager_id = B.employee_id
and A.manager_id is not null;

-- 3개 이상 테이블 조인하기
-- 사원아이디, 사원이름, 직종아이디, 급여, 직종최저급여, 직종최고급여, 소속부서 아이디, 부서명
-- employees -> 사원아이디, 사원이름, 직종아이디, 급여, 소속부서아이디 
-- jobs -> 직종최저급여, 직종최고급여
-- departments -> 부서명 
select E.employee_id, E.first_name,E.job_id,
        E.salary, J.min_salary, J.max_salary,
        E.department_id, D.department_name
from employees E, jobs J, departments D
where E.job_id = J.job_id
and E.department_id = D.department_id
order by E.employee_id asc;

-- 100번 사원의 이름, 전화번호, 이메일, 
-- 소속부서아이디, 소속부서명, 소속부서 도시명, 소속부서 소재지주소
select E.first_name, E.phone_number, E.email,
        D.department_id, D.department_name,
        L.city, L.street_address
from employees E, departments D, locations L
where E.employee_id = 100   -- 검색조건 
and E.department_id = D.department_id
and D.location_id = L.location_id;

-- 50번 부서에 소속된 사원들의 사원아이디, 이름, 직종아이디, 직종제목 조회하기 
-- 사원아이디, 이름, 직종아이디 -> employees
-- 직종제목 -> jobs
select A. employee_id, A.first_name, B.job_id, B.job_title
from employees A, jobs B
where A.department_id = 50
and A.job_id = B.job_id;

-- 급여를 15000이상 받는 사원들의 이름, 직종, 급여, 부서명을 조회하기
-- 급여를 15000이상, 이름, 직종아이디 -> employees
-- 부서명 -> departments

select A.first_name, A.job_id, A.salary, B.department_name
from employees A, departments B
where A.salary >= 15000 
and A.department_id = B.department_id;

-- 100번 직원이 관리하는 사원들의 이름, 직종아이디, 직종제목, 부서아이디, 부서명 조회하기
-- 100번 직원, 이름, 직종아이디, 부서아이디 -> employees
-- 직종제목 -> jobs
-- 부서명 -> departments
select A.first_name, A.job_id, A.department_id, B.job_title, C.department_name
from employees A, jobs B, departments C
where A.manager_id = 100
and A.job_id = B.job_id
and A.department_id = C.department_id;





