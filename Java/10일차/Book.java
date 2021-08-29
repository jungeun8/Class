package day5;

public class Book {

	private int no;
	private String title;
	private String writer;
	private String publisher;
	private int price;
	private boolean isSoldOut;
	private double discountRate;
	private Event event;
	private Gift gift;

public Book() {}
	
	public Book(int no, String title, String writer, String publisher, int price, boolean isSoldOut,
			double discountRate) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
		this.isSoldOut = isSoldOut;
		this.discountRate = discountRate;
	}
	//getter/setter 메소드 정의하기
	/*
	 * getter 메소드 
	 * 		멤버변수의 값을 반환하는 메소드다. 
	 * 		반환타입은 void가 될 수 없다.
	 * 		메소드명은 get멤버변수명이다. 
	 * 		매게변수는 없다.
	 * 		public 타입 get멤버변수명(){
	 * 		return 멤버변수명
	 * 		}
	 * setter 메소드
	 * 		멤버변수의 값을 변경하는 메소드 
	 * 		반환 타입은 항상 void다.
	 * 		매개변수가 항상 있다.
	 * 		메소드명은 set멤버변수명(해당 멤버변수의 타입 매개변수)
	 * 		public void set멤버변수명(해당 멤버변수의 타입 변수명){
	 * 			this.멤버변수명 = 변수명;
	 * 		}
	 * 
	 * 
	 * 
	 */
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isSoldOut() {
		return isSoldOut;
	}
	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Gift getGift() {
		return gift;
	}
	public void setGift(Gift gift) {
		this.gift = gift;
	}
	
	
}






