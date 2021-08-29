package day2;

public class TvApp {

	public static void main(String[] args) {
		// Tv 객체 생성하기 
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		
		// Tv객체 전원켜기
		tv1.on();
			// Tv객체의 현재 채널번호 조회하기 
		int channelNumber = tv1.getCurrentChannel();
		System.out.println("현재 채널번호: " + channelNumber);
		// Tv객체의 채널을 하나 증가시키기 
		tv1.channelUp();
		tv1.channelUp();
		channelNumber = tv1.getCurrentChannel();
		System.out.println("현재 채널번호 " + channelNumber);

		// Tv 객체의 채널을 24번으로 변경하기 
		tv1.changeChannel(24);
		channelNumber = tv1.getCurrentChannel();
		System.out.println("현재 채널번호 " + channelNumber);

		// Tv 객체의 채널을 -100으로 변경하기 
		tv1.changeChannel(-100);
		// channel은 은닉화 되었다 
		// 외부에서 Tv객체의 chmmel, power 멤버볌수의 값을 직접 변셩할 수 없게 되어었다.
		// tv1.channel = -100;
		channelNumber = tv1.getCurrentChannel();
		System.out.println("현재 채널번호 " + channelNumber);
		
		tv2.on();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
