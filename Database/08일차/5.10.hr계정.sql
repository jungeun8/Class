-- 자신이 소속되어 있는 부서의 평균급여보다 급여를 많이 받은 사원을 조회하기 
select O.employee_id, O.first_name,O.salary
from employees O
where O.salary > (select avg(I.salary)
                from employees I
                where i.department_id = o.department_id);

-- 사용자아이디, 이름, 급여, 자신이 소속된 부서의 평균급여를 조회하기
select O.employee_id, O.first_name, O.department_id, O.salary,
        (select trunc(avg(I.salary))
        from employees I
        where I.department_id = O.department_id)avg_salary
from employees O;

-- 부서아이디, 부서명, 해당부서의 관리자 이름, 소속된 사원수 조회하기 
select o.department_id, o.department_name, o.manager_id,
        (select I.first_name
        from employees I
        where I.employee_id = o.manager_id) as manager_name,
        (select count(*)
        from employees I 
        where I.department_id = o.department_id) as employee_cnt
from departments o;

-- 스칼라 서브쿼리
-- 서브쿼리의 실행결과가 단일행-단일칼럼인 경우(오직 값이 하나만 조회되는 서브쿼리)
-- 사원아이디, 이름, 급여, 사원전체평균급여를 조회하기 
select O.employee_id, O.first_name, O.salary,
        (select trunc(avg(I.salary)) from employees I) avg_salary
from employees O;

-- 스칼라 서브쿼리를 update 문에서 사용하기 
-- 사원들의 급여를 전체사원의 평균급여의 10%만큼 인상시키기
update employees
set
    salary = salary + (select trunc(avg(salary)*0.1) from employees);
    
-- 스칼라 서브쿼리를 insert문에서 사용하기 
-- 새로운 사원정보를 추가하기 
insert into employees
(employee_id, first_name, last_name, email, phone_number, 
 hire_date, job_id, salary, commission_pct, manager_id, department_id)
values 
(employees_seq.nextval, 'Gildong', 'Hong', 'GILDONG', '010.1111.2222', 
 sysdate, 'IT_PROG', (select min_salary from jobs where job_id = 'IT_PROG') , null, 103, 60);
 
 -- 뷰(가상의 테이블)
 -- 부서 상세정보를 제공하는 가상의 테이블 생성하기 
 -- 부서 상세정보 - 부서아이디, 부서명, 관리자아이디, 관리자이름, 부서에 소속된 사원수, 부서의 소재지, 주소
 create or replace view departments_detail_view
 as
 select d.department_id, d.department_name, d.manager_id, e.first_name, e.last_name,
    l.city, l.street_address,
    (select count(*) from employees I where I.department_id = d.department_id)emp_cnt
from departments d, employees e, locations l
where d.manager_id = e.employee_id(+)
and d.location_id = l.location_id;

-- 60번 부서의 상세정보 조회하기 
-- view사용하기 전 
select d.department_id, d.department_name, d.manager_id, e.first_name, e.last_name,
    l.city, l.street_address,
    (select count(*) from employees I where I.department_id = d.department_id)emp_cnt
from departments d, employees e, locations l
where d.manager_id = e.employee_id(+)
and d.location_id = l.location_id
and d.department_id = 60;
-- view사용하기 후 
select deparmtment_id, department_name, manager_id, first_name, last_name,
    city, street_address, emp_cnt
from departments_detail_view
where department_id = 60;

-- 사원의 상세정보를 제공하는 뷰 생성하기
-- 사원아이디, 이름, 이메일, 전화번호, 입사일, 근무개월수, 근무년수, 급여, 커미션, 급여등급, 
-- 연봉, 상사의 아이디, 상사의 이름, ,직종아이디, 직종제목, 부서아이디, 부서명, 부서관리자이름 
create or replace view employees_detail_view
as
select E.employee_id as emp_id,
   E.first_name || ', ' || E.last_name as full_name,
   E.email, 
   E.phone_number, 
   E.hire_date, 
   trunc(months_between(sysdate, E.hire_date)) work_months,
   trunc(months_between(sysdate, E.hire_date)/12) working_year,
   E.salary, 
   E.commission_pct, 
   G.grade, 
   E.salary*12+E.salary*12*nvl(E.commission_pct, 0) annual_salary,
   M.employee_id as manager_id,
   M.first_name || ', ' || M.last_name as manager_name,
   E.job_id,
   J.job_title, 
   E.department_id,
   D.department_name, 
   dm.employee_id dept_manager_id
   DM.first_name || ', ' || DM.last_name as dept_manager_name
from employees E, salary_grade G, employees M, jobs J, departments D, employees DM
where E.salary >= G.min_salary and E.salary <= G.max_salary 
and E.manager_id = M.employee_id(+)
and E.job_id = J.job_id 
and E.department_id = D.department_id 
and D.manager_id = DM.employee_id(+)
with read only;

-- 200사원의 아이디, 이름, 급여, 급여등급, 연봉, 직종아이디, 소속부서명 조회
select emp_id, full_name, salary, grade, annual_salary, job_id, department_name
from employees_detail_view
where emp_id = 200;


-- 급여등급별 사원수를 조회하기 
select grade, count(*)
from employees_detail_view
group by grade
order by grade;

-- 입사일 기준 근무년수가 15년 이상인 사원의 아이디, 이름, 입사일, 근무년수를 조회하기
select emp_id , full_name, hire_date,working_year
from employees_detail_view
where working_year >= 15
order by working_year desc;

-- 연봉이 20만불 이상인 사원의 아이디, 이름, 급여, 급여등급, 연봉, 직종을 조회하기 
select emp_id, full_name, salary, grade, annual_salary, job_id
from employees_detail_view
where annual_salary >= 200000;

-- 인라인 뷰
-- 직종별 사원수를 조회하기
-- 직종아이디, 직종제목, 직종최소급여, 직종최대급여, 사원수
-- select job_id, count(*)
-- from employees
-- group job_id
select a.job_id, b.job_title, b.min_salary, b.max_salary,a.cnt
from (select job_id, count(*) cnt
    from employees
    group by job_id) A, jobs B
where A.job_id = B.job_id;

-- top-n 분석 
-- 지정된 칼럼의 값을 기준으로 행을 정렬하고, 상위 n개의 열을 조회하는 것 
-- 연봉에 대한 내림차순으로 정렬했을 때 상위 3명의 아이디, 이름, 연봉을 조회하기 
select rownum,emp_id, full_name, annual_salary
from(select emp_id, full_name, annual_salary
    from employees_detail_view
    order by annual_salary desc)
where rownum <= 3;

-- 직종별 인원수를 조회했을 때, 인원수가 가장 많은 직종 3개를 조회하기 
select rownum, job_id, cnt
from(
select job_id, count(*) cnt
from employees
group by job_id
order by cnt desc)
where rownum <=3;

-- 직종별 인원수를 조회했을 때, 인원수를 기준으로 내림차순 정렬하고, 6번째~10번째에 해당하는
-- 행을 조회하기
select ranking, job_id, cnt
from(select rownum ranking, job_id, cnt
    from(select job_id, count(*) cnt
    from employees
    group by job_id
    order cnt desc))
where ranking >= 6 and ranking <= 10;