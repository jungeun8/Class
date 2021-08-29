# Java
값의 출력 및 변수 생성값의 출력 및 변수 생성
Dao 개발 가이드 
	- Com.sample.dao 패키지에 dao 클래스를 정의한다.
	- 작성예
		○ @Repasitory
		Public class xxxDao{
			@Autowired
			JdbcTepmlate jdbcTemplate;
			
			// CURD 메소드 
		}
		
Spring-mybatis 연동하기
	1. Mybatis.jar, mybatis-spring.jar 라이브러리 의존성을 pom.xml에 추가
	  mybatis.jar : SQL Mapper Frameword
	 mybatis-spring.jar : mybatis와 spring framwork의 연동을 지원
 2. 매퍼 인터페이스 정의하기 
	테이블에 대한 CRUD 작업을 정의한 인터페이스다.
	작성예) 
		Package com.sample.dao;
		Public interface UserMapper{
			Void insertUsesr(User user);
			Void updateUser(User user);
			User getUserById(String userId);
		}
		• DAO 클래스에 대한 인터페이스 버전이다. 
 3. 매퍼 파일 정의하기 
	CRUD작업에 대한 SQL을 정의한 xml 파일이다.
	Dao에 있는 내용이 무조건 xml에 있어야한다.
	작성예)
		Users.xml
		<mappers namespace="무조건 dao의 전체이름 즉, 패키지 이름이어야한다. Ex) com.sample.dao.UserMapper">
			<insert id="insertUser" parameterType="com.sample.vo.User">
				SQL작성
			</insert>
			<update id="updateUser" parameterType="com.sample.vo.Usesr">
				SQL작성
			</update>
		</mappers>
	4. Mybatis-config.xml파일 정의
		Mybatis 환경설정 정보 정의하는 파일이다.
	5. Spring과 mybatis 연동시키기
		- sqlsessionFactory를 스프링 컨테이너의 빈으로 등록하기 
		- MapperScannerConfigurer를 스프링 컨테이너의 빈으로 등록하기 
			매퍼 인터페이스에 대한 구현객체를 생성하고, 그 객체를 스프링 컨테이너에 포함시킨다.
Mybatis의 주요 Api
	SqlsessioinFactoryBuilder.   -mybatis의 핵심 객체인 SqlSessionFactory를 생성한다.
	SqlsessioinFactory.   - sqlsession(CRUD 기능 지원)을 제공한다.
	Sqlsessioin             - CRUD기능을 제공한다.
	Mapper 인터페이스 - 테이블에 대한 CRUD기능이 정의된 인터페이스다.
	Mapper 파일         - 테이블 대상으로 실행할 SQL이 정의된 파일이다.
	Mapper 인스턴스 - SqlSession이 Mapper인터페이스와 Mapper 파일을 이용
					Mapper 인터페이스의 구현객체를 생성하고, 스프링 빈으로 등록한다.
	Public class UserService{
		Public void addNewUser(User user)
		Sqlsession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		usesrMapper.insertUser(user);
		}
	}
	
	**매퍼인터페이스파일, 메퍼파일 무조건 1대1

