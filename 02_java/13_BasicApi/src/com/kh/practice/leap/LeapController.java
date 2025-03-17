package com.kh.practice.leap;

import java.util.Calendar;
import java.util.Date;

public class LeapController {

	public boolean isLeapyear(int year) {

		int uyear1 = year % 4;
		int uyear2 = year % 400;
		boolean result = false;

		if (uyear1 == 0) {
			if (uyear2 == 0) {
				result = true; // 윤년
			} else {
				result = false; // 평년
			}
		}

		return result;
	}

	public long leapDate(Calendar c) {

		Date date = new Date();
		int total = 0;
		for(int i=1; i<=c.get(Calendar.YEAR);i++) {

			if (isLeapyear(i)) {
				total += 366;
			} else {
				total += 365;
			}
		}
		
		for(int i=1; i<3; i++) {
			
		}

		return total;
	}
}
