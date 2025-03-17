package com.kr.object;

public class Methode02 {

		public static void main(String[] args) {
			
			System.out.println( add(10,20));
			// => 출력 : 30
			System.out.println( add(123,567));
			// => 출력 : 690
			System.out.println( add(55) );
			// => 출력 : 65
			
//			System.out.println( divide(4,3) );
		}
		
		public static int add(int n1, int n2) {
			return n1 + n2;
		}
	
		// * 메소드 "오버로딩" => 같은 이름의 메소드를 여러 개 작성하느 것
		//		(조건) 메소드명이 동일, 매개변수 정보가 다름!!
		public static int add(int n1) {
			return n1 + 10 ;
		}
		
		/*
		 *  반환형이 다르더라도 메소드명과 매개변수 정보가 같은 경우
		 *  오류 발생!! => 오버로딩이 적용되지 않음!
		 *  public static double add(int num) {
		 *    return num;
		 *   }
		 */
		
		 // ---------------------------------------
		
		/*
		 *  return의 두가지 의미
		 *  (1) 반환 값을 돌려줌! ( return 값; )
		 *  (2) 메소드 종료!!    ( return; )
		 *  
		 */
		public static void divide(int n1, int n2) {
			//n2 변수의 값이 0인 경우 메소드 종료!
			if (n2==0) {
				System.out.println("0으로 나눌수 없습니다.");
				return;
			}
			System.out.println("n1 / n2 = " + (n1/n2));
		}
		
}
