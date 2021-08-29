
public class ForDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		// for문에 내포된 if문
		// 1~10사이의 정수중에서 홀수만 출력하기 
		for (int i=1; i<=10; i++) {
			if (i%2 == 1) {
				// i값을 2로 나눈 나머지가 1인 경우에만 실행되는 수행문 
			}
			System.out.println(i);
		}

		// 1 ~ 10사이의 정수 중에서 짝수의 총합을 계산하고, 그 결과를 출력하기 
		int sum = 0;
		for(int i=1; i<=10; i++) {
			if (i%2 == 0) {
				// i값을 2로 나눈 나머지가 0일 경우에만 sum에 i값을 더한다.
				sum += i;
			}
		}
		System.out.println("합계: "+ sum);
		// 1 ~ 10사이의 정수 중에서 홀수의 총합과 짝수의 총합을 계산하고. 그 결과를 출력하기 
		int oddSum = 0;
		int evenSum = 0;
		for (int i=1;i<=10; i++) {
			if(i%2 == 0) {
				//짝수의 값을 evenSum에 더하기 
				evenSum += i;
			} else {
				// 홀수를 oddSum에 더하기
				oddSum += i;
			}

		}

		System.out.println("짝수의 합: " + evenSum);
		System.out.println("홀수의 합: " + oddSum);
	}

	}


	





