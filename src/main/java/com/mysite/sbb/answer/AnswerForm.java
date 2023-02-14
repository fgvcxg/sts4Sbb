package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerForm {
	
	@NotEmpty(message = "내용이 비어 있습니다. 입력해")
	private String content;
	

}
