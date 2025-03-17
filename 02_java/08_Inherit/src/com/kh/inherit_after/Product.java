package com.kh.inherit_after;

public class Product {
	
	 protected String brand;
	 protected String name;
	 protected String model;
	 protected String serial;
	 protected int price;
	 
	 public Product() {}

	public Product(String brand, String name, String model, String serial, int price) {
		super();
		this.brand = brand;
		this.name = name;
		this.model = model;
		this.serial = serial;
		this.price = price;
	}
	 
	
	public String information() {
		
	   return String.format("제품사: %s 이름: %s 모델: %s 시리얼: %s 가격: %d", 
									 brand,name,model,serial,price);
				
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
