package day6;

public class PrinterApp {
	
	public static void main(String[] args) {
		
		//### Printer객체 사용하기
		System.out.println("### Printer객체 사용하기");
		Printer p1 = new Printer();
		p1.refill();
		p1.print();
		
		//### ColorPrinter객체 사용하기
		System.out.println("### ColorPrinter객체 사용하기");
		ColorPrinter p2 = new ColorPrinter();
		p2.refill();
		p2.print();
		
		//### LaserPrinter 객체 사용하기
		System.out.println("### LaserPrinter 객체 사용하기");
		LaserPrinter p3 = new LaserPrinter();
		p3.refill();
		p3.print();
		
		//### LaserColorPrinter객체 사용하기
		System.out.println("### LaserColorPrinter객");
		LaserColorPrinter p4 = new LaserColorPrinter();
		p4.refill();
		p4.print();
	}
}