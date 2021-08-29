package day2.user;

import java.util.ArrayList;
import java.util.Iterator;

public class UserService {
	
	ArrayList<User> users = new ArrayList<User>();
	
	public UserService() {
		users.add(new User("hong", "홍길동", "1234"));
		users.add(new User("kim", "김유신", "1234"));
		users.add(new User("lee", "이순신", "1234"));
		users.add(new User("kang", "강감찬", "1234"));
		users.add(new User("ryu", "유관순", "1234"));
		
	}
	// 새 사용자(아이디, 이름, 비밀번호 포함) 등록기능
	// 동일한 아이디로 가입된 사용자가 존재하면 UserAlreadyExistsException 을 던진다. 
	public void insertUser(User user) {
		User savedUser = getuUserById(user.getId());
		if(savedUser != null) {	// 이미 동일한 아이디의 사용자가 등록되어 있으면 
			throw new UserAlreadyExistsException(user.getId());	// 예외던지고 메소드 종료 
		}
		users.add(user);
		}
	
	// 아이디를 전달받아서 해당 아이디로 가입한 사용자를 반환하는 기능 
	public User getuUserById(String userId) {
		for(User user : users) {
			if(user.getId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
	// 아이디, 이전 비밀번호, 새 비번을 전달받아서 비번을 변경하는 기능 
	// 아이디에 해당하는 사용자가 존재하지 않으면 UserNotFoundException을 던진다.
	// 비밀번호가 일치하지 않으면 PasswordMismatchException을 던진다.
	public void changUsesrPassword(String userId, String oldPassword, String newPassword) {
		User savedUser = getuUserById(userId);
		if(savedUser == null) {	// 아이디에 해당하는 사용자 정보가 존재하지 않는다면 
			throw new UserNotFoundException(userId);	// 예외 던지고 메소드 종료 
		}
		if(!savedUser.getPassword().equals(oldPassword)) {	// 비밀번호가 일치하지 않는다면 
			throw new PasswordMismatchException(userId);	// 예외던지고 메소드종료 
		}
		savedUser.setPassword(newPassword);
	}
	
	// 아이디를 전달받아서 해당 아이디로 가입한 사용자를 삭제하는 기능
	// 아이디에 햐당하는사용자가 존재하지 않으면 UserNotFoundException을 던진다. 
	public void deleteUserById(String userId, String password) {
		User savedUser = getuUserById(userId);
		if(savedUser == null) {	// 아이디에 해당하는 사용자 정보가 존재하지 않는다면 
			throw new UserNotFoundException(userId);	// 예외던지고 메소드종료 
		}
		if(!savedUser.getPassword().equals(password)) {	// 비밀번호가 일치하지 않는다면 
			throw new PasswordMismatchException(userId);	//예외던지고 메소드 종료 
		}
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {		// Iterator에서 다음번 반복할 데이터가 있는지 확인
		User user = iterator.next();	// Iterator에서 데이터를 조회한다.
		if(user.getId().equals(userId)) {
			iterator.remove();		// 지금 조회한 데이터를 삭제한다.
			break;
		}
		}
	}
	
	/*
	
	public User findUserById2(String id) {
//		User foundUser = null;
//		for(User user : users) {
//			if(user.getId().equals(id)) {
//				foundUser = user;
//				break;
//			}
//		}
//		
//		if(foundUser == null) {
//			throw new UserNotFoundException(id);
//		}
//		return foundUser;
//		
//	}
		// id에 해당하는 사용자가 존재하면 User객체가, 존재하지 않으면 예외가 던져지는 메소드 
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		throw new UserNotFoundException(id);	// return null (changePassword1)도 가능하다 
	}
	
//	public void changePassword1(String id, String oldPwd, String newPwd) {
//		User user = findUserById1(id);
//		if (user != null) {
//			if(user.getPassword().equals(oldPwd)) {
//				user.setPassword(newPwd);
//			}else {
//				System.out.println("비밀번호가 일치하지 않습니다.");
//			}
//			
//		}else {
//			System.out.println("아이디와 일치하는 사용자가 존재하지 않습니다.");
//		}
//		
//	}
//	
	public void changePassword2(String id, String oldPwd, String newPwd) {
		
		User user = findUserById2(id);	// 사용자가 존재하지 않으면 예외발생, 메소드 종료
		
		if(!user.getPassword().equals(oldPwd)) {	// 비번이 일치하지 않으면 
			throw new PasswordMismatchException(id);	// 예외발생, 메소드 종료 
		}
		
		user.setPassword(newPwd);
	}
*/
	
}




















