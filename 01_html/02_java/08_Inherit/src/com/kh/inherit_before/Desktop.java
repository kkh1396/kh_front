package com.kh.inherit_before;

public class Desktop {
	
	private String brand;
	private String code;
	private String name;
	private int price;
	
		public Desktop() {}
	
		public Desktop(String brand, String code, String name, int price) {
		super(); // 부모 클래스 생성자 호출 (Object) 기본 생성자 호출
		this.brand = brand;
		this.code = code;
		this.name = name;
		this.price = price;
	}
		
		public String information() {
			
			String info = String.format("%s %s %s %d", brand,code,name,price);		
			return info;
		}
}

	
	

