package com.kr.object.ex3;

public class run {

	public static void main(String[] args) {
	
		
		// 클래스명 참조변수명 = new 클래스명();
	    //				* 클래스명() -> 생성자
		Book b1 = new Book();
	    
	    // b1.title = "자바의 정석";
	    // => title 변수에 접근 불가!!
	    // --> 해당 변수는 private으로 선언되어 있어
	    //     해당 클래스(Book)에서만 접근 가능!!
		b1.setTitle("자바의정석");
		String b1Title = b1.getTitle();
		System.out.println(b1Title);
		//---------------------------------------
		
		
		Book b2 = new Book("자바프로그래밍","전공서적","김xx");
		b2.setTitle("Doit 자바프로그래밍 입문");
		
		String info = b2.toString();
		System.out.print(info);
	}
		
	    
	    
}
