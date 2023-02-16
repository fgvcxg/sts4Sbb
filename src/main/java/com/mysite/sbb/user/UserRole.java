package com.mysite.sbb.user;

import lombok.Getter;

@Getter
public enum UserRole {
	/*enum 으로 사용한 이유에 관하여
		enum 은 상수를 보유할 수 있는 것이다.
		따라서
		
		private final static String 00 = 00 이라고 작성해야 할 것을 확연하게
			줄일 수 있기에 enum을 쓴 것이다
			
		
		
	*/
	
	
	//스프링 시큐리티는 인증 뿐만 아니라 권한도 관리한다. 따라서 인증 후에 사용자에게 부여할 권한이 필요하다.
	//아래와 같이 ADMIN USER 2개의 권한을 갖는 UserRole 을 만든다
	//각각의 변수와 변수 값을 고정한 것이다. ADMIN에는 ROLE_ADMIN이 들어간 것이다. 이 수는 고정이다
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
	
	private String value;
	
	UserRole(String value) {
		this.value = value;
	}

}
