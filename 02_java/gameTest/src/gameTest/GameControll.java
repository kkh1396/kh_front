package gameTest;

public class GameControll {

	private Player p = new Player();

	public Player makePlayer(String name) {

		if (p.getName() == null) {
			p.setName(name);
		}

		return p;
	}

	public Player showPlayer() {
		return p;
	}

	public void field() {

		int ran = dice();
		int gprogress = showPlayer().getProgress();
		int gPoint = showPlayer().getPoint();
		if (ran == 1) {
			ran = dice();
			if (gprogress >= 0) {
				ran = dice();
				switch (ran) {
				case 1:
					showPlayer().setProgress(gprogress - 1);
					System.out.println("뒤로 1칸!");
					break;
				case 2:
					showPlayer().setProgress(gprogress - 2);
					System.out.println("뒤로 2칸!");
					;
					break;

				case 3:
					showPlayer().setProgress(gprogress - 3);
					System.out.println("뒤로 3칸!");
					break;

				}
			}
		} else if (ran == 2) {
			ran = dice();
			switch (ran) {
			case 1:
				showPlayer().setProgress(gprogress + 1);
				System.out.println("앞으로 1칸!");
				break;
			case 2:
				showPlayer().setProgress(gprogress + 2);
				System.out.println("앞으로 2칸!");
				break;
			case 3:
				showPlayer().setProgress(gprogress + 3);
				System.out.println("앞으로 3칸!");
				break;

			}
		} else {
			ran = dice();
			switch (ran) {
			case 1:
				showPlayer().setPoint(gPoint + 1);
				System.out.println("1점 획득!");
				break;
			case 2:
				showPlayer().setPoint(gPoint + 2);
				System.out.println("2점 획득!");
				break;
			case 3:
				showPlayer().setPoint(gPoint + 3);
				System.out.println("3점 획득!");
				break;
			}
		}
	}

	

	public int dice() {

		int ran = (int) (Math.random() * 3 + 1);

		return ran;
	}

	public int Move(int move) {

		int prog = p.getProgress();
		prog += move;
		p.setProgress(prog);

		return prog;
	}

}
