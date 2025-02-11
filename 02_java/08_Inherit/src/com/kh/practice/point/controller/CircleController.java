package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {

	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius ) {
		// Circle 클래스 set 메소드로 아래 대체 가능
//		c.setX(x);
//		c.setY(y);
//		c.setRadius(radius);
		
		c = new Circle(x, y, radius);
		double area =  (radius*radius) * Math.PI;
				
		
//		return c.toString() + " / " + area;
		return String.format("%.15f",area);
		
	}
	
	public String calcCircum(int x, int y, int radius) {
		
		c = new Circle(x, y, radius);
		double area =  radius * 2 * Math.PI;
		
		
//		return String.format("%s", area);
		return c.toString() + " / " + area;
	}
}
