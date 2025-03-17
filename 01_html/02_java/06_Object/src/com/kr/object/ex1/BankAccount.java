package com.kr.object.ex1;

public class BankAccount {

	int balance = 0 ; // 예금잔액
	
	// 데이터 (변수)
	
	
				// 기능 (메소드)
				// 입금 기능 (예금잔액에 값을 더함)
				/*
				 * 접근제한자 [예약어] 반환형 메소드명(매개변수정보) {
				 * }
				 */ 
		
	
	public static void main(String[] args) {
		
		
	
	}
	
	
	
        //입금 기능 (예금잔액에 값을 더함)
		public void deposit(int money) {
			balance += money;
	
	}
		// 출급 기능 (예금잔액에 값을 뻄)
		public void withdraw(int money) {
			balance -= money;
		}
		
		// 조회 기능 (예금 잔액 정보를 출력)
		public void check() {
			System.out.println("잔액 : " + balance);
		}
	
}
