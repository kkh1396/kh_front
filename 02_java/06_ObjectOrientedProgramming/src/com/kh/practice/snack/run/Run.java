package com.kh.practice.snack.run;

import com.kh.practice.snack.view.*;

// * main 메소드를 가지고 있는 클래스 => 실행용 클래스
public class Run {

	public static void main(String[] args) {
		/*
		 *  MVC구조
		 *   * M(Model) => 데이터 저장용도. => Snack 클래스 담당
		 *   * V(View)  => 화면 표시 용도. => SnackMenu 클래스 담당
		 *   * C(controller) => 요청을 받아 처리하는 용도. => SnackController 클래스 담당
		 */
		
		SnackMenu sm = new SnackMenu();
		
		sm.menu();

	}

}
