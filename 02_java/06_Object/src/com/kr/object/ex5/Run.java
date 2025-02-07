package com.kr.object.ex5;

public class Run {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.age = 20;
		
		System.out.println(p1.toString());
		
		Person p2 = new Person("아이유",30);
		System.out.println(p2.toString());
		
		System.out.println("Math.Pi : " + Math.PI);
		System.out.println("Math.random : " + Math.random());
	}
}
