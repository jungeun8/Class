import java.util.Scanner;

public class Example5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 학생이름, 전자계산기, 데이터베이스, 알고리즘 점수를 입력받는다.
		 * 학생이름, 각 과목점수, 총점, 평균, 합격여부를 출력한다.
		 * 평균이 60점 이상이면 합격이다.
		 * 한 과목이라도 40점 미만인 경우는 불합격이다.
		 * 
		 */
		
		System.out.println("이름을 입력하세요");
		 String name = sc.next();
		
		System.out.println("전자계산기 점수를 입력하세요");
		int cal = sc.nextInt();
		// 스캐너객체의 next()를 실행시켜서 입력된 값을 읽어서 변수 이름에 저장한다.
		
		System.out.println("데이터베이스 점수를 입력하세요");
		int dbs = sc.nextInt();
		
		System.out.println("알고리즘 점수를 입력하세요");
		int alg = sc.nextInt();
		
		
		int total = cal + dbs + alg;
		int average = total /3;
		
	/*	if (aver >= 60){
			if(cal, dbs, alg <= 40) {
				System.out.println("불합격");
			} else { 
				System.out.println("합격");
			}	
		*/
			String result = "";
			if (average >= 60) {
				if(cal <40 || dbs< 40 || alg < 40 ) { //과목과락인경우
				result = "불합격";
			} else {
				result = "합격";
			}
			} else {
				result ="불합격";
			}
			
			
	
			
			System.out.println("===============================================================================");
			System.out.println("이름: " + name);
			System.out.println("전자계산기:" + cal);
			System.out.println("데이터베이스: " + dbs);
			System.out.println("알고리즘: " + alg);
			System.out.println("총점: " + alg);
			System.out.println("평균: " + average);
			System.out.println("시험결과: " +result);
			System.out.println("===============================================================================");
			
			
			
			
		}	
	

	}
