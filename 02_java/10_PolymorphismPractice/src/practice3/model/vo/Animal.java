package practice3.model.vo;

public abstract class Animal {
	// 
	
	
	private String name;
	private String kinds;
	
	protected Animal() {}

	protected Animal(String name, String kinds) {
		super();
		this.name = name;
		this.kinds = kinds;
	}
	
	@Override  // => 오버라이딩된 메소드 의미
	public String toString() {
		return String.format("저의 이름은 %s이고 종류는 %s",name,kinds);
	}
	   // toString()는 Object 클래스에 정의되어 있는 메소드 
	   // => 따라서, 현재 클래스에서 재정의됨! (오버라이딩)
	    
	   // *보통 toString 메소드는 현재 클래스의 모든 필드의 정보를
	   // 문자열로 반환하는 역할을 하도록 재정의됨!
	   //  => 참조변수를 문자열로 사용할 때, toString 메소드 호출됨!
	
	public abstract void speak();
	// 접근제한자 예약어 반환형 메소드명(매개변수정보)
	// => 예약어 위치에 "abstract" 사용되면 추상메소드가 됨!
	//    추상 메소드는 구현부가 없음! 따라서 메소드 머리부 끝에 세미콜론으로 끝맺음!
}
