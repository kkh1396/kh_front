package com.Practice1;

import java.util.Scanner;

public class VariablePractice_01 {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		method1();
//		method2();
//		method3();
		method4();
	}
	
	public static void method4() {
		
//		System.out.print("문자열을 입력하세요 : ");
//		String str = sc.nextLine();
//		
//		
//		for (int i=0; i<3; i++) {
//			System.out.println(i+"번째 문자 : "+str.charAt(i));
//		}
		
//		System.out.println("첫 번째 문자 : " + str.charAt(0));
//		System.out.println("두 번째 문자 : " + str.charAt(1));
//		System.out.println("세 번째 문자 : " + str.charAt(2));
//		
	}
	
	public static void method3() {
		
		System.out.print("가로 : ");
		double row = sc.nextDouble();
		System.out.print("세로 : ");
		double col = sc.nextDouble();
		
		double area = row * col ;
		double Circum = (row + col ) *2;
		
		System.out.println("면적 : " + area);
		System.out.println("둘레 : " + Circum);
	}
	
	public static void method2() {
		
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		int sum = num1 + num2 ;
		int minus = num1 - num2;
		int jegum = num1 * num2;
		int nanugi = num1 / num2 ;
		System.out.println("더하기 결과 : " + sum);
		System.out.println("빼기 결과 : "  + minus );
		System.out.println("곱하기 결과 : " + jegum );
		System.out.println("나누기 결과 : " + nanugi );
		
		
		
	}
	
	public static void method1() {
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("성별을 입력하세요(남/여) : ");
		char gender = sc.next().charAt(0);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("키를 입력하세요 : ");
		double cm = sc.nextDouble();
		
		System.out.printf("키 %.1fcm인 %d살 %c자 %s님 반갑습니다^^",
				cm,age,gender,name);
	}

}
