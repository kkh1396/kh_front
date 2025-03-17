package com.kh.inherit;

public class InheritMemo {

	/*
	 *  상속 : 부모 클래스의 맴버(필드, 메소드)를 자식 클래스에서 
	 *        그대로 이어받아 사용하는 것 
	 *        실제로 상속된 클래스를 통해 객체 생성 시 부모 클래스의 맴버들도 생성됨!
	 *        
	 *   * 장점 
	 *        - 적은 양의 코드로 새로운 클래스를 정의하고 사용할 수 있음
	 *        - 코드를 공통으로 관리하기 떄문에 코드의 추가나 수정이 용이함(유지보수성이 좋음!)
	 *        
	 *   * 특징
	 *        - 부모클래스의 생성자, 초기화블록은 상속되지 않음!
	 *        - 부모클래스의 private 맴버는 상속은 되지만 , 직접 접근 불가!
	 *          protected 맴버는 직접 접근 가능!
	 *        - 모든 클래스는 Object 클래스의 후손임!
	 *          => 자바에서 제공되는 클래스, 직접 만든 클래스 등등!
	 *        - 클래스 간의 상속은 "단일 상속"만 가능 (다중 상속 불가 => 부모는 하나!)
	 *        - 부모 클래스의 정의되어 있는 메소드를 자식 클래스에서 재정의 할 수 있음!
	 *          => 오버라이딩!
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Desktop 클래스
		 * - brand:String
		 * - code:String
		 * - name:String
		 * - price :int
		 * -------------------
		 * +Desktop(brand:String,code:String,name:String,price:int)
		 * +information():String
		 * -----------------------
		 */
		
		/*
		 * TV 클래스
		 * ---------------------
		 * - brand:String
		 * - code:String
		 * - name:String
		 * - price :int 
		 * - inch:int
		 * ---------------------------
		 * +TV(모든 필드를 매개변수로 가짐)
		 * +information():String
		 */

	}

}
