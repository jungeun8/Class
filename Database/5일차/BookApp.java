package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Scanner scanner = new Scanner(System.in);
	String driverClassName = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.123.13:1521:xe";
	String username = "hr";
	String password = "zxcv1234";
	String sql = "insert into sample_books values(?,?,?,?,?,?,sysdate)";
	

	
	System.out.println("책 등록하기");
	
	System.out.println("제목을 입력하세요");
	String title = scanner.nextLine();
	
	System.out.println("저자를 입력하세요");
	String writer = scanner.nextLine();
	
	System.out.println("번호를 입력하세요");
	int no = scanner.nextInt();
	
	System.out.println("가격을 입력하세요");
	int price = scanner.nextInt();
	
	System.out.println("할인가격을 입력하세요");
	int discountPrice = scanner.nextInt();
	
	System.out.println("재고량을 입력하세요 ");
	int stock = scanner.nextInt();
	
	Class.forName(driverClassName);
	Connection connection = DriverManager.getConnection(url,username, password);
	PreparedStatement pstmt = connection.prepareStatement(sql);
	
	pstmt.setInt(1, no);
	pstmt.setString(2, title);
	pstmt.setString(3, writer);
	pstmt.setInt(4, price);
	pstmt.setInt(5, discountPrice);
	pstmt.setInt(6, stock);
	
	int rowCount = pstmt.executeUpdate();
	System.out.println(rowCount + "개의 행이 추가되었습니다.");
	
	pstmt.close();
	connection.close();
	
	
	
	}
	

}
