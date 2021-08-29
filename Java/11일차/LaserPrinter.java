package day6;

public class LaserPrinter extends Printer{
	
	//print() override (레이저 흑백 출력)
	@Override
	public void print() {
		System.out.println("레이저 흑백 출력");
	}
	
	//refill() override (토너 교체)
	@Override
	public void refill() {
		System.out.println("토너 교체");
	}

}