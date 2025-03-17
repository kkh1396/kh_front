package com.kh.practice.book.model.vo;

import java.io.Serializable;

public class Book implements Serializable {
	private String title; // 도서명
	private String author; // 저자
	private int price;  // 가격
	private String date; // 출판날짜
	private double discount; // 할인율
	
	public Book() {}
	
	public Book(String title, String author, int price, String date, double discount) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
		this.discount = discount;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", date=" + date + ", discount="
				+ discount + "]";
	}
}







