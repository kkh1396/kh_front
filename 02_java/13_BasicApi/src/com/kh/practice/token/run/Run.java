package com.kh.practice.token.run;

import java.util.Scanner;

import com.kh.practice.token.controller.TokenController;
import com.kh.practice.token.view.TokenMenu;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TokenController tc = new TokenController();
		TokenMenu tm = new TokenMenu();
		Scanner sc = new Scanner(System.in);
		
		

//		System.out.println(tc.firstCap("java"));
		tm.mainMenu();
//	    tm.tokenMenu();
		
	}

}
