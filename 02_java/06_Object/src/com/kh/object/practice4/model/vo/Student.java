package com.kh.object.practice4.model.vo;

public class Student {

	private int grade ;
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
	
	public Student(int grade, int classroom, String name, double height, char gender) {
		super();
		this.grade = grade;
		this.classroom = classroom;
		this.name = name;
		this.height = height;
		this.gender = gender;
	}
	

	public void information() {
		System.out.print( grade + "학년 "
							+ classroom + "반 " 
							 + " 이름 : " + name
							  + " 키 : " + height 
							    + " 성별 : " + gender );
	}
	
}
