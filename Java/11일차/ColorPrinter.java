package day6;

public class ColorPrinter extends Printer{
	
	//print() override (컬러로 출력하기)
	@Override
	public void print() {
		System.out.println("컬러로 출력하기");
	}
	
	//refill() override (컬러 잉크 채우기)
	@Override
	public void refill() {
		System.out.println("컬러 잉크 채우기");
	}
	

}
