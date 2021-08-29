package com.sample.dao;

import com.sample.vo.User;

public interface UserDao {

	void insertUser(User user);
	
	User getUserById(String userId);
	
	User getUserByEmail(String userEmail);
	
}
