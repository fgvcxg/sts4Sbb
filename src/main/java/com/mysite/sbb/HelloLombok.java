package com.mysite.sbb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor	//기본 생성자를 자동으로 생성해줌 
@ToString
public class HelloLombok {
	
	private String hello;
	private int lombok;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//위에 생성된 클래스의 내용이 롬북이 잘 적용되었는지 확인
		//객체 생성 <== 객체 내부의 필듸와 메소드를 사용함
		HelloLombok lombok = new HelloLombok();
		
		//setter를 사용해서 값을 입력
		lombok.setHello("hihi");
		lombok.setLombok(40);
		
		//getter를 사용해서 값을 출력
		System.out.println(lombok.getHello());
		System.out.println(lombok.getLombok());
		
		//toString() 메소드 호출
		System.out.println(lombok);
		

	}

}
