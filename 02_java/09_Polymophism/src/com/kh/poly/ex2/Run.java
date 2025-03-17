package com.kh.poly.ex2;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c1 = new Car("red", "가솔린", 2023);
		// Car ---> Car
		// color color
		// fuel fuel
		// year year
		// drive() drive()
		c1.drive();

		// [2] 자식타입 참조변수로 자식객체를 다루는 경우
		Sonata c2 = new Sonata("black", "경우", 2022);

		// Sonata ---> Sonatar
		// color color
		// fuel fuel
		// year year
		// drive() drive()
		// moveSonata() moveSonata()

		c2.drive();
		c2.moveSonata();

		// [2] 자식타입 참조변수로 자식객체를 다루는 경우
		Car c3 = c2; // => Car c3 = new Sonata();

		// Car ---> Sonatar
		// color color
		// fuel fuel
		// year year
		// drive() drive()
		// moveSonata()

		c3.drive();

		// c3.moveSonata(); // => 오류 발생!
		// c3변수를 사용하여 moveSonata 메소드를 호출하고 싶다면..?
		// => 강제형변환! (다운캐스팅)
		((Sonata) c3).moveSonata();
//		 	자식 타입   = (자식 타입) 부모생성자

		/*
		 * *다형성 : 부모 타입으로부터 파생된 여러 타입의 자식 객체들을 부모 타입 하나로 다룰 수 있는 기술!
		 * 
		 * - 장점 : 하나의 부모 타입만으로 여러 자식 객체들을 다룰 수 있어 "편리"하고, "코드 길이 감소"됨!
		 * 
		 * *클래스 간의 형변환(*상속 관계에서 가능*) -Up Casting : 자식 타입 -> 부모 타입 형변환 자동형변환 ex) Car c1 =
		 * (Car)new Sonata(); - Down Casting : 부모 타입 -> 자식 타입 형변환 강제형변환 필요!
		 * 
		 * * 동적 바인딩 : 프로그램이 실행되기 전에는 컴파일 되면서 정적바인딩됨! (=> 참조변수타입의 메소드를 가리킴) 단, 실질적으로 참조하는
		 * 자식 클래스에 해당 메소드가 "오버라이딩"되어 있으면 프로그램 실행 시 동적으로 해당 "자식 클래스의 오버라이딩된 메소드를 찾아서 실행"
		 */
//		c3.drive();

		System.out.println();

//		// * 다형성을 사용하기 전...
//		Sonata[] sArr = new Sonata[3]; // Sonata 객체를 여러 개 저장하는 배열
//		sArr[0] = new Sonata("black","가솔린",0);
//		
//		Avante[] vArr = new Avante[5];
//		vArr[0] = new Avante("blue","가스",2020);
//		
//		
//		for (Sonata s : sArr) {
//			if(s != null) {
//				s.drive();
//			}
//		}
//		
//		for (Avante a : vArr) {
//			if(a != null) {
//				a.drive();
//			}
//		}

		// *다형성을 사용한다면...?
		Car[] cc = new Car[10];

		cc[0] = new Sonata("black", "가솔린", 0);
		cc[1] = new Avante("blue", "가스", 2020);

		for (Car c : cc) {
			if (c != null) {
				c.drive();

				if (c instanceof Sonata) {
					((Sonata) c).moveSonata();
				} else if (c instanceof Avante) {
					((Avante) c).moveSonata();
				}
			}
		}

		System.out.println();
		for ( int i=0; i<cc.length; i++) {
			if (cc[i] != null) {
				cc[i].drive();
				
				if (cc[i] instanceof Sonata) {
					((Sonata)cc[i]).moveSonata();
				} else if (cc[i] instanceof Avante) {
					((Avante)cc[i]).moveSonata();
				}
			}
		}
	}
	

}
