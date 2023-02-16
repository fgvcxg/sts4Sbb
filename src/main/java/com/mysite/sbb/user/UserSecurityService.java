package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService{
	//UserDetailsService 를 구현하는 이유
		//UserDetailsService 는 loadUserByUsername 메서드를 구현하도록 강제하는 인터페이스
		//loadUserByUsername 메서드는 사용자명으로 비밀번호를 조회하여 리턴하는 메서드이다
	
	//UserSecurityService는 스프링 시큐리티 로그인 처리의 핵심 부분
	
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<SiteUser> _siteUser = this.userRepository.findByUsername(username);
		
		if(_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		
		SiteUser siteUser = _siteUser.get();
		
		List<GrantedAuthority> authoritise =  new ArrayList<>();
		
		if("admin".equals(username)) {
			authoritise.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		}else {
			authoritise.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		
		return new User(siteUser.getUsername(), siteUser.getPassword(), authoritise);
	}
	
	
	

}
