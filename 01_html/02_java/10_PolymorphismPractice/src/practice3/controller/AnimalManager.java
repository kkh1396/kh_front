package practice3.controller;

import practice3.model.vo.Animal;
import practice3.model.vo.Cat;
import practice3.model.vo.Dog;

public class AnimalManager {

	
	
	public static void main(String[] args) { 
	
		Animal[] am = new Animal[5];
		
		
		for(int i=0; i<am.length;i++) {
			int ran = (int)(Math.random() * 2 + 1) ;
			if (am[i] == null ) {
				 if (ran == 1) {
					 am[i] = new Cat("나비","길거리","서울","검정");
//					 System.out.println("ran : " + ran);
				 } else {
					 am[i] = new Dog("흰둥이","진돗개",40);
//					 System.out.println("ran : " + ran);
				 }
			}
			System.out.print("i : "+ i + "동물 객체는"  );
			am[i].speak();
			System.out.println();
		}
		
	}
}
