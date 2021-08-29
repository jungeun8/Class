package day3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ApacheIOApp {

	public static void main(String[] args) throws IOException {
		// 파일 복사하기 
		File src = new File("src/day3/song.mp4");
		File dest = new File("src/day3/song_copy.mp4");
		
		
		FileUtils.copyFile(src, dest);
		
		// 인터넷의 자원(텍스트, 사진 , 영상 ) 가져오기
		URL url = new URL("https://img.wowtv.co.kr/wowtv_news/dnrs/20210423/B20210423103853997.jpg");
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("src/day3/photo.jpg");
		
		IOUtils.copy(in, out);
	}


}
