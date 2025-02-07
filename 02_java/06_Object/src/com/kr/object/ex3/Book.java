package com.kr.object.ex3;

public class Book {
/*
 *  *접근 제한자 : 클래스 내의 맴버(변수, 메소드)들에 접근할 수 있는 범위를 제한함!
 *   			클래스 정의 시에도 사용함
 *      
 *         - 클래스에 사용 가능한 접근 제한자 : 2가지
 *           public, default
 * 
 * 
 * 		   - 클래스 내 맴버(변수, 메소드)에 사용할 수 있는 접근 제한자 : 4가지
 *           public 	: 어디서든 접근 가능 
 *           protected  : 같은 패키지 또는 상속 관계에서만 접근 가능
 *           default    : 같은 패키지에서만 접근 가능
 *           private    : 해당 클래스에서만 접근 가능           
 */
	
	// ----필드부 ----------------------
	// * 모든 변수들은 클래스 내에서만 접근 가능하도록 할 것.
	private String title;	// 제목 title : String
	private String genre;	// 장르 genre : String
	private String author;// 저자 author : String
	private int  maxPage; // 페이지수 : maxPage : int
	// ---------------------------
		
	// ----------생성자부-------------------------

	// * 정의한 현재 클래스를 생성할 때 사용되는 메소드!
	// * 객체를 생성할 떄 데이터를 초기화하기 위한 목적으로 생성자를 정의함!
	
	// [규칙]
	// 	(1) 생성자명은 클래스명과 동일
	//  (2) 반환형을 표시하지 않음! 반환되는 값도 없음!
	 public Book() {} // 기본생성자
	 // => 생성자를 따로 정의하지 않으면 컴파일러를 통해 기본생성자를 만들어줌!
	 
	 // 매개변수 정보(개수, 종류, 순서)를 구분하여 정의하면
	 // 생성자도 오버로딩이 적용됨
	 
	 // 배개변수가 3개인 생성자 (제목, 장르, 저자)
	 public Book(String title, String genre, String author) {
//		 this.title = title;
//		  // this(현재 클래스 내에 있는).title변수에 전달받은 title 값을 대입
//		 this.genre = genre;
//		 this.author = author;
		 this(title, genre, author, 0);
	 }
	 // 매개변수가 4개인 생성자 (제목, 장르, 저자, 페이지 수)
	 public Book(String title, String genre, String author, int maxPage) {
		 this.title = title;
		 this.genre = genre;
		 this.author = author;
		 this.maxPage = maxPage;
	 }
	// ----------------------------------------
	 
	 // -----------메소드부 --------------------
	 // * private 변수에 접근하기 위한 메소드 (getter/setter)
	 
	 // * 제목(title)을 저장하는 변수의 값을 조회하는 메소드 (getter)
	 // => 제목에 대한 정보를 반환해줘야 함!
	 public String getTitle() {
		 return title;
	 }
	 // * 제목(title)에 대해 값을 저장하기 위한 메소드 (setter)
	 // => 저장할 값을 전달받아 변수에 저장해야 함!
	 
	 public void setTitle(String title) {
		 this.title = title;
	 }
	 
	 // * 저장된 데이터(변수)들을 조회하는 메소드 (toStirng)
	 
	   public String toString() {
		   return "제목: " + title + "\n"
				   + "장르: " + genre + "\n"
				    + "저자: " + author + "\n"
				     + "페이지 수: " + maxPage;
	   }
	 
	 
	
	 // -------------------------------------
	 
	 
	 
	 
	 
}
 