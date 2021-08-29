import java.util.Scanner;
public class Example4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 고객이름, 고객등급(1, 2, 3 중 하나다), 누적구매횟수, 당총구매금액을 입력받는다.
		 * 고객이름, 고객등급, 누적구매횟수, 당일총구매금액, 적립포인트, 사은품지급여부를 출력한다.
		 * 적립포인트는 1등급고객의 경우 당일구매금액의 3%고, 나머지는 1%이다.
		 * 사은품지급여부는 등급이 1등급이건, 누적구매횟수가 5회이상이거나, 당일총구매금액이 30만원이상이면 
		 * 사은품지급대상이다. (사은품지급여부는 "지급대상임", "지급대상아님"으로 출력한다.)
		 * 
		 * 적립포인트와 사은품지급여부를 계산할 때는 조건식 ? 값1 : 값2 조건 연산자를 사용하세요.
		 * 조건 연산자의 조건식은 true/false가 최종연산결과로 나오는 비교연산자, 논리연산자를 사용한다.
		 */
		
		
		
		// 고객이름을 입력하세요를 출력한다.
		System.out.println("고객이름 입력하세요");
		// 고객이름을 읽어서 변수에 저장한다.
		 String name = scanner.next();
		 
		// 고객등급을 입력하세요를 출력한다.
		 System.out.println("고객등급 입력하세요");
		// 고객등급을 읽어서 변수에 저장한다.
		 int grade = scanner.nextInt();
		 
		// 누적구매횟수를 입력하세요을 출력한다.
		 System.out.println("누적횟수 입력하세요");
		// 누적구매횟수를 읽어서 변수에 저장한다.
		 int totalOrderCount =  scanner.nextInt();
		
		// 당일총구매금액을 입력하세요를 출력한다.
		 System.out.println("당총구매금액 입력하세요");
		// 당일총구매금액을 읽어서 변수에 저장한다.
		 int price = scanner.nextInt();
		
		// 당일총구매금액과 적립률 포인트를 계산해서 변수에 저장한다.
		 System.out.println("당총구매금액 입력하세요");
		// 포인트는 1등급인 경우와 아닌 경우로 구분해서 계산한 다음 변수에 저장한다.
		double point = grade == 1 ? price * 0.03 : price * 0.01;
		//만약에 int로 사용하고 싶은 경우
		//int point = (int) (grade == 1 ? price * 0.03 : price * 0.01;)
			
		 
		// 사은품지급대상인지 여부를 판정해서 변수에 저장한다.
		// 위에서 제시한 사은품지급대상일 경우만 "지급대상"임을, 아닌 경우에는 "지급대상아님"이 변수에 저장된다.
		boolean result = grade == 1 || totalOrderCount >=5 || price >= 300000;
			String gift = result ? "지급대상임" : "지급대상이 아님";
				
		// 모든 내용을 출력한다.
		
			System.out.println("고객명 : " + name);
			System.out.println("고객등급 : " + grade);
			System.out.println("방문횟수 : " + totalOrderCount);
			System.out.println("포인트 : " + point);
			System.out.println("사은품: " + gift);
		
		 
		 
		 
		
		/* System.out.println("고객이름 입력하세요");
		 String name = sc.next();
		System.out.println("고객등급 입력하세요");
		 grade = sc.nextInt();
		System.out.println("누적횟수 입력하세요");
		int count = sc.nextInt();
		System.out.println("당총구매금액 입력하세요");
		int price = sc.nextInt();
		
		int point = grade > 1 ? 
		
		*/
		 
		 
		 
	}

}
