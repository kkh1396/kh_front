package com.kh.inter;

public class Cat implements Animal {
		// Cat 클래스는 Animal 인터페이스를 구현
	    // => 해당 인터페이스의 추상 메소드를 오버라이딩 해야 함! => 객체 생성 가능!
	    //    추상 메소드를 오버라이딩 하지 않으면 ?
	    //    현재 클래스는 추상메소드를 가지게 되어 추상클래스가 될 것임! => 객체 생성 불가!
	
	@Override
	public void move() {
		System.out.println("Cat이 걷습니다.");
	}
	
	@Override
	public void eat() {
		System.out.println("Cat이 먹습니다..");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Cat이 야옹하고 웁니다.");
	}
}
