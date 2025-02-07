package com.kh.object.practice6.model.vo;

public class Book {

	// 필드 부분
	private String title;
	private String publisher;
	private String author;
	private int price ;
	private double discountRate;
	
	
	// 생성자 부분 
	public Book() {}
	
	public Book(String title, String publisher, String author) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}
	
	public Book(String title, String publisher, String author
			,int price, double discountRate) {
	this.title = title;
	this.publisher = publisher;
	this.author = author;
	this.price = price;
	this.discountRate =discountRate;
	}
	
	// 메소드 부분
	
	public void inform(String title, String publisher, String author) {
		System.out.print("제목: " + title + " 퍼블리셔: "+ publisher+
				           " 저자: " + author);
	}
	
	public void inform(String title, String publisher, String author
			,int price, double discountRate) {
		System.out.print("제목: " + title + " 퍼블리셔: "+ publisher+
				           " 저자: " + author + " 가격: " + price 
				             + " 할인율: " + discountRate);
	}
}
