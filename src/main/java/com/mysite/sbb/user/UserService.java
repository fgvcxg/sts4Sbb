package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public SiteUser create(String username, String email, String password) {
		
		SiteUser user = new SiteUser();
		user.setEmail(email);
		user.setUsername(username);
		
		//암호화 하는 클래스 호출 -> 의존성으로 컨테이너에서 받음
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		//패스워드는 반드시 암호화 해서 저장해야 함으로 암호화 클래스로 인코딩해서 저장한다.
		user.setPassword(passwordEncoder.encode(password));
		this.userRepository.save(user);
		
		return user;
	}
	
	//UserService 를 통해 SiteUser를 조회할 수 있는 getUser를 만들기
	public SiteUser getUser(String username) {
		Optional<SiteUser> siteuser	= 
				this.userRepository.findByUsername(username);
		
		if(siteuser.isPresent()) {
			return siteuser.get();
		}else {
			throw new DataNotFoundException("siteuser not found");
		}
	}
}
