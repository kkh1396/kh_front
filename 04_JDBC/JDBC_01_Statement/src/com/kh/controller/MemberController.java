package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.view.MemberMenu;
import com.kh.vo.Member;

/*
  *  * Controller : View로부터 사용자가 요청한 기능에 대해 처리하는 역할
  *  				전달받은 데이터를 가공처리한 후 DAO로 전달하여 호출 
  *  				DAO로부터 반환받은 결과에 따라 성공인지, 실패인지 판단 후 응답
  */


public class MemberController {

	 private MemberDao mDao = new MemberDao();
	/*
	 * 회원 추가 요청을 처리할 메소드
	 * @parm id  	신규회원아이디
	 * @parm pwd  	신규회원비밀번호
	 * @parm gender 성별
	 * @parm age  	나이 
	 * 
	 */
	
	public void insertMember(String id, String pwd,
							 char gender, int age) {
		
		// View로부터 전달받은 값들을 DAO에게 바로 전달하지 않고
		// Member 객체에 담아서 잔달
		
		// *Member 객체 생성
		//   - 기본생성자로 생성 후 setter를 이용해 저장
		//	 - 매개변수가 있는 생성자를 사용하여 저장 
		
		Member m = new Member(id, pwd, gender, age);
		
		// DAO에게 신규회원정보(Member)를 전달하여 추가 요청 
		
		int result = mDao.insertMember(m);
		
		if (result > 0) {
			// 회원 추가 성공 출력(=> View를 이용하여)
			new MemberMenu().displaySuccess("회원 추가 성공!");
		} else {
			// 회원 추가 실패 출력(=> View 이용
			new MemberMenu().displayFailed("회원 추가 실패!");
		}
		
		
	}
	
	/*
	 *  전체 회원 정보들을 조회
	 * 
	 */
	
	public void selectAll() {
		 ArrayList<Member> list = mDao.selectAllList();
		 
		 // * 조회된 결과에 따라 사용자에게 표시(출력)
//		 if (list.size() == 0) {
		   if (list.isEmpty()) {
			   // 조회 결과가 없을 경우 (=> 리스트가 비어있다면)
			  new MemberMenu().displaynoDate();
		 } else {
			  // 조회 결과가 있을 경우 
			 new MemberMenu().displayAllMemberMenu(list);
		 }
		 
	}

	
	/*
	 *  전달된 아이디에 해당하는 회원 정보 조회
	 *  @param searchId 회원 아이디
	 * 
	 */
	public void searchById(String searchId) {
		Member m = mDao.searchById(searchId);
		
		if (m == null) {
			// 조회된 결과가 없는 경우
			new MemberMenu().displaynoDate();
		} else {
			// 조회된 결과가 있는 경우
			new MemberMenu().displayMember(m);
		}
		
	}

	
	/**
	 *  회원 아이디 기준으로 회원 정보 변경
	 *  @param id		 회원 아이디					
	 *  @param pwd		 회원 비밀번호
	 *  @param gender	 회원 성별
	 *  @param addr	     회원 주소
	 *  @param hobby	 회원 취미 
	 *  
	 */
	public void updateMember(String id, String pwd, char gender, String addres, String hobby) {
		  // 전달받은 데이터를 Member 객체에 담아 Dao에게 전달
		  
		// 1) 기본생성자로 객체 생성 후 setter 메소드를 사용하여 저장
		/*
		  Member m = new Member();
		         m.setMemberId(id);
		         m.setMemberPw(pwd);
		         m.setGender(gender);
		         m.setAddress(addres);
		         m.setHobby(hobby);
		 */
		// 2) 매개변수 생성자로 객체 생성하여 저장
		 Member m = new Member(id,pwd,gender,addres,hobby);
		 int result  = mDao.updateMember(m);
		
		 if ( result > 0 ) {
			 // 회원 수정 성공시
			   new MemberMenu().displaySuccess("회원 정보 수정 성공!");
		 } else {
     		 // 회원 수정 실패
			  new MemberMenu().displayFailed("회원 정보 수정 실패");
		 }
		
	}

	public void deleteMember(String id) {
		
		   
		    int result  = mDao.deleteMember(id);
				
			 if ( result > 0 ) {
				 // 회원 삭제 성공시
				   new MemberMenu().displaySuccess("회원 정보 삭제 성공!");
			 } else {
	     		 // 회원 삭제 실패
				  new MemberMenu().displayFailed("회원 정보 삭제 실패");
			 }
		
		
	}

}
