package com.kh;

import java.util.Scanner;

public class VariablePractice1 {
	
	/*
	 * 실습문제1
	 * 	이름, 성별, 나이, 키를 사용자에게 입력 받아
	 *  각각의 값을 변수에 담고 출력하세요.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("성별을 입력하세요(남/여) : ");
		String gender = sc.next();	// sc.nextLine() => String
		// 문자타입(char)으로 사용하고자 할 경우,
		//    .charAt(인덱스값) : 문자열 인덱스 위치의 한 문자를 반환
		//    "apple".charAt(3) -> 'l'
		char gen = gender.charAt(0);
		
		
		// 나이 -> 딱 떨어지는 수 : 정수형 int
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		// 키 -> 소숫점이 포함되어 있는 수 : 실수형 double
		System.out.print("키를 입력하세요(cm) : ");
		double height = sc.nextDouble();
		
		/*
		System.out.println("키 " + height + "cm인 " 
							+ age + "살 " + gender + "자 " 
							+ name + "님 반갑습니다^^");
		*/
		/*
		System.out.println("키 " + height + "cm인 " 
				+ age + "살 " + gen + "자 " 
				+ name + "님 반갑습니다^^");
		*/
		// * printf 메소드 사용
		//		%s :문자열, %c : 문자, %d : 정수형, %f : 실수형
		//			- 성별 : gender 변수 사용 (String)
		System.out.printf("키 %.1fcm인 %d살 %s자 %s님 반갑습니다^^\n"
							, height, age, gender, name);
		//			- 성별 : gen 변수 사용 (char)
		System.out.printf("키 %.1fcm인 %d살 %c자 %s님 반갑습니다^^\n"
				, height, age, gen, name);
	}
}





