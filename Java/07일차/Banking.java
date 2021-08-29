package day2;
/**
 * 신규계좌등록, 계좌조회, 입금, 이체, 비밀번호변경, 해지환급금 조회기능을 제공하는 객체를 생성할때
 * 필요한 클래스다.<br/>
 * Banking 객체는 Account를 여러개 저장하는 배열을 맴버변수로 가지고 있다.<br/>
 * Banking 객체는 Account가 배열의 몇번째 칸에 저장되는지 알려주는 멤버변수를 가지고 있다.<br/>
 * 
 * @author jungeun-kim
 */
/* 1. 신규계좌등록기능은 
 * 		a. 계좌번호, 예금주면, 최초입금액, 비밀번호를 매개변수로 전달받는다. 
 * 		b. 위의 정보를 저장하기 위해서 Account객체를 생성한다. 
 * 		c. 생성된 Account객체의 멤버변수(no, owner, balance, password)에
 * 		   매개변수로 전달받은 값을 대입한다. 
 * 		d. 계좌정보가 저장된 Account객체를 accounts 배열의 savePosition번째에 저장한다.
 * 			*savePosition의 초기값은 0이다. 
 * 		e. savePosition의 값을 1증가시킨다.
 * 			* 신규 계좌등록기능이 호출될 떄마다 배열의 0번째부터 순서대로 Account객체가 저장된다. 
 * 
 *  2. 계좌정보 조회기능
 *  	a. 계좌번호, 비밀번호를 매개변수로 전달받는다.
 *  	b. 조회된 계좌정보(Account객체)를 저장할 Account타입의 searchedAccount 변수를 생성한다.
 *  		Account searchedAccount = null;
 *  	c. 향상된 for문을 이용해서 배열에 저장된 Account객체를 순서대로 하나씩 가져온다. 
 *  		for(Account account: accounts){
 *  			i. account 변수에 대입된 Account 객체의 계좌번호/비밀번호와 
 * 				   매개변수로 전달받은 계좌번호/비밀번호가 일치하는 Account객체가 존재하면
 * 				ii. b에서 생성한 searchedAccount에 account변수에 저장된 Account객체를 대입한다. 
 *  		}
 *  	d. searchedAccount에 저장된 Account객체를 반환한다.
 *  		* 일치하는 계좌정보가 존재하지 않을 경우 null이 반환될 수 있다. 
 */
public class Banking {
// 실제로 구현하는 클래스, 배열과 객체 두개의 변수가 존재 

	Account[] accounts = new Account[5];
	int savePosition = 0;
	/**
	 * 계좌번호, 예금주, 최초잔액, 비밀번호를 전달받아서, 신규 계좌정보를 배열에 저장한다. 
	 * @param accNo 계좌번호 
	 * @param accName 예금주명 
	 * @param accBalance 최초잔액 
	 * @param accPassword 비밀번호 
	 */
	
	// 신규계좌 개설(등록) 기능 
	// 등록 기능 ->  반환값이 없음
	// 매개변수: 계좌번호, 사용자명, 최초잔액, 비밀번호 
	void insertAccount(int accNo, String accName, long accBalance, int accPassword) {
	
		System.out.println("신규 계좌번호: " + accNo);
		System.out.println("신규 예금주명: " + accName);
		System.out.println("신규 최초잔액: " + accBalance);
		System.out.println("신규 비밀번호: " + accPassword);
		
		// 메소드 호출시 매개변수로 전달된 정보(계좌번호, 예금주, 잔액, 비밀번호)를 담는 Account객체 생성 
		Account account = new Account();
		// 생성된 Account객체의 맴버변수에 매개변수로 전달받은 값 대입 
		account.no = accNo;
		account.owner = accName;
		account.balance = accBalance;
		account.password = accPassword;
		
		// 생성된 Account객체를 accounts배열에 저장하기
		// savePosition은 배열에서 저장위치를 지정한다. 
		accounts[savePosition] = account;
		// 저장이 완료되면 savePosition의 값을 1증가시켜 다음 칸에 저장되도록 한다. 
		savePosition++;
		System.out.println("## 신규 계좌가 배열에 등록되었습니다.");
	}
	/**
	 * 계좌번호, 비밀번호를 전달받아서 계좌번호에 해당하는 계좌정보를 찾아서 제공한다.
	 * @param accNo 조회할 계좌의 계좌번호 
	 * @param accPassword 조회할 계좌의 비밀번호 
	 * @return 조회된 계좌 정보
	 */

	// 계좌번호 조회기능 
	// 반환값: 있음 (조회기능) [Account 객체]
	// 매개변수: 계좌번호, 비밀번호 
	Account getAccountByNo(int accNo, int accPassword) { //반환타입이 Account이다. 
		System.out.println("전달받은 계좌번호: " + accNo);
		System.out.println("전달받은 비밀번호: " + accPassword);
		
		Account searchedAccount = null;
		
		// 배열에서 Account객체를 하나씩 순서대로 조회해서 계좌번호와 비밀번호가 일치하는 계좌정보를 찾기 
		for(Account account : accounts) {
			System.out.println("전달받은 계좌번호: " + account.no);
			System.out.println("전달받은 비밀번호: " + account.password);
			// 배열에서 꺼낸 Account 객체의 계좌번호와 비밀번호가 매개변수로 전달받은 계좌번호, 비밀번호와 일치하면
			// 그 Account객체를 searchedAccount에 대입한다. 
			if(account.no == accNo && account.password == accPassword) {
				System.out.println("일치하는 계좌정보를 가진 Account객체를 searchedAccount에 대입함");
				searchedAccount = account;
				break;
			}
		}
		System.out.println("최종 조회결과: " + accNo);
		return searchedAccount;
	}
	/**
	 * 계좌번호, 이전비밀번호, 새비밀번호를 전달받아서 해당 계좌의 비밀번호를 변경한다. 
	 * @param accNo 비밀번호를 변경할 계좌의 계좌번호 
	 * @param oldPassword 이전 비밀번호 
	 * @param newPassword새 비밀번호 
	 */
	
	// 비밀번호 변경기능
	// 반환값: 없음 (변경기능)
	// 매개변수: 계좌번호, 구비밀번호, 새비밀번호 
	
	void changePassword(int accNo, int oldPassword, int newPassword) {
		
	}
	/**
	 * 
	 * @param accNo
	 * @param amount
	 */
	// 적금 기능
	// 반환값: 없음 (잔액 변경기능)
	// 매개변수: 계좌번호, 입금액 
	
	void deposit(int accNo, long amount) {
		
	}
	/**
	 * 
	 * @param accNo
	 * @param amount
	 * @param password
	 * @param otherAccNo
	 */
	// 이체 기능 
	// 반환값: 없음 (잔액 변경기능)
	// 매개변수: 계좌번호, 이체금액, 비밀번호, 수신측계좌번호
	
	void transaction(int accNo, long amount, int password, int otherAccNo) {
		
	}
	/**
	 * 계좌번호, 비밀번호를 전달받아서 해당계좌의 해지환급금액을 알려준다.
	 * @param accNo 계좌번호 
	 * @param password 계좌비밀번호 
	 * @return 해지시 환급예상금액 
	 */
	// 해지금액 조회 기능 
	// 반환값: 있음 (조회기능)
	// 매개변수: 계좌번호, 비밀번호 	
	int getCancelBalance(int accNo, int password) {
		return 0;
	}
	
	
}
