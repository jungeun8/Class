package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.sample.dao.UserDao;
import com.sample.vo.User;

@Service
public class UserServiceImple implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void registerUser(User user) {
		
		// 사용자 아이디로 사용자 정보가 조회되면 예외발생
		User savedUser = userDao.getUserById(user.getId());
		if(savedUser != null) {
			throw new RuntimeException("["+user.getId()+"]는 이미 사용중인 아이디 입니다.");
		}
		// 사용자 이메일로 사용자 정보가 조회되면 예외발생
		savedUser = userDao.getUserByEmail(user.getEmail());
		if(savedUser != null) {
			throw new RuntimeException("["+user.getEmail()+"]는 이미 등록됨 이메일 입니다.");
		}
		
		// 사용자 비밀번호를 암호화한다.
		//String secretPassword = DigestUtils.sha256Hex(user.getPassword());
		//user.setPassword(secretPassword);

		// 사용자 정보를 저장한다. 
		userDao.insertUser(user);
		
	}

}
