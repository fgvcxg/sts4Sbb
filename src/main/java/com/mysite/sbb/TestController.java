package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@GetMapping("test")
	@ResponseBody
	public String test() {
		
		return "Test 코드 블락입니다ㅏewsdddssdf123123";
	}
}
