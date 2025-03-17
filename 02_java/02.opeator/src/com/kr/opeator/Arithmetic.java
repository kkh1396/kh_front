package com.kr.opeator;

public class Arithmetic {
	
	/*
	 *  산술연산자 ( 이항연산자 )
	 *  => + - / % 
	 *  
	 *   
	 *   우선 순위 : * / % > + -
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 method1();
		 method2();
	}
	
	public static void method2() {
		int a = 5;
		int b = 10;
		
		int c = (++a) + b ; 	// c => 16 a:6 b:10
		int d = c /a;       	// d => 2 
		int e = c%a;			// e => 4
		int f = e++;			// f => 4 e:5
		int g = (--b) + (d--);  // g => 11 b:9 d:1
		int h = 2;
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); // i => 15
		//	     6   + 9  /  3 *  10   %  8
//		          6 + 3 * 10 %8
//		           6 + 30 % 8
		//                       12
		//   a : 7 , b : 9 c: 15 f:4  g:10  d:1   e:6  h:2 
		
		System.out.printf("a: %d b: %d, c: %d, d: %d, e: %d, ",a,b,c,d,e);
		System.out.printf("f: %d g: %d, h: %d, i: %d",f,g,h,i);
	}
	
	public static void method1() {
		int n1 = 10;
		int n2 = 3;
		
		System.out.println("n1 + n2 = "+ (n1 + n2));
		System.out.println("n1 - n2 = "+ (n1 - n2));
		
		System.out.println("n1 * n2 = "+ (n1 * n2));
		System.out.println("n1 / n2 = "+ (n1 / n2));  // => 10 / 3 = 3
		System.out.println("n1 % n2 = "+ (n1 % n2));  // => 10 % 3 = 1
		
		// 나머지 연산자 (%) -> 짝수/홀수 판별
		// (변수 %2 ==0 ) --> 짝수 
		// (변수 %2 !=0 ) --> 홀수
		// => !(변수 %2 ==0)
		System.out.printf("n1의 값은 짝수인가? %b\n ",(n1 % 2 == 0)); // true
		System.out.printf("n2의 값은 짝수인가? %b\n ",(n2 % 2 == 0)); // false
	}

}
