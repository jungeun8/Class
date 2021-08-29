package day2;

import java.io.IOException;
import java.io.PrintWriter;

public class WriterApp1 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * PrintWriter
		 * 	- 출력전용 문자스트림 클래스다.
		 * 	- 직접 텍스트 데이터 쓰기 가능한 스트림이다.
		 * 	- OutputStream, Writer 스트림에 추가기능을 제공하는 보조스트림으로 사용할 수 있다.
		 * 	- 추가기능
		 * 		- 줄바꿈문자를 자동으로 추가하는 출력메소드를 제공한다. println(데이터);
		 * 		- auto-flush 기능을 제공한다.
		 * 	- 생성자 
		 * 		PrintWriter(File file)
		 * 		PrintWriter(File file, String charseName)
		 * 		PrintWriter(String filename)
		 * 		PrintWriter(String filename, String charseName)
		 * 		PrintWriter(OutStream out)
		 * 		PrintWriter()
		 * 		PrintWriter()
		 * 		PrintWriter()
		 * 		PrintWriter()
		 * 	- 주요메소드
		 * 		- void write(String text)
		 * 		텍스트를 출력한다.
		 * 		- void println(String text)
		 * 		텍스트를 출력하고 줄바꿈 문자를 추가한다.
		 */
		PrintWriter writer = new PrintWriter("src/day2/sample.txt");
		
		// 파일에 기록된 데이터가 줄바꿈되지 않음 
		writer.write("김유신, 100,100, 100");
		writer.write("김유신, 100,100, 100");
		writer.write("김유신, 100,100, 100");
		writer.write("김유신, 100,100, 100");
		writer.write("김유신, 100,100, 100");
		
		writer.println();
		// 파일에 기록한 데이터가 줄바꿈됨 
		writer.println("김유신, 100,100, 100");
		writer.println("김유신, 100,100, 100");
		writer.println("김유신, 100,100, 100");
		writer.println("김유신, 100,100, 100");
		writer.println("김유신, 100,100, 100");
		writer.println("김유신, 100,100, 100");
		writer.println("김유신, 100,100, 100");
		writer.println("김유신, 100,100, 100");
		
		writer.close();
		
		

	}

}
