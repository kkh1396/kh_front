package com.kh.object.practice2.model.vo;

public class Product {

	private String productName;
	private int price;
	private String brand;
	
	public Product() {}
	public Product(String productName, int price, String brand) {
		this.productName = productName;
		this.price = price;
		this.brand = brand;
	}
	
	public void information() {
	   System.out.print(
			   "이름은 "+this.productName + 
			   	" 가격은 " + this.price + 
			   	 " 브랜드는 " +this.brand);	
	}
	
	
	
	
}
