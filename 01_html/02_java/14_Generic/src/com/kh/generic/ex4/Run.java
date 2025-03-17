package com.kh.generic.ex4;

public class Run {

	public static void main(String[] args) {
		DBox<String, Integer> b1 = new DBox<>();
		
		b1.set("test1", 100);
//		b1.set(100, "test1"); // => 매개변수 타입 불일치로 오류발생!!
		
		System.out.println(b1); // b1.toString();
		

		// b2 변수 선언
		DBox<Double, Boolean> b2 = new DBox<>();
		b2.set(12.34, false);
		System.out.println(b2);

		
	}

}
