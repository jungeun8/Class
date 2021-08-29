package string;

public class StringApp4 {

	public static void main(String[] args) {
//	String src = "...!@BaT#*..y.abcdefghijklm";
	String src = "=.=";
		
	//1단계, 대문자를 소문자로 변경 
	src = src.toLowerCase();
	System.out.println("1단계: " + src);
	
	// 2단계, 특수문자 제거
	// [^]는 부정의 의미 
	// [a-z]는 소문자 전부, [0-9]는 숫자전부 
	// [^a-z0-9-_.]는 영어소문자, 숫자, -, _, . 아닌 것!!
	src = src.replaceAll("[^a-z0-9-_.]", "");
	System.out.println("2단계: " + src);
	
	// 3단계, 마침표가 2개 이상이면 하나로
	// [.]는 점을 뜻함 
	// [.]{2,}는 점이 두개 이상 
	//[.]{2,5}는 점이 2개에서 5개 
	src = src.replaceAll("[.]{2,}", ".");
	System.out.println("3단계: " + src);
	
	// 4단계, 마침표가 처음이나 끝에 있으면 제거하시오.
	// ^[.] 시작문자가 점인 것 
	src = src.replaceAll("^[.]", "");
	// [.]$  끝이라는 뜻 
	src = src.replaceAll("[.]$", "");
	System.out.println("4단계: " + src);
	
	// 5단계, 빈문자열이 있으면 a를 
	if(src.isEmpty()) {
		src = "a";
	}
	System.out.println("5단계: " + src);

	// 6단계, 길이가 16이상이면, 15개를 제외한 나머지를 제거한다.
	if(src.length() >= 16) {
		src = src.replaceAll("[.]$", "");
		src = src.substring(0,15);
	}
	System.out.println("6단계: " + src);
	
	// 7단계, 길이가 2이하면 맨마지막글자를 길이가 3이 될때까지 채운다.
	if(src.length() <= 2) {
		// ab 
		String lastChar = String.valueOf(src.charAt(src.length()-1));
		if(src.length() == 1) {
			src += lastChar;
		}
		src += lastChar;
	}
	System.out.println("7단계: " + src);
	
	
	
	
	}

}
