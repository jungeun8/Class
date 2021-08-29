package app;

import demo2.dao.UserDao;
import demo2.vo.User;

public class SimpleUserApp {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();
		// 새로운 사용자정보 등록하기 
		/*User user = new User();
		user.setId("hong");
		user.setPassword("zxcv1234");
		user.setName("홍길동");
		user.setEmail("hong@naver.com");
		user.setPhone("010-4856-9765");
		
		
		userDao.insertUser(user);
		System.out.println("새로운 사용자 정보가 등록되었습니다.");
		 */
		
		// 사용자 정보 조회
		User savedUser = userDao.getUserById("hong");
		System.out.println("아이디: "+ savedUser.getId());
		System.out.println("비밀번호: "+ savedUser.getPassword());
		System.out.println("사용자이름: "+ savedUser.getName());
		System.out.println("전화번호: "+ savedUser.getPhone());
		System.out.println("이메일: "+ savedUser.getEmail());
		System.out.println("사용자상태: "+ savedUser.getStatus());
		System.out.println("사용자 정보 생성일: "+ savedUser.getCreatedDate());
		
		// 사용자정보 변경하기 
		// 'hong' 아이디를 가진 사용자의 이메일, 전화번호 변경하기 
		User savedUser2 = userDao.getUserById("hong");
		savedUser2.setEmail("gildong@gmail");
		savedUser2.setPhone("010-4422-8888");
		userDao.updateUser(savedUser2);
	}

}
