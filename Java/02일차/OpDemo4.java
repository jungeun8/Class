
public class OpDemo4 {
	public static void main(String[] args) {
		// 비교 연산자 
		// > >= < <= == !=
		
		int x = 3;
		int y = 4;
		
		System.out.println(x > y);    // x의 값이 y의 값보다 큰가?         f
		System.out.println(x >= y);   // x의 값이 y의 값보다 크거나 같은가?    f
		System.out.println(x < y);    // x의 값이 y의 값보다 작은가?          t
		System.out.println(x <= y);   // x의 값이 y의 값보다 작거나 같은가?    t
		System.out.println(x == y);   // x의 값이 y의 값이 같은가?           f
		System.out.println(x != y);   // x의 값이 y의 값이 같지 않은가?       t
		
		int a = 4000;
		// a의 값이 1000이상 5000이하인가?
		// System.out.println(1000 <= a <= 5000);   // 오류 
		System.out.println(1000 <= a && a <= 5000);
		
		
		// 유상수리 여부를 확인해보기 
		// 주행거리가 10만 km이상인 경우 유상수리 한다. 
		// 사용기간이 3년 이상인 경우 유상수리 한다.
		// 2가지 조건 중 하나라도 충족되면 유상수리 한다.
		int distance = 50000;
		int usedYear = 4;
		
		// 주행거리가 규정거리 이상인가?
		// 사용기간이 규정기간 이상인가?
		boolean result1 = distance >= 100000;
		boolean result2 = usedYear >= 3;
		System.out.println(result1);
		System.out.println(result2);
		System.out.println("최종판정");
		System.out.println(result1 || result2);

		
		  
	}
}
