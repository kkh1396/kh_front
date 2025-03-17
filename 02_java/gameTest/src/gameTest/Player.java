package gameTest;

public class Player {

	private String name ;
	private int point = 0;
	private int Progress = 0 ;
    
    
    public Player() {}
	
	
	public String toString() {
		String player = "이름: "+name+" 점수: "+point+" 진행도: "+Progress; 
		return player;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getProgress() {
		return Progress;
	}
	public void setProgress(int progress) {
		this.Progress = progress;
	}

	

}
