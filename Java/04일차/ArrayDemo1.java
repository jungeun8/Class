
public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * int[] numbers = new int[5];
		 *	new int[5]  정수 다섯개를 저장할 수 있는 칸을 가진 배열객체를 생성한다.
		 *	int[] numbers  정수배열객체의 주소값을 담는 변수 numbers를 생성한다.
		 *
		 *	int[] numbers = new int[5];
		 *	정수 5개를 저장할 수 있는 베열객체를 생성하고, 그 배열객체의 주소값을 변수 numbers에 
		 *	대입한다.
		 *	numbers 변수는 생성된 배열객체를 참조하는 주소값으 가진 변수(저장소)이다.
		 *
		 *
		 */		

		int[] numbers = new int[5];
		double[] points = new double[5];
		String[] names = new String[5];

		// 배열의 각 저장소에 들어있는 값 출력해보기
		// 해당 치에 저장된 값  <-- 배열명[인덱스]
		int x0 = numbers[0];
		int x1 = numbers[1];
		int x2 = numbers[2];
		int x3 = numbers[3];
		int x4 = numbers[4];

		System.out.println(x0);
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);
		System.out.println(x4);

		double y0 = points[0];
		double y1 = points[1];
		double y2 = points[2];
		double y3 = points[3];
		double y4 = points[4];

		System.out.println(y0);
		System.out.println(y1);
		System.out.println(y2);
		System.out.println(y3);
		System.out.println(y4);

		String s1 = names[0];
		String s2 = names[1];
		String s3 = names[2];
		String s4 = names[3];
		String s5 = names[4];


		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);


		//값을 나열해서 배열객체 생성하기
		int[] scores = {80, 60, 100};
		String[] categories = {"뉴스", "연예", "스포츠", "자동차", "쇼핑"};

		int score1 = scores[0];
		int score2 = scores[1];
		int score3 = scores[2];
		System.out.println(score1);
		System.out.println(score2);
		System.out.println(score3);

		String category1 = categories[0];
		String category2 = categories[1];
		String category3 = categories[2];
		String category4 = categories[3];
		String category5 = categories[4];

		System.out.println(category1);
		System.out.println(category2);
		System.out.println(category3);
		System.out.println(category4);
		System.out.println(category5);

		// 배열의 값을 변경하기
		// 배열명[인덱스] = 새로운 값 <-- 배열의 지정된 위치는 값이 새로운 값으로 변경된다.
		int[] balances = new int[3];
		String[] depts = new String[3];
		String[] subjects = {"국어", "영어", "수학"};


		balances[0] = 1000000;
		balances[2] = 23000;

		depts[0] = "전자공학과";
		depts[1] = "컴퓨터공학과";
		depts[2] = "통계학과";

		subjects[2] = "수학2";

		//for문을 이용해서 배열의 값 출력하기 
		for (int i=0; i<3; i++) {
			String deptName = depts[i];
			System.out.println("학과명: " + deptName);
			// 한 번더 넣어주지 않고, 이런 방식으로도 가능하다. 	System.out.println("학과명: " + depts[i]);


		}


		for (int i=0; i<3; i++){
			int amount = balances[i];
			System.out.println("잔액: " + amount);
		}




		for (int i=0; i<3; i++) {
			String subname = subjects[i];
			System.out.println("과목 " + subname);




		}



	}

}
