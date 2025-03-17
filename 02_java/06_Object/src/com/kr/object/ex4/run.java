package com.kr.object.ex4;

import java.util.Scanner;

public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "김xx", 30살 , 수학:80, 영어 70, 국어 80
		Student s1 = new Student("김xx",30,80,70,80);
		// "방xx", 25살 , 수학:90, 영어 90, 국어 70
		Student s2 = new Student("방xx",25,90,90,70);
		
		// 김ㅌㅌ 학생의 평균 : xx" -> 출력 형식
		// 첫번째 학생의 평균 출력
		System.out.println(s1.getName()+ "학생의 평균 : " + s1.getEvg());
	
		// 두번째 학생의 평균 출력
		System.out.println(s2.getName()+ "학생의 평균 : " + s2.getEvg());
		
		/*
		 * 
		 * 사용자로부터 이름, 나이, 수학점수, 영어점수, 국어점수를
		 *    입력받아 평균을 구하고 출력하는 프로그램
		 * 
		 *  ex) 
		 *      이름 : xxx
		 *      나이 : xx
		 *      수학점수 : xx
		 *      영어점수 : xx
		 *      국어점수 : xx
		 *      ----------
		 *      xxx의 평균 : xx
		 */
		
		test1();
	}
	
	public static void test1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("나이 : ");
		int age = sc.nextInt();

		System.out.print("수학점수 : ");
		int mathPoint = sc.nextInt();

		System.out.print("영어점수 : ");
		int engPoint = sc.nextInt();

		System.out.print("국어점수 : ");
		int korPoint = sc.nextInt();
		
		Student t = new Student(name,age,mathPoint,engPoint,korPoint);
		
		System.out.println("--------------");
		System.out.printf("%s님의 평균 : %d",name,t.getEvg());
	}
	

}
