package com.kh.object.practice3.model.vo;

public class Circle {

	private double Pi = 3.14;
	private int radius = 1 ;
	
	public Circle() {
		this.getAreaOfCircle();
		this.getSizeOfCircle();
	}
	
	public void incrementRadius(int rad) {
		this.radius += rad;
		getAreaOfCircle();
		getSizeOfCircle();
	}
	
	// 원의 둘레
	public void getAreaOfCircle() {
		System.out.println("원의 둘레 : "+radius * Pi);
		
	}

	// 원의 넓이
	public void getSizeOfCircle() {
		System.out.println("원의 넓이 : "+ radius * radius * Pi);
}
	
	
	
			
}
