package day4;

public class Employee {
	
	//  맴버변수 
	int no;
	String name;
	String dept;
	String position;
	int salary;
	double commissionPct;
	
	
	// 기본 생성자 
	Employee (){}
		

	// no, name, salary를 초기화하는 작업을 수행하는 생성자 
	
	public Employee(int no, String name, int salary) {
		super();
		this.no = no;
		this.name = name;
		this.salary = salary;
	}
	
	// no, name, dept, position, salary, commissionPct를 초기화하는 작업을 수행하는 생성자 
	public Employee(int no, String name, String dept, String position, int salary, double commissionPct) {
		super();
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.position = position;
		this.salary = salary;
		this.commissionPct = commissionPct;
	}
	
	
	
	void printEmployeeInfo() {
		System.out.println("직원번호: " + no);
		System.out.println("직원이름: " + name);
		System.out.println("소속부서: " + dept);
		System.out.println("직원직위: " + position);
		System.out.println("직원급여: " + salary);
		System.out.println("커미션지급율: " + commissionPct);
		
		
	}

	
	
	
	
	
	
	
	
}
