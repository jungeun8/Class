
public class ForDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// 수행문을 10개 실행하기
		for (int i=0; i<10; i++) {
			System.out.println("안녕하세요");
		}

		System.out.println("=========================");

		for (int i=10; i>0; i--) {
			System.out.println("안녕하세요");
		}

		System.out.println("=========================");

		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}

		// 구구단 출력하기
		for (int i=1; i<=9; i++) {
			System.out.println("2 * " + i + " = " + 2*i);
		}


		System.out.println("=========================");

		// 합계 구하기
		// 1 ~ 100까지 합계를 구하고 출력한다.
		/*int sum = 0;
		sum += 1;
		sum += 2;
		sum += 3;
		..
		sum += 100;
		*/
		
		// 1 ~ 100까지 합계를 구하고 출력한다.
		int sum = 0;
		for (int i=1; i<=100; i++) {
			sum += i;
		} System.out.println(sum);

		



	}

}
