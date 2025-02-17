package com.kh.poly.ex2;

public class Car {

	private String color;
	private String fuel;
	private int year;
	
	public Car() {}
	
	public Car(String color, String fuel, int year) {
		super();
		this.color = color;
		this.fuel = fuel;
		this.year = year;
	}
	
	public String toString() {
		
		return String.format("color : %s fuel : %s year : %d",color,fuel,year);
				
	}
	public void drive() {
		System.out.println("Car dirve~~");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
