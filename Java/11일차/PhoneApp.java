package day6;

public class PhoneApp {

	public static void main(String[] args) {
		//Phone 객체 생성
		Phone p1 = new Phone();
		
		//전화번호 설정
		p1.setTel("010-1111-2222");
		//전화걸기
		p1.call();
		
		//FeaturePhone 객체 생성
		FeaturePhone p2 = new FeaturePhone();
		//전화번호 설정
		p2.setTel("010-2222-3333");
		//화소 설정
		p2.setPixel(86000000);
		//전화걸기
		p2.call();
		//사진찍기
		p2.takePicture();

		//SmartPhone 객체 생성
		SmartPhone p3 = new SmartPhone();
		//전화번호 설정
		p3.setTel("010-3333-4444");
		//전화걸기
		p3.call();
		//아이피설정
		p3.setIp("192.168.10.1");
		//이메일주소설정
		p3.setEmailAddress("masarapchicken@chicken.com");
		//인터넷 접속
		p3.web();
		//메일보내기
		p3.mail();
		
	}
	

}


