package Practice;

import java.util.Scanner;

public class Study02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("==== 입력한 값의 제곱한 결과를 표시 ====");
		System.out.print(" : ");
		int num = sc.nextInt();
		

		System.out.println("결과 => " + num * num);
	}
}
/*
 * Study02 클래스 실행 결과 작성 *
 ********************************
 * ==== 입력한 값의 제곱한 결과를 표시 ====
 *  : (입력값)
 *  결과 => num의제곱값
 */