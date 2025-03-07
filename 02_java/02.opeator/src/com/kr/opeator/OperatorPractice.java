package com.kr.opeator;

import java.util.Scanner;

public class OperatorPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		practice1();
//		practice2();
//		practice3();
//		practice4();
//		practice5();
//		practice6();
//		practice7();
//		practice8();
//		practice9();
//		practice10();
		practice11();
	}

	public static void practice11() {
		// 실습 문제 11 풀이.
		Scanner sc = new Scanner(System.in);

		System.out.print("사원1 : ");
		int num1 = sc.nextInt();

		System.out.print("사원2 : ");
		int num2 = sc.nextInt();

		System.out.print("사원3 : ");
		int num3 = sc.nextInt();

		// 사원 1 연봉 및 연봉+인센티브 계산
		double e1 = num1 * 0.4;

		// 사원 2 연봉 및 연봉+인센티브 계산
		double e2 = num2 * 1;

		// 사원 3 연봉 및 연봉+인센티브 계산
		double e3 = num3 * 0.15;

		// 연봉+인세티브가 3천 이상인가 계산
		String result1 = (num1 + e1) >= 3000 ? "3000 이상" : "3000미만";
		String result2 = (num2 + e2) >= 3000 ? "3000 이상" : "3000미만";
		String result3 = (num3 + e3) >= 3000 ? "3000 이상" : "3000미만";

		System.out.println("사원 1은 연봉/연봉+a : "  + num1 + "/" + (num1 +e1));
		System.out.println("사원 1은 : " + result1);

		System.out.println("사원 2은 연봉/연봉+a : " + num2 + "/"  + (num2 + e2));
		System.out.println("사원 2은 : " + result2);

		System.out.println("사원 2은 연봉/연봉+a : " + num3 +  "/" + (num3 + e3));
		System.out.println("사원 2은 : " + result3);

	}

	Scanner sc = new Scanner(System.in);

	public static void practice10() {
		// 실습 문제 10 풀이
		Scanner sc = new Scanner(System.in);

		System.out.print("입력1 : ");
		int num1 = sc.nextInt();

		System.out.print("입력2 : ");
		int num2 = sc.nextInt();

		System.out.print("입력3 : ");
		int num3 = sc.nextInt();

		boolean result;

		result = (num1 == num2) && (num2 == num3);

		System.out.print(result);

	}

	public static void practice9() {
		// 실습 문제 9 풀이
		Scanner sc = new Scanner(System.in);

		System.out.print("정수1 : ");
		int num1 = sc.nextInt();

		System.out.print("정수2 : ");
		int num2 = sc.nextInt();

		System.out.print("입력 : ");
		int num3 = sc.nextInt();

		boolean numax ;
		numax = (num1 < num2);
		
		boolean result;
		result = (numax == true) ? (num3 <= num1) || (num3 > num2) : false;

		System.out.print(result);

	}

	public static void practice8() {
		// 실습 문제 8 풀이
		Scanner sc = new Scanner(System.in);

		System.out.println("주민번호를 입력하세요(- 포함)");
		String myNum = sc.nextLine();

//		String k = myNum.substring(7,8);
		char k = myNum.charAt(7);

		String result = "" + (k == '1' ? "남자" : k == '2' ? "여자" : "특정불가");

		System.out.println(k);
		System.out.println(result);

	}

	public static void practice7() {
		// 실습 문제 7 풀이
		Scanner sc = new Scanner(System.in);

		System.out.print("국어 점수를 입력하세요");
		int ko = sc.nextInt();
		System.out.print("영어 점수를 입력하세요");
		int en = sc.nextInt();
		System.out.print("수학 점수를 입력하세요");
		int math = sc.nextInt();

		int total = ko + en + math;
		double avg = Math.round((total / 3.0) * 100) / 100.0;

		String result = "불합격";
		result = " " + (((ko >= 40) && (en >= 40) && (math >= 40) && avg >= 60) ? "합격" : result);

		System.out.println("합격 : " + total);
		System.out.println("평군 : " + avg);
		System.out.println("합격여부 : " + result);

	}

	public static void practice6() {
		// 실습 문제 6 풀이
		Scanner sc = new Scanner(System.in);

		System.out.print("나이를 입력하세요");
		int age = sc.nextInt();

		String result = "잘못입력";

		result = age <= 13 ? "어린이" : result;
		result = (age > 13) && (age <= 19) ? "청소년" : result;
		result = age > 19 ? "성인" : result;

		System.out.println("나이 : " + age);
		System.out.print(result);

	}

	public static void practice5() {
		// 실습 문제 5 풀이
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요");
		String name = sc.nextLine();

		System.out.print("학년을 입력하세요 (숫자만)");
		int classNum = sc.nextInt();

		System.out.print("반을 입력하세요(숫자만)");
		int ban = sc.nextInt();

		System.out.print("번호을 입력하세요(숫자만)");
		int Num = sc.nextInt();

		System.out.print("성별을 입력하세요(M/F)");
		char gender = sc.next().charAt(0);

		System.out.print("성적을 입력하세요(소수점 둘쨰자리까지)");
		double point = sc.nextDouble();

		String gresult = "" + (gender == 'M' ? "남학생" : gender == 'F' ? "여학생" : "잘못입력");

		System.out.print(
				classNum + "학년 " + ban + "반 " + Num + "번 " + "" + name + " " + gresult + "의 성적은" + point + "이다.");
	}

	public static void practice4() {
		// 실습 문제 4 풀이
		Scanner sc = new Scanner(System.in);
		System.out.print("인원을 입력하세요");
		int yong = sc.nextInt();
		System.out.print("사탕갯수를 입력하세요");
		int candy = sc.nextInt();

		int result = candy / yong;
		int result1 = candy % yong;
		System.out.print("1인당 사탕 개수는 : " + result + "남은 사탕개수는 : " + result1);
	}

	public static void practice3() {
		// 실습 문제 3 풀이
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요");
		int yong = sc.nextInt();

		String result = "" + (yong % 2 == 0 ? "짝수" : "홀수");
		System.out.print("입력한 값은 : " + result);
	}

	public static void practice2() {
		// 실습 문제 2 풀이

		Scanner sc = new Scanner(System.in);
		System.out.print("" + "정수를 입력하세요");
		int yong = sc.nextInt();

		String result = "" + (yong == 0 ? "0이다" : (yong > 0) ? "양수다" : "음수다");
		System.out.print("입력한 값은 : " + result);

	}

	public static void practice1() {
		// 실습 문제 1 풀이

		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력하세요");
		int yong = sc.nextInt();

		String result = "" + (yong > 0 ? "양수" : "양수가 아니다");
		System.out.print("입력한 값은 : " + result);

	}

}
