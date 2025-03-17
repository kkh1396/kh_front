package com.kh.last.p3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();

		System.out.println("날짜를 입력하시오");
		System.out.print("년 : ");
		int year = sc.nextInt();
		System.out.print("월 : ");
		int month = sc.nextInt();
		System.out.print("일 : ");
		int day = sc.nextInt();

		c.set(year, month - 1, day);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		SimpleDateFormat sd = new SimpleDateFormat("yyyy년 MM월 dd일 ");

		String korDay = "";
		switch (dayOfWeek) {
		case 1:
			korDay = "일";
			break;
		case 2:
			korDay = "월";
			break;
		case 3:
			korDay = "화";
			break;
		case 4:
			korDay = "수";
			break;
		case 5:
			korDay = "목";
			break;
		case 6:
			korDay = "금";
			break;
		case 7:
			korDay = "토";
			break;
		default:

		}

		int y4 = year % 4;
		int y100 = year % 100;
		int y400 = year % 400;
		String yday = "";
	       if(y400 == 0)
	    	   yday = "윤년";
	        else if(y100 == 0)
	        	yday = "평년";
	        else if(y4 == 0)
	        	yday = "윤년";
	        else
	        	yday = "평년";

		SimpleDateFormat sd2 = new SimpleDateFormat("yyyy년은 " + yday + "이다");

		System.out.println();
		System.out.println("입력된 날짜에 대한 정보는 아래와 같습니다.");
		System.out.println(sd.format(c.getTime()) + korDay + "요일");
		System.out.println(sd2.format(c.getTime()));
	}

}
