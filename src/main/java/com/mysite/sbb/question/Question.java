package com.mysite.sbb.question;

import java.time.LocalDateTime;	//자신의 시스템의 로컬의 시간 설정
import java.util.List;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;	//JPA 에서 적용된 어노테이션
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Question {
	
	@Id	//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//시퀀스 할당
	private Integer id;	//Primary key, 시퀀스 (1, 1)
	
	@Column(length = 200)	//200자까지
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	//Question 테이블에서 Answer 테이블을 참조하는 컬럼을 생성 @OnetoMany
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	//여러개의 질문이 한 명의 사용자에게 작성 될 수 있으므로 @ManyToOne 관계 성립
	@ManyToOne
	private SiteUser author;
	
	private LocalDateTime modifyDate;
	

}
