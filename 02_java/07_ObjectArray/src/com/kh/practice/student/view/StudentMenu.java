package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;

public class StudentMenu {

	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		
		// 학생 정보 출력
		 System.out.println("==================학생 정보 출력=============");
		for (int i = 0 ; i< ssm.printStudent().length; i++) {
		
			System.out.print(ssm.printStudent()[i].inform());
			
		}
		 
		System.out.println();
		 // 학생 성적 출력
		 System.out.println("==================학생 성적 출력============="); 
		 System.out.println("학생 점수 합계 : " + (int)ssm.avgScore()[0]);
		 System.out.println("학생 평균 합계 : " + ssm.avgScore()[1]);
		 
		 // 성적 결과 출력
		 System.out.println("==================성적 결과 출력=============");
		 for (int i =0; i<ssm.printStudent().length; i++) {
			 if (StudentController.CUT_LINE > ssm.printStudent()[i].getScore()) {
			     System.out.printf("%s학생은 재시험 대상입니다. \n",ssm.printStudent()[i].getName());
			 } 
			 System.out.printf("%s학생은 통과입니다. \n",ssm.printStudent()[i].getName());
		 
		 }
		
		
	}
	
}
