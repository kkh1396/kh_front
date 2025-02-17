package com.kh.practice.chap01_poly.controller;

import com.kh.practice.chap01_poly.model.vo.AniBook;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member;

public class LibraryController {

	
	Member mem = new Member(); 
	Book[] bList = new Book[5];
 	
	
	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	
	
	public void inserMember(Member mem) {
		// 전달받은 mem (매개변수) 주소값을 통해
		// LibraryController의 mem에(인스턴스변수, 필드) 대입 -> setter 메소드
		 this.mem = mem;
		
	}
	
	public Member myinfo() {
		// 회원 레퍼런스(mem) 주소값 리턴 -> getter 메소드
		return mem;
	}
	
	public Book[] selectAll() {
		// 도서 전체 목록 (bList) 주소값 리턴 => bList필드의 getter 메소드
		return bList;
		
	}
	
	public Book[] searchBook(String keyword) {
		/*
		 *  전달받은 키워드(매개변수)가 포함된 도서가 여러 개가 존재할 수 있으니
		 *  검색된 도서를 담아줄 Book 객체 배열을 새로이 생성하고
		 *  
		 *  for문을 통해 bList 안의 도서들과 전달받은 키워드를 비교하여
		 *  포함하고 있는 경우 새로운 배열에 차곡차곡 담기
		 *  -> 그 배열 주소 값 리턴
		 * 
		 */
		
		Book[] searchList = new Book[bList.length];
		
		int count=0;
		// for문을 사용하여 bList 안의 도서들에서 키워드에 해당하는 항목을 (문자열.contains(키워드))
		// searchList배열에 저장 
		// * 키워드 포함 여부 확인 : 문자열.contains(키워드)
		
		 for (int i=0; i< searchList.length; i++) {
			  if (bList[i] != null && bList[i].getTitle().contains(keyword)) {
				  searchList[count++] = bList[i];
			 }
		 }
		
		return searchList;
		
	}
	
	public int rentBook(int index) {
		
		Book b = bList[index];
		int result =0;
		if (b instanceof AniBook) {
			
			if ( mem != null &&
					((AniBook)b).getAccessAge() > mem.getAge()) {
				
				result = 1;
			}
		} else if ( b instanceof CookBook) {
			if (mem != null 
					&& ((CookBook)b).isCoupon()	){
				mem.setCouponCount( mem.getCouponCount() + 1 );
				
				result = 2;
			
			}
		}
		
		
		return result;
	}
}
