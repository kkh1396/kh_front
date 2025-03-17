package com.kh.object.practice7.model.vo;

public class Employee {

	// 필드
	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	// 생성자
	public Employee() {}
	
	public Employee(int empNo, String empName) {
		this.empNo = empNo;
		this.empName = empName;
	}
	
	public Employee(int empNo, String empName, String dept, String job, int age, char gender, int salary,
			double bonusPoint, String phone, String address) {
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.bonusPoint = bonusPoint;
		this.phone = phone;
		this.address = address;
	}
	
	
	// 메소드
	
	//메소드 2개
	public void setter(int empNo, String empName) { 
		this.empNo = empNo;
		this.empName = empName;
	}
	
	// 메소드 10개
	public void setter(int empNo, String empName, String dept, String job, int age, char gender, int salary,
			double bonusPoint, String phone, String address) { 
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.bonusPoint = bonusPoint;
		this.phone = phone;
		this.address = address;
	}
	
	public void getter() {
		System.out.print("사원 번호: " + empNo + " 사원 이름: "+empName + " 부서: "+dept+" 직업: "+job
				         +" 나이: "+age+" 성별 "+gender+" 직급: "+salary+" 보너스점수: "+ bonusPoint +" 전화번호: "+phone
				         + " 주소: " + address
				);
	}
}
