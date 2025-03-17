package com.kr.object.ex4;

/*
 * 학생 정보 (Student)
 * -이름    -name:String
 * -나이    -age :int 
 * -수학점수 -math:int
 * -영어점수 -eng:int
 * -국어점수 -kor:int
 * ==> 데이터의 경우 직접 접근을 허용하지 않고 모두 간접적으로 접근할수 있도록 정의
 * 
 * 모든 데이터를 매개변수로 받아 초기화하면서 객체를 생성할 수 잇는 생성자 정의
 */
public class Student {
	// -------------필드부 (변수 영역)------------------
	private String name;
	private int age;
	private int math;
	private int eng;
	private int kor;
	
	
	//----------생성자부------------------------------------------
	public Student() {};
  public Student(String name, int age,int math, int eng, int kor) {
	    this.name = name;
		this.age = age;
		this.math = math;
		this.eng = eng;
		this.kor = kor;
  }
	
	
  //----------메소드부 (기능 영역)-----------------------------------
  
	// * 모든 과목의 평균을 계산하는 메소드
	public int getEvg() {
		// 평균 = 총합 / 개수
		return (math + eng + kor) /3;
	}
  
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setage(int age) {
		this.age = age;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public String toString() {
		return "name: " + name +","
				+"age: " + age + ","
				 +"math: " + math + ","
				  +"eng: " + eng + ","
				   +"kor: " + kor ;
	}
	
	


	
}
