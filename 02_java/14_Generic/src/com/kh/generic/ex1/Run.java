package com.kh.generic.ex1;

public class Run {

	
	public static void main(String[] args) {
		Box aBox = new Box();          // 상자를 만든다.
		aBox.setOb(new Apple());	   // 상자에 사과를 담는다.
		Apple apple = (Apple)aBox.getOb(); // 상자에서 사과를 꺼낸다

		System.out.println(apple);
		
		// * 문제가 생긴다면..
		Box oBox = new Box();  // 상자를 만든다.
		oBox.setOb("Orange");  // 오렌지를 담아야 하는데, 이름을 담았다.
		// ..
		Orange orange = (Orange)oBox.getOb();  //상자에서 오렌지를 꺼낸다.
		// 오렌지를 담지 않았는데, 오렌지를 꺼내려고 했다. => 오류발생
		
		System.out.println(orange);
		
		
	
		
	}
}
