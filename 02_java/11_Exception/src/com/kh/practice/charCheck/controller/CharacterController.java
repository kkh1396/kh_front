package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {

	
	/* 
	 *  매개변수로 들어온 값에 영문자가 몇 개 들어있는지 반환
	 *  @param ;
	 *  @return 영문자 개수 :int
	 *  @throws CharCheckException
	 * 
	 */
	
	public CharacterController() {};
	public int countAlpha(String s)  throws CharCheckException{
		// 문자열에 공백이 있을 경우 예외 발생!
		// => 문자열.contains(비교문자열) : 문자열 내에 비교문자열이 포함
		
		
		
		if (s.contains(" ")) {
			// CharCheckException 예외 발생시키기!!
			// => throw 예외클래스 객체 생성
			// => throw new 예외클래스생성자
			throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
		}
		int count=0;
		
		// 문자열.toUpperCase():String => 문자열의 알파벳을 모두 대문자로 바꿔서 반환
		// 문자열.toLowerCase():String => 문자열의 알파벳을 모두 소문자로 바꿔서 반환
		
		for(int i=0; i<s.length();i++) {
			char ch = s.charAt(i);
			
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				count++;
			}
		}
		
		return count;
		
		
//		int alpha = 0;
//		int minus = 0;
//		for (int i=0; i<s.length();i++) {
//			char a = s.charAt(i);
//			if ( a >= 'a' && a <= 'z' 
//				 || a >= 'A' && a <= 'Z') {
//				alpha++;
//			} 
//		}
//		return alpha;
	}
}
	