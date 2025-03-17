package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {

	}

	public String afterToken(String str) {
//		public void afterToken(String str) {

		StringTokenizer st = new StringTokenizer(str, " ");
		
		String[] arr = new String[str.length()];
		String sum = "";
		while (st.hasMoreTokens()) {
			sum += st.nextToken();
			
		}
		
		return sum; 
	}

	public String firstCap(String input) {

		if (input.length() <= 1) return input;
		
		
		return input.substring(0, 1).toUpperCase() 
				+input.substring(1)	;


	}
	/*
	 *  문자열 안에 찾을 문자 개수가 몇 개 들어가있는지 반환
	 *  @param input 문자열
	 *  @param one 찾을 문자
	 *  @return 문자열 내의 찾을 문자 개수
	 * 
	 */

	public int findChar(String input, char one) {

		int count =0;
		// * charAt() 메소드 사용
		for (int i=0; i<input.length();i++) {
			if(input.charAt(i) == one) {
				count++;
			}
		}
		
		
		return count;
	}
}
