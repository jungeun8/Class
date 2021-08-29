-- 부서아이디, 부서명, 부서관리자아이디, 부서관리자 이름 조회하기 
-- 부서아이디, 부서명, 부서관리자아이디 - departments
-- 부서관리자 이름 - employees 
select D.department_id, D.department_name, D.manager_id, E.first_name
from departments D, employees E
where D.manager_id = E.employee_id
order by D.department_id asc;

-- 포괄 조인을 활용하면, employees테이블과 매칭되지 않는 departments의 부서정보도 조회할 수 있다.
select D.department_id, D.department_name, D.manager_id, E.first_name
from departments D, employees E
where D.manager_id = E.employee_id(+)
order by D.department_id asc;

-- 커미션을 받는 사원들의 사원아이디, 이름, 소속부서아이디, 소속부서명 조회하기 
select E.employee_id, E.first_name, E.department_id, D.department_name
from employees E, departments D
where E.department_id = D.department_id(+)
and E.commission_pct is not null
order by E.employee_id;

-- 90범 부서에 소속된 사원들의 사원 아이디, 이름, 해당 사원의 상사의 이름을 조회하기 
select 사원.employee_id, 사원.first_name, 상사.first_name
from employees 사원, employees 상사
where A.department_id = 90
and 상사.employee_id(+) = 사원.manager_id;

-- 오라클조인과 ANSI-조인
-- 90번 부서에서 소속된 사원들의 아이디, 이름, 직종아이디 직종제목 조회하기 
select E.employee_id, E.first_name , J.job_id, J.job_title
from employees E, jobs J
where E.department = 90
and E.job_id = J.job_id;

-- ANSI- 조인 
select E.employee_id, E.first_name , J.job_id, J.job_title
from employees E join jobs J on E.job_id = J.job_id 
where E.department_id = 90;

-- 90번 부서에 소속된 사원의 아이디, 이름, 직종아이디, 직종제목, 소속부서 아이디, 소속부서명 조회하기
-- 사원의 아이디, 이름, 직종아읻, 소속부서아이디 - employees
-- 직종아이디, 직종제목 - jobs
-- 소속부서아이디, 소속부서명 - departments
select e.employee_id, e.first_name, j.job_id, d.department_id, d.department_name
from employees E, jobs J, departments D
where e.department_id = 90
and E.job_id = J.job_id
and E.department_id = d.department_id;

select e.employee_id, e.first_name, j.job_id, d.department_id, d.department_name
from employees E join jobs J on E.job_id = J.job_id
                join departments D on e.department_id = D.department_id
where E.department_id = 90;

-- 90번 부서에 소속된 사원의 아이디, 이름, 급여, 급여등급을 조회하기
select E.employee_id, E.first_name, e.salary, s.grade
from employees E, salary_grade S
where E.department_id = 90
and E.salary >= S.min_salary and E.salary <= S.max_salary;

select E.employee_id, E.first_name, e.salary, s.grade
from employees E join salary_grade S on E.salary >= s.min_salary and E.salary <= s.max_salary
where E.department_id = 90;

-- 부서아이디, 부서명, 부서담당자 아이디, 부서담당자 이름 조회하기 
-- 부서담당자가 결정되어 있지 않은 부서도 조회한다.
select D.department_id, D.department_name, D.manager_id, E.first_name
from departments D, employees E
where d.manager_id = e.employee_id(+);

select D.department_id, D.department_name, D.manager_id, E.first_name
from departments D left outer join employees E on d.manager_id = e.employee_id;
-- left outer join : 선행테이블의 모든 행이 조회되도록 한다. 

select  D.department_id, D.department_name, D.manager_id, E.first_name
from employees E right outer join departments D on d.manager_id = e.employee_id;
-- right outer join : 후행테이블의 모든 행이 조회되도록 한다. 

create table sample_books(
    book_no number(4),
    book_title varchar2(200),
    book_writer varchar2(100),
    book_price number(8),
    book_discount_price number(8),
    book_stock number(4),
    book_created_date date 
);

-- 테이블에 새로운 행 추가하기 

-- 행의 모든 칼럼의 값을 지정해서 추가하기
insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
values
(101, '자바의 정석', '남궁성', 35000, 29000, 1000, sysdate);

-- 행의 특정 칼럼에만 값을 지정해서 추가하기, 생략된 칼럼에는 null값이 저장된다. 
insert into sample_books
(book_no, book_title, book_price, book_created_date)
values
(102, '이것이 자바다', 28000, sysdate);

-- 행을 추가할 때 행의 모든 칼럼에 값을 추가하고, 칼럼의 순서 그대로 값을 추가할 때는
-- 컬럼명을 생략할 수 있다.
insert into sample_books
-- (book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
values(103, '이것은 데이터분석이다', '윤기태', 28000, 26000, 100, sysdate);

insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
values
(104, '스프링 인 액션', '미상', 30000, 27000, 20 );

-- 테이블에 저장된 데이터 삭제하기 

-- 테이블에 저장된 모든 데이터 삭제 
delete from sample_books;

-- 테이블에 저장된 데이터 중에서 특정 행을 삭제하기 
delete from sample_books
where book_title like '&자바&';

delete from sample_books
where book_no = 103;

delete from sample_books
where book_no = 104;

-- 테이블에 저장된 데이터 변경하기 

-- 테이블의 모든 행에 대해서 book_price 칼럼의 값을 10000으로 변경하기 
update sample_books
set
    book_price = 10000;
    
-- 테이블의 특정 행에 대해서 book_price 칼럼의 값을 32000으로 변경하기 
update sample_books
set
    book_price = 32000
where
    book_no = 101;

update sample_books
set
    book_writer = '신용권',
    book_price = 35000,
    book_discount_price = 31500,
    book_stock = 50
where
    book_no = 102;
    
--(book_no, book_title, book_writer, book_price, book_discount_price, book_stock, book_created_date)
-- sample_books 테이블에 새로운 책 정보 추가하기 (3개 이상)
insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
values
(105, '정보처리기사', '윤영빈', 27000, 23000, 10 );

insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
values
(106, '정보처리산업', '서용욱', 14000, 13000, 23 );

insert into sample_books
(book_no, book_title, book_writer, book_price, book_discount_price, book_stock)
values
(107, '혼자 공부하는 자바', '김학배', 30000, 25000, 7 );

delete from sample_books;

select*
from sample_books;




