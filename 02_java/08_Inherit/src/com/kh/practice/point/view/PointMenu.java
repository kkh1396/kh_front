package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {

	
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		
		boolean run = true;
		while (run) {
			
			System.out.println("=== 메뉴 ====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menuNum = sc.nextInt();
			
			switch (menuNum) {
				case 1 : 
					circleMenu();
					break;	
				case 2 : 
					rectangleMenu();
					break;
				case 9 : 
					System.out.print("종료합니다.");
					run = false;
				default :
				
			}
			
		}
		
	}
	
	public void circleMenu() {
		
		
			System.out.println("=== 원 메뉴 ===");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.println("메뉴 번호 : ");
			int circleNum = sc.nextInt();
	   
				switch (circleNum) {
					case 1 :
						calcCircum();
						break;
					case 2 :
						calcCircleArea();
						break;
					case 9 :
						break;		
				}
		
	}
	public void rectangleMenu() {
		
		System.out.println("=== 사각형 메뉴 ===");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");
		int RectangleNum = sc.nextInt();
   
			switch (RectangleNum) {
				case 1 :
					calcPerimeter();
					break;
				case 2 :
					calcRectArea();
					break;
				case 9 :
					System.out.print("종료합니다.");
					break;		
			}
	
	}
	public void calcCircum() {
		
		System.out.print("x 좌표 :");
		int x = sc.nextInt();
		System.out.print("y 좌표 :");
		int y = sc.nextInt();
		System.out.print("radius 좌표 :");
		int radius = sc.nextInt();
		
		System.out.printf("면적 :  %s \n",cc.calcCircum(x, y, radius));
		
		
	}
	public void calcCircleArea() {
		System.out.print("x 좌표 :");
		int x = sc.nextInt();
		System.out.print("y 좌표 :");
		int y = sc.nextInt();
		System.out.print("radius 좌표 :");
		int radius = sc.nextInt();
		
		
		System.out.printf("넓이 :  %s \n", cc.calcArea(x, y, radius));
		
	}
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 :");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int width = sc.nextInt();
		System.out.print("너비 : ");
		int height = sc.nextInt();
		
		System.out.printf("넓이 : %d %d %d %d / %s \n",
				 			x,y,width,height,rc.calcPerimeter(x, y, width, height));
		
	}
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int width = sc.nextInt();
		System.out.print("너비 : ");
		int height = sc.nextInt();
		
		System.out.printf("넓이 : %d %d %d %d / %s \n",
				 			x,y,width,height,rc.calcArea(x, y, width, height));
		
	}
	
}
