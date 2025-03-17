package com.kh.inter;

public  class Rabbit  implements Animal, Baby{

	@Override
	public void move() {
		System.out.println("Rabbit이 걷습니다.");
	}
	
	@Override
	public void eat() {
		System.out.println("Rabbit이 먹습니다..");
	}
	
	@Override
	public void makeSound() {
		System.out.println("Rabbit 웁니다.");
	}
}
