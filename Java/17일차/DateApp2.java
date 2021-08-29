package date;

import java.util.Calendar;
import java.util.Date;

public class DateApp2 {

	public static void main(String[] args) {
		// 현재 날짜 및 시간정보를 포함하고 있는 Date객체 생성하기 
		Date now = new Date();
		
		// 현재 날짜 및 시간정보를 포함하고 있는 Calender객체 생성하기 
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		// 특정 날짜와 시간정보를 포함하는 Calendar객체 생성하기 
		Calendar cal2 = Calendar.getInstance();
		// 2021년 4월 14일 11시 34분 10초에 해당하는 날짜 정보를 Calendar에 설정 
		cal2.set(1995, 7, 8, 7, 33, 10);
		System.out.println(cal2);
		
		// Calendar객체로부터 Date객체 조회하기 
		Date date = cal2.getTime();
		System.out.println(date);
		
		// Calendar 객체로부터 유닉스타임 조회하기
		long unixTime = cal.getTimeInMillis();
		System.out.println("유닉스타임: " + unixTime);
		
		// 유닉스타임값으로 Date객체 생성하기 
		Date date2 = new Date(1000);
		System.out.println(date2);
	}

}
