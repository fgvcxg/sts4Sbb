package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		//Spring Boot Framework에 HelloController 빈등록
public class HelloController {
	
	@GetMapping("hello")
	@ResponseBody
	public String hello() { //return String
		
		return "hello world - my Web Site";
		
	}

}
