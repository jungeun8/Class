# Java
값의 출력 및 변수 생성값의 출력 및 변수 생성
	DispatcherServlet
		- FrontController 역할 수행
		- 모든 URL 요청을 받는다.
			1. 요청 URL을 HandlerMapping에게 보내서 해당 URL과 매핑되는 컨트롤러 혹은 요청 핸들러 메소드를 정보를 제공받는다.
			2. 해당 요청핸들러 메소드를 실행하고, ModelAndView객체를 반환받는다.
				요청핸들러 메소드의 실행은 HandlerAdapter 인터페이스가 담당한다.
			3. ModelAndView객체에서 View객체를 꺼낸다.
				View객체가 존재하지 않으면 ViewResolver를 실행해서 적절한 View객체를 제공받는다.
			4. View객체의 render()메소드를 실행해서 응답컨텐츠를 생성하게 하고, 그 응답컨텐츠를 응답으로 제공한다.
				
		
		- Web 계층에서 사용되는 객체를 생성/의존성주입/관리하는 
	          Spring Container를 생성해서 가지고 있다.
	          (HandlerMapping, ViewResolver, View, Controller,
	           Interceptor, MultipartResolver, ...)
	
	HandlerMapping 인터페이스
		- 요청URL과 컨트롤러 혹은 요청URL과 요청핸들러 메소드의 매핑정보를 분석해서 DispatcherServlet에게 제공한다.
		- 스프링은 다양한 HandlerMapping 구현체를 제공한다.
		- 기본 핸들러 매핑은 RequestMappingHandlerMapping객체다.
			* RequetMappingHandlerMapping은 
			  @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 
			  어노테이션 정보를 분석해서 요청URL과 컨트롤러 혹은 요청URL과 요청핸들러 메소드의 매핑정보를
			  알아낸다.
			작성예)
				@Controller
				public class BoardController {
					@RequestMapping(path="/board/list") 
					public String list() { ... }
	
					@RequestMapping(path="/board/detail")
					public String detail() { ... }
				}
	
				@Controller
				@RequestMapping("/board")
				public class BoardController {
					@RequestMapping(path="/list") 
					public String list() { ... }
	
					@RequestMapping(path="/detail")
					public String detail() { ... }
				}
	
				@Controller
				public class UserController {
					@GetMapping("/register")
					public String registerform() { ... }
	
					@PostMapping("/register") 
					public String registerUser() { ...}
				}
	
	HandlerAdapter
		- 실제로 Controller를 실행하는 객체다.
		- 기본 HandlerAdapter는 RequestMappingHandlerAdapter 클래스다.
		- HandlerAdapter은 컨트롤러의 요청 핸들러 메소드의 매개변수를 분석해서 적절한 값 혹은 객체를 제공한다.
		- HandlerAdapter는 컨트롤러의 요청 핸들러 메소드의 반환값을 분석해서 ModelAndView객체를 DispatcherServlet에게 제공한다.
			* ModelAndView객체는 View전달할 데이터, 응답컨텐츠를 제공하는 View객체, 뷰페이지의 이름 등을 포함하고 있다.
			
	Controller
		- 클라이언트의 요청을 처리하는 객체다.
		- 하나의 컨트롤러 클래스는 여러 개의 URL 요청을 처리할 수 있는 다수의 요청핸들러 메소드를 가질 수 있다.
		- 컨트롤러 클래스는 @Controller나 @RestController 어노테이션이 지정되어 있어야 한다.
		- 스프링의 컨트롤러는 단순한 POJO 객체다.
		- 스프링의 컨트롤러는 HttpServletRequest, HttpServletResponse, HttpSession등의 서블릿 API를 사용하지 않고도
		  요청메세지, 응답메세지, 세션처리 등을 할 수 있다.
		- 스프링 컨트롤러의 요청핸들러 메소드는 매개변수의 타입, 갯수에 대한 제한이 거의 없다.
		- 스프링 컨트롤러의 요청핸드러 메소드는 반환 타입에 대한 제한이 거의 없다.
	
	Model
		- 비즈니스 로직(업무로직)의 수행 및 View 전달할 데이터를 제공한다.
		- 혹은, View에 전달하는 데이터 그 자체를 모델이라고도 한다.
		- Service 객체나 Dao객체를 이용해서 View 전달할 데이터를 가공한다.
	
	View
		- 다양한 타입의 응답컨텐츠를 제공하는 역할을 수행한다.
		- View 인터페이스를 구현한 다양한 구현클래스가 있고, 사용자정의 구현클래스도 만들 수 있다.
		- JSP 기반의 웹 애플리케이션에서는 InternalResourceView, JstlView, RedirectView가 기본 View객체다.
			* InternalResourceView와 JstlView는 JSP로 내부이동시키는 뷰다. 즉, JSP를 실행시켜서 동적 HTML을 생성해서 응답으로 제공한다.
			* RedirectView는 재요청URL을 응답으로 제공하는 View다.
				요청 핸들러 메소드의 반환값이 "redirect:/board/list?page=1"과 같이 redirect:로 시작하면
				내부적으로 RedirectView를 사용한다.
	
	ViewResolver
		- DispatcherServlet이 컨트롤러를 실행하고 ModelAndView객체를 반환받았는데, ModelAndView객체에 
		  뷰이름만 있고 View객체가 들어있지 않은 경우 뷰 이름에 맞는 적절한 View객체를 찾아서 반환하다.
		- ViewResolver 인터페이스를 구현한 다양한 구현클래스가 있다.
		- JSP 기반의 웹 애플리케이션에서는 InternalResourceViewResolver가 기본 ViewResolver 객체다.
		- InternalResourceViewResolver은 뷰이름이 "home", "board/list", "user/info" 인 경우 각각
		  "/WEB-INF/views/home.jsp", "/WEB-INF/views/board/list.jsp", "/WEB-INF/views/user/info.jsp"로 내부이동시키는
		  InernalResourceView나 JstlView객체를 반환한다.
		- InternalResourceviewResolver는 뷰이름이 "redirect:list?page=1", "redirect:/home"인 경우 각각
	           해당 URL을 재요청URL 응답을 보내는 RedirectView객체를 반환한다.
	
	
	
	
	서블릿 등록하기
	
	########### @WebServlet어노테이션으로 서블릿 배포하기
	package com.sample.web;
	@WebServlet("/my")
	public class MyServlet extends HttpServlet {
	
		void service(request, response) { ....}
	}
	
	
	########### web.xml에서 서블릿 배포하기
	package com.sample.web;
	public class MyServlet extends HttpServlet {
	
		void service(request, response) { ....}
	}
	
	web.xml
	<!-- 
		"/my"라는 url패턴의 요청이 접수되면 "app"라는 이름을 가진 서블릿을 실행시켜라
		즉, com.sample.web.MyServlet의 service()메소드가 실행됨
	-->
	<servlet>
		<servlet-name>app</servlet-name>
		<servlet-class>com.sample.web.MyServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>app</servlet-name>
		<url-pattern>/my</url-pattern>
	</servlet-mapping>

