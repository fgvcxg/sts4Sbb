package com.mysite.sbb;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HelloLombok2 {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;

	public static void main(String[] args) {
		//객체 생성후 테스트0
		
		HelloLombok2 ll = new HelloLombok2();
		
		ll.setSeq(0);
		ll.setTitle("title");
		ll.setWriter("man");
		ll.setContent("qwerty");
		ll.setRegdate(null);
		ll.setCnt(0);
		
		System.out.println(ll.getSeq());
		System.out.println(ll.getTitle());
		System.out.println(ll.getWriter());
		System.out.println(ll.getContent());
		System.out.println(ll.getRegdate());
		System.out.println(ll.getCnt());
		
		System.out.println(ll);
	}

}
