package com.kh.inherit;

public class TV extends Desktop {
	
	private int inch;

	public TV(String brand, String code, String name, int price, int inch) {
		super(brand, code, name, price);
		this.inch = inch;
	}
	
	public String information() {
		
		String info = String.format("%s %d",super.information(),inch );
		return info;
	}
	
	
}
