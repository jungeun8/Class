package com.sample.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.sample.dao.FileItemDao;
import com.sample.vo.FileItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


/*
 * @WebServlet
 * - 이 클래스가 클라이언트의 http요청을 처리하는 서블릿 클래스임을 나타낸다.
 * - ("/upload")는 이 서블릿 클래스와 매핑된 url을 설정한다.
 * 		위의 설정은 http"//localhost/upload라는 요청이 접수되면 이 서블릿의 
 * 		void service() 메소드가 실행되게 한다 
 */
@WebServlet("/upload")
/*
 * @MultipartConfig
 * 	- 이 클래스가 멀티파트요청을 처리하는 서블릿 클래스임을 나타낸다.
 * 	- 멀티파트요청은 폼 입력요소에 첨부파일 업로드가 포함되어있는 요청이다.
 * 	- 멀티파트요청은 <form/> 태그의 enctype="multipart/form-data"로 설정되어 있는 것이다.
 * 	- @MultipartConfig 어노테이션이 부착되어 있지 않은 서블릿 클래스는 멀티파트 요청을 처리할  수 없다. 
 */
@MultipartConfig
public class FilrUploadServlet extends HttpServlet{
	
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException,IOException{
		
		// 요청파라미터 조회하기 
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		//System.out.println("제목" + title);
		//System.out.println("설명" + description);
		
		// 업로드된 첨부파일 처리하기 
		// Part는 업로드된 첨부파일의 정보를 가지고 있는 객체다.
		// Part로 부터 파일명, 파일종류(contentType), 파일의크기, 파일을 읽어오는 스트림을 획득할 수 있다. 
		Part part= request.getPart("upfile");
		
		// 1. 업로드된 첨부파일 정보 획득하기 
		String filename = System.currentTimeMillis() + part.getSubmittedFileName();
		//System.out.println("파일이름: " + filename);
		//System.out.println("파일사이즈: " + part.getSize());
		//System.out.println("파일타입: " + part.getContentType());
		
		// 2. 업로드된 첨부파일을 지정된 폴더에 복사하기 
		// * 서버로 업로드된 첨부파일은 서버의 임시 디렉토리에 임시파일(xxxxxxx.tmp)의 형태로 저장되어 있음 
		String saveDirectory = "/Users/jungeun-kim/workspace/java-web/upload";
		
		// File객체 생성 : 지정된 디렉토리와 파일명에 대한 정보를 가지는 객체다. 
		//				 실제로 존재하지 않은 파일에 대해서도 객체 생성이 가능하다. 
		OutputStream out = new FileOutputStream(new File(saveDirectory, filename));
		InputStream in = part.getInputStream();
		IOUtils.copy(in, out);
		out.close();
		
		// 3.업로드된 파일정보(제목, 설명, 파일명)을 데이터베이스에 저장하기
		FileItem fileItem = new FileItem();
		fileItem.setTitle(title);
		fileItem.setDescription(description);
		fileItem.setFilename(filename);
		
		FileItemDao fileItemDao = FileItemDao.getInstance();
		fileItemDao.insertFileItem(fileItem);
		
		// 클라이언트에게 index.jsp를 재용청하게하는 응답을 보내기 
		response.sendRedirect("/index.jsp");
		
	}
	
	
	}
	

