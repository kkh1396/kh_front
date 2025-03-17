package com.kh.generic.ex3;


// 타입 제한하기
// <T extends 클래스 또는 인터페이스>
// => 클래스 또는 인터페이스 상속(구현)하는 타입으로 제한!
//  * 클래스인 경우 해당 클래스도 포함됨!!
public class Box<T extends Number> {
	// => Number 클래스를 상속하는 타입으로 제한
	
	private Object ob;
	// 선언한 타입 매개변수 T로 필드의 타입 지정
	// => 클래스 생성 시 전달된 타입으로 객체가 생성될 것임!!
	

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}
	
}

class Apple  {

	
}


class Orange {

	@Override
	public String toString() {
		return "I'm an Orange.";
	}
	
}
