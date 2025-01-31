package com.kh.condition;

import java.util.Scanner;

public class If {

	
	/*
	 *  조건문 if
	 *  : 기본적으로 프로그램은 순차적으로 진행 (위->아래, 왼쪽->오른쪽)
	 *    순차적인 흐름을 바꿀때 제어문(조건문, 반복문, ..)
	 * 
	 *  : 조건문 - 조건에 따라 선택적으로 실행할 때
	 *  : 반복문 - 반복적으로 실행할 때  
	 *  
	 *  : "조건식"을 통해 참인지, 거짓인지 판단하여 그에 해당하는 코드를 실행
	 *   => 조건식의 결과 : true, false
	 *   => 연산자 : 비교연산자(>< == ..), 논리연산자(&&||)를 주로 사용
	 *   
	 *   : 조건문의 종류 : if, switch
	 *    * if
	 *        [1] 단독 if문
	 *          	if( 조건식 ) {
	 *               // 조건식이 참인 경우 실행할 코드
	 *          }
	 *          // => 조건식이 거짓인 경우 실행되는 내용은 없음!
	 *          
	 *        [2] if ~ else 문
	 *           if (조건식) {
	 *              // 조건식이 참인 경우 실행할 코드
	 *           } else {
	 *               // 조건식이 거짓인 경우 실행할 코드
	 *           }
	 *           
	 *        [3] if ~ else if ~ else 문
	 *           if (조건식) {
	 *               // 조건식이 참인 경우 실행할 코드
	 *           } else if (조건식2) {
	 *           	// 조건식이 거짓이고, 조건식2가 참인 경우 실행할 코드
	 *           }  else {
	 *           	// 조건식, 조건식2 모두 거짓인 경우 실행할 코드
	 *           }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 method1();
//		 method2();
		 method3();
	}
	
	public static void method3() {
		/*
		 *  주민번호 입력받아서 남자인지, 여자인지 출력
		 *  (단 - 포함해서 입력받은 값의 길이가 14가 아닌 경우 "잘못 입력되었습니다." 출력)
		 *  * 문자열 길이 확인 메소드 : 문자열.length()
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요(xxx-xxx 형태로 작성)");
		String al = sc.next();
		
		char a2 = al.charAt(7);

		
		
		if ( al.length() == 14) {
			if ( a2 =='1') {
				System.out.print("남자 \n");
			} else if ( a2 =='2'){
				System.out.print("여자 \n");
			} else {
				System.out.print("잘못 입력");
			}
		} else {
			System.out.print("잘못 입력");
		}
		
	}
	
	public static void method2() {
		/*
		 *  문자를 입력받아 소문자인 경우 "{입력받은값}은 소문자입니다." 출력
		 *  대문자인 경우 "{입력받은값}은 대문자입니다." 출력
		 *  그렇지 않으면 "알파벳이 아닙니다." 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("알파벳을 입력하세요");
		char al = sc.next().charAt(0);
		
		
		if ( al >= 'a' && al <= 'z') {
			System.out.print("소문자 : "+ al);
			
		} else if ( al >= 'A' && al <= 'Z'){
			System.out.print("대문자 : "+ al);
		} else {
			System.out.print("알파벳이 아닙니다.");
		}
		
	}
	
	public static void method1() {
		/*
		 *  사용자의 입력 값이 1 ~ 10 사이의 값인지 확인하여
		 *  범위를 벗어난 경우 "범위를 벗어났습니다." 출력
		 *  범위 내에 있는 경우 입력값을 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("값의 입력 : ");
		int num = sc.nextInt();
		
		
		if ( num >= 1 && num <= 10) {
			System.out.print("입력값 : "+num);
			
		} else {
			System.out.print("범위를 벗어났습니다.");
		}
		
	}

}
