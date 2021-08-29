package com.sample.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.gson.Gson;
import com.sample.web.SampleAjaxServlet2.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajax3")
public class SampleAjaxServlet3  extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Integer, Book> map = new HashMap<Integer,Book>();
		map.put(100, new Book(100, "미드나잇 라이브러리", "매트 헤이그", "인풀루엔셀", 14220));
		map.put(200, new Book(200, "조국의 시간", "조국", "한길사", 15300));
		map.put(300, new Book(300, "완전한 행복", "정유정", "은행나무", 14220));
		map.put(400, new Book(400, "부의 시나리오", "오건영", "페이지2", 16200));
		map.put(500, new Book(500, "세금내는 아이들", "옥효진", "한국경제신문사", 12620));
		map.put(600, new Book(600, "흔한남매 8", "흔한남매", "미래엔아이세움", 12150));
		map.put(700, new Book(700, "청사과 낙원", "청낙원", "위즈덤하우스", 37000));
		
		// 요청파라미터값 조회하기 
		int bookNo = NumberUtils.toInt(request.getParameter("no"));
		// 데이터조회하기 
		Book book = map.get(bookNo);
		// 데이터를 json 형식의 텍스트로 변환하기 
		Gson gson = new Gson();
		String jsonText = gson.toJson(book);
		// 응답 데이터 보내기
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out =response.getWriter();
		out.write(jsonText);
		out.flush();
		out.close();
		
	}

	
	public class Book {
		int no;
		String title;
		String writer;
		String publisher;
		int price;
		
		public Book(int no, String title, String writer, String publisher, int price) {
			super();
			this.no = no;
			this.title = title;
			this.writer = writer;
			this.publisher = publisher;
			this.price = price;
		}

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		
	}

}
