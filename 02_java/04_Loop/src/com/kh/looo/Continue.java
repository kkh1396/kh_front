package com.kh.looo;

public class Continue {
	/*
	 *  분기문 continue
	 *  : continue; 가 실행되면 뒤에 구문들은 무시하고
	 *     증감식(for) 또는 조건식(while)으로 이동 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 method1();
		 method2();
	}

	public static void method2() {
		// 1부터 100까지 총 합
		// 단, 3의 배수이거나 5의 배수는 합산에서 제외 
	   int sum=0;
	   for (int i=0; i<=100; i++) {
		
		if (i % 3 ==0 || i % 5 ==0) {
			continue;
		}
		sum += i;
	   }
	   System.out.println("합산"+ sum);
	}
	
	public static void method1() {
		//1부터 10까지 정수 중에 짝수 출력
		for(int i=0; i<=10; i++) {
			// 홀수인 경우 다음반복문 실행
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
	}
}
