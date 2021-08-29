package day2;

/**
 * Tv 관련 기능을 제공하는 클래스다.
 * @author jungeun-kim
 * @version 0.1
 * @since 2021/3/30
 *
 */
public class Tv {
	
	// private 접근제한제는 맴버변수를 은닉화 시킨다. 
	private int channel = 10;
	private boolean power;
	
	// tv를 켠다. 
	// power의 값을 true로 설정한다. 	
	// 변경작업 - 반환타입: void
	// 매개변수 필요없음 
	// java document 주석이다.
	/**
	 * Tv객체의 power상태를 ture로 설정한다. 
	 */
	public void on() {
		// Tv객체의 전원상태를 true로 설정한다. 
		power = true;
	}
	
	// tv를 끈다.
	// power의 값을 false로 설정한다. 	
	// 변경작업 - 반환타입: void
	// 매개변수 -필요없음 
	/**
	 * Tv객체의 power상태를 false로 설정한다. 
	 */
	public void off() {
		// Tv객체의 전원상태를 false로 설정한다. 
		power = false;
	}
	// 채널숫자를 1 감소시킨다.		
	// 변경작업 - 반환타입: void
	// 매개변수 - 필요없음
	/**
	 *  Tv 객체의 재널번호를 1감소시킨다.
	 */
	public void channelDown() {
		// Tv 객체의 채널번호를 1 감소시킨다. 
		channel--;
		if(channel < 1) {
			channel = 100;
		}
	}
	
	// 채널숫자를 1 증가시킨다. 		
	// 변경작업 - 반환타입: void
	// 매개변수 - 필요없음
	/**
	 * Tv 객체의 재널번호를 1증가시킨다.
	 */
	public void channelUp() {
		// Tv 객체의 채널번호를 1 증가 시킨다. 
		channel++;
		if(channel > 100) {
			channel = 1;
		}
	}
	
	// **채널로 변경한다.		
	// 변경작업 - 반환타입: void
	// 매개변수 - 채널번호 (정수)
	/**
	 * 채널번호를 전달받아서 Tv객체의 채널번호를 변경한다.
	 * @param channelNumber 변경할 채널번호 
	 */
	public void changeChannel(int channelNumber) {
		// Tv객체의 채널 번호에 전달받은 채널번호를 대입한다.  
		if(channelNumber >=1 && channelNumber <= 100) {
			channel = channelNumber;
		}
	}
	
	// 현재 시청중인 채널번호를 조회한다. 		
	// 조회작업 -반환타입: 채널번호(정수)
	// 매개변수 - 필요없음 
	/**
	 * Tv객체의 현재 채널번호를 반환한다.
	 * @return 현재 채널번호(1~100사이의 정수값)
	 */
	public int getCurrentChannel() {
		// Tv 객체의 channel변수에 저장돈 채널번호를 반환한다. 
		return channel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
