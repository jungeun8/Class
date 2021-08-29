package com.sample.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//@Setter
//@Getter
@ToString
@Data
public class User {
	private String id;
	private String name;
	private String password;
	private String email;
	private String phoneNumber;
	private String status;
	private Date createdDate;
	private int point;
	
		
	
	
	
	

}
