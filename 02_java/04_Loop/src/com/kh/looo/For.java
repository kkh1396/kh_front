package com.kh.looo;


import java.util.Scanner;

public class For {
	
	/*
	 * 반복문 : 프로그램 흐름을 제어하는 제어문 중 하나로 
	 * 		   특정 코드를 반복적으로 수행하는 문법
	 * *For 문*
	 * [표현식]
	 *        for(초기식;조건식;증감식) {
	 *           //반복적으로 수행할 코드
	 *        }
	 *  * 초기식 : 반복문이 수행될 때 "최초" 한번만 실행되는 구문
	 *  * 조건식 : 반복문이 "수행될 조건"을 작성하는 구문 
	 *       - 조건식의 결과가 true일 때 -> 중괄호 안의 코드 수행
	 *       - 조건식의 결과가 false일 때 -> 반복문 종료
	 *  * 증감식 : 반복문을 제어하는 변수의 값을 증감시키는 구문
	 *   ==> 보통 초기식, 조건식, 증감식에서 사용되는 변수가 동일!
	 *   
	 *   [for 실행 순서]
	 *   초기식 -> 조건식 검사 -> true인 경우 반복할 코드 수행 -> 증감식
	 *         -> 조건식 검사 -> true인 경우 반복할 코드 수행 -> 증감식
	 *         ------------------계속 반복 --------------------
	 *         -> 조건식 검사 -> false인 경우 반복문 종료
	 *   
	 *   참고 : 초기식, 조건식, 증감식 생략 가능!
	 *        => 세미콜론(;)은 필수로 입력!
	 *      - 증감식 생략 : for(초기식;조건식;) {}
	 *      - 초기식 생략 : for(;초기식;조건식) {}
	 *      - 조건식 생략 : for(초기식;;증감식) {}
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
		method8();
	}
	
	public static void method8() {
		// 2단부터 9단까지 출력
		
//		for (int i=1; i<=9; i++) {
//			System.out.printf("\n");
//			System.out.printf("=========================================== \n");
//			System.out.printf("%d단 입니다 \n",i);
//			
//			for (int j=1; j<=9; j++) {
//				int sum = i * j;
//				System.out.printf("%d x %d = %d \n",i,j,sum);
//			}
//		}
		   
		for (int i=1; i<=9; i++) {
			
			for  (int j=2; j<=9; j++) {
				int sum = i * j;
				System.out.printf("%d x %d = %d\t",j,i,sum);				
			}
			System.out.println();
		}
		
	}
	public static void method7() {
		// 사용자에게 2~9사이의 정수를 입력받아 
		// 해당 구구단을 출력하기
		Scanner sc = new Scanner(System.in);
		
		System.out.println("2~9 사이의 정수 입력");
		int num = sc.nextInt();
		
		
		if ( 2 <= num && num <=9  ) {	
		 for (int i=1; i<=9; i++) {
				 int dan = num * i;
				 System.out.printf("%d x %d = %d \n",num,i,dan);
		 }
		}else {
			 System.out.printf("입력범위를 벗어났습니다");
		}
	}
	
	
	public static void method6() {
		// 상수로 변수 선언시에는 변수는 대문자로 선언 
		final String STR = "Story";
		// 각 인덱스(위치) 별 문자를 한 줄씩 출력
		// => 문자열 길이 : 문자열.length()
		// => 문자열의 인덱스 위치의 문자 조회 : 문자열.charAt(인덱스)
		/*
		 * 출력 결과 :
		 * S
		 * t
		 * o
		 * r
		 * y
		 */
		
		 for (int i=0; i< STR.length(); i++) {
			 char t = STR.charAt(i);
			 System.out.println(t);
		 }
		
		
	}
	
	
	public static void method5() {
		// 랜덤값을 조회하여 1부터 해당 값까지의 총 합
		/*
		 *  [랜덤값 구하는 방법]
		 *  -Math : java.lang.Math
		 *  		random()
		 *  => Math.random() 호출하여 사용
		 *     0.0 ~ 0.9999999 ( 0.0 <= random값 < 1.0)
		 * 
		 */
		// Math.random() * 10     // 0.0 ~ 9.99999
		// Math.random() * 10 + 1 // 1.0 ~ 10.999999
		// (int)(Math.random() * 10 + 1 ) // 1 ~ 10
		
		int num = (int)(Math.random() *10 +1);
		
		int sum = 0;
		for (int i=0; i <= num; i++) {
			sum += i;
		}
//		System.out.println("랜덤값은 : "+ num +" 합은 " +sum);
		System.out.printf("랜덤값은 : %d 합은 : %d ",num,sum);
		
		
		
		
		
		
	}
	
	public static void method4() {
		// TODO: 사용자로부터 1~10 사이의 정수를 입력받아
		// 1부터 입력받은 값까지의 총 합을 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1~10 사이의 정수 입력");
		int num = sc.nextInt();
		
//		int total=0;
//		for (int i=0; i<=num; i++) {
//			total += i;
//		}
//		System.out.print(total);
		
		
		if (1 <= num && num <= 10) {
			//1부터 입력받은값(num)까지의 총 합 계산
			int sum = 0;
			for(int i=1; i<=num; i++) {
			   sum += i;	
			  
			}
			System.out.printf("1부터 %d까지의 총 합 : %d \n",num,sum);
		} else {
			System.out.print("범위를 벗어난 값이 입력되었습니다.");
		}
	}
	
	
	public static void method3() {
		//TODO : 1부터 10까지의 총 합을 구해서 출력
		
		int total = 0;
		for (int i=1; i<11; i++) {
			total += i;	
		}
		System.out.print(total);
	}
	
	public static void method2() {
		 // 반복문(for)을 사용하여 10부터 1까지 출력
		 
		int i;
		for (i=10; i>0; i--) {
			System.out.print(i+" ");
			if (i >1) {
				System.out.print(" ");
			}
		}
		
		
		
	}
	
	public static void method1() {
		// "Happy" 5번 출력
//		System.out.println("Happy");
//		System.out.println("Happy");
//		System.out.println("Happy");
//		System.out.println("Happy");
//		System.out.println("Happy");
//		
//		System.out.println("");
		
		 
//		for (int i=0;i<5; i++) {
//			System.out.println("Happy");
//		}
		
		int i=0;
		for (i=0;i<5; i++) {
			System.out.println("Happy");
		}
		System.out.println(i);
		// 반복문 종료 후 i값을 확인하고자 할 경우..?
	}
	

}
