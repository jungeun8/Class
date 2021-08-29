package com.sample.di.demo7;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	
	/*
	 * Properties 파일로 설정된 설정값을 멤버변수에 주입하기 
	 * 	@Value  어노테이션 사용한다.
	 *  *Properties파일은 <context:property-placeholder/> 태그로
	 *  스프링 컨테이너에 로딩되어 있어야한다.
	 */

	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	
	public void config(){
		System.out.println("드라이버 클래스명:" + driverClassName);
		System.out.println("Url:" + url);
		System.out.println("사용자명:" + username);
		System.out.println("비밀번호:" + password);
	}
}
