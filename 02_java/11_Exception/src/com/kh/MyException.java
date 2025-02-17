package com.kh;
/*
 *  나만의 예외 클래스 만들기 
 *  [1] 예외 클래스 상속 ( Exception, ....)
 *  [2] 예외 메시지 초기화 (설정)
 *       - 매개변수가 1개인 생성자 이용
 *       - getMessage 메소드 오버라이딩
 * 
 */

public class MyException extends Exception {

	public MyException() {}
	
	public MyException(String msg) {
		//전달된 값을 부모생성자를 통해 초기화
		 super(msg);
	}
	
}
