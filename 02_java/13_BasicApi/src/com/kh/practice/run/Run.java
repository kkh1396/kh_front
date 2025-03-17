package com.kh.practice.run;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import com.kh.practice.leap.LeapController;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDateTime date = LocalDateTime.now();
		Calendar c1 = Calendar.getInstance();
		LeapController lc = new LeapController();
//		LeapView lv = new LeapView();
		
		
//		System.out.println(lc.isLeapyear(2000));
		
		
//		System.out.println(lc.leapDate(c1));
		
		System.out.println(date.getDayOfMonth());
		
		
	}

}
