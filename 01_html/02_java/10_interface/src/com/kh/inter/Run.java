package com.kh.inter;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// * 사용자가 선택한 메뉴에 따라 동물 객체를 크기가 3인 배열에 담기
		/*
		 * 1. 고양이 2. 강아지 3. 토끼
		 */

		Scanner sc = new Scanner(System.in);
		Animal[] am = new Animal[3];

		System.out.println("=== 동물 선택 ===");
		System.out.println("1. 고양이");
		System.out.println("2. 강아지");
		System.out.println("3. 토끼");
		System.out.print("메뉴 선택 : ");
		int menuNum = sc.nextInt();

		switch (menuNum) {
		case 1:
			am[0] = new Cat();
			System.out.println("저장했습니다.");
			break;
		case 2:
			am[1] = new Dog();
			System.out.println("저장했습니다.");
			break;
		case 3:
			am[2] = new Rabbit();
			System.out.println("저장했습니다.");
			break;
		default :
			System.out.println("잘못입력했습니다 다시 실행해 주세요");
		}

		
		for (int i=0; i< am.length;i++) {
			if (am[i] != null) {
			System.out.println();
			 if (am[i] instanceof Baby) {
				 System.out.println("움직일수 없습니다.");
				 am[i].eat();
				 am[i].makeSound();
			 } else {
			 	am[i].move();
			 	am[i].eat();
			 	am[i].makeSound();
			 	}
			}
		}
	}
	     

}
