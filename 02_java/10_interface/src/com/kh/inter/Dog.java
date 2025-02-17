package com.kh.inter;

public  class Dog implements Animal {
	
	
	@Override
	public void move() {
		System.out.println("Dog이 걷습니다.");
	}
	
	@Override
	public void eat() {
		System.out.println("Dog이 먹습니다..");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Dog이 멍하고 웁니다.");
	}
}
