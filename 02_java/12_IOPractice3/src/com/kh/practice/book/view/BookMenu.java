package com.kh.practice.book.view;

import java.util.Scanner;
import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	 Scanner sc = new Scanner(System.in);
	
	private BookController bc = new BookController();
	private Book[] bArr; 
	
	public BookMenu() {
		bc.makeFile();
		Book[] bArr = bc.fileRead();		
	}
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("1. 도서 추가 저장"); // ➔ fileSave()
			System.out.println("2. 저장 도서 출력"); // ➔ fileRead()
			System.out.println("9. 프로그램 끝내기"); // ➔ “프로그램 종료” 출력 후 종료
			
			System.out.print("메뉴 번호 : ");
			int bm = sc.nextInt();
			sc.nextLine();
			
			switch(bm) {
			case 1: fileSave();
				break;
			case 2: fileRead();
				break;
			case 9: System.out.println("프로그램 종료");
				return;
			default: 
				System.out.print("잘못 입력하셨습니다. 다시 입력해주세요. : ");
			}	
		}
		
	}
	
	public void fileSave() {
		System.out.print("도서 명: ");
		String title = sc.nextLine();
		
		System.out.print("저자 명: ");
		String author = sc.nextLine();
		
		System.out.print("도서 가격: ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("출판 날짜(yyyy-mm-dd): ");
		String date = sc.nextLine();
		
		System.out.print("할인율: ");
		double discount = sc.nextDouble();
		// 입력받은 값을 Book 객체에 담고
		// 비어있는 Book객체 배열(bArr)에 담아 bc에 fileSave()에 매개변수로 전달
		// bc.fileSave();
		Book bArr = new Book(title, author, price, date, discount);
		
	}
	
	public void	fileRead() {
		// bc에 fileRead()의 반환 값을 가지고 저장된 데이터 출력
		System.out.println(bc.fileRead());
		
	}
		
		
}



