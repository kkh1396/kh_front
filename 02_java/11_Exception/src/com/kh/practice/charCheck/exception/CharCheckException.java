package com.kh.practice.charCheck.exception;

public class CharCheckException extends Exception {

	// (1) 예외 클래스 상속
	// (2) 예외 메시지(detail) 초기화
	//		- 생성자 이용  -> 문자열 값을 전달받아 부모생성자 호출
	//		- getMessgae 메소드 오버라이딩
	// 	+ CharCheckException()
	public CharCheckException() {};
	// + CharCheckException(msg:String)
	public CharCheckException(String msg) {
		super(msg);
	}
	
//	@Override
//	public String getMessage() {
//		return "예외 발생 : 공백이 포함되어 있습니다.";
//	}
}
