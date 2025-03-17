package com.kh.person.model.person.controller;

import com.kh.person.model.mo.Employee;
import com.kh.person.model.mo.Student;

public class PersonController {

	Student[] s = new Student[3];
	Employee[] e = new Employee[10];
	
	
	public int[] personCount() {
		
		int[] temp = new int[2];
		int s_sum = 0;
		int e_sum = 0;
		// 학생수 
			for(int j=0; j<s.length;j++) {
				   if( s[j] != null) {
	 
					  s_sum++;			   }
				}
			for(int j=0; j<s.length;j++) {
				   if( e[j] != null) {
					  e_sum++; 
				   }
				}
			
			temp[0] = s_sum;
			temp[1] = e_sum;
				
		return temp;
	
	}
	
	public void insertStudent(String name, int age, double height, double weight
								, int grade, String major) {
		
		for (int i=0; i<s.length;i++) {
			if (s[i] == null) {
				s[i] = new Student(name, age,  height,  weight,  grade,  major);
			}
		}
		
	}
	
	public Student[] printStudent() {
		
		Student[] temp = new Student[s.length];
		   for ( int i=0; i<s.length; i++) {
			   if (s[i] == null) {
				   temp[i] = s[i];
			   }
		   }	
		return temp;
	}
	
	public void insertEmployee(String name, int age, double height, double weight
								, int salary, String dept) {
		for (int i=0; i<s.length;i++) {
			if (e[i] == null) {
				e[i] = new Employee(name, age,  height,  weight,  salary,  dept);
			}
		}
	}
	
	public Employee[] printEmployee() {
		return e;
	}
	
}
