package com.kh;

public class Variable {
	// 자바 실행 시 꼭 필요한 메소드 : main
	public static void main(String[] args) {
		// printVariable();
		declareVariable();
	}
	
	public static void declareVariable() {
		/*
		 * 변수 선언 : 값을 기록하기 위한 변수를 메모리 공간에 할당(확보)
		 * 
		 * [표현식] 
		 * 			자료형 변수명;
		 * 
		 * 		- 자료형 : 변수의 크기 및 모양을 지정하는 부분
		 * 		- 변수명 : 변수의 이름을 부여하는 부분 (의미 부여!)
		 * * * *
		 * 명명 규칙
		 * 		[1] 카멜케이스 : 소문자로 시작하고, 다른 단어가 붙을 땐 대문자로 시작
		 * 			=> 클래스명의 경우 "대문자"로 시작!!
		 * 		[2] 영문은 대소문자를 구분함
		 * 		[3] 숫자로 시작하면 안됨!
		 * 		[4] 예약어(키워드) 사용 불가!
		 * 		[5] 특수문자 $ 또는 _ 만 사용 가능!!
		 * * * *
		 * 주의 사항
		 * 		- 같은 영역 안({})에서는 동일한 변수명으로 선언 불가 (중복 선언 불가)
		 * 		- 해당 영역 안({})에서 선언된 변수는 그 영역 안에서만 사용 가능.
		 * 			=> 다른 영역에서는 사용 불가!
		 */
		// 정수형 변수 num에 10을 대입
		int num = 10;
		// int num = 20;	// 중복 선언 불가! 같은 이름으로 이미 선언되어 있음.
		int num2 = 20;
		
		// ------------------------------------------
		// 1. 논리형 (boolean) : 논리값 (true/false) 1byte
		boolean isTrue = true;
		boolean isFalse = false;
		System.out.println("isTrue 변수의 값 : " + isTrue);
		System.out.println("isFalse 변수의 값 : " + isFalse);
		
		isTrue = 1 + 3 > 1;	// isTrue 값 : true
		System.out.println("1 + 3 > 1 결과 : " + isTrue);
		isFalse = 2 + 3 < 0;// false
		// ----------------------------------------------
		// 2. 숫자 (정수형/실수형)
		// 2-1) 정수형 : 딱 떨어지는 수. 소숫점 x
		//		byte (1B) / short (2B) / int (4B) * / long (8B)
		
		byte bNum;	// byte : -128 ~ 127
		bNum = -128;
		
		//bNum = 1000; // 범위를 벗어나면 오류 발생!
					  // (byte형) = (int형)
		
		// 2-2) 실수형 : 소숫점 o
		//		float (4B) / double (8B) *
		float fNum = 0.0f;	// 0.0 값을 저장
							// 소숫점 7자리까지 표현 가능한 자료형
							// 값 자체(리터럴)를 저장할 때 값 뒤에 f를 붙여줌
		double dNum = 0;	// 소숫점 15자리까지 표현 가능.
							// 실수형의 기본 자료형*
		// ------------------------------------------------
		// 3. 문자형 ( char / String )
		// 3-1) 문자 : char (2B)
		char ch = 'a';
		char kim = '김';
		
		// 3-2) 문자열 : String (참조자료형)
		String str;
		str = "문자열입니다~~";
		System.out.println("str 변수의 길이 : " + str.length());
		// -------------------------------------------------
		
		// 상수 : 변하지 않는 값을 저장하는 공간
		// [표현식]
		//			final 자료형 변수명;
		
		// TODO: 나이를 저장하기 위한 상수 AGE 선언
		final int AGE;
		AGE = 20;
		
		// AGE = 25;	// 값이 한 번 저장된 이후에 변경 불가능! (재할당 불가능)
		
		// 대표적인 상수 : Math.PI
		System.out.println("Math.PI : " + Math.PI);
		
		// [참고]
		int sample = 999_999_999; // 가독성을 위한 3자리마다 _ 표시 가능!
		System.out.println("sample : " + sample);
	}
	
	public static void printVariable() {
		// System.out.println(num);	// 다른 영역에 있는 변수 사용 불가!
		/*
		 * 변수의 목적?
		 * 	- 데이터(값)를 저장하기 위한 공간
		 *  - 가독성 증가 ( 변수의 이름을 의미있게 지어주어야 함! )
		 *  - 재사용성 증가 ( 한번 값을 저장하면 필요할 때마다 변수이름으로 가져다가 사용 )
		 *  - 유지보수 용이 ( 한번 저장해놓으면 해당 위치의 값을 변경 )
		 */
		
		// 월급 계산 = 시급 x 근무시간 x 근무일수
		//  *출력 형식* --> ooo : 0000원
		//  * 2025 최저시급: 10050
		System.out.println("아이유 : " + 12000*6*7 + "원");
		System.out.println("카리나 : " + 12000*8*7 + "원");
		System.out.println("설운도 : " + 12000*10*7 + "원");
		System.out.println("테스형 : " + 12000*8*7 + "원");
		
		// 변수를 사용한다면..?
		int pay = 12000;	// 정수 자료형(int) pay 변수에 10050 값을 대입(저장)
		int time = 8;
		int day = 7;
		
		System.out.println("-------------------------------");
		// TODO: 변수를 사용하여 위의 내용 출력하기
		System.out.println("아이유 : " + pay*(time-2)*day + "원");
		System.out.println("카리나 : " + pay*time*day + "원");
		System.out.println("설운도 : " + pay*10*day + "원");
		System.out.println("테스형 : " + pay*time*day + "원");		
	}
}





