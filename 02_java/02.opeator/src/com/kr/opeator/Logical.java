package com.kr.opeator;

import java.util.Scanner;

public class Logical {
	
	/*
	 *  논리 연산자 ( 이항 연산자 )
	 *  : 두 개의 논리값을 연산 ( true/false )
	 *  : 결과값도 논리값
	 * 
	 *  * 종류 : && ||
	 *   - A && B    : A, B 모두 true값이어야 결과값 true.
	 *   
	 *      true && true  => true
	 *      true && false => false
	 *      false && true => false
	 *      false && false => false
	 *   
	 *   - A || B    : A  또는 B 둘중 하나라고 true이면 true.
	 *    true || true => true
	 *    true || false => true
	 *    false || true => true
	 *    false || false => false
	 *   
	 *   
	 *   -------------------------------------------------
	 *   주의 사항. SCe (Short-Circuit Evaluation)
	 *   * && 연산자 : 왼쪽(앞) 조건이 false라면 오른쪽(뒤) 조건은 실행되지 않음
	 *   * || 연산자 : 왼쪽(앞) 조건이 true라면 오른쪽(뒤) 조건은 실행되지 않음!
	 *   
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
		method2();
	}
	
	public static void method2() {
		// TODO: 입력받은 문자가 소문자인지 확인
		// ASCII 'a' : 97 ~ 'z' :122
		
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳을 입력하시오. : ");
		/*
		String spell = sc.nextLine();
		char sp = spell.charAt(0);
		*/
		char ch = sc.next().charAt(0);
		
		boolean result = ((int)ch >96) && (((int)ch <= 122));
		boolean result2 = (ch > 'a') && (ch <= 'z');
		
		System.out.print("입력한 값은 소문자"+ ch + " 유니코드 : " + (int)ch +"\n");
		System.out.print("입력한 값은 소문자"+ ch + " 유니코드 :" + result2);
		
		
		
	}
	
	public static void method1() {
		 // 입력받은 값이 1~10 사이의 값인지 확인
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int Num1 = sc.nextInt();
		
		boolean result1 = ( 1<= Num1 ) &&  (Num1 <= 10 );		
		System.out.printf("해당숫자는 : %d  1~10사이의 숫자이고 %b입니다.. \n" , Num1 , (Num1 < 11));
		System.out.println("1~10사이의 숫자입니다. " + result1);
		
		boolean result2 = ( 1 > Num1 ) ||  (Num1 > 10);
		System.out.printf("해당숫자는 : %d  10이상의사이의 숫자이고 %b입니다.. \n" , Num1, (Num1 >= 11));
		System.out.println("1~10사이의 숫자가 아닙니다. " + result2);
		 
		
	}

	
}
