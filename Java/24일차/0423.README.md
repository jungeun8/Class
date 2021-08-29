# Java(21.04.23)
값의 출력 및 변수 생성값의 출력 및 변수 생성
브릿지 스트림
	문자스트림이다.
	바이트스트림과 문자스트림을 연결하는 스트림
		InputStreamReader
			InputStream과 Reader를 연결하는 스트림
			사용예)
			FileInputStream inputStream = new FileInputStream("a.txt");
			InputStreamReader isr =  new InputStreamReader(inputStream);
			 * FileInputStream과 BufferedReader를 연결하였음. 
			
			URL url = new URL("http://www.abc.net/코로나현황.csv");
			InputStream is = url.openStream();
			InputStreamReader isr =  new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			 * URL객체가 제공하는 InputStream과 BufferedReader 를 연결하였음 
			
			Socket socket = new Socket("채팅서버주소", 3000);
			InputStream is = socket.getInputStream();
			InputStreamReader isr =  new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
		         * 채팅서버와 연결관 Socket객체가 제공하는 InputStream과 BufferedReader를 연결함 
			
		OutputStreamWriter
			OutStream Writer를 연결하는 스트림 
			사용예)
				FileOutputStream outputStream = new FileOutputStream("a.txt");
				OutputStreamWriter osw = new OutputStreamWriter (outtputStream);
				FileWriter writer = new FileWriter(osw);
				
				Socket socket = new Socket("채팅서버주소", 3000);
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osr = new OutputStreamWriter(os);
				PrintWriter writer = new PrintWriter(osr);
				 * 채팅서버와 연결된 Socket 객체가 제공한 OutputStream이고 PrintWriter를 연결 

InputStream
	FileInputStream
		직접 파일에서 1byte씩 읽어오는 스트림
		new FileInputStream("경로/파일명");
		new FileInputStream(new File("경로/파일명"));

	BufferedInputStream
		모든 InputStream과 연결해서 사용하는 보조스트림, InputStream의 읽기 속도를 향상시킨다.
		new BufferedInputStream(다른 InputStream);

 OutputStream
	FileOutputStream
		직접 파일에 1byte씩 출력하는 스트림
		new FileOutputStream("경로/파일명");
		new FileOutputStream(new File("경로/파일명"));

	BufferedOutputStream
		모든 OutputStream과 연결해서 사용하는 보조스트림, OutputStream의 출력 속도를 향상시킨다.
		new BufferedOutputStream(다른 OutputStream);

	PrintStream
		시스템의 표준출력 스트림으로 사용되는 스트림, System.out과 System.err 정적변수에 각각 연결되어 있다.
		print(), println()이 중복정의되어 있다.
 Reader
	FileReader
		직접 파일에서 1글자씩 읽어오는 스트림
		new FileReader("경로/파일명");
		new FileReader(new File("경로/파일명"));

	BufferedReader
		모든 Reader와 연결해서 사용하는 보조스트림, 텍스트를 1줄씩 읽어오는 readLine() 메소드가 있다.
		new BufferedReader(다른 Reader);

	InputStreamReader
		브릿지스트림, InputStream과 연결할 수 있는 보조스트림
		new InputStreamReader(다른 InputStream);

 Writer
	FileWriter
		직접 파일에 1글자씩 읽어오느 스트림
		new FileWriter("경로/파일명")
		new FileWriter(new File("경로/파일명"));

	PrintWriter
		텍스트 출력의 만능 스트림
		print(), println()이 중복정의되어 있다. 자동으로 줄바꿈문자 추가, auto-flush 기능 체공	
		new PrintWriter("경로/파일명");
		new PrintWriter(다른 InputStream);
		new PrintWriter(다른 Writer)

	OutputStreamWriter
		브릿지스트림, OutputStream과 연결할 수 있는 보조스트림
		new OutputStreamWriter(다른 OutputStream);


