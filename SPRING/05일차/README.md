# Java
	AOP 주요 개념
	
	Target		- 핵심 기능이 구현된 객체, 공통 관심사항이 적용될 대상 객체
	Join Point 	- 공통 관심사항이 결합되는 지점, 스프링은 "메소드 실행"만 지원
			  (컴파일, 클래스로딩, 객체 생성, 메소드 실행, 객체의 상태 변경)
	Advice		- 공통 관심사항의 구현체
	(What + When)		* Before Advice		- 대상 메소드 실행전에 실행되는 공통 관심사항 구현체
				* After Returing Advice	- 대상 메소드가 성공적으로 실행된 후에 실행되는 공통 관심사항 구현체
				* After Throwing Advice	- 대상 메소드에서 예외가 발생한 후에 실행되는 공통 관심사항 구현체
				* After Advice		- 대상 메소드의 실행이 종료(정상종료/예외발생 모두)된 후에 실행되는 공통 관심사항 구현체
				* Around Advice 	- 대상 메소드의 실행 전/후에 실행되는 공통 관심사항 구현체
	Pointcut	- Advice를 어떤 Join Point에 결합시킬지를 지정하는 규칙
	(Where)			* 로그 출력을 지원하는 Advice	  - 모든 메소드가 결합 대상이다.
				* 메소드 수행시간 체크를 지원하는 Advice - 모든 메소드가 결합 대상이다.
				* 트랜잭션 처리를 지원하는 Advice	  - 두 개 이상의 데이터베이스 엑세스 작업을 수행하는 메소드가 결합대상이다.
	Aspect		- AOP의 실질적인 구현체, Advice와 Pointcut의 결합체다.
	
	Proxy		- Target의 Join Point에 Aspect가 결합된 객체, Spring 컨테이너가 AspectJ 라이브러리를 이용해서 직접 생성하고,
			  스프링의 빈으로 등록한다. Proxy는 Target의 자식 객체다(따라서 Proxy는 Target과 같은 타입의 객체다).
	
	Weaving		- Target과 Aspect를 엮어서 Proxy객체를 생성하는 것
	
	Pointcut 표현식
		- 포인트컷 지정자
			- execution : advice를 적용할 메소드를 지정한다.
			- within    : advice를 적용할 객체의 타입을 지정한다
		- 포인트컷 와일드 카드
			*	: any one
			..	: all		(매개변수:매개변수의 갯수 제한없음, 패키지경로:하위 패키지)
				사용예)
				execution(public * *(..))	모든 pubic 메소드에 적용
				execution(* set*(..))		set로 시작하는 모든 메소드에 적용
				execution(* set*(*))		set으로 시작하는 메소드중에서 매개변수가 1개 있는 메소드에 적용
				execution(* com.sample.service.ProductService.*(..))
								com.sample.service패키지의 ProductService의 모든 메소드에 적용
				execution(* com.sample.service.*Service.*(..))
								com.sample.service패키지의 클래스나 인터페이스 이름이 
								Service로 끝나는 모든 메소드에 적용
				execution(* com.sample.service.*.*(..))
								com.sample.service의 모든 클래스의 모든 메소드에 적용
				
				execution(* com.sample..*.*(..)) com.sample 패키지의 모든 클래스의 모든 메소드와
								 com.sample의 하위 패키지의 모든 클래스의 모는 메소드에 적용	
				within(com.sample.service.ProductService)
								com.sample.service패키지의 ProductServic의 모든 메소드에 적용
				within(com.sample.service.*Service)
								com.sample.service패키지에서 Service로 끝나는 클래스의 모든 메소드에 적용


