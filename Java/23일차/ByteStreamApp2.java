package day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ByteStreamApp2 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://imgnews.pstatic.net/image/001/2021/04/22/PCM20200812000099990_P4_20210422161351889.jpg?type=w647");

		InputStream in = url.openStream();
		FileOutputStream out =  new FileOutputStream("src/day2/백신.jepg");
		
		BufferedInputStream bis = new BufferedInputStream(in);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		int value = 0;
		while ((value=bis.read()) != -1) {
			bos.write(value);
		}
	bos.close();	
	}

}
