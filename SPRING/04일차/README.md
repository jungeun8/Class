# Java
값의 출력 및 변수 생성값의 출력 및 변수 생성
	// 빌드패던 
	public class User {
		private String id;
		private String password;
		private String name;
		private Stirng email;
		private String phone;
	
		public static UserBuilder builder() {
			return new UserBuilder();
		}
	
		// getter/setter메소드 정의
	
		public static class UserBuilder {
			private String id;
			private String password;
			private String name;
			private Stirng email;
			private String phone;
	
			public UserBuilder id(String id) {
				this.id = id;
				return this;
			}
			public UserBuilder password(String password) {
				this.password= password;
				return this;
			}
			public UserBuilder name(String name) {
				this.name =  name;
				return this;
			}
			public UserBuilder email(String email) {
				this.email = email;
				return this;
			}
			public UserBuilder phone(String phone) {
				this.phone = phone;
				return this;
			}
			public User build() {
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
				user.setPhone(phone);
	
				return user;
			}
		}
	
	}

