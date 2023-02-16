package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	
	
	@Size(min = 3, max = 25)
	@NotEmpty(message = "사용자 id는 필수 항목")
	private String username;
	
	@NotEmpty(message = "비밀번호를 작성해주세요")
	private String password1;
	
	@NotEmpty(message = "비밀번호 확인을 작성해주세요")
	private String password2;
	
	@NotEmpty(message = "사용자 id는 필수 항목")
	@Email
	private String email;
	
	
}
