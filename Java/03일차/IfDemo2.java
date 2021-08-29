
public class IfDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// if ~ else if ~ else if ~ else 문을 사용하면
		// 다양한 조건을 제시해야하는 조건문을 작성할 수 있다.
	
	
	
		 /* 91점 이상이면 "A", 81점 이상이면 "B", 71점 이상이면 "C"
		 * 61점 이상이면 "D", 60점 이하는 "F"를 출력한다.
		 */
		
       	int score = 81;
	
		if (score >= 91) {
			System.out.println("A학점");
		}
		if (score >= 81) {
			System.out.println("B학점");
		}
		if (score >= 71) {
			System.out.println("C학점");
		}
		if (score >= 61) {
			System.out.println("D학점");
		}
		if (score <= 60) {
			System.out.println("F학점");
		}
		
	}

}
