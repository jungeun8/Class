# HTML(21.05.25)
mybatis
	- SQL Mapper Framework
	- SQL 실행에 필요한 객체와 SQL  실행 후 조회된 데이터를 저장할 객체을 매핑하면
          PreparedStatement처리와 ResuletSet처리에서 자동으로 값을 매핑시켜서 SQL를 실행한다.
	
	- mybatis의 내장 타입 별칭
		Integer -> int, Long -> long, Double -> double, String -> string,
		Date -> date, Map -> map, HashMap - > hashmap, ArrayList -> arraylist
		BigDecimal -> bigdecimal

	- mapper 파일 작성 규칙
		* select 쿼리
			<select id="쿼리 식별자" parameterType="전체클래스명 혹은 별칭" 
						resultType="전체클래스명 혹은 별칭">
				SELECT 구문
			</select>
		* insert 쿼리
			<insert id="쿼리 식별자" parameterType="전체클래스명 혹은 별칭">
				INSERT 구문
			</insert>
			
			<insert id="쿼리 식별자" parameterType="전체클래스명 혹은 별칭">
				<selectKey keyProperty="조회된 값이 저장될 필드명" 
					   resultType="조회된 값의 타입" 
					   order="selectKey구문의 실행 순서(BEFORE, AFTER 중 하나)">
					PK로 사용할 값을 조회하는 구문
				</selectKey>
				INSERT 구문
			</insert>
			* Primary Key를 조회해서 먼저 필드에 저장하고 insert 작업을 실행
			* insert작업이 종료되면 객체의 필드에 시퀀스값이 저장되어 있다.
			
			작성예)
			Order order = new Order();
			order.setUserNo(user.getNo());
			order.setCreateDate(new Date());	
			---------------------------------------> Order [no=0, userNo=20, creatDate=2020-01-20]

			<insert id="insertOrder" parameterType="Order">
				<selectKey keyProperty="no" 
					   resultType="int" 
					   order="BEFORE">
					select bookstore_orders_seq.nextval from dual					
				</selectKey>
				insert into (order_no, user_no, create_date)
				values (#{no}, #{userNo}, #{createDate})
			</insert>
			orderDao.insertOrder(order);
			---------------------------------------> Order [no=100, userNo=20, creatDate=2020-01-20] 
			OrderItem item = new OrderItem();
			item.setOrderNo(order.getNo());	// 시퀀스로 획득한 값이 Order에 저장되어 있기 때문에
			item.setBookNo(100000)		// 현재 저장된 주문번호가 필요하면 Order객체에서 조회하면 된다.
			item.setAmount(2);

		* ${} 표현식을 사용한 문자열 대체하기
			- #{}표현식은 SQL구문의 ?에 값을 셋팅할 때 사용한다.
			- #{}표현식은 SQL의 키워드, 테이블명, 컬럼명 등의 자리에 사용할 수 없다.
			- ${}표현식은 SQL의 키워드, 컬럼명의 자리에 사용해서 그 문자열을 대체할 수 있다.
			- ${}표현식은 SQL 구문에서 조회 결과에 영향을 미치지 않는 
                          order by 절에서 정렬대상 컬럼명이나 정렬방식을 지정할 때만 사용하자.
			- 작성예
				<select id="getAllBooks" parameterType="map" resultType="Book">
					select *
					from bookstore_books
					order by ${columnName} ${sortType}
				</select>

	- 다이나믹 SQL
		* mybatis는 ibatis나 다른 SQL Mapper 프레임워크보다 훨씬 강력한 동적 SQL 작성기능을 제공한다.
		* mybatis의 동적 SQL 관련 태그는 JSTL의 태그와 사용법이 유사하다.
		* 태그 종류
			- if 태그
			<if test="조건식">
				조건식의 결과가 참인 경우 실행될 SQL 구문
			</if>
			* if 태그 사용시 주의점
				문자열 비교에서 한 글자 비교는
				<if test='grade == "A"'>와 같은 형식으로 조건식을 작성한다.
			* 두 개 이상의 조건식을 사용될 때는 논리연산자가 필요하다.
				논리연산자는 and나 or로 표시하면 된다.
			- choose, when, otherwise 태그
			<choose>
				<when test="조건식1">
					조건식1의 결과가 참인 경우 실행될 SQL 구문
				</when>
				<when test="조건식2">
					조건식2의 결과가 참인 경우 실행될 SQL 구문
				</when> 
				<otherwise>
					제시된 조건을 만족하지 못할 경우 실행될 SQL 구문
				</otherwise>
			</choose>
			- foreach  태그
			<foreach index="인덱스" 
				 item="변수명" 
				 collection="프로퍼티명"
				 separator="구분문자"
				 open="반복시작 전 표시할 내용"
				 close="반복종료 후 표시할 내용">
					#{변수명}
			</foreach>
			* collection에는 배열, List, Set과 같이 반복할 대상이 위치한다.
			* index는 현재 조회된 값의 index값이 전달된다.
			* item에 지정된 변수에 값이 순서대로 하나씩 전달된다.
			
			- where 태그
			<where>
				if태그, choose,when,otherwise 등의 태그를 포함하고 있다.
			</where>
			* <where>태그 내부에서 동적 SQL의 실행결과로 SQL이 반환되면 where태그를 추가한다.
				<where> 태그를 사용하면 아래와 같은 경우가 방지할 수 있다.
					select *
					from tables
					where
			
			* <where>태그 내부에서 동적 SQL의 실행결과로 반환된 SQL에 'and'나 'or'가 있으면 지워버린다.
				아래의 동적쿼리에서 startDate가 null이고 endDate가 null이 아닌경우
				아래와 같은 경우일 때 and를 제거한다.
					select *
					from tables
					where 
						and event_date <= '2019-12-31'
				<where>
					<if test="startDate != null">
						event_date >= #{startDate}
					</if>
					<if test="endDate != null">
						and event_date <= #{endDate}
					</if>
					<if test="eventType != null">
						and event_type = #{eventType}
					</if>
				</where>
			- set 태그
			  * update 구문에서 사용되는 태그다.
			  * update 항목들이 동적 SQL로 작성되어 있는 경우에만 사용하자.
			  * update 항목의 맨 마지막 항목에 ,가 있으면 자동으로 제거한다.
				update bookstore_user
				<set>
					<if test="point > 0">      
						user_point = #{point},
					</if>
					<if test="grade != null">   
						user_grade = #{grade},
					</if>
					<if test="filename != null"> 
						user_image_filename = #{filename},
					</if>
					<if test="enabled != null">
						user_enabled = #{enabled}
					</if>
				</set>
				where
					user_no = #{no}

	- 두 개 이상의 테이블을 조인하는 경우
		* <resultMap/> 태그를 사용해서 조인결과를 VO객체와 매핑할 수 있다.
		* 작성예
			<resultMap id="식별자" type="클래스의 별칭 혹은 클래스의 전체이름">
				<id property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
				<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
				<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
				<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
				<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
				<association property="객체의 변수명" javaType="클래스의 별칭 혹은 클래스의 전체이름">
					<id property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
					<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
					<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
				</assocication>
				<collection property="객체의 변수명" ofType="클래스의 별칭 혹은 클래스의 전체이름">
					<id property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
					<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
					<result property="객체의 변수명" column="컬럼명 혹은 컬럼의 별칭" />
				</collection>
			</result>
		* <resultMap/> 태그에서 <id />는 Primary Key 값에 해당하는 컬럼을 매핑할 때 사용한다.
		  나머지 <result/>는 일반 컬럼들을 매핑할 때 사용한다.
		* <resultMap/> 태그에서 <association>은 복잡한 타입(객체의 하나)의 연관관계를 매핑한다.
		* <resultMap/> 태그에서 <collection>은 복잡한 타입의 콜렉션에 대한 연관관계를 매핑한다.
		* 작성예
			class Dept {			class Manager {			class Emp {
				int id;				int id;				int id;
				String name;			String name;			String firstName;
				Manager mgr;		}				}
				List<Emp> employees;						
			}								
			
			* 부서정보 + 관리자정보 + 소속사원들
			<resultMap id="DeptDetail" type="Dept">
				<id property="id" 	column="dept_id" />
				<result property="name" column="dept_name"/>
				<association property="mgr" javaType="Manager">
					<id property="id" 	column="mgr_id" />
					<result property="name"	column="mgr_name"/>
				</association>
				<collection property="employees" ofType="Emp">
					<id property="id"		column="emp_id"/>
					<result property="firstName"	column="emp_name"/>
				</collection>
			</resultMap>
			<select id="complexSql" parameterType="int" resultMap="DeptDetail">
				select
					A.department_id			dept_id,
					A.department_name		dept_name,
					B.employee_id			mgr_id,
					B.first_name			mgr_name,
					C.employee_id			emp_id,
					C.first_name			emp_name	
				from departments A, employees B, employees C
				where A.manager_id = B.employee_id
				and A.department_id = C.department_id
				and A.department_id = #{value}
			</select>
				

spring-mybatis 연동하기
	1. pom.xml에 의존성 추가하기
		mybatis, mybatis-spring 의존성 추가
	2. /META-INF/mybatis 폴더 생성하기
		/META-INF/mybatis/mybatis-config.xml 추가
			* NULL값 추가 설정
			* TypeAlias 설정
		/META-INF/mybatis/mappers폴더 추가
	3. Dao 인터페이스 추가
		kr.co.jhta.xxx.dao 패키지에 xxxDao 인터페이스 추가
			* xxxDao 인터페이스는 각각의 테이블에 대한 CRUD작업을 정의한다.
	4. /META-INF/mybatis/mappers 폴더에 매퍼파일 추가
		* xxxDao 하나당 매퍼파일 하나를 생성한다.
		* 매퍼파일의 <mapper namespace="xxxDao의 전체이름">으로 작성한다.
		* 매퍼파일의 sql 구문 식별자(id)는 xxxDao의 메소드명과 반드시 일치해야 한다.
		* 매퍼파일의 sql 구문에서 parameterType과  resultType은
		  xxxDao의 메소드의 메소드 인자타입, 반환값과 일치해야 한다.
		  (단, 반환값이 List<클래스타입> 인 경우는 resultType에 클래스타입만 적는다.)
	5. bean configuration 파일 설정하기
		* DataSource 빈 등록
		* SqlSessionFactory 빈 등록 <--- SqlSessionFactoryBean을 이용해서 등록
			<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				<property name="dataSource" ref="dataSource"></property>
				<property name="configLocation" value="classpath:/META-INF/mybatis/mybatis-config.xml" />
				<property name="mapperLocations" value="classpath:/META-INF/mybatis/mappers/*.xml" />
			</bean>
			* ConnectionPool, mybatis 환경설정 파일, mybatis 매퍼파일 경로 주입
		
		* MapperScannerConfigurer 빈 등록
			<mybatis-spring:scan base-package="kr.co.jhta.xxx.dao" 
						 factory-ref="sqlSessionFactory"/>
			* base-package는 xxxDao 인터페이스가 정의되어 있는 패키지를 지정한다.
			* factory-ref에는 mybatis의 핵심객체 SqlSessionFactory를 주입한다.
			* <mybatis-spring:scan> 태그는 MapperScannerConfigurer을 스프링의 빈으로 등록한다.
			* MapperScannerConfigurer은 base-package로 지정된 패키지에서 
                          xxxDao 인터페이스를 전부 스캔해서 xxxDao 인터페이스에 대한 
			  구현객체를 자동으로 생성하고, 생성된 구현객체를 스프링의 빈으로 등록한다.
			* 스프링의 빈으로 등록된 구현객체들은 xxxDao 인터페이스 타입으로 주입받을 수 있다.
	6. xxxServiceImpl에서 xxxDao 주입받기
			@Service
			public class xxxServiceImpl implements xxxService {
				@AutoWired
				xxxDao dao;	// xxxDao인터페이스 타입의 필드를 정의하고
						// @AutoWired 어노테이션을 부착해두면
						// 스프링 컨테이너는 보유하고 있는 빈들 중에서
						// xxxDao 타입의 객체를 주입한다.
				// xxxDao 타입의 객체는 MapperScannerConfigurer이 구현해서 등록한 객체다. 
				
			}
		

