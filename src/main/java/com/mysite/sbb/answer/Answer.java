package com.mysite.sbb.answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // JPA 에서 자바객체를 DataBase의 테이블에 매핑
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@Column(columnDefinition = "TEXT")
	@Column(length = 4000)
	private String content;

	private LocalDateTime createDate;

	@ManyToOne		//Foreign key : 부모테이블의 PK, UK 컬럼의 값을 참조해서 값을 할당
	private Question question; //부모 테이블이 Question 테이블의 primary key 를 참조 (id)
	
	//여러개의 질문이 한 명의 사용자에게 작성 될 수 있으므로 @ManyToOne 관계 성립
	@ManyToOne
	private SiteUser author;
	
	private LocalDateTime modifyDate;
	
	@ManyToMany
	 Set<SiteUser> voter;

	
	
}
