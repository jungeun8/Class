package collection.map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class HashMapApp3 {

	public static void main(String[] args) {

		HashMap<String, User> users = new HashMap<>();
		users.put("hong", new User("hong", "zxc1234", "홍길동"));
		users.put("kim", new User("kim", "zxc1234", "김유신"));
		users.put("kang", new User("kang", "zxc1234", "강감찬"));
		users.put("lee", new User("lee", "zxc1234", "이순신"));
		users.put("ryu", new User("ryu", "zxc1234", "유관순"));
		
		// Map에 저장된 Entry (key, value)쌍을 모두 조회하기 
		Set<Entry<String, User>> entrySet = users.entrySet();
		for(Entry<String, User> entry : entrySet) {
			String key = entry.getKey();
			User user = entry.getValue();
			System.out.println("["+key+"]" + user.getName()+ ", " + user.getPwd());
			
		}
	}

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
