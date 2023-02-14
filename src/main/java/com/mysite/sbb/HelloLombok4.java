package com.mysite.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor
@RequiredArgsConstructor	//생성자를 생성시 필드이름 앞에 final이 들어있는 필드만 argument 로 생성
//@AllArgsConstructor
public class HelloLombok4 {
	
	private final String hello;
	private int lombok;

	/* @RequiredArgsConstructor
		
		public HelloLombok4( String hello){
			this.hello = hello;
		}
	
	
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloLombok4 lombok4 = new HelloLombok4("qwe");
		
		System.out.println(lombok4.getHello());

	}

}
