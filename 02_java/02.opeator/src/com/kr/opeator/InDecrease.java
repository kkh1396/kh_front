package com.kr.opeator;

public class InDecrease {
	
	/*
	 *  증감 연산자 (단항 연산자)
	 *  
	 *  ++ : 값을 1씩 증가시키는 연산자
	 *  -- : 값을 1씩 감소시키는 연산자
	 *  
	 *  * 처리순서 : 다른 연산자가 있을 경우 *
	 *  - (증감연산자) 변수 : 전위 연산
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
//		 method2();
		 method3();
		
	}
	
	
	public static void method3() {
		int a = 10;
		int b = 20;
		int c = 30;
		
		int r1 = a++;
		
		System.out.printf("a: %d, b: %d, c: %d. r1: %d \n",a,b,c,r1 );
		
		// => a: 11, b: 20, c: 30, r1: 10
		
		int r2 = (++a) + (b++);
		System.out.printf("r2 : %d \n",r2); // 
		// 예상  32      a:12 b:21
		int r3 = (a++) + (--b) + (--c);
		System.out.printf("r3 : %d \n",r3);
		// 예상   12 + +20 +29  49+12  = 61
		//       a : 13 b : 20 c: 29 
		
		System.out.printf("a: %d, b: %d, c: %d. \n",a,b,c);
		
		
		
		
		
		
		
		
	}
	
	public static void method2() {
		int num1 = 20;
		int result1 = ++num1 * 3 ;
		
		System.out.printf("num : %d, result1 : %d \n ", num1 , result1);
		// num1 : 21, result1 : 63
		
		int num2 = 20;
		int result2 = num2++ *3;
		System.out.printf("num2 : %d, reuslt2 : %d",num2, result2);
		// num2 : 21, result2 : 60
	}
	

	public static void method1() {
		int num1 = 10;
		
		System.out.println("num1 : " + num1);
	}
}
