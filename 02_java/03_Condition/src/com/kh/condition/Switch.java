package com.kh.condition;

import java.util.Scanner;

public class Switch {
	/*
	 * if문과 동일한 조건문이지만, 동등비교를 통해 흐름을 제어 실행할 코드만 실행하고 자동으로 종료되지 않음 => 직접 종료될 수 있게 설정!
	 * (break)
	 * 
	 * switch(비교대상) { // 배교대상(변수/식) --> 정수, 문자, 문자열 case 값: // 비교대상 == 값 실행코드; case
	 * 값2: // 비교대상 == 값2 실행코드;
	 * 
	 * ... default: // 모든 case에 해당되지 않을 때 실행코드;
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
//		method2();
		method3();
	}

	
	public static void method3() {
		/*
		 *  "월"을 입력받아 해당 월의 말일이 며칠까지인지 출력
		 *  
		 *  월을 입력하세요: xx
		 *  xx월은 xx일까지입니다.
		 *  
		 *  
		 *  * 1 3 5 7 8 10 12 => 31
		 *  * 4 6 9 11        => 30
		 *  * 2               => 28
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);

		System.out.print("월을 입력하세요");
		int mon = sc.nextInt();
		
		int lastDay1 = 31;
		int lastDay2 = 30;
		int lastDay3 = 28;
		
		
		
		switch (mon) {
		    
		case 1,3,5,7,8,10,12 : {
			System.out.printf("%d은 %d일까지입니다.",mon,lastDay1);
			break;
		}
		case 4,6,9,11 : {
			System.out.printf("%d은 %d일까지입니다.",mon,lastDay2);
			break;
		}
		case 2 : {
			System.out.printf("%d은 %d일까지입니다.",mon,lastDay3);
			break;
		}
		
		}
		
		
		
//		switch (mon) {
//		 
//		case 1 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay1);
//			break;
//		}
//		
//		case 2 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay3);
//			break;
//		}
//		
//		case 3 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay2);
//			break;
//		}
//		
//		case 4 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay2);
//			break;
//		}
//		
//		case 5 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay1);
//			break;
//		}
//		
//		case 6 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay2);
//			break;
//		}
//		
//		case 7 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay1);
//			break;
//		}
//		
//		case 8 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay1);
//			break;
//		}
//		
//		case 9 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay2);
//			break;
//		}
//		
//		case 10 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay1);
//			break;
//		}
//		
//		case 11 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay2);
//			break;
//		}
//		case 12 : {
//			System.out.printf("%d은 %d일까지입니다.",mon,lastDay1);
//			break;
//		}
//		   
//		}
		
		
		
		
	}
	
	
	
	public static void method2() {
		/*
		 * * 과일을 구매하는 프로그램 * 사용자가 구매하고자 하는 과일을 입력하면, 해당 가격을 출력
		 * 
		 * 출력 => {과일이름}의 가격은 {과일가격}원입니다.
		 * 
		 * ----------------------------- 사과 : 15000 포도 : 30000 귤 : 8000
		 * -----------------------------
		 * 
		 */

		Scanner sc = new Scanner(System.in);

		System.out.print("과일을 입력하시오");
		String fruit = sc.nextLine();

		switch (fruit) {
		case "사과": {
			System.out.printf("%s의 가격은 15000원입니다.", fruit);
			break;
		}
		case "포도": {
			System.out.printf("%s의 가격은 30000원입니다.", fruit);
			break;
		}

		case "귤": {
			System.out.printf("%s의 가격은 8000원입니다.", fruit);
			break;
		}
		default: {
			System.out.printf("해당없음");
		}

		}

	}

	public static void method1() {

		Scanner sc = new Scanner(System.in);

		/*
		 * 정수를 입력받아, 아래 조건에 따라 출력. - 1 : "빨간색" - 2 : "파란섹" - 3 : "초록색" - 그외 :
		 * "잘못입력하셨습니다."
		 * 
		 */

		System.out.print("정수를 입력하시오");
		int num = sc.nextInt();
//
//		switch (num) {
//		case 1: {
//			System.out.print("1은 : 빨간색");
//			break;
//		}
//		case 2: {
//			System.out.print("2은 : 파란색");
//			break;
//		}
//		case 3: {
//			System.out.print("3은 : 초록색");
//			break;
//		}
//		default: {
//			System.out.print("그외 :  잘못입력하셨습니다.");
//			break;
//		}
//	  }

		/*
		 * => if문으로 작성한다면...
		 */

		if (num > 0 && num < 4) {
			if (num == 1) {
				System.out.print("1은 : 빨간색");
			} else if (num == 2) {
				System.out.print("2은 : 파란색");
			} else if (num == 3) {
				System.out.print("3은 : 초록색");
			} else {
				System.out.print("그외 :  잘못입력하셨습니다.");
			}
		} else {
			System.out.print("그외 :  잘못입력하셨습니다.");
		}

	}

}
