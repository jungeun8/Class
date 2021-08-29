-- 서브쿼리

------------------단일행 서브 쿼리-------------------
-- 전체사원의 평균급여보다 급여를 적게 받는 사원들의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from employees 
where salary < (select avg(salary)
                    from employees);
                    
                
-- 100번 사원과 같은 부서에 근무하는 사원들의 아이디, 이름을 조회하기 
-- 100번 사원이 소속되어 있는 부서 아이디
select department_id
from employees
where employee_id = 100;

-- 90번 부서에서 근무하고 있는 사원들의 사원아이디, 이름 조회하기 
select employee_id, first_name
from employees
where department_id = 90;

select employee_id, first_name
from employees
where department_id = (select department_id
                        from employees
                        where employee_id = 100);

-------------------다중횅 쿼리-------------------
-- 부서별 평균급여를 조회했을 때 평균급여가 5000달러 이하인 부서에 근무종인 사원들 조회
-- 부서별 평균급여를 조회했을 떄 평균급여가 5000달러 이하인 부서
select department_id    -- 10, 30, 50부서 평균급여가 5000달러 이하인 부서 
from employees
where department_id is not null
group by department_id
having avg(salary) <= 5000;

--평균급여가 5000달러 이하인 부서에 근무종인 사원들 조회
select employee_id, first_name, departmet_id
from employees
where department_id in (10, 30, 50);

-- 부서별 평균급여를 조회했을 때 평균급여가 5000달러 이하인 부서에 근무종인 사원들 조회
select employee_id, first_name,departmet_id
from employees
where department_id in (select department_id  
                        from employees
                        where department_id is not null
                        group by department_id
                        having avg(salary) <= 5000);
                        
                        
-- 직종최소급여가 10000달러 이하인 직종에 종사중인 사원들의 아이디, 이름, 직종아이디 조회하기 
-- 1. 직종최소급여가 10000달러 이인 직종에
select job_id -- AD_PRES, AD_VP
from jobs
where min_salary;
-- 2. 직종최소급여가 10000달러 이상인 직종에 종사중인 사원 
select employee_id,first_name, job_id, salary
from employees
where job_id in ('AD_PRES', 'AD_VP', 'SA_MAN');
--3. 직종최소급여가 10000달러 이상인 직종에 종사중인 사원들의 아이디, 이름, 직종아이디 조회하기 
select employee_id,first_name, job_id, salary
from employees
where job_id in (select job_id from jobs where min_salary >= 10000);
-- 서브쿼리로 해결되는 문제를 조인로 해결하기 
select e.employee_id,e.first_name, j.job_id, e.salary
from jobs j, employees e
where j.min_salary >= 10000
and j.job_id = e.job_id;

-- 80번 부서에 소속된 사원중에서 60번 부서에 소속된 직원의 급여보다 급여를 많이 받는
-- 사원의 아이디, 이름, 급여를 조회하기
-- 1. 60번부서에 소속된 사원들의 급여 조회 
select salary -- 9000, 6000, 4800, 4200
from employees
where department_id = 60;
-- 2. 60번 부서에 소속된 직원의 모든 급여보다 급엽를 많이 받는 50번 부서의 사원 조회
select employee_id, first_name, salary
from employees
where depart_id = 50
and salary >all (90006000,4800,4200); -- and salary > 9000
-- 2. 60번 부서에 소속된 직원들 중 아무거나 하나보다 급여를 많이 받는 50번 부서의 사원 조회
select employee_id, first_name, salary
from employees
where depart_id = 50
and salary >any (9000,6000,4800,4200); -- and salary > 4200
-- 3. 50번 부서에 소속된 사원중에서 60번 부서에 소속된 직원의 급여보다 급여를 많이 받는
-- 사원의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from employees
where department_id = 50
and salary > all (select salary
                    from employees
                    where deparatment_id = 60);
-- ">all"은 "> max()"로 대체할 수 있다.
select employee_id, first_name, salary
from employees
where department_id = 50
and salary > (select max(salary)
             from employees 
             where deparatment_id = 60);

-------------------- 다중열 서브쿼리 -------------------
-- 부서별 최고 급여를 받는 사원의 아이디, 이름, 급여, 부서아이디를 조회하기
-- 1.부서별 최고급여를 조회하기
select department_id, max(salary)
from employees
where department_id is not null
group by department_id;
-- 2. 100번 부서의 경우 12008이 최고급여다. 이 급여를 받은 사원의 정보를 조회하기
select employee_id, first_name, salary, department_id
from employees
where (department_id, salary) in (select department_id, max(salary)
                                    from employees
                                    where department_id is not null
                                    group by department_id);
                                    
--------------------- having절 서브쿼리 -----------------------
-- 부서별 사원수를 조회했을 때 가장 인원수가 많은 부서의 아이디와 인원수를 조회하기
-- 1. 부서별 사원수를 조회하기
select department_id, count(*)   
from employees
where department_id is not null
group by department_id;

--2. 가장많은 인원수 조회하기 
select max(count(*)) -- 45   
from employees
where department_id is not null
group by department_id;

-- 3.가장 많은 인원수를 보유하고 있는 부서 
select department_id, count(*)   
from employees
where department_id is not null
group by department_id
having count(*) = 45;

-- 4.부서별 사원수를 조회했을 때 가장 인원수가 많은 부서의 아이디와 인원수를 조회하기
select department_id, count(*)   
from employees
where department_id is not null
group by department_id
having count(*) = (select max(count(*))
                    from employees
                    where department_id is not null
                    group by department_id);
                    
-- 단일행 서브쿼리연슴 
-- Neena와 같은 해에 입사한 사원들의 아이디, 이름, 입사일 조회하기 
select employee_id, first_name, hire_date
from employees
where to_char(hire_date, 'yyyy') = (select to_char(hire_date, 'yyyy')
                                    from employees
                                    where first_name = 'Neena');

-- Neena와 같은 해에 입사한 사원들 중에서 전체 사원의 평균 급여보다 급여를 많이 받는
-- 사원의 아이디, 이름, 입사일, 급여를 조회하기
select employee_id, first_name, hire_date, salary
from employees
where to_char(hire_date, 'yyyy') = (select to_char(hire_date, 'yyyy')
                                    from employees
                                    where first_name = 'Neena')--서브쿼리 : 니나가 입사한 해 
and salary > (select avg(salary) --서브쿼리 : 전체사원의 평균급여
                from employees);
                
-- Neena의 상사가 소속되어 있는 부서와 같은 부서에서 근무하는 사원의 아이디, 
-- 이름, 직종, 부서아이디를 조회하기
select employee_id, firest_name, job_id, department_id
from employees
where department_id = (select department_id -- (니나의 상사가 소속된 부서의 아이디)
                        from employees
                        where employee_id = (select manager_id -- 니나의 상사
                                            from employees
                                            where fires_name = 'Neena'));
                                            
-- 60번 부서에 소속된 사원들의 급여를 인상시키기
-- (인상액은 전체 사원 평균급여의 10%, 소수점이하는 반올림한다.)
update employees
set
    salary = salary + (select round(avg(salary)*0.1)
                from employees)
where department_id = 60;

-- 다중행 서브쿼리 연습하기 
-- 100 사원에게 보고하는 직원이 자신의 상사인 사원들의 아이디, 이름, 상사의 아이디를 조회하기
select employee_id, first_name, manager_id
from employees
where manager_id in (select employee_id --(100에게 보고하는 직원들의 아이디)
                    from employees
                    where manager_id = 100);

-- 직종이 변경된 적이 있는 직원의 아이디, 이름, 소속부서 아이디를 조회하기
select employee_id,first_name, department_id
from employees
where employee_id in ( select employee_id from job_history );

--'seattle'에서 소속부서가 있는 사원들의 아이디, 이름, 부서 아이디를 조회하기 
select employee_id, first_name,department_id
from employees
where department_id in (select department_id
                    from departments
                    where location_id in (select location_id
                                        from locations
                                        where city = 'Seattle'));
-- 'Steven'의 급여보다 많은 급여를 받는 사원들의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from employees
where salary >all (select salary
                from employees
                where first_name = 'Steven');
