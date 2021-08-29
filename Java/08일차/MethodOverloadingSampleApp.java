package day3;

public class MethodOverloadingSampleApp {

	public static void main(String[] args) {
		MethodOverloadingSample sample = new MethodOverloadingSample();
		
		sample.plus(10,20);
		sample.plus(10,20,30);
		sample.plus(10.0,20.0);
		sample.plus(10,20.0);
		sample.plus(10.0,20);

	}

}
