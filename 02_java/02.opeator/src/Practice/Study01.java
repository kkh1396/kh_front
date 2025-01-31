package Practice;

import java.util.Scanner;

public class Study01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();

		System.out.println("반갑습니다 ^^" + name + "님!");
	}

}
