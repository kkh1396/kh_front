package com.kh.test;

public class Employee {

	private static int empNo;	// 사원 번호
	private String empName;	// 사원명
	private String deptName;	// 부서명
	private int salary;		// 급여

	public Employee(String empName, String deptName, int salary) {
		empNo++;
//		아래부분 3개 this. 이 빠짐
		this.empName = empName;
		this.deptName  = deptName;
		this.salary = salary;
	}

	public Employee(String empName, int salary) {
		empNo++;
//		아래부분 2개 this. 이 빠짐
		this.deptName  = empName;
		this.salary = salary;
	}

	public int getEmpNo() {
//		this. 빠짐
		return this.empNo;
	}
	
	public String getEmpName() {
//		this. 빠짐
		return this.empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
//		this. 빠짐
		this.deptName = deptName;
	}

	public int getSalary() {
		return this.salary;
	}
	// 매개변수 String -> int 변경
	public void setSalary(int salary) {
//		this. 빠짐
		this.salary = salary;
	}
	/**
		* 저장된 사원 정보를 출력하는 메소드
	*/
	public void printInfo() {
		
		//  void는 반환이 없는것으로 return 사용 불가
		// return 제거하고 출력으로 변경
		   
		System.out.print("[" + empNo + "] " + empName + ", " + deptName + ", " + salary);
//		return info;
	}
}
