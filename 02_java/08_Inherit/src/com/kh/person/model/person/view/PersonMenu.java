package com.kh.person.model.person.view;

import java.util.Scanner;

import com.kh.person.model.person.controller.PersonController;

public class PersonMenu {

	Scanner sc = new Scanner(System.in);
	PersonController pc = new PersonController();

	public void mainMenu() {

		boolean run = true;
		while (run) {
		System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
		System.out.println("현재 저장된 학생은 " + pc.personCount()[0] + "명입니다.");
		System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
		System.out.println("현재 저장된 사원은 " + pc.personCount()[1] + "명입니다.");

		System.out.println();
		System.out.println("1. 학생 메뉴");
		System.out.println("2. 사원 메뉴");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();

		
			switch (menuNum) {
			case 1:
				StudentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				run = false;
			default:

			}
		}
	}

	public void StudentMenu() {

		
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 보기");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();

		switch (menuNum) {
		case 1:
			insertStudent();
			break;
		case 2:
			printStudent();
			break;
		case 9:
			System.out.print("메인으로 이동합니다.");
			break;
		default:
		}
	}

	public void employeeMenu() {

	}

	public void insertStudent() {
		boolean run = true;
			System.out.print("학생 이름 : ");
			String name = sc.next();
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			System.out.print("학생 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			System.out.print("학생 전공 : ");
			String major = sc.next();

			pc.insertStudent(name, age, height, weight, grade, major);
			System.out.println("그만 하시려면 N 또는 n), 이어하시려면 아무 키나 누르세요. ");
			char yn = sc.next().charAt(0);

			if (yn == 'n' || yn == 'N') {
				run = false;
			}

			if (pc.printStudent()[2] != null) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생메뉴로 돌아갑니다. ");
				run = false;
		}
	}

	public void printStudent() {

		
		for (int i=0; i<pc.printStudent().length;i++) {
			if (pc.printStudent()[i] != null) {
			System.out.println(pc.printStudent()[i].toString());
			}
		}
	}

	public void insertEmployee() {

	}

	public void printEmployee() {

	}
}
