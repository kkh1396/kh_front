package com.kh.object.practice1.model.vo;

public class Member {
 /* --- 필드부 ----- */
	private String memberid;
	private	String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	
	/* ---------생성자부--------------------*/
	/* 
	 *  + Member()
	 */
	public Member() {}
//	public Member(String memberid, String memberPwd, String memberName, int age, char gender, String phone,
//			String email) {
//		super();
//		this.memberid = memberid;
//		this.memberPwd = memberPwd;
//		this.memberName = memberName;
//		this.age = age;
//		this.gender = gender;
//		this.phone = phone;
//		this.email = email;
//		
//	}
	/*----------------------------------- */
	
	
	/*---------메소드부------------------- */
	
	 /*
 		+ changeName(name:String):void
		+ printName():void
		
	 */
	
	public void ChangeName(String name) {
		this.memberName = name;
	}
	
	public void printName() {
		System.out.println("맴버의 이름은 "+this.memberName);
	}
	
}
