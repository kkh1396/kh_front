package com.kh.inherit_after;

public class Tv extends Product{
	
	private int inch;
	private String kind;
	
	public Tv() {}

	
	public Tv(String brand, String name, String model, String serial, int price, int inch, String kind) {
		super(brand, name, model, serial, price);
		this.inch = inch;
		this.kind = kind;
	}

	
	public String information() {
		
		return super.information() + " 인치 : "+ inch + " 종류 :" +  kind;
	}


	public int getInch() {
		return inch;
	}


	public void setInch(int inch) {
		this.inch = inch;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}
	
	

}
