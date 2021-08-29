package com.sample.vo;

public class Score {
	
	private String firstName;
	private String lastName;
	private int kor;
	private int eng;
	private int math;
	
	public Score() {}

	public Score(String firstName, String lastName, int kor, int eng, int math) {
		super();
		this.firstName = firstName;
		this.lastName =lastName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public String getFullName() {
		return firstName + lastName;
	}
	
	public int getTotal() {
		return kor + eng + math;
	}

	public int getAverage() {
		return (kor + eng + math)/3;
	}
}
