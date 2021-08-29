package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {
	
	static String driverClassName = "oracle.jdbc.OracleDriver";
	static String url = "jdbc:oracle:thin:@192.168.50.55:1521:xe";
	static String username = "hr";
	static String password = "zxcv1234";
	
	public static void deleteBook(int bookNo) {
		String sql = "delete from sample_books "
				+ "where book_no = ? ";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(BookApp.url, BookApp.username, BookApp.password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + "개의행이 삭제됨 ");
			
		}catch(SQLException e) {
			System.out.println("오류코드" + e.getErrorCode());
			System.out.println("오류메시지" + e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(SQLException e) {}
			try {if (con != null) con.close();} catch(SQLException e) {}
		}
		
	}
	
	public static void updateBook(Book book) {
		
	}
	// 반환값이 null일 수도 있다. 조회된 데이터가 없으면 null을 반환한다. 
	public static Book selectBookByNo(int bookNo) {
		String sql = "select book_no, book_title, book_price, "
				+ "			 book_discount_price, book_stock, book_created_date "
				+ "from sample_books "
				+ "where book_no = ? ";
		
		Book book = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection(BookApp.url, BookApp.username, BookApp.password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			rs = pstmt.executeQuery();	
			
			// 한행이 조회되어가 조회된 행이 없거나 2가지만 가능
			//rs.next()의 실행결과가 true면 조회된 행이 있는 경우
			// rs.next()의 실행결과가 false 면 조회된 행이 없는 경우
			if(rs.next()) {		
				book = new Book();
				book.setNo(rs.getInt("book_no"));
				book.setTitle(rs.getString("book_title"));
				book.setWriter(rs.getString("book_writer"));
				book.setPrice(rs.getInt("book_price"));
				book.setDiscountPrice(rs.getInt("book_discount_price"));
				book.setStock(rs.getInt("book_stock"));
				book.setCreatedDate(rs.getDate("book_created_date"));
			}
		    pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("오류코드" + e.getErrorCode());
			System.out.println("오류메시지" + e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {if (rs != null) rs.close();}catch(SQLException e) {}
			try {if (pstmt != null) pstmt.close();}catch(SQLException e) {}
			try {if (con != null) con.close();}catch(SQLException e) {}
		}
		
		return book;
	}
	
	// 반환값은 언제나 null이 아니다. 조회된 데이터가 없으면 List객체가 비어있을 뿐이다. 
	public static List<Book> selectAllBooks(){
		String sql = "select book_no, book_title, book_writer, book_price, "
				+ "			 book_discount_price, book_stock, book_created_date "
				+ "from sample_books "
				+ "order by book_no desc";
		
		List<Book> books = new ArrayList<Book>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(BookApp.url, BookApp.username, BookApp.password);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			
			// 여러행이 조회되거나 조회된 행이 없을 수 있다.
			while (rs.next()) {
				// 조회된 행바다 Book객체를 새로 생성해서 조회된 정보를 저장한다. 1
	
				Book book = new Book();
				book.setNo(rs.getInt("book_no"));
				book.setTitle(rs.getString("book_title"));
				book.setWriter(rs.getString("book_writer"));
				book.setPrice(rs.getInt("book_price"));
				book.setDiscountPrice(rs.getInt("book_discount_price"));
				book.setStock(rs.getInt("book_stock"));
				book.setCreatedDate(rs.getDate("book_created_date"));
				
				// Book객체를 ArrayList객체에 추가한다. 
				books.add(book);
			}
			
		}catch(SQLException e) {
			System.out.println("오류코드" + e.getErrorCode());
			System.out.println("오류메시지" + e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {if (pstmt != null) pstmt.close();} catch(SQLException e) {}
			try {if (con != null) con.close();} catch(SQLException e) {}
			try {if (rs != null) rs.close();}catch(SQLException e) {}
		}
		
		return books;
	}
	
	public static void insertBook(Book book) {
		String sql = "insert into sample_books "
					+ "(book_no, book_title, book_writer, book_price, book_discount_price, book_stock) "
					+ "values "
					+ "(?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(BookApp.url, BookApp.username, BookApp.password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, book.getNo());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getWriter());
			pstmt.setInt(4, book.getPrice());
			pstmt.setInt(5, book.getDiscountPrice());
			pstmt.setInt(6, book.getStock());
			
			pstmt.executeUpdate();
	
			
		}catch(SQLException e) {
			System.out.println("오류코드" + e.getErrorCode());
			System.out.println("오류메시지" + e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {if(pstmt != null) pstmt.close();} catch(SQLException e) {}
			try {if(con != null) con.close();} catch(SQLException e) {}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName(driverClassName);
		}catch(ClassNotFoundException e) {
		throw new RuntimeException(e);
	}
		
	while (true) {
		System.out.println("===================================");
		System.out.println("1.조회 2.등록 3.수정 4.삭제 0.종료");
		System.out.println("===================================");
		
		System.out.println("메뉴선택 >");
		int menuNo = scanner.nextInt();
		scanner.nextLine();
		
		if(menuNo == 1) {
			System.out.println("전체 도서 조회");
			
			List<Book> books = BookApp.selectAllBooks();
			if(books.isEmpty()) {
				System.out.println("안내: 조회된 책정보가 존재하지 않습니다.");
			}else {
				System.out.println("==============================");
				for(Book book : books) {
					System.out.println("번호: " + book.getNo());
					System.out.println("제목: " + book.getTitle());
					System.out.println("가격: " + book.getPrice());
					System.out.println();
				}
				System.out.println("==============================");
			}
			
		}else if (menuNo == 2) {
			System.out.println("새 도서 등록");
			System.out.println();
			
			System.out.println("제목 입력");
			String title = scanner.nextLine();
			System.out.println();
			
			System.out.println("저자 입력");
			String writer = scanner.nextLine();
			System.out.println();
			
			System.out.println("번호 입력");
			int no = scanner.nextInt();
			System.out.println();
			
			System.out.println("가격 입력");
			int price = scanner.nextInt();
			
			System.out.println("할인가격 입력");
			int discountPrice = scanner.nextInt();
			
			System.out.println("재고량 입력");
			int stock = scanner.nextInt();
			
			Book book = new Book();
			book.setNo(no);
			book.setTitle(title);
			book.setWriter(writer);
			book.setPrice(price);
			book.setDiscountPrice(discountPrice);
			book.setStock(stock);
			
			BookApp.insertBook(book);
			System.out.println("안내 : 새 책이 등록되었습니다.");
			
		}else if (menuNo == 3) {
			System.out.println("도서 정보 수정");
			
		}else if (menuNo == 4) {
			System.out.println("도서 정보 삭제");
			
		}else if (menuNo == 0) {
			System.out.println("프로그램 종료");
			break;
			
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
	}

}
