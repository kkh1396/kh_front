package com.kh.practice.numRange.controller;

import com.kh.practice.numRange.exception.NumRangeException;

public class NumberController {

	public NumberController() {}
	public boolean checkDouble(int num1, int num2) throws NumRangeException{
		
		if ((num1 > 0 && num1 < 101) && (num2 > 0 && num2 < 101)) {
			
			int bea = num1 % num2;
			if ( bea == 0) {
				return true;
			} else {
//				System.out.print(bea);
				return false;
				
			}
		    
		} 
		throw new NumRangeException("1~100사이의 값이 아닙니다.");
	}
}
