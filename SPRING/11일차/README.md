# Java
값의 출력 및 변수 생성값의 출력 및 변수 생성
	@GetMapping
	public String handlerMethod(매개변수타입 매개변수) {
	
	}
	사용가능한 매개변수
		기본자료형타입(String 포함)	- 요청파라미터와 매핑되는 매개변수다.
			작성예
				@GetMapping("/search")
				handlerMethod(@RequestParam("keyword") String keyword, 
						@RequestParam(name="page", required="false", defaultValue="1") int page)
					* request.getParameter("keyword")로 획득한 값을 keyword 변수에 전달한다.
					* request.getParameter("page")로 획득한 값을 page에 전달한다.
						- 매개변수 타입이 int이기 때문에 정수형으로 변환해서 전달함.
						  (만약, 조회된 값에 정수로 변환할 수 없는 값이 포함되어 있으면 오류 발생)
						- required=false는 요청파라미터에 page라는 값이 없어도 상관없다.
						- defaultValue="1"은 요청파라미터에 page가 존재하지 않을 때 사용될 기본값이다.
					* /search				매개변수 keyword=null, page=1
					* /search?keyword=자바			매개변수 keyword=자바, page=1
					* /search?keyword=자바&page=3		매개변수 keyword=자바, page=3
					* /search?keyword=자바&page=		오류
					* /search?keyword=자바&page=가		오류
				handlerMethod(String keyword, int page)
					* handlerMethod(@RequestParam(name="keyword", required=true) String keyword,
							@RequestParam(name="page", required=true) int page)
					* /search				오류
					* /search?keyword=자바			오류
					* /search?keyword=자바&page=		오류	
					* /search?keyword=자바&page=가		오류
					* /search?keyword=자바&page=1		매개변수 keyword=자바, page=1
		사용자정의 XXXForm객체
			작성예
				@PostMapping("/register")
				handlerMethod(UserRegisterForm userRegisterForm)
					* 사용자정의 클래스가 요청핸들러 메소드의 매개변수로 지정되어 있는 경우
					  스프링은 기본생성자 메소드를 호출해서 객체를 초기화시킨다.(무조건 기본생성자가 존재해야 함)
					* Getter/Setter 메소드가 구현되어 있어야 한다.
					* 사용자정의 클래스는 다수의 요청파라미터 혹은 폼입력값을 전달받기 위해서 사용한다.
					* 사용자정의 클래스의 멤버변수명은 요청파라미터의 이름 혹은 폼입력요소의 name속성과 일치해야 한다.
		배열 혹은 List
			작성예
				@RequestMapping("/order")
				handlerMethod(int[] no, int[] amount)
					* 같은이름의 요청파라미터값이 여러개 전달되는 경우 배열 혹은 List타입의 매개변수를 지정한다.
						order?no=10&amount=1&no=34&amount=2
		사용가능한 매개변수 타입
			Servlet API		- HttpServletRequest, HttpServletResponse, HttpSession
			java.util.Locale	- 지역화정보가 포함된 객체(국가코드, 언어)
			Model, Map, ModelMap	- 뷰에 전달할 데이터를 담는 용도의 객체를 전달받을 수 있다.
			Errors, BindingResult	- 입력값 유효성 검증결과를 저장하는 객체를 전달받을 수 있다.
			SessionStatus		- 세션폼 처리시에 해당 세션을 제거하기 위해서 사용한다.
			
					
				
	
사용자정의 어노테이션과 HandlerMethodArgumentResolver
	1. 사용자정의 어노테이션 정의하기
		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.PARAMETER)
		public @interface LoginUser {

		}

	2. 어노테이션 사용하기
		@GetMapping("/my/reviewList")
		public String myReviews(@LoginUser User user) {

		}		
		@GetMapping("/product/addCart")
		public String addCartItem(@RequestParam("no") int productNo, @LoginUser User user) {

		}
		@GetMapping("/order/add")
		publc String addOrder(OrderForm orderForm, @LoginUser User user) {

		}

	3. 위와 같이 어노테이션을 사용했을 때 요청핸들러의 매개변수를 분석해서 로그인된 사용자정보를 전달하는 사용자정의 HandlerMethodArgumentResolver 구현하기

		public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

			public boolean supportsParameter(MethodParameter parameter) {
				return Objects.nonNull(parameter.getParameterAnnotation(LoginUser.class));
			}
	
			public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
				NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
				return SessionUtils.getAttribute("LOGINED_USER");
			}

		}

	4. 스프링 빈 설정 파일에 사용자정의 HandlerMethodArgumentResolver를 등록한다.
		<mvc:annotation-driven>
			<mvc:argument-resolvers>
				<bean class="com.sample.web.argumentResolver.LoginUserArgumentResolver"></bean>
			</mvc:argument-resolvers>
		</mvc:annotation-driven>

