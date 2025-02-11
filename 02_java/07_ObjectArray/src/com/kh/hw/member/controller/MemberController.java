package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
    
	 public static final int SIZE =10;
	 private Member[] m = new Member[SIZE];
	 
	 
	 public int existMemberNum() {
		
		 int total =0;
		 for (int i=0; i<m.length;i++) {
			 if (m[i] != null ) {
				 total++;
			 }
		 }
		 return total;
	 }
	 
	 public Boolean checkid(String inputid) {
		 
		 for (int i=0; i<m.length; i++) {
			 if (m[i] != null) {
				  if ( m[i].getId().equals(inputid)) {
					   return true;
				  }
			 }
		 }
		 return false;
	 }
	 
	 public void insertMember(String id, String name, String password, 
			 String email, char gender, int age) {
		 
		 for (int i=0; i<m.length;i++) {
			 if (m[i] != null) {
				 m[i] = new Member(id, name, password, email, gender, age);
				 break;
			 }
		 }
		 
		 
	 }
	 
	 public String searchid(String id) {
		 /*
		  *  id로 회원을 조회하는 메소드
		  *  @param id 아이디
		  *  @return 회원정보(문자열) : inform() 사용
		  */ 
	
		 String info =null;
		 for(int i=0; i<m.length; i++) {
			 if (m[i] != null) {
				 if(id.equals(m[i].getId())) {
					 // id값이 같은 경우
					 // 해당 객체의 inform 메소드를 통해 회원정보 반환
//					 return m[i].inform();
					 info = m[i].inform();
					 break;
				 }
			 }
		 }
		 return info;
		 
		 
		 //내가 작성
//		 for(int i=0; i<m.length;i++) {
//			 if (m[i].getId() == id  ) {
//				 return m[i].inform();
//			 }  
//		 }
//		 return null;
		 
		 
	 }
	 
	 public Member[] searchName(String name) {
		 String info =null;
		 for(int i=0; i<m.length; i++) {
			 if (m[i] != null) {
				 if(name.equals(m[i].getName())) {
					 // id값이 같은 경우
					 // 해당 객체의 inform 메소드를 통해 회원정보 반환
					 
					 return m;
//					 info = m[i].inform();
//					 break;
				 }
			 }
		 }
		 return null;
	 }
	 
	 public Member[] searchEmail(String email) {

		 for(int i=0; i<m.length; i++) {
			 if (m[i] != null) {
				 if(email.equals(m[i].getEmail())) {
					 // id값이 같은 경우
					 // 해당 객체의 inform 메소드를 통해 회원정보 반환
					 return m;
//					 info = m[i].inform();
//					 break;
				 }
			 }
		 }
		 return null;
	 }
	 
//	 public Boolean updatePassword(String id, String password) {
//		 
//		
//	 }
//	 
//	 public Boolean updateName(String id, String name) {
//		
//	 }
//	 public Boolean updateEmail(String id, String email) {
//		
//	 }
	 
//	 public Boolean delete(String id) {
//		 
//		
//	 }
//	 
//	 public void delete() {
//		 	
//	 }
//	 
//	 public Member[] printAll() {
//	 }
// 	 
	 
 }
