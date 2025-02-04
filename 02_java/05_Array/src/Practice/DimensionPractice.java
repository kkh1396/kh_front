package Practice;

import java.util.Scanner;

public class DimensionPractice {

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
		practice9();
	}

	public static void practice9() {
		String[] Student = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"

		};

		String[][] Squad_1 = new String[3][2];
		String[][] Squad_2 = new String[3][2];
		int sq = 0;

		for (int z = 1; z < 3; z++) {
			System.out.printf("== %d분단 == \n", z);

			if (z == 1) {

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 2; j++) {

						Squad_1[i][j] = Student[sq++];
						System.out.print("i : "+ i+ " j : "+ j +Squad_1[i][j] + " ");
						System.out.print(Squad_1[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 2; j++) {

						Squad_2[i][j] = Student[sq++];
						System.out.print("i : "+ i+ " j : "+ j  + Squad_2[i][j]+" ");
						System.out.print(Squad_2[i][j] + " ");
					}
					System.out.println();
				}
			}
		}

		System.out.println();
		System.out.println("======================");
		Scanner sc = new Scanner(System.in);

		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.nextLine();

		boolean yes = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
						
				if (Squad_1[i][j].equals(name) ) {
					 yes = true;
					 
				}
				
				if (Squad_2[i][j].equals(name) ) {
					 yes = true;
				}				
			}
			
		}
		if (yes == true) {
			System.out.println(name + "학생은 있습니다.");
			System.out.println("검색하신 학생은 분단 번째 줄 쪽에 있습니다.");
			yes = false;
			} else {
			System.out.print(name + "학생은 없습니다.");
			}
		
		
	}

	public static void practice8() {

		String[] Student = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"

		};

		String[][] Squad_1 = new String[3][2];
		String[][] Squad_2 = new String[3][2];
		int sq = 0;

		for (int z = 1; z < 3; z++) {
			System.out.printf("== %d분단 == \n", z);

			if (z == 1) {

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 2; j++) {

						Squad_1[i][j] = Student[sq++];
						System.out.print("i : "+ i+ " j : "+ j  + " ");
						System.out.print(Squad_1[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 2; j++) {

						Squad_2[i][j] = Student[sq++];
						System.out.print("i : "+ i+ " j : "+ j  + " ");
						System.out.print(Squad_2[i][j] + " ");
					}
					System.out.println();
				}
			}
		}
	}

	public static void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행 크기");
		int num = sc.nextInt();

		int[][] Narr = new int[num][];
		int sub_a = 97;

		for (int i = 0; i < num; i++) {
			System.out.printf("%d행의 열 크기 : ", i);
			int num1 = sc.nextInt();

			Narr[i] = new int[num1];
			for (int j = 0; j < num1; j++) {
				Narr[i][j] = sub_a++;
			}

		}

		for (int i = 0; i < Narr.length; i++) {
			for (int j = 0; j < Narr[i].length; j++) {
				System.out.print((char) Narr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void practice6() {

		String[][] strArr = new String[][] { { "이", "까", "왔", "앞", "힘" }, // 0.0 0.1 0.2 0.3 0.4
				{ "차", "지", "습", "으", "냅" }, // 1.0 1.1 1.2 1.3 1.4
				{ "원", "열", "니", "로", "시" }, // 2.0 2.1 2.2 2.3 2.4
				{ "배", "심", "다", "좀", "다" }, // 3.0 3.1 3.2 3.3 3.4
				{ "열", "히", "! ", "더", "!!" } };// 4.0 4.1 4.2 4.3 4.4

		for (int i = 0; i < strArr.length; i++) {

			for (int j = 0; j < strArr[i].length; j++) {
				System.out.print(strArr[j][i] + " ");
			}
			System.out.println();
		}
	}

	public static void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행 크기");
		int row = sc.nextInt();
		System.out.print("열 크기");
		int col = sc.nextInt();

		int[][] num = new int[row][col];

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				num[i][j] = (char) (Math.random() * 26 + 65);
				System.out.print((char) num[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void practice4() {

		int[][] num = new int[4][4];

		// 랜덤 배열 생성
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				// 마지막 행의 인덱스
				int lastRow = num.length - 1;

				// 마지막 열의 인덱스
				int lastCol = num.length - 1;

				if (i < lastRow && j < lastCol) {
					// 0,0 ~ 2,2 위치에 랜덤값을 저장
					num[i][j] = (int) (Math.random() * 10 + 1);
				}

				// 행의 위치가 마지막행이 아닌경우
				// 현재 값을 더해서 마지막 행에 저장

				if (i < lastRow) {
					num[lastRow][j] += num[i][j];
				}

				if (i < lastCol) {
					num[i][lastCol] += num[i][j];
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%3d", num[i][j]);

			}
			System.out.println();
		}

	}

	public static void practice3() {

		int[][] num = new int[4][4];

		int value = 16;
		for (int i = 0; i < num.length; i++) {

			for (int j = 0; j < num[i].length; j++) {
				num[i][j] = value--;
				System.out.printf("%2d ", num[i][j]);
			}
			System.out.println();
		}

	}

	public static void practice2() {

		// 2차원 배열 선언
		int[][] str = new int[4][4];

		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < str.length; j++) {
				str[i][j] = j + 1;
				System.out.printf("%2d ", str[i][j]);
			}

		}
		System.out.println();

		for (int i = 1; i < str.length; i++) {

			for (int j = 0; j < str.length; j++) {
				str[i][j] = str[i - 1][j] + 4;
				System.out.printf("%2d ", str[i][j]);
			}
			System.out.println();
		}

	}

	public static void practice1() {

		// 2차원 배열 선언
		String[][] str = new String[3][3];

		// 2차원배열의 행부분
		for (int i = 0; i < 3; i++) {

			// 2차원배열의 열부분
			for (int j = 0; j < str.length; j++) {
				// 정해진 인덱스 값에 데이터 삽입
				str[i][j] = "(" + i + "," + j + ")";
				// 출력
				System.out.print(str[i][j] + " ");
			}
			// 개행
			System.out.println();
		}
	}
}
