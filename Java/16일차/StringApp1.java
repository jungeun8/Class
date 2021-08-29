package string;

public class StringApp1 {

	public static void main(String[] args) {
		String a = "안녕";
		String b = "안녕";
		String c = new String("안녕");
		String d = new String("안녕");
		
		System.out.println("a == b" + (a == b));			// ture
		System.out.println("a.equals(b)" + a.equals(b));	// ture
		System.out.println("c == d" + (c == d));			// false
		System.out.println("c.equals(d)" + c.equals(d));	// true 
		// * String객체의 생성방법에 상관없이 객체가 가진 문자열이 동일하면 같은 객체로 
		//  판정하는 equals(Object obj)를 사용해서 문자열을 비교해야한다. 
	
	}

}
