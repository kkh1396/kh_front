package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {

	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		
		r = new Rectangle(x, y, height,width);
		int Area =  height * width;
		
		
		return String.format("%s", Area);
	}
	
	public String calcPerimeter(int x, int y, int width, int height) {
		
		
		r = new Rectangle(x, y, height,width);
		int Area =  (height + width) * 2;
		
		
		return String.format("%s", Area);
	}
}
