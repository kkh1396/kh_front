package com.kh.api;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class API4_Date {

	// java.util.Date
	// * 날짜, 시간 관련 클래스
	public static void main(String[] args) {
		
		Date date = new Date();
		
		System.out.println(date);
		// => 현재 날짜 + 시간
		
		// * 원하는 날짜 지정
		//   - 연도 : 지정연도-1900
		//   - 월  : 지정월-1
		Date date2 = new Date(2024-1900,12-1,31);
		System.out.println(date2);
		
		// java.text.SimpleDateFormat
		// : 형식을 지정하는 객체
		String format = "yyyy년 MM월 dd일 hh시 mm분 ss초";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		System.out.println( sdf.format(date) );
		
		// java.time.localDateTime
		LocalDateTime date3 = LocalDateTime.now();
		// * LocalDateTime.now() : 현재 날짜시간 기준으로 생성
		System.out.println(date3);
		
		
		System.out.println();
		// * 변수명.getMonth() : 월 정보를 반환 (영어)
		System.out.println(date3.getMonth());
		// * 변수명.getMonthValue() : 월 정보를 반환 (숫자)
		System.out.println(date3.getMonthValue());
		
		// * 변수명.getDayofmonth() : 일 정보를 반환 (월 기준)
		System.out.println(date3.getDayOfMonth());

		// * 변수명.getDayofYear() : 일 정보를 반환 (연 기준)
		System.out.println(date3.getDayOfYear());
		
		System.out.println();
		
		// 올해는 며칠이 남았는지  
		System.out.println( 365 - date3.getDayOfYear());

		// * 변수명.getHour() : 시 정보
		System.out.println(date3.getHour());
		
		
		// 퇴근까지 몇시간 남았는지
		
		System.out.println(18 - date3.getHour());
	
		
		// * 형식 지정하기
		// java.time.format.DateTimeFormatter 이용
		// DateTimeFormatter.ofPattern(형식)
		
		String format2 = date3.format(
						DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		System.out.println(format2);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
