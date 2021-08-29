package day2.game;

public class GameApp {

	public static void main(String[] args) {
		
		Marine unit1 = new Marine();
		Firebat unit2 = new Firebat();
		Ghost unit3 = new Ghost();
		BattleCruiser unit4 = new BattleCruiser();
		
		System.out.println("##Marine 객체의 공격하기");
		unit1.attack();
		unit1.move();
		
		System.out.println("### Firebat객체의 이동하기/공격하기");
		unit2.attack();
		unit2.move();
		
		System.out.println("### Ghost객체의 이동하기/공격하기");
		unit3.attack();
		unit3.move();
		
		System.out.println("### BattleCruiser객체의 이동하기/공격하기");
		unit4.attack();
		unit4.move();
	}

}
