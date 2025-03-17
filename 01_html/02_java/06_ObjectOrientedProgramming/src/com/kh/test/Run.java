package com.kh.test;

import com.kh.test.*;

public class Run {

	public static void main(String[] args) {
		Employee emp1 = new Employee("홍길동", 3000);
		emp1.printInfo();
		// =>  예상 출력 결과 ?
//		[1]홍길동, null, 3000

//		Employee emp2 = new Employee();
//		emp2.printInfo();
		// => 예상 출력 결과 ?
//		에러
	}

	Run[] arr= new Run[6];
	Employee[] emp = new Employee[2];
}
