import java.util.Scanner;

public class Example6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		/*
		 * 고객명, 고객등급, 총구매금액을 입력받는다.
		 * 고객명, 고객등급, 총구매금액, 적립포인트, 보너스포인트를 출력한다.
		 * 
		 * 등급별 적립포인트는 1등급은 5%, 2등급은 3%, 3등급은 1%이다.
		 * 보너스포인트 지급기준
		 * 		1등급 300만원 초과한 부분에 대헤서 10% 추가포인트 지급
		 * 		2등급은 150만원 초과한 부분에 대해서 5% 추가포인트 지급
		 * 		3등급은 100만원 초과한 부분에 대해서 3% 추가포인트 지급
		 * 
		 */


		System.out.println("고객명을 입력하세요");
		String name = sc.next();

		System.out.println("고객등급을 입력하세요");
		int grade = sc.nextInt();

		System.out.println("총구매금액을 입력하세요");
		int price = sc.nextInt();

		int point = 0;
		int bonusPoint = 0;

		if (grade == 1) {
			point = (int)(price*0.05);
			if (price >3000000) {
				bonusPoint = (int)((price-3000000)*0.1);
			}
		} else if (grade == 2 ) {
			point =(int) (price*0.03);
			if (price>1500000) {
				bonusPoint = (int)((price-1500000)*0.05);
			}
		} else if (grade == 3 ) {
			point = (int)(price*0.01);
			if (price>1000000) {
				bonusPoint = (int)((price-1000000)*0.03);
			}
		}	

		System.out.println("===============================================================================");
		System.out.println("고객명: " + name);
		System.out.println("고객등급:" + grade);
		System.out.println("총구매금액: " + price);
		System.out.println("적립포인트: " + point); 
		System.out.println("보너스포인: " + bonusPoint); 
		System.out.println("===============================================================================");



	}
}
		
		
		
		
		
		



