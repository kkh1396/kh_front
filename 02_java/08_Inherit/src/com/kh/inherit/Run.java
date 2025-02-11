package com.kh.inherit;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Desktop dt = new Desktop("LG", "Lg-001","사무용",100000);
		System.out.println(dt.information());
		
		TV tv = new TV("LG", "Lg-001","사무용",100000, 55);
		System.out.println(tv.information());
	}

}
