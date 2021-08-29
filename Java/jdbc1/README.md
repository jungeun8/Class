# Java(21.05.05)
값의 출력 및 변수 생성값의 출력 및 변수 생성
데이터베이스 엑세스 작업을 수행하는 메소드

	INSERT문을 수행하는 메소드 - 새로운 데이터 저장(테이블에 새로운 행을 추가)
	public void insertProduct(Product product) { 	// 새로운 책정보가 저장된 Product객체를 전달받는다.
		// Connection획득, PreparedStatement획득
		// ?에 값 바인딩
		// SQL문 전송 및 실행(PreparedStatement객체의 int executeUpdate() 실행)
		// Connection, PreparedStatment 연결 해제
	}

	DELETE문을 수행하는 메소드 = 저장된 데이터 삭제(테이블에서 행을 삭제)
	public void deleteProduct(int productNo) {
		// Connection획득, PreparedStatement획득
		// ?에 값 바인딩
		// SQL문 전송 및 실행(PreparedStatement객체의 int executeUpdate() 실행)
		// Connection, PreparedStatment 연결 해제
	}

	UPDATE문을 수행하는 메소드 = 저장된 데이터의 값을 변경(테이블에서 기존 행의 값을 변경)
	public void updateProduct(Product product) {	// 변경할 책정보가 저장된 Product객체를 전달받는다.
		// Connection획득, PreparedStatement획득
		// ?에 값 바인딩
		// SQL문 전송 및 실행(PreparedStatement객체의 int executeUpdate() 실행)
		// Connection, PreparedStatment 연결 해제
	}

	SELECT문을 수행하는 메소드 - 조회조건에 맞는 데이터 조회(테이블에 저장된 데이터 조회)
	1. 테이블의 기본키컬럼, 고유키컬럼의 값으로 데이터를 조회하는 경우 - 한 건의 데이터만 조회됨
	public Product getProductByNo(int productNo) {
		Product product = null;
		// Connection획득, PreparedStatement획득
		// ?에 값 바인딩
		// SQL문 전송 및 실행 -> ResultSet 획득(PreparedStatement객체의 ResultSet executeQuery() 실행)
		// ResultSet 처리 
		if (rs.next()) { 
			product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setCompary(rs.getString("product_company"));
			...
		}

		return product;
	}

	2. 테이블의 기본키컬럼, 고유키컬럼이 아닌 값으로 데이터를 조회하는 경우 - 여러 건의 데이터가 조회됨
	public List<Product> getProductsByCategory(int categoryNo) {
		List<Product> products = new ArrayList<>();
		// Connection획득, PreparedStatement획득
		// ?에 값 바인딩
		// SQL문 전송 및 실행 -> ResultSet 획득
		// ResultSet 처리 
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setCompary(rs.getString("product_company"));
			...
			products.add(product);
		}
		return products;
	}
	public List<Product> getProductsByPrice(int minPrice, int maxPrice) {
		List<Product> products = new ArrayList<>();

		return products;
	}
	public List<Product> getProductsByName(String keyword) {
		List<Product> products = new ArrayList<>();

		return products;
	}
	public List<Product> getNewArrivalProducts() {
		List<Product> products = new ArrayList<>();

		return products;
	}


