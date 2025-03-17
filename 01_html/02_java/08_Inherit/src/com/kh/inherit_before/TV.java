package com.kh.inherit_before;

public class TV  {
	private String brand;
	private String code;
	private String name;
	private int price;
	private int inch;

	public TV(String brand, String code, String name, int price, int inch) {
		super();
		this.inch = inch;
	}
	
	public String information() {
		
		String info = String.format("%s %s %s %d %d", brand,code,name,price,inch);	
		return null;
	}
	
	
}
