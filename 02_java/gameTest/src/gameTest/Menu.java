package gameTest;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);
	GameControll gc = new GameControll();
	private boolean run = true;
	
	public void mainMenu() {

		startMenu();

	}

	public void startMenu() {

		System.out.println();
		System.out.println("===========================");
		System.out.println("=                         =");
		System.out.println("=    one-person Marvel    =");
		System.out.println("=                         =");
		System.out.println("=       Game start        =");
		System.out.println("=                         =");
		System.out.println("===========================");
		System.out.println();
		System.out.printf("	Press 1번  ");
		int startNum = sc.nextInt();

		pageDown(8);
		while (run) {

			System.out.println("===========================");
			System.out.println("=       Menu select       =");
			System.out.println("===========================");
			System.out.println("=     1. Nickname create  =");
			System.out.println("=     2. Player Check     =");
			System.out.println("=     3. Game start       =");
			System.out.println("=     4. Game exit        =");
			System.out.println();
			System.out.println("===========================");
			System.out.println();
			System.out.println();
			System.out.print("=     select Number   :   =");
			startNum = sc.nextInt();
			sc.nextLine();

			switch (startNum) {

			case 1:
				pageDown(11);
				makePlayer();
				break;
			case 2:
				pageDown(6);
				showPlayer();
				break;
			case 3:
				if (playerCheck() == false) {
				pageDown(10);
				start();
				break;
				} 
				pageDown(5);
				System.out.println("닉네임을 설정하지 않았습니다.");
				pageDown(5);
				sc.nextLine();
				continue;
			case 4:
				run = false;
			default:
				System.out.println("test");

			}
		}
	}

	public void pageDown(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println();
		}
	}

	public void makePlayer() {

		System.out.println("게임을 시작하기전 아래 이름을 지어주세요");

		System.out.printf("플레이어의 닉네임을 적어주세요 : ");
		String name1 = sc.nextLine();
		pageDown(5);

		gc.makePlayer(name1);

	}
	
	public boolean playerCheck() {
		
		if (gc.showPlayer().getName() == null) {
			return true ;
		}
		return false;
	}
	


	public void showPlayer() {

		if (gc.showPlayer() != null) {
			System.out.println(" " + gc.showPlayer().toString());
			pageDown(5);
			sc.nextLine();
		} else {
			pageDown(5);
			System.out.println("Nickname이 없습니다.");
			pageDown(5);
			sc.nextLine();
		}
	}

	public void start() {

		firstScene();
		
		
		while (run) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 주사위를 굴린다");
			System.out.println("2. 상태 확인");
			System.out.println("3. 규칙 확인");
			System.out.println("4. 게임 종료 ");
			System.out.print("선택 : ");
			int menuNum = sc.nextInt();
			pageDown(5);
			
			switch (menuNum) {

			case 1:		
				twoScene();
				pageDown(5);
				break;
			case 2:
				pageDown(3);
				showPlayer();
				sc.nextLine();
				break;
			case 3:
				pageDown(5);
				firstScene();
				break;
			case 4:
				run = false;		
				break;
			default:
				pageDown(5);
				System.out.println("메뉴에 있는 번호로 눌러주세요");
			}
			
			
			if (win() == false) {
			System.out.println(" 승리하셨습니다.");
			showPlayer();
			run = win() ;
			}
			
			
		}
	}

	public void firstScene() {

		sc.nextLine();
		System.out.println("========= 게임 규칙 =========");
		System.out.println("1. 메뉴의 주사위를 돌려 이동합니다.. ");
		System.out.println("2. 모든 칸은 랜덤으로 내용이 정해집니다.");
		pageDown(5);

		sc.nextLine();

		System.out.println("========= 승리 조건 =========");
		System.out.println("1. 먼저 20칸을 이동한 경우");
		System.out.println("2. 10점을 모은 경우");
		System.out.println("위 2조건중 한가지라도 먼저 달성한 경우");
		pageDown(3);
		
		sc.nextLine();
		
	}

	public void twoScene() {

		int dice = gc.dice();
		gc.Move(dice);
		
		
		
		
		
		
		for (int i = 0; i < dice; i++) {

			System.out.print("===========================");

		}

		System.out.println();

		for (int i = 0; i < dice; i++) {

			System.out.print("=                         =");

		}

		System.out.println();
		for (int i = 0; i < dice; i++) {

			System.out.print("=                         =");

		}
		System.out.println();
		for (int i = 0; i < dice; i++) {

			System.out.print("=                         =");

		}
		System.out.println();
		for (int i = 0; i < dice; i++) {

			System.out.print("=                         =");

		}
		System.out.println();
		for (int i = 0; i < dice; i++) {

			System.out.print("=                         =");

		}
		System.out.println();
		for (int i = 0; i < dice; i++) {

			System.out.print("===========================");

		}
		pageDown(2);
		System.out.println("주사위 숫자는 : "+dice);
		gc.field();
		sc.nextLine();
		sc.nextLine();

	}
	
	public boolean win() {
		
		int w20 = gc.showPlayer().getProgress();
		int p10 = gc.showPlayer().getPoint();
		
		if (w20 >= 20 || p10 >= 10) {
			return false;
		}
		return true;
	}

}
