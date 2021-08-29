package day1;

public class ProductApp2 {

	public static void main(String[] args) {
		
		// 상품정보를 3개 저장하는 배열객체 생성하기 
		Product[] products = new Product[3];
		System.out.println("## 배열 생성 직후 배열의 각 칸에 저장된 값 출력하기");
		System.out.println("0번째 칸: " + products[0]);
		System.out.println("1번째 칸: " + products[1]);
		System.out.println("2번째 칸: " + products[2]);
		
	//	Product p1 = new Product();
	//Product p2 = new Product();
	//Product p3 = new Product();
		
		// 상품정보를 담을 수 있는 Product객체 3개 생성하기 
				Product p1 = new Product();
				p1.no = 100;
				p1.category = "식품";
				p1.name = "홍길동";
				p1.maker = "kop";
				p1.price = 10000;
				p1.isSoldOut = false;
				
				Product p2 = new Product();
				p2.no = 100;
				p2.category = "노트북";
				p2.name = "그램";
				p2.maker = "ko";
				p2.price = 5300;
				p2.isSoldOut = false;
				
				Product p3 = new Product();
				p3.no = 100;
				p3.category = "스마트워치";
				p3.name = "애플워치";
				p3.maker = "koq";
				p3.price = 30000;
				p3.isSoldOut = false;

		System.out.println("##참조 변수가 참조하는 객체의 정보 출력하기");
		System.out.println("p1이 참조하는 객체: " + p1);
		System.out.println("p2이 참조하는 객체: " + p2);
		System.out.println("p3이 참조하는 객체: " + p3);
		
		// 배열의 0번째 칸부터 2번째 칸에 생성된 Product객체를 저장하기 
		products[0] = p1;		//p1참조변수가 참조하는 객체의 주소값을 배열의 0번째 칸에 대입함
		products[1] = p2;		//p2참조변수가 참조하는 객체의 주소값을 배열의 1번째 칸에 대입함
		products[2] = p3;		//p3참조변수가 참조하는 객체의 주소값을 배열의 2번째 칸에 대입함
		
		System.out.println("## 배열의 각 칸에Product객체를 저장한 후 각 칸에 저장된 값 출력하기");
		System.out.println("0번째 칸: " + products[0]);
		System.out.println("1번째 칸: " + products[1]);
		System.out.println("2번째 칸: " + products[2]);
		
		
		// 모든 상품의 이름을 화면에 출력하기 
		Product px = products[0];		//products배열의 0번째 칸에 저장된Product객체의 주소값을px에 대입
		Product py = products[1];		//products배열의 1번째 칸에 저장된Product객체의 주소값을py에 대입
		Product pz = products[2];		//products배열의 2번째 칸에 저장된Product객체의 주소값을pz에 대입
		System.out.println("### 배열에 각 칸에 저장된 Product객체의 상품이름을 출력하기");
		System.out.println("0번째 칸에 저장된 상품객체의 이름: " + px.name);
		System.out.println("1번째 칸에 저장된 상품객체의 이름: " + py.name);
		System.out.println("2번째 칸에 저장된 상품객체의 이름: " + pz.name);
		System.out.println("0번째 칸에 저장된 상품객체의 이름: " + products[0].name);
		System.out.println("1번째 칸에 저장된 상품객체의 이름: " + products[1].name);
		System.out.println("2번째 칸에 저장된 상품객체의 이름: " + products[2].name);
		
		// 모든 상품의 이름을 향상된 for문을 사용해서 출력하기 
	/*	for(Product x : products) {   // products --> [#222, #333, #444]
			System.out.println(x.name);		//x에는 #222,  #222로 참조되는 객체의 name값이 출력된다. 
		}
		{
			System.out.println(x.name);		//x에는 #333, #333로 참조되는 객체의 name값이 출력된다. 
		}
		{
			System.out.println(x.name);		//x에는 #444, #444로 참조되는 객체의 name값이 출력된다. 
		}
	*/	
		for(Product x : products) {		// x에는 products 배열에 저장된 Product객체의 주소값이 순서대로  
		//	System.out.println(x.name);
			String productName = x.name;
			int productPrice = x.price;
			int productStock = x.stock;
			System.out.println(productName + "," + productPrice + "," + productStock);
			
		}
		
		
		
		
	}

}
