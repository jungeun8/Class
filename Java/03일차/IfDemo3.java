import java.util.Scanner;
public class IfDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		/*
		 *  내포된 if문 사용하기
		 *  고객명, 고객등급(1, 2, 3중 하나), 총구매금액 입력받는다.
		 *  고객등급이 1등급인 경우, 총구매금액의 3%를 적립포인트로 지급한다.
		 *  단, 총구매금액이 100만원을 초과하는 경우, 100만원을 제외한 나머지 금액에 대해서는 5%를 적립한다.
		 *  그 외는 총구메금액에 관계없이 총구매금액의 1%를 적립포인트로 지급한다.
		 *  
		 *  고객명, 고객등급, 총구매금액, 적립포인트를 출력한다.
		 */
		
		System.out.println("고객명을 입력하세요");
		String name = sc.next();
		
		System.out.println("고객등급을 입력하세요");
		int grade = sc.nextInt();
		
		System.out.println("총구매금액을 입력하세요");
		int totalPrice = sc.nextInt();
		
		int point = 0; 
		int bonusPoint = 0;
		
		if (grade == 1) {
			if (totalPrice > 1000000) {
				//1등급이고, 구매금액이 100만원 초과인 경우
				//100만원까지는 3%, 그 이후금액은 5%적립
			bonusPoint = (int) ((totalPrice - 1000000)*0.05);
			point =	bonusPoint + 30000;
			} else {
				// 1등급이고, 구매금액이 100만원 이하인 경우
				// 3%적립 
				 point = (int) (totalPrice*0.03);
			}
			
		} else {
			// 1등급이 아닌 경우 
			// 1%적립
			point = (int) (totalPrice*0.01);
		}
		
		
		System.out.println("===============================================================================");
		System.out.println("고객명: " + name);
		System.out.println("고객등급:" + grade);
		System.out.println("총구매금액: " + totalPrice);
		System.out.println("적립포인트: " + point);
		System.out.println("보너스포인: " + bonusPoint);
		System.out.println("===============================================================================");
		
		
	}

}
