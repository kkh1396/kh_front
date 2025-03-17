package com.kh.practice.view;

import java.util.Calendar;

import com.kh.practice.leap.LeapController;

public class LeapView {

	LeapController lc = new LeapController();
	Calendar c = Calendar.getInstance();
	
	public LeapView() {
	
	
     if( lc.isLeapyear(c.get(c.YEAR))) {
    	 System.out.println(c.get(c.YEAR)+"년은 윤년입니다.");
     } else {
    	 System.out.println(c.get(c.YEAR)+"년은 평년입니다.");
     }
		
	 
      System.out.println(lc.leapDate(c));
	
	}

}
