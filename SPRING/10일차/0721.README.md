# Java

	사용자 인증하기(로그인하기)
	1. 로그인 폼 요청하기
		요청방식 : GET
		요청URL : localhost/spring-mvc/login
		컨트롤러 : HomeController
	
		요청핸들러 메소드
			@GetMapping("/login")
			public String loginform() {
				return "loginform";	"/WEB-INF/views/" + loginform + ".jsp"
			}	
	
	2. 사용자 인증하기(로그인하기)
		요청방식 : POST
		요청URL : localhost/spring-mvc/login
		폼데이터 : id=hong&password=zxcv1234
		컨트롤러 : HomeController
	
		요청핸드러 메소드
			@PostMapping("/login")
			public String login(@RequestParam("id") String userId, @RequestParam("password") String userPassword) {
	
			}
	
			@PostMapping("/login")
			public String login(String id, String password) {
	
			}
	
			@PostMapping("/login")
			public String login(User user) {
	
			}
	
		데이터베이스 엑세스
			UserDao 인터페이스
				User getUserById(String userId)		// 이미 선언되어 있음
			users.xml
				<select id="getUserById" ...></select>	// 이미 작성되어 있음
	
		업무로직 구현
			UserService 인터페이스
				void login(String userId, String password);
			UserServiceImpl 구현클래스
				void login(String userId, String password) {
					// 사용자 인증처리하기
				}
		
	상품 정보 조회하기
	
	1. 전체 상품 조회하기
		요청방식 : GET
		요청URL : localhost/spring-mvc/product/list
		
		요청핸들러 메소드
		@GetMapping("/list")	
		public String products(Model model) {
			// 전체 상품정보 조회하기
			List<Product> productList = productService.getAllProducts();
	
			// 뷰(jsp 페이지)에 조회된 정보 전달하기
			model.addAttribute("products", productList);
			
			// 뷰페이지 이름 반환	prefix				   suffix
			return "product/list";	"/WEB-INF/views/" + product/list + ".jsp"
		}
		// 데이터베이스 엑세스 작업 정의
		ProductDao
			List<Product> getAllProducts();
		products.xml
			<select id="getAllProducts" resultType="com.sample.vo.Product">
	
			</select>
		// 클라이언트의 요청을 처리하기 위한 업무로직 구현
		ProductService
			List<Product> getAllProducts();
		productServiceImple
			public List<Product> getAllProducts() {
				return productDao.getAllProducts();
			}
	
	2. 상품 상세정보 조회하기
		요청방식 : GET
		요청URL : localhost/spring-mvc/product/detail?no=100
	
		요청핸들러 메소드
		@GetMapping("/detail")
		public String detail(@RequestParam("no") int productNo, Model model) {
			logger.info("조회할 상품번호: " + productNo);
	
			// 상품번호에 해당하는 상품 상품만 조회
			Product product = productService.getProductDetail(productNo);
			
			// 뷰에 조회된 정보 전달하기
			model.addAttribute("product", product);
			
			return "product/detail";  "/WEB-INF/views/" + product/detail + ".jsp"
		}
	
		ProductDao
			Product getProductByNo(int productNo)
		products.xml
			<select id="getProductByNo" parameterType="" resultType="">
	
			</select>
	
		ProductService
			Product getProductDetail(int productNo)
		ProductServiceImpl
			public Product getProductDetail(int productNo) {
				// 상품정보에 해당하는 상품정보를 조회해서 반환한다.
			}
	
	
	장바구니
		장바구니에 상품담기
			요청방식: GET
			요청URL: localhost/spring-mvc/product/addCart?no=100
			컨트롤러: ProductController
		
			요청핸들러 메소드
			@GetMapping("/addCart")
			public String addCartItem(@RequestParam("no") int productNo) {
	
			}
				
			데이터베이스 엑세스
				CartDao
					void insertCartItem(CartItem cartItem)
					CartItem getCartItem(String userId, int productNo)
					void updateCartItem(CartItem cartItem)
			업무로직
				ProductService
					void addCartItem(CartItem cartItem);	
				ProductServiceImpl
					public void addCartItem(CartItem cartItem) {
						// 업무로직 수행
						// 장바구니에 동일한 상품이 이미 저장되어 있는 경우? 갯수증가
					}
			
	
		내 장바구니 보기
	
		장바구니에서 상품삭제하기
	
		장바구니에서 선택된 상품 전부 삭제하기
	
		장바구니에서 모든 상품 삭제하기

