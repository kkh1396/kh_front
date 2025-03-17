package com.kh.generic.ex1;


// 제네릭 적용전
public class Box {

	private Object ob;
	// Object 클래스는 최상위 클래스로, 모든 클래스의 인스턴스를 저장할 수 있음!(참조가능)

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}
	
}

class Apple {

	@Override
	public String toString() {
		return "I'm an apple.";
	}

}


class Orange {

	@Override
	public String toString() {
		return "I'm an Orange.";
	}
	
}
