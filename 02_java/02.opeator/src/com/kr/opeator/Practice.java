package com.kr.opeator;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		example01();
//		example02();
		example03();
	}

	/*
	 * [1] 복합 대입 연산자 : 대입 연산자와 다른 연사를 조합해 하나의 연산자처럼 사용되는 연산자
	 * 
	 * n1 += 10;
	 * 
	 */

	/*
	 * [2] 비교 연산자, 논리 연산자 : 결과 값이 참(true) 또는 거짓(false)
	 * 
	 */
	
	public static void example03() {
		/*
		 *  산술 연산자 활용 예제_
		 *  키와 몸무게를 입력받아 BMI를 계산하여 출력
		 *  * BMI : 몸무게 / (키(m) * 키(m));
		 *  * BMI 판정 기준
		 *     - 18.5 이하 : 저체중
		 *     - 18.5 < BMI <= 22.9 : 정상
		 *     - 23.0 <= BMI <= 24.9 : 과체중
		 *     - 25 <= BMI : 비만
 		 * 
		 * 
		 *  출력 예) "BMI 지수는 20.5로 정상입니다."
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("키 입력(cm) : ");
		double height = sc.nextDouble();
		height *= 0.01;
		// 키 입력 받기
		System.out.print("몸무게 입력(kg) : ");
		// 몸무게 입력 받기
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		String result = bmi <= 18.5 ? "저체중":
			             18.5 < bmi && bmi <= 22.9 ? "정상" :
			            	 23.0 <= bmi && bmi <= 24.9 ? "과제충" : "비만";
		
		System.out.printf("BMI 지수는 %.1f로 %s입니다.\n",bmi,result);
						
		
		
		
		

//		System.out.print("키와 몸무게를 입력하세요");
//		int cm = sc.nextInt();
//		int kg = sc.nextInt();
//		int kg2 = kg * kg;
//		int BMI = cm / ( kg * kg );
//		
//		
//		String result = "";
//		// 저체중 확인
//		result = 18.5 >= BMI ? "저체중" : result ;
//		// 정상 확인
//		result = 18.5 <= BMI && BMI <= 22.9 ? "정상" : result;
//		// 과체중 확인
//		result = 23.0 <= BMI && BMI <= 24.9 ? "과체중" : result;
//		// 비만 확인
//		result = 25 <= BMI ? "비만" : result ;
//		
//		
//		System.out.println("키는 : "+ cm + "몸무게는" + kg  + "몸무게의 제곱 : " + kg2);
//		System.out.print("결과는 : "+ result + "BMI는" + BMI);
		
		
	}

	public static void example02() {

		/*
		 * 나이를 입력받아 초등학생, 중학생, 고등학생인지 구분하여 출력 (+ 그 외에는 "알수없음") 초등학생 : 8살 ~ 13살 중학생 : 14살
		 * ~ 16살 고등학생 : 17살 ~ 19살
		 * 
		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);

		System.out.print("나이를 입력하시오");
		int age = sc.nextInt();

//		String result = " " + (age > 7 && age < 14 ? "초등학생"
//				: (age > 13 && age < 17) ? "중학생" 
//						: (age > 16 && age < 20) ? "고등학생" : "알수없음");
//		System.out.print("나이는 " + age + "이고" + result);

		String result = "알수없음";
		// 초등학생인지 확인
		result = 8 <= age && age <= 13 ? "초등학생" : result;
		// 중학생인지 확인
		result = 14 <= age && age <= 16 ? "중학생" : result;
		// 고등학생인지 확인
		result = 17 <= age && age <= 19 ? "고등학생" : result;
		
		System.out.println("결과 : " + result);

		
		//----------------------------------------
		// SCE => &&, || 연산자가 수행될 때 두 항을 모두 실행하지 않더ㅏ도 
		//          결과를 알 수 있는 경우 뒤쪽 연산을 수행하지 않는다.
		// *  &&  : 앞의 조건이 false일 때 뒤의 조건이 수행 x
		// * ||   : 앞의 조건이 true일 때 뒤의 조건이 수행 x
		int num = 10;
		int i = 3;
		boolean result2 ;
		
		result2 = ((num += 15) < 0 ) && ((i *= 2) > 2);
		System.out.println("===== && 연산 결과 =====");
		System.out.println("result2 : " +result2);
		System.out.println("i : " +i);
		System.out.println("num : "+num);
		// => result2 : false, i :3 , num : 25
		
		result2 = ((num += 15) < 0 ) || ((i *= 2) > 2);
		System.out.println("===== && 연산 결과 =====");
		System.out.println("result2 : " +result2);
		System.out.println("i : " +i);
		System.out.println("num : "+num);
		// => result2 : true, i :6 , num : 25
	}

	public static void example01() {
		/*
		 * 사용자로부터 숫자를 입력받아 그 값을 7L을 더한 결과를 출력 // => 숫자를 입력받을 때 타입을 short 자료형 사용
		 * (.nextShort())
		 * 
		 */

		Scanner sc = new Scanner(System.in);

		System.out.print("값의 입력");
		short sh = sc.nextShort();

//		sh += 7L ;  //"0.0f -> float"
//      sh = sh + 7L;

//		System.out.print("입력 값 : "+ sh + ", 7L을 더한 값 : " + (sh+=7L));
//		sh = (short)(sh + (short)7L);
//		sh = (short) + 7L (long;)

	}
}
