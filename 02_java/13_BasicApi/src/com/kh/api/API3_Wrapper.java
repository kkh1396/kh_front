package com.kh.api;

public class API3_Wrapper {

	/*
	 * Wrapper 클래스
	 * : 기본 자료형을 객체화 해주는 클래스 
	 * 
	 *    boolean	---->	Boolean
	 *    char		---->	Character
	 *    byte		---->	Byte
	 *    short		---->	Short
	 *    int		---->	Integer
	 *    long		---->	Long
	 *    float		---->	Float
	 *    double	---->	Double
	 *    
	 *    *기본 자료형을 객체로 표현해야하는 이유?
	 *     - 다형성을 적용시키고 싶을 때
	 *     - 메소드 호출 시 매개변수가 기본자료형이 아닌 객체타입만 요구될 때
	 */
	
	public static void main(String[] args) {
		// * Boxing : 기본 자료형 -> Wrapper 클래스 (객체화)
		int n1 = 100;
		int n2 = 200;
		
//		System.out.println(n1.equals(n2));
		
		// [1] 객체 생성 구문 사용
		Integer i1 = new Integer(n1);
		Integer i2 = new Integer(n2);
		
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1.compareTo(i2));
		// => 두 값을 비교하여 앞쪽의 값이 크면 1 반환
		//				   뒤쪽의 값이 크면 -1 반환
		//				   같으면 0 반환
		
		// [2] 객체 생성 구문 없이 사용
		Integer i3 = n1;   // 오토 박싱
		System.out.println(i3);
		
		// * 객체 생성을 통해 반드시 변환해야 하는 경우
		//	 => 문자열을 Integer타입으로 변환하고 싶을 때
		Integer i4 = new Integer("300");
		Integer i5 = Integer.parseInt("400");
		
		// --------------------------------------
		
		// UnBoxing : Wrapper 클래스 --> 기본 자료형
		
		// [1] Wrapper클래스에서 제공하는 메소드 사용(xxxValue())
		int n3 = i3.intValue() ; 		// i3 변수의 값을 intValue 메소드를 사용
		int n4 = i4.intValue();
		
		// [2] 메소드 사용하지 않고 바로 대입 (Auto UnBoxing)
		int n5 = i5;
		
		//--------------------------------------
		
		// * String 과의 변환
		
		// String ---> 기본 자료형
		String str1 = "10";
		String str2 = "35.5";
		
		System.out.println(str1+str2); //10+33.5
		
		// * Wrapper클래스.parseXXX()
		int num = Integer.parseInt(str1); // "10" -> 10 변환
		double dNum = Double.parseDouble(str2);
		System.out.println(num+dNum);
		
		// 기본자료형 --> String
		System.out.println(num + "");
		System.out.println(String.valueOf(num));
		System.out.println(String.valueOf(dNum));

	}

}
