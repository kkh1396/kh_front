package Practice;

import java.util.Scanner;

public class ControlPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		practice1();
//		practice2();
//		practice3();
//		practice4();
//		practice5();
//		practice6();
//		practice7();
//		practice8();
//		practice9();
		practice10();

	}

	public static void practice10() {

		Scanner sc = new Scanner(System.in);

		System.out.println("실행할 기능을 선택하세요 : ");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수 ");
		System.out.println("3. 합격/불합격 ");
		System.out.println("4. 계절 ");
		System.out.println("5. 로그인 ");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		int num1 = sc.nextInt();
		

		switch (num1) {
		case 1: {
			practice1();
			break;
		}
		case 2: {
			practice2();
			break;
		}
		case 3: {
			practice3();
			break;
		}
		case 4: {
			practice4();
			break;
		}
		case 5: {
			practice5();
			break;
		}
		case 6: {
			practice6();
			break;
		}
		case 7: {
			practice7();
			break;
		}
		case 8: {
			practice8();
			break;
		}
		case 9: {
			practice9();
			break;
		}
		default : {
			System.out.print("실행 불가 ");
			break;
		}

		}

	}

	public static void practice9() {
		Scanner sc = new Scanner(System.in);

		System.out.print("중간 고사 점수 : ");
		double num1 = sc.nextDouble();

		System.out.print("기말 고사 점수 : ");
		double num2 = sc.nextDouble();

		System.out.print("과제 점수 : ");
		double num3 = sc.nextDouble();

		System.out.print("출석 회수 : ");
		double num4 = sc.nextDouble();

		double numck1 = num1 / 100 * 20.0; // 중간고사 비율
		double numck2 = num2 / 100 * 30.0; // 기말고사 비율
		double numck3 = num3 / 100 * 30.0; // 과제점수 비율

		double numck4 = 20.0 / 100 * 30.0; // 출석 과락 비율

		double sum = numck1 + numck2 + numck3 + num4;

		System.out.println("=========결과==========");
		System.out.println("중간 고사 점수(20)" + numck1);
		System.out.println("기말 고사 점수(30)" + numck2);
		System.out.println("과제 점수(30)" + numck3);
		System.out.println("출석 점수(20)" + num4);
		System.out.println("총점" + sum);

		if (sum >= 70) {
			System.out.println("PASS");
		} else if ((num4 - numck4) < numck4) {
			System.out.println("Fail [출석 미달]");
		} else if (sum <= 69) {
			System.out.println("Fail [점수 미달]");
		}

	}

	public static void practice8() {

		Scanner sc = new Scanner(System.in);

		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();

		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();

		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		char undo = sc.next().charAt(0);

		int sum = num1 + undo + num2;

		if (num1 > 0 && num2 > 0) {

			switch (undo) {
			case '+': {
				System.out.printf("%d %c %d = %d", num1, undo, num2, (num1 + num2));
				break;
			}
			case '-': {
				System.out.printf("%d %c %d = %d", num1, undo, num2, (num1 - num2));
				break;
			}
			case '*': {
				System.out.printf("%d %c %d = %d", num1, undo, num2, (num1 * num2));
				break;
			}
			case '/': {
				System.out.printf("%d %c %d = %d", num1, undo, num2, (num1 / num2));
				break;
			}
			case '%': {
				System.out.printf("%d %c %d = %d", num1, undo, num2, (num1 % num2));
				break;
			}
			default: {
				System.out.print("잘못 입력하셨습니다. 프로그램을 종료합니다.");

			}
			}

		} else {
			System.out.print("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}

	}

	public static void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("키(m) : ");
		double ki = sc.nextDouble();

		System.out.print("몸무게(kg) : ");
		double kg = sc.nextDouble();

		double bmi = kg / (ki * ki);

		System.out.println("BMI 지수 : " + bmi);

		if (bmi < 18.5) {
			System.out.print("저체중");
		} else if (18.5 <= bmi && bmi < 23) {
			System.out.print("정상체중");
		} else if (23 <= bmi && bmi < 25) {
			System.out.print("과제충");
		} else if (25 <= bmi && bmi < 30) {
			System.out.print("비만");
		} else {
			System.out.print("고도비만");
		}

	}

	public static void practice6() {
		Scanner sc = new Scanner(System.in);

		System.out.print("권한을 확인하고자 하는 회원 등급(관리자,회원,비회원) : ");
		String id = sc.nextLine();

		switch (id) {

		case "관리자": {
			System.out.printf("%s는 회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성 \n", id);
			break;

		}

		case "회원": {
			System.out.printf("%s는 게시글 작성, 게시글 조회, 댓글 작성", id);
			break;
		}

		case "비회원": {
			System.out.printf("%s는 게시글 조회", id);
			break;
		}

		}

	}

	public static void practice5() {
		Scanner sc = new Scanner(System.in);

		String idck = "myId";
		String pwck = "myPassword12";

		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		if (id.equals(idck) && pw.equals(pwck)) {
			System.out.print("로그인 성공");
		} else {

			if (!id.equals(idck)) {
				System.out.print("아이디가 틀렸습니다. ");
			} else if (!pw.equals(pwck)) {
				System.out.print("비밀번호가 틀렸습니다. ");
			} else {
				System.out.print("가입된 정보가 없습니다.");
			}

		}

	}

	public static void practice4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("월을 입력하세요 : \n");
		int num = sc.nextInt();
		String season = "";
		switch (num) {

		case 1, 2, 12: {
			season = "겨울";
			System.out.printf("%d월은 %s입니다.", num, season);
			break;
		}
		case 3, 4, 5: {
			season = "봄";
			System.out.printf("%d월은 %s입니다.", num, season);
			break;
		}
		case 6, 7, 8: {
			season = "여름";
			System.out.printf("%d월은 %s입니다.", num, season);
			break;
		}
		case 9, 10, 11: {
			season = "가을";
			System.out.printf("%d월은 %s입니다.", num, season);
			break;
		}

		default: {
			System.out.printf("%d월은 잘못 입력된 달입니다. ", num);
			break;
		}

		}

	}

	public static void practice3() {

		Scanner sc = new Scanner(System.in);

		System.out.print("국어점수 : ");
		int num1 = sc.nextInt();
		System.out.print("수학점수 : ");
		int num2 = sc.nextInt();
		System.out.print("영어점수 : ");
		int num3 = sc.nextInt();

		int total = num1 + num2 + num3;
		double avg = total / 3;

		System.out.println("국어 : " + num1);
		System.out.println("수학 : " + num2);
		System.out.println("영어 : " + num3);
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + avg);

		if ((num1 >= 40 && num2 >= 40 && num3 >= 40) && (avg >= 60)) {

			System.out.print("축하합니다, 합격입니다. ");

		} else {
			System.out.print("불합격입니다!");
		}

	}

	public static void practice2() {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 한개 입력하세요 : ");
		int num = sc.nextInt();

		if (num % 2 == 0 && num > 0) {
			System.out.print("짝수다");
		} else if (num % 2 != 0 && num > 0) {
			System.out.print("홀수다");
		} else {
			System.out.print("양수만 입력해주세요.");
		}

	}

	public static void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.print("메뉴 번호를 입력하세요");
		int num = sc.nextInt();
		String menu = "";

		switch (num) {
		case 1: {
			menu = "입력";
			break;
		}
		case 2: {
			menu = "수정";
			break;
		}
		case 3: {
			menu = "조회";
			break;
		}
		case 4: {
			menu = "삭제";
			break;
		}
		case 7: {
			menu = "종류";
			break;
		}

		}

		System.out.printf("%s 메뉴입니다.", menu);

	}
}
