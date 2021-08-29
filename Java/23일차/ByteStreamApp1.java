package day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamApp1 {

	public static void main(String[] args) throws IOException{
		// src.txt을 읽어서 src_copu.txt로 저장하기 
		
		// src.txt를 읽어오기
		// InputStream 중에서 FileInputStream 사용 
		FileInputStream in = new FileInputStream("src/day2/src.jpeg");
		
		
		// src_copy.txt로 저장하기 
		// OutputStream 중에서 FileOutputStream 사용 
		FileOutputStream out = new FileOutputStream("src/day2/src_copy.jpeg");
		
		// FileInputStream으로 파일의 데이터 읽기 
		//FileOutputStream으로 파일에 데이터 쓰기 
		
		int value = 0;
		while((value = in.read()) != -1) {
			out.write(value);
		}
		
		// 컴퓨터의 입출력 장치에 대한 점유를 해제하기 
		in.close();
		out.close();
	}

}
