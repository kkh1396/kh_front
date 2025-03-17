package com.kh.object.practice5.model.vo;

public class Lotto {

	
	// 변수 선언
	private int[] lotto;
	
	//초기화 블록 사용
//	{
		// 중복하지 않는 1~45까지의 난수들로 배열 초기화(6개)
		
//		lotto = new int[6];
//		
//		for (int i=0; i<lotto.length; i++) {
//			lotto[i] = (int)(Math.random()*45 +1);
//			
//		}
		
		// 기본 생성자 사용
		public Lotto() {
			lotto = new int[6];
			
			for (int i=0; i<lotto.length; i++) {
				lotto[i] = (int)(Math.random()*45 +1);
				 for( int j=0; j<i; j ++) {
					 if (lotto[i] == lotto[j]) {
						 i--;
						 break;
					 }
				 }
			}
		}
		
		
		// -----메소드부 -----
		public void information() {
			// 반복문을 이용하여 배열 출력
			// * for-each 문 : 배열의 첫번째 위치부터 마지막 위치까지
//							  변수를 통해서 접근
			// [표현식] for(자료형 변수명 : 배열명) {}
			for (int value : lotto) {
				System.out.print(value + " ");
			}
	}
	
	
	
	
	
	
	
	
	
	
	// 내가 작성한것
//	private int[] lotto = new int[6];
//
//	public Lotto() {}
//
//
//	public void information() {
//		
//		System.out.print("lotto 6자리 번호 : " );
//		for(int i=0; i<lotto.length; i++ ) {
//			 lotto[i] = (int)(Math.random() * 45 + 1 );
//			 for(int j=0; j<i; j++) {
//				  
//				 if (lotto[i] == lotto[j]) {
//					 lotto[i] = (int)(Math.random() * 45 + 1 );
//					 i--;
//				 }
//				 
//			 }
// 		}
//		
//		for(int i=0; i<lotto.length; i++) {
//			System.out.print(lotto[i] + " " );
//		}
//		
//		
//	}
	
}
