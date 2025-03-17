package com.kh.object.practice1.run;

import com.kh.object.practice1.model.vo.Member;

// => 패키지 경로가 다른 클래스 이므로 import 해야함;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Member m1 = new Member();
		m1.ChangeName("홍길동");
		
		m1.printName();
		
		Member m2 = new Member();
		m2.ChangeName("아이시");
		
		m2.printName();
		
		
	}

}
