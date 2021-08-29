package day1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService service = new StudentService();
		
		while(true) {
			System.out.println("--------------------------------");
			System.out.println("1. 전체조회 2. 추가 3. 검색 4. 삭제 5. 석차 0. 종료");
			System.out.println("--------------------------------");
			
			System.out.println("메뉴선택");
			int menuNo = scanner.nextInt();
			
		try {
			if(menuNo == 1) {
				System.out.println("전체 학생 정보 조회");
				
				ArrayList<Student> students = service.getAllStudentList();
				if(students.isEmpty()) {
					System.out.println("안내 등록된 학생정보가 없습니다.");
				}else {
					System.out.println("학생명\t총점\t평균");
					for(Student student : students) {
						System.out.print(student.getName() + "\t");
						System.out.print(student.getTotal()+ "\t");
						System.out.println(student.getAverage());
					}
				}
				
			}else if (menuNo == 2) {
				System.out.println("학생정보추가");
				
				System.out.println("이름 입력 ");
				String name = scanner.next();
				System.out.println("국어점수 입력 ");
				int kor = scanner.nextInt();
				System.out.println("영어점수 입력 ");
				int eng = scanner.nextInt();
				System.out.println("수학점수 입력 ");
				int math = scanner.nextInt();
				
				Student student = new Student(name, kor, eng, math);
				
			}else if (menuNo == 3) {
		
			}else if (menuNo == 4) {
				
			}else if (menuNo == 5) {
				
			}else if (menuNo == 0) {
				System.out.println("프로그램 종료");
				service.saveAllStudentData();
				break;
			}
			
		}catch(Exception e) {
			System.out.println("오류" + e.getMessage());
		}
		System.out.println();
		System.out.println();
		}

	}

}
