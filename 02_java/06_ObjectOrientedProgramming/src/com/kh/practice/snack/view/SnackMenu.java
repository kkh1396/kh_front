package com.kh.practice.snack.view;

import com.kh.practice.snack.controller.*;

import java.util.Scanner;

public class SnackMenu {

	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public SnackMenu() {}
	
	public void menu() {
		
		System.out.println("스냅류를 입력하세요.");
		
		System.out.print("종류: ");
		String kind = sc.next();
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("맛: ");
		String flavor = sc.next();
		
		System.out.print("개수: ");
		int numOf = sc.nextInt();
		
		System.out.print("가격: ");
		int price = sc.nextInt();
		
	    System.out.println(scr.saveData(kind, name, flavor, numOf, price));
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
	    char YN = sc.next().charAt(0);
	    
	    if (YN == 'Y' || YN == 'y') {
	    	System.out.print(scr.confirmData());
	    } else if (YN == 'N' || YN == 'n') {
	    	
	    }
	}
}
