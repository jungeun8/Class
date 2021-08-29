package collection.map;

import java.util.HashMap;
import java.util.Set;

public class HashMapApp2 {

	public static void main(String[] args) {
		
		HashMap<String, User> users = new HashMap<>();
		users.put("hong", new User("hong", "zxc1234", "홍길동"));
		users.put("kim", new User("kim", "zxc1234", "김유신"));
		users.put("kang", new User("kang", "zxc1234", "강감찬"));
		users.put("lee", new User("lee", "zxc1234", "이순신"));
		users.put("ryu", new User("ryu", "zxc1234", "유관순"));
		
		// Map객체에 저장된 데이터(객체) 조회하기 
		// User user = users.get("hong");		// 홍길동 정보를 담고 있는 User 객체 획득 
		
		// Map객체의 모든 key값을 조회하기 
		// Set<K> getSet() : Map 객체의 모든 Key값을 중복 허용하지 Set객체에 담아서 반환한다.
		Set<String> keys = users.keySet();
		System.out.println("Map객체의 key들: " + keys);		// [hong, kang, lee, kim, ryu]
		
		//Set<String> keys(조회된 key값)으로 Map에 저장된 데이터 전부 조회하기
		for(String key : keys) {
			User savedUser = users.get(key);
			System.out.println("["+key+"]" + savedUser.getName()+ ", " + savedUser.getPwd());
			
		}
		
	}
		// TODO Auto-generated method stub
		private static class User{
			String id;
			String pwd;
			String name;
			
			User(String id, String pwd, String name) {
				
				this.id = id;
				this.pwd = pwd;
				this.name = name;
			}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
			
		}

	

}
