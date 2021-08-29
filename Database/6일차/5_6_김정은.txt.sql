-- 사원아이디, 이름, 소속부서 아이디, 소속부서명을 조회하기
select E.employee_id, E.first_name, D.department_name
from employees E, departments D
where E.department_id = D.department_id;

-- 60번부서에 소속된 사원들의 사원아이디, 이름, 급여, 직종아이디, 직종제목, 직종최저급여, 직종최고급여를 조회하기
select employee_id, first_name, salary, job_id, job_title, min_salary, max_salary
from employees E, jobs J
where E.department_id = 60
and E.job_id = J.job_id;

-- 모든 사원들의 사원아이디, 이름, 급여, 급여등급을 조회하기
select E.employee_id, E.first_name, E.salary, G.grade
from employees E, salary_grade G, jobs J
where E.job_id = J.job_id
and G.min_salary = J.min_salary;

-- 60번부서에 소속된 사원들의 사원아이디, 이름, 상사의 이름을 조회하기
select e.employee_id, e.first_name, d.manager_name
from employees e, departments d
where D.department_id = 60
and e.department_id = d.department_id;

-- 부서관리자가 있는 부서의 부서아이디, 부서명, 부서관리자 아이디, 부서관리자이름을 조회하기
select d.department_id, d.department_name, e.manager_id, e.first_name
from departments d, employees e
where d.department_id is not null
and d.department_id = e.department_id;

-- 부서관리자가 있는 부서의 부서소재지 도시명을 중복없이 조회하기
select distinct L.city, D.manager_id
from locations L, departments D
where D.manager_id is not null;

-- 소속부서명이 'Sales'이고, 급여등급이 'A'나 'B'에 해당하는 사원들의 아이디, 이름, 급여, 급여등급을 조회하기
select E.employee_id, E.first_name, E.salary, G.grade
from employees E, salary_grade G, departments D
where D.department_name = 'Sales'
and grade in (A ,B);

-- 60번 부서에 소속된 사원들의 평균급여를 조회하기
select avg(salary)
from employees
where department_id = 60;

-- 직종아이디별 사원수를 조회하기
select count(job_id)
from jobs;

-- 급여 등급별 사원수를 조회하기
select grade,count(*)
from salary_grade
group by grade;

-- 2007년 입사한 사원들의 월별 입사자 수를 조회하기
select to_char(hire_date, 'MM') hire_month, count(*)
from employees
where hire_date >= to_date('2007/01/01') and hire_date < to_date('2008/01/01')
group by to_char(hire_date, 'MM');
