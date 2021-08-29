package com.sample.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	
	private String id;
	private String name;
	private String password;
	private String email;
	private int phone;
	private String point;
	private String status;
	private Date createdDate;

}
