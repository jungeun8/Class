import java.util.Arrays;

public class ArrayDemo6 {

	public static void main(String[] args) {
		// 난수를 활용해서 로또 번호 만들기 
		// 난수는 수행문이 실행될 때마다 생성되는 임의의 숫자다.
		// 자바는 Math 클래스에 여러가지 수학연산과 관련된 기능을 가지고 있고, 
		// 난수를 생성하는 기능도 가지고 있다.
		// 난수 만들기 Math.random() 메소드를 사용해서 난수를 생성한다.
		// 0 <= Math.random() < 1 난수의 범위다.
		
		
		/*
		 * 로또번호 생성하기
		 * 1. 번호를 저장할 배열을 생성한다.
		 * 2. 중복체크가 끝난 숫자를 배열의 몇번째 칸에 저장해야 하는기 그 위치를 
		 * 	  기억하는 변수를 만든다.
		 * 3. while문을 사용해서 중복이 없는 로또번호가 만들어질 때까지 무한반복한다.  
		 * 	1) position값이 6이면 반복문을 탈출한다. 
		 * 	2) Math.random()을 이용하여 임의의 숫자(1~45)를 획득한다. 
		 * 	3) lotto 배열에 2)번에서 획득한 숫자가 저장되어 있는지 여부를 조사한다. 
		 * 	   a. lotto배열에 숫자가 존재하는지 여부를 담는 변수를 선언한다.(boolean타입의 변수)
		 * 	   b. for문을 사용해서 lotto배열에 저장된 값을 순서대로 조회해서 
		 *     c.  2)번에서 획득한 번호와 일치하는지 조사해서 일치하면 숫자존재여부를 true로 설정한다. 
		 * 	4) 저장여부를 조사했을 때 false로 판정되면, 
		 *     a. 2)번에서 획득한 숫자를 lotto배열에 position이 가르키는 위치에 저장
		 *     b. position의 값을 1증가시킨다. (숫자가 배열에 저장될 때만 position값이 1증가됨)
		 * 4. 완성된 로또번호를 출력한다. 
		 */
		
		
		//for(int i=1; i<=6; i++) {
		//int number = (int)(Math.random()*45) + 1;
		//System.out.println(number);
		//}
		
		int[] lotto = new int[6];       //1   로또용 배열 생성 
		// 숫자를 저장할 위치를 기억하고 있는 변수 
		int position = 0;              //2		중복여부 체크가 완료된 숫자가 저장될 위치를 기억하는 변수 
		while (true) {                 //3		숫자 뽑기 무한 반복 
			if (position == 6) {       //3-1)   반복문 중지여부 결정 
				break;
			}
			int number = (int) (Math.random()*45) +1;   //3-2)    난수획득 
			
														//3-3)   중복(존재)여부 조사 
			boolean isExist = false;                 //3-3).a
			for (int no : lotto) {     			//3-3).b
				if(no == number) {					//3-3).c
					isExist = true;
					break;
				}
			}
			
													//3-4)  중복여부체크가 완료된 숫자를 로또 배열에 저장 
			if(!isExist) {							// 3-4)
				lotto[position] = number;			 //3-4).a
				position++;							//3-4).b
			}
			
			
		}
		
		Arrays.sort(lotto);
		for (int x : lotto) {                     // 4
			System.out.print(x + " ");
		}
	
		
	}

}
