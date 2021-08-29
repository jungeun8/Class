package day5.inner.example;

public class StatsApp {

	public static void main(String[] args) {
		StudentRepo repo1 = new StudentRepo();
		GameRepo repo2 = new GameRepo();
		
		// 학생 성적에 대한 총점, 평균을 제공하는 Stats 구현 객체 얻기
		Stats stats1 = repo1.getStats();
		System.out.println("##학생성적 통계정보 출력");
		System.out.println("성적총합: " + stats1.total());
		System.out.println("성적평균: " + stats1.total());
		
		// 게임 기록에 대한 승리 횟수, 승률을 제공하는 Stats 구현 객체 얻기 
		Stats stats2 = repo2.getStats();
		System.out.println("##게임성적 통계정보 출력");
		System.out.println("승리횟수: " + stats1.total());
		System.out.println("게임승률: " + stats1.total() + "%");

	}

}
