package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor   // DI(생성자에 객체주입)
@Service
public class QuestionService {
   //JPA 메소드를 사용하기 위해 (생성자를 이용한 객체 자동 주입)
   private final QuestionRepository questionRepository;
   
   //메소드선언 : question 테이블의 List정보를 가지고오는 메소드 <2월 14일 수정됨 : paging 처리를 위해>
//   public List<Question> getList(){
//      return this.questionRepository.findAll();
//   }
   
   //Controller에서 getList 메소드 호출시 출력할 page 번호를 매개변수로 받음 : 0, 1, 2, 3
   public Page<Question> getList(int page){
	   
	   //최신글을 먼저 출력하기, 날짜 컬럼(createDate)을 desc해서 출력
	   List<Sort.Order> sorts = new ArrayList();
	   sorts.add(Sort.Order.desc("createDate"));
	   
	   //Pageable 객체에 2개의 값을 담아서 매개변수로 던짐
	   Pageable pageable = PageRequest.of(page,10,Sort.by(sorts));
	   
	   return this.questionRepository.findAll(pageable);
   }
   
   //상세 페이지를 처리하는 메소드 : id를 받아서 Question 테이블을 select(findById(1))
      //해서 select한 레코드를 Question 객체에 담아서 리턴
   public Question getQuestion(Integer id) {
      Optional<Question> op = this.questionRepository.findById(id);
      if(op.isPresent()) {	//op에 값이 존재하는 경우
    	  return op.get();	//Question 객체를 리턴
      }else {
    	  //사용자 정의 예외
    	  //throw : 예외를 강자로 발생
    	  throw new DataNotFoundException("요청한 파일을 찾지 못했습니다");
      }
      
   }
   
   public void create(String subject, String content) {
	   Question question = new Question();
	   question.setContent(content);
	   question.setSubject(subject);
	   question.setCreateDate(LocalDateTime.now());
	   
	   this.questionRepository.save(question);
   }
   
}