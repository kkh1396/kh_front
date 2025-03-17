package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;

public class MemberMenu {

	Scanner sc = new Scanner(System.in); 
	MemberController mc = new MemberController();
	
	
	public void mainMenu() {
		
		
		System.out.printf("최대 등록 가능한 회원 수는 %d명입니다. \n",mc.SIZE);
//		System.out.printf("현재 등록된 회원 수는 "+mc.existMemberNum()+"명입니다.\n");
		
		System.out.println("1. 새 회원 등록");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 모두 출력");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();
		
		
		switch (menuNum) {
			case 1 : 
				insertMember();
				break;
			case 2 :
				
			case 3 : 
				
			case 4 :
				
			case 5 :
				
			case 9 :
				
			default :
		}
		
		 
		
	}
	
	public void insertMember() {
		
		
		System.out.print("아이디 :  ");
		String id = sc.next();
		
			if (mc.checkid(id)) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
				this.insertMember();
			} 
		
		System.out.print("이름 :  ");
		String name = sc.next();
		
		System.out.print("비밀번호 :  ");
		String passwd = sc.next();
		
		System.out.print("이메일 :  ");
		String email = sc.next();
		
		System.out.print("성별(M/F) :  ");
		char gender = sc.next().charAt(0);
		
		while (true) {
			if ( gender == 'F' || gender == 'M') {
				break;
			} else {
				System.out.println("성별을 다시 입력하세요.");
			}
		}
		
		
		System.out.print("나이 :  ");
		int age = sc.nextInt();
		
		mc.insertMember(id, name, passwd, email, gender, age);

	}
	
	public void searchMember() {
		
	}
	
	public void searchid() {
		
	}
	
	public void searchName() {
		
	}
	
	public void searchEmail() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void updatePassword() {
		
	}
	
	public void updateName() {
		
	}
	
	public void updateEmail() {
		
	}
	
	public void deleteMember() {
		
	}
	
	public void deleteOne() {
		
	}
	
	public void deleteAll() {
		
	}
	
	public void printAll() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
