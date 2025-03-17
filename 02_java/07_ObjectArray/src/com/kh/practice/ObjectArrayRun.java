package com.kh.practice;

import java.util.Scanner;

public class ObjectArrayRun {

	
	// * 객체 배열 : 여러 개의 객체를 관리하는 구조
	
	/*
	*   클래스명[] 변수명;
	*   
	*   할당 
	*       변수명 = new 클래스명[배열크기];
	*   
	*   인덱스 위치에 초기화 // => 해당 인덱스 위치에 객체를 생성하여 할당
	*         변수명[인덱스] = new 클래스명(); 
	*         
	*/ 
	public static void main(String[] args) {
		// 크기가 3인 정수형 배열 선언 및 할당
//		int[] d = new int[3];
//		// 반복문 사용하여 1 ~ 3 까지 저장
//		for (int i=0; i<d.length; i++) {
//			d[i]= i+1;
//			System.out.println(d[i]);
//		}
//		
		
		// 학생 정보를 담을 객체 배열 선언 및 할당
		//[1] 학생 정보를 관리하기 위해 Student 클래스 추가(정의)
		//[2] 정의한 Student 객체를 사용하여 배열 선언 및 할당

//		Student[] stArr = new Student[2]; // [null] [null]
//		stArr[0] = new Student("홍ㅌㅌ",20,'남'); // | student 객체 | null
//		stArr[1] = new Student("홍ㅊㅊ",30,'여'); // | student 객체 | student 객체 
		
		// ** 저장된 학생 정보 출력 **
//		stArr[0].printInfo(); // 첫번쨰 정보 출력
		
		// 두번쨰 학생 정보 제거
//		stArr[1] = null; // 첫번쨰 정보 출력
		
		//------------------------------
		// 입력받은 앖으로 학생정보 관리
		Student[] sArr = new Student[2];
		
		Scanner sc = new Scanner(System.in);
		
		// 반복문을 사용하여 입력된 정보 배열에 저장
		
		for (int i =0; i<sArr.length;i++){
			
			System.out.print("이름 정보 : ");
			String name = sc.next();
			
			System.out.print("나이 정보 : ");
			int age = sc.nextInt();
			
			System.out.print("성별 정보 : ");
			char gender = sc.next().charAt(0);
			
			 sArr[i] = new Student(name,age,gender);
//			 sArr[i].printInfo();
		}
		
		// for(자료형 변수명, 배열) 
		for(Student s : sArr) {
			s.printInfo();
		}
	}

}
