package com.kh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class exception {

	/*
	 *  *에러 종류
	 *   - 시스템 에러 : 컴퓨터의 오작동으로 발생하는 에러
	 *                 => 코드로 해결할 수 없음 (심각한 오류..)
	 *   - 컴파일 에러 : 문법 상의 오류
	 *    			   => 빨간 줄로 오류를 파악할 수 있음!
	 *    				  (개발자의 실수) -> 발견, 해결 쉬움!
	 *   - 런타임 에러 : 코드 상의 문제는 없으나 실행 중 발생할 수 있는 오류
	 *   			  => 사용자의 실수 또는 미처 처리하지 못한 기능
	 *   - 논리적 에러 : 문법상 문제 없고, 실행 시에도 문제가 없으나 
	 *                프로그램의 의도와 맞지 않은 동작이나 결과를 나타내는 오류 
	 *           
	 *      컴파일 에러, 런타임 에러, 논리적 에러와 같은 개발자가 예측 가능하고 
	 *      수정할 수 있는 에러들을 "예외"라고 표현함! => Exception
	 *      
	 *      이러한 "예외"를 "처리"하는 방법 => "예외처리"
	 *      
	 *      *왜 예외처리를 하는가? (목적)
	 *       [1] 직접 처리 : try~catch문 이용 (=> 메소드 구현부)
	 *       [2] 위임(떠넘기기) : throws 이용 (=> 메소드 머리부)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
//		method2();
		method3();
	}
	
	
	public static void method3() {
		
		// 나만의 예외 만들기 =>  예외 발생 만들기
		// [1] 예외 클래스 정의하기 => MyExption 클래스 추가
		// [2] 예외 발생 시키기 => throw new MyException();
		
		try {
		 // => 예외가 발생됨 --> 예외처리를 해야함!!
//			throw new MyException();
			throw new MyException("내가 만든 예외가 발생");
		} catch(MyException e) {
			System.out.println("내가 만든 예외가 발생!!!");
			System.out.println(">> " + e.getMessage());
		}
		
	}
	
	public static void method2() {
		/*
		 *  Checked Exception
		 *   : 반드시 예외처리를 해야하는 예외(오류)!
		 *  => 조건문 사용 불가: 예측이 불가능한 곳에서 문제가 발생되기 떄문에 예외처리
		 *  =>				 외부 매체와의 입출력 시 발생됨!!
		 *  
		 */
		
		// BufferedReader : Scanner와 같이 키보드로부터 값을 입력받을 수 있는 객체
		//					문자열로 읽어옴!
		
		
		BufferedReader br = new BufferedReader(
								new InputStreamReader(System.in)
				);
		
		String str = null; // 입력된 값 저장하기 위한 변수
		
		// * IOexeption => 반드시 예외처리가 필요!!
		try {
		str = br.readLine();
		} catch(IOException e) {
			System.out.println("오루 발생");
			System.out.println("오루 : "+ e.getMessage());
		}
		
	}
	
	public static void method1() {
		/*
		 *  Unchecked Exception
		 *  : 예외처리가 필수는 아니나 실행 중 발생 가능성이 있는 예외!!
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		try {
		System.out.print("a / b ... a? ");
		int a = sc.nextInt();
		
		System.out.print("a / b ... b? ");
		int b = sc.nextInt();
		
		//  * 예외가 발생할 가능성 있는 코드
			System.out.printf("%d / %d = %d \n", a,b,a/b);
		} catch (ArithmeticException e) {
			System.out.println("산술 연산 오류 발생");
			System.out.println("오류 내용 : " + e.getMessage());
			// * 오류 내용 + 발생 위치
			    e.printStackTrace();
		} 	catch (InputMismatchException e) {
			 System.out.println("오류 발생");
			 System.out.println("오류 내용 : " + e.getMessage());
		 }
			System.out.println("===== method1 종료! =====");
		
	}
	

}
