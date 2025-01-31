package com.kh.looo;

public class While {
	/*
	 * while 문
	 * 
	 * [표현식]
	 * 			//	[초기식] // => 생략 가능!
	 * 			while(조건식) {
	 * 					// 반복적으로 수행할 코드
	 * 
	 * 					// [증감식] => 생략 가능!
	 * 
	 * 				}
	 * 
	 *  * 실행 순서
	 *   - 조건식 검사 -> 조건식의 결과가 true인 경우 중괄호 안의 코드 수행
	 *   -> 조건식 검사 -> 조건식의 결과가 true인 경우 중괄호 안의 코드 수행
	 *   -----------------------계속 반복 --------------------------------
	 *   -> 조건식 검사 -> 조건식의 결과가 false인 경우 반복문 종료
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
		method2();
	}
	
		public static void method2() {
			//For 클랙스의 method5 예제를 while문을 사용하여 작성! 
			
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
			int i = 0;
			while (num >= i) {
				sum += i;
				i++;
				// sum += i++;  //sum에 i값을 더하고 i값을 증가
			
			}
			System.out.printf("랜덤값은 : %d 합은 : %d ",num,sum);
		}
	
	 public static void method1() {
		 //"Happy" 문장을 5번 출력
		 int i = 10;			//초기식
		 while (i>5) {			//조건식
			  System.out.println("Happy");
			  i--;	  			//증감식
		 }
	 }

}
