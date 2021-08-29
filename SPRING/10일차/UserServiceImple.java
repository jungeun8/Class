package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.sample.dao.UserDao;
import com.sample.vo.User;
import com.sample.web.utils.SessionUtils;

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
	@Override
	public void login(String id, String password) {
		// 사용자정보 조회 - null인지 체크, 삭제된 사용자인지 체크, 비밀번호가 일치하는지 체크 
		User user = userDao.getUserById(id);
		if(user == null) {
			throw new RuntimeException("아이디 혹은 비밀번호가 유효하지 않습니다.");
		}
		if(!"ACTIVE".equalsIgnoreCase(user.getStatus())) {
			throw new RuntimeException("삭제 혹은 이용이 중지된 사용자입니다.");
		}
		String secretPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
		if(!user.getPassword().equals(secretPassword)) {
			throw new RuntimeException("아이디 혹은 비밀번호가 유효하지 않습니다.");
		}
		
		// HttpSession객체에 사용자 인증이 완료된 사용자 정보를 속성으로 추가한다.
		SessionUtils.addAttribute("LOGINED_USER", user);
		
	}

		
	}

	

