package com.mysite.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor	//객체 생성시 모든 필드의 값을 입력 받아 필드의 초기값을 할당
public class HelloLombok3 {
	
	private String hello;
	private int lombok;
	
	/*
	public HelloLombok3(){} <== 기본생성자@NoArgsConstructor
	public HelloLombok3(String hello, int lombok){ <==@AllArgsConstructor
		this.hello = hello;
		this.lombok = lombok;
	}
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HelloLombok3 lombok3 = new HelloLombok3("123",123);
		
		System.out.println(lombok3.getHello());
		System.out.println(lombok3.getLombok());

	}

}
