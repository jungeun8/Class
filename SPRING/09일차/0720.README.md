# Java

	spring mvc 웹 애플리케이션 개발하기
	1. pom.xml에 의존성 추가
		spring-webmvc 라이브러리 의존성 
		javax.servlet-api, jstl 라이브러리 의존성
		그 외, 오라클, mybatis, 커넥션풀, 롬복, 코덱, 로그출력 기타 등등
		* spring-webmvc는 mvc 패턴의 웹 애플리케이션 개발을 지원하는 스프링의 라이브러리다.
		* javax.servlet-api는 jsp작성 및 요청/응답객체, 세션객체를 사용할 때 필요할 라이브러리다.
		* jstl은 jsp에서 core태그, 국제화태그 사용하기 위해서 필요한 라이브러리다.
	2. 스프링 빈 설정파일 생성하기
		context-root.xml
			* 루트 웹 애플리케이션컨텍스트(루트 스프링 컨테이너)용 스프링 빈 설정파일이다.
			* ContextLoaderListener가 설정파일을 읽어서 스프링 컨테이너를 생성한다.
			* 업무로직 수행에 필요한 객체들이 포함된다.
	                  (커넥션풀, 트랜잭션처리, mybatis연동, DAO, ServiceImpl)
	
			<context-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/spring/context-root.xml</param-value>
			</context-param>
			<listener>
				<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
			</listener>
			* Listener클래스는 웹 이벤트가 발생했을 때 자동으로 실행되는 클래스다.
			* 웹 이벤트는 요청객체가 생성/폐기 될 때, 세션객체가 생성/폐기 될 때, 애플리케이션객체가 생성/폐기 될 때,     
				요청객체에 속성값이 저장/변경/삭제 될 때, 
				세션객체에 속성값이 저장/변경/삭제 될 때, 
				애플리케이션 객체에 속성값이 저장/변경/삭제 될 때 발생한다.
			* ContextLoaderListener은 애플리케이션객체(ServletContext)의 초기화가 완료될 때 자동으로 실행되는 리스너 클래스다.
			* 애플리케이션객체의 초기화는 Tomcat이 켜지면 시작된다.
	                  애플리케이션객체는 초기화될 때 <context-param />으로 설정한 초기화 파라미터값을 읽어간다.
					
			
		context-web-*.xml
			* 자식 웹 애플리케이션컨텍스트(Child 스프링 컨테이너)용 스프링 빈 설정파일이다.
			* DispatcherServlet이 설정파일을 읽어서 스프링 컨테이너를 생성한다.
			* 주로, 웹 요청처리에 필요한 객체들이 포함된다.
			
			<servlet>
				<servlet-name>app</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>contextConfigLocation</param-name>
					<param-value>/WEB-INF/spring/context-web.xml</param-value>
				</init-param>
				<load-on-startup>1</load-on-startup>
			</servlet>
			<servlet-mapping>
				<servlet-name>app</servlet-name>
				<url-pattern>/</url-pattern>
			</servlet-mapping>
			* Dispatcher서블릿은 <init-param />에 설정된 스프링 빈 설정 파일읽어서 스프림 컨테이너를 생성한다.
			* Dispatcher서블릿이 생성한 스프링 컨테이너들끼리는 객체를 참조할 수 없다.(서로 의존성 주입을 할 수 없다.)
	
	3. 클라이언트 요청 처리하기 
		1. 컨트롤러에 요청핸들러 메소드 구현하기
			@RequestMapping("/product/list")
			public String productList() {
				// 클라이언트의 요청을 처리하는 수행문;
			}
		2. ProductService 인터페이스에 클라이언트의 요청을 처리하기 위한 업무로직 수행 메소드를 정의하기
			public interface ProductService {
				List<Product> getAllProducts();
			}
		3. ProductServiceImpl 구현클래스에서 메소드를 재정의(메소드를 구현)한다.
			public class ProductServiceImpl implements ProductService {
				
				@Autowired
				ProductDao productDao;	// mybatis의 MapperScannerConfigurer객체가 ProductDao 인터페이스를 구현한
							// 구현객체(Proxy 빈, 매퍼인스턴스)를 스프링의 빈으로 등록하였음
	
				public List<Product> getAllProducts() {
					// 업무로직을 수행하는 수행문;
				}
			}
			* 업무로직 수행시 필요한 데이터를 엑세스하기 위해서 DAO 구현체가 필요한 경우, @Autowired 어노테이션을
			  이용해서 필요한 DAO 구현객체를 주입받는다.
		4. ProductDao 인터페이스에 필요한 데이터베이스 엑세스 작업과 관련된 메소드를 정의한다.
			public interface ProductDao {
				List<Product> selectAll();
			}
		5. ProductDao 인터페이스와 매핑된 매퍼파일에 selectAll() 구현시 필요한 SQL을 정의한다.
			<select id="selectAll" resultType="com.sample.vo.Product">
				select product_no as no,
					product_name as name,
					...
				from
					sample_products
			</select>
		* 조회작업인 경우 - "4 -> 5 -> 2 -> 3 -> 1 -> JSP" 의 순서로 개발함
		* 추가, 변경인 경우 - "JSP -> 1 -> 4 -> 5 -> 2 -> 3 -> 1"의 순서로 개발함 

