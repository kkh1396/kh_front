package com.kr.object.ex1;



public class run {

	public static void main(String[] args) {
		// BankAccount 클래스 사용
		// * 변수 선언 및 인스턴스 생성
		BankAccount ba; // BankAccount 타입으로 변수 선언.
		ba = new BankAccount(); // 인스턴스 생성 후 할당. 참조변수(메모리 주소값저장)가 됨

		//입금 ( deposit 호출 )
		//     => 참조변수명.메소드명(전달값);
		ba.deposit(10000);
		
		// 조회 ( check 메소드 호출 )
		ba.check();
		
		// 출금 ( withdraw 메소드 호출 )
		ba.withdraw(3000);
		
		ba.check();
		
		// -----------------------------
		
		BankAccount ba2 = ba;
		// => ba2 변수는 ba 참조변수가 가지고 있는 인스턴스의 주소를 저장하게됨!
		//    같은 인스턴스를 참조하게 됨!
		
		ba2.deposit(50000);
		
		ba.check();
		ba2.check();
		
	}
	

}
