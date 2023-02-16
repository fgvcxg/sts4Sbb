package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	
	//사용자를 조회하는 기능이 필요
	Optional<SiteUser> findByUsername(String username);

}
