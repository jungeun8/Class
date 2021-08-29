package com.sample.mapper;

import java.util.List;

import com.sample.vo.User;

public interface UserMapper {
	
	/**
	 *  사용자 정보를 받아서 저장하기 
	 * @param user
	 */
	void insertUser (User user);
	
	/**
	 *  변경된 사용자 정보를 전달받아서 반영하기
	 * @param user
	 */
	void updateUser (User user);
	
	/**
	 * 아이디로 사용자 정보를 조회해서 반환하기
	 * @param userId
	 * @return
	 */
	User getUserById(String userId);

	
	/**
	 * 이메일로 사용자 정보를 조회해서 반환하기
	 * @param email
	 * @return
	 */
	User getUserByEmail(String email);
	
	/**
	 * 전화번호로 사용자 정보를 조회해서 반환하기
	 * @param phoneNumber
	 * @return
	 */
	List<User> getUserByPhone(String phone);
	
	
	
	
	
	

}
