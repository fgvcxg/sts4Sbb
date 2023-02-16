package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jayway.jsonpath.Option;
import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootTest
class SbbApplicationTests {

	private QuestionService questionService;

	@Autowired // 객체 자동 주입, JPA 의 CRUD 할 수 있는 메소드가 적용되어 있음
	private QuestionRepository questionRepository;

	@Autowired // 객체 자동 주입(DI), JPA 의 메소드를 사용, findAll(), findById(), sa
	private AnswerRepository answerRepository;

//	@Test
//	void testJpa() {
//		for (int i = 1; i <= 300; i++) {
//			String subject = String.format("테스트 데이터입니다:[%03d]", i);
//			String content = "내용무";
//			this.questionService.create(subject, content, null);
//		}
//	}

	/* Answer 페이블에 더미 데이터 입력 */
//	   @Test
//	   public void insertAnswer() {
//	      Question q = new Question();
//	      Answer a = new Answer();
//	      
//	      //Question 객체 질문에 대한 값을 가지고 와서 answer question필드에 넣어준다.
//	      Optional<Question> op =
//	      this.questionRepository.findById(2);
//	      q = op.get();
//	      
//	      a.setContent("2번 글에대한 답변입니다. - 3");
//	      a.setCreateDate(LocalDateTime.now());
//	      a.setQuestion(q);
//	      
//	      this.answerRepository.save(a);
//	   }

	/* Question 테이블에 for 문을 사용해서 더미값 1000개 insert */
	   @Test
	   public void insert1000() {
	      Question q = null;   // 여기서 new 해 만들면 하나의 객체를 쓰기에 안된다.(변수선언만)
	      
	      //for 문을 사용해서 레코드 1000개 insert
	      for(int i = 1; i<=1000; i++) {
	         q = new Question();
	         q.setSubject("제목 - " + i);
	         q.setContent("내용 - " + i);
	         q.setCreateDate(LocalDateTime.now());
	         
	         this.questionRepository.save(q);
	      }
	   }

	/* 하나의 질문에 여러개의 답변 찾기 */
//	@Transactional	//아래의 메소드가 하나의 트랜잭션으로 작동되도록 설정
//	@Test
//	public void testjpa8() {
//		//1. Question 테이블에서 질문의 레코드를 얻어온다. 끄집어 낸다.
//		Optional<Question> q =
//			this.questionRepository.findById(1);
//		
//		Question qq = null;
//		
//		//2. 갖고온 객체의 q.getAnswerList() <==  갖고온 객체의 답변글을 얻어온다
//		if(q.isPresent()) {
//			qq = q.get();
//		}
//		
//		//Question 객체의 AnswerList 컬럼은 List<Answer>
//		List<Answer> all =
//				qq.getAnswerList();
//		
//		//3. 출력 구문에서 출력한다
//		
//		
//		for(int i = 0; i<all.size(); i++) {
//			Answer a = all.get(i);
//			System.out.println(a.getContent());
//			System.out.println();
//		}
//	}

	/* 답변 레코드 하나 갖고 오기 */
//	@Test
//	public void testjpa7() {
//		Optional<Answer> aa =
//		this.answerRepository.findById(2);
//		
//		if(aa.isPresent()) {	//inPresent() : null (false), not null(true)
//			Answer a = aa.get();
//			System.out.println(a.getId());
//			System.out.println(a.getContent());
//			System.out.println(a.getCreateDate());
//		//	System.out.println(a.getQuestion());
//		}
//		
//	}

	/* Answer 테이블에 Insert 처리 */
//	@Test
//	public void testAnswerJpa() {
//		//1. Question (부모) 테이블의 답변을 처리할 레코드를 먼저 select 한다. findById(1)
//		Optional<Question> op = 
//				this.questionRepository.findById(3);
//		Question q = op.get();
//		
//		//2. Answer 엔티티 테이블의 객체 생성을 하고, setter 를 사용해서 값을 넣는다.
//		//	setQuestion(q)
//		Answer a = new Answer();
//		a.setQuestion(q);
//		a.setContent("qwe3");
//		a.setCreateDate(LocalDateTime.now());
//		
//		//3. save 메소드를 사용해서 저장
//		this.answerRepository.save(a);
//	}

	/* 데이터 삭제 : JPA 메소드 : delete() */
//	@Test
//	public void testjpa6() {
//		//1. 테이블에서 삭제할 레코드를 가지고 온다
//		Optional<Question> op = 
//				this.questionRepository.findById(2);
//		//2. Optional 에 저장된 객체를 끄집어 낸다
//		Question q = op.get();
//		//3. delete()
//		this.questionRepository.delete(q);
//	}

	/* 데이터 수정 : save() */
//	@Test
//	public void testjpa5() {
//		//1. 수정할 객체를 findById() 메소드를 사용해서 가지고 온다
//		Optional<Question> op =
//				this.questionRepository.findById(1);
//		//2. 가지고 온 객체를 끄집어 내서 setter를 사용해서 수정
//		Question q = op.get();
//		q.setContent("수정");
//		q.setSubject("수정");
//		//3. 수정된 객체를 save(q)
//		this.questionRepository.save(q);
//	}

	/* 테이블의 모든 레코드 정렬 */
//	@Test
//	public void testjpa4() {
//		List<Question> all =
//				this.questionRepository.findAllByOrderByCreateDateAsc();
//		
//		System.out.println(all.size());
//	

	/* 특정 조건을 사용해서 검색후 정렬해서 출력 */
//	@Test
//	public void testjpa3() {
//		List<Question> or =
//				this.questionRepository.findBySubjectLikeOrderByCreateDateAsc("%sbb%");
//		
//		for(int i = 0; i < or.size() ; i++) {
//			Question q = or.get(i);
//			System.out.println(q.getId());
//		}

//		for(Question q : or) {
//			System.out.println(q);
//		}
//	}

	/* 두컬럼을 and 연산으로 검색 : subject, content */
//	@Test
//	public void testjpa2() {
//		List<Question> sqq = 
//				this.questionRepository.findBySubjectLikeAndContentLike("%question%", "%auto%");
//		
//		Question q = sqq.get(0);
//		System.out.println("리스트에 검색된 레코드수 : " + sqq.size());
//		System.out.println(q.getId());
//		System.out.println(q.getSubject());
//		System.out.println(q.getContent());
//	}

	/* 두컬럼을 or 연산으로 검색 : subject, content */
//	@Test
//	public void testjpa2() {
//		List<Question> sq = 
//				this.questionRepository.findBySubjectLikeOrContentLike("%sbb%", "%auto%");
//		
//		Question q = sq.get(0);
//		System.out.println("리스트에 검색된 레코드수 : " + sq.size());
//		System.out.println(q.getId());
//		System.out.println(q.getSubject());
//		System.out.println(q.getContent());
//	}

	/* 사용자 정의 select 문 : subject 컬럼, content 컬럼 검색, Like */
//	@Test
//	public void testjpa() {
//		List<Question> all = this.questionRepository.findBySubjectLike("%sbb%");
//		
//		Question q = all.get(0);
//		System.out.println("리스트에 검색된 레코드수 : " + all.size());
//		System.out.println(q.getId());
//		System.out.println(q.getSubject());
//		System.out.println(q.getContent());
//		
//		System.out.println("========================");
//		
//		List<Question> all2 = this.questionRepository.findByContentLike("%auto%");
//		Question q2 = all2.get(0);
//		System.out.println("리스트에 검색된 레코드수 : " + all.size());
//		System.out.println(q2.getId());
//		System.out.println(q2.getSubject());
//		System.out.println(q2.getContent());
//		
//		
//	}

	/*
	 * 조건에 맞는 레코드 하나만 가져오기 Question 테이블의 Primary key 컬럼은 기본적으로 제공됨 : findById()
	 * 
	 */
//	@Test
//	public void jpaTestget() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			System.out.println(q.getId());
//			System.out.println(q.getSubject());
//			System.out.println(q.getContent());
//			System.out.println(q.getCreateDate());
//		}
//		
//	}

//	/* Select List JUnit Test */
//	@Test
//	public void jpaTest() {
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(4, all.size());	// assertEquals(기대값, 실제값) , 두 값이 일치 : 성공
//		
//		Question q = all.get(0);	//List all 변수에 담긴 0번방의 Question 객체를 갖고온다.
//		assertEquals("what is sbb", q.getSubject());
//		
//		System.out.println(q.getId());
//		System.out.println(q.getSubject());
//		System.out.println(q.getContent());
//		System.out.println(q.getCreateDate());
//	}

//	@Test
//	void contextLoads() {
//		Question q1 = new Question();
//		q1.setSubject("what is sbb");
//		q1.setContent("i wanna know the sbb");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		q2.setSubject("question about spring boot");
//		q2.setContent("auto generate id");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);		
//	}

}
