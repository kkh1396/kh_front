package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.service.MemberService;
import com.kh.mybatis.member.service.MemberServiceImpl;
import com.kh.mybatis.member.vo.Member;

/**
 * Servlet implementation class Memberinsertcontorller
 */
@WebServlet("/insert.me")
public class Memberinsertcontorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Memberinsertcontorller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 전달된 데이터 추출
		//   => POST 요청인 경우 전달된 데이터에 한글이 포함될수 있으므로 
		// 		인코딩 처리 필요!
		request.setCharacterEncoding("UTF-8");
		
		
		// 데이터 추출 메소드 ; getParameter("키값");
		   String userid = request.getParameter("userId");
		   String userPwd = request.getParameter("userPwd");
		   String userName = request.getParameter("userName");
		   String email = request.getParameter("email");
		   String gender = request.getParameter("gender");
		   String birthday = request.getParameter("birthday");
		   String phone = request.getParameter("phone");
		   String address = request.getParameter("address");
		   
		   System.out.println(String.format("%s,%s,%s,%s,%s,%s,%s,%s"
				   						, userid, userPwd ,userName, email
				   						, gender, birthday, phone, address));
		   
		   Member m = new Member(
				      userid
				     ,userPwd
				     ,userName
				     ,email
				     ,gender
				     ,birthday
				     ,phone
				     ,address
				   );
		   // ---> 스프링 사용 시 간단해질 부분임!
		   		  		   	
		  
		   
		// * Service 객체에게 전달된 데이터를 전달 -> 데이터 추가요청
		  int result = new MemberServiceImpl().insertMember(m);
		
		  System.out.println(result);
		
		// * 결과에 따라 페이지 구분 
		  if (result > 0) {  // 회원 가입 성공!! --> 메인페이지 url 재요청
//			  response.sendRedirect("/mybatis");
			  response.sendRedirect(request.getContextPath());
			  System.out.println(request.getContextPath());
		  } else {			// 회원 가입 실패!!  --> 에러페이지 포워딩
			  // * request 영역에 에러메시지 저장
			  	request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			  // common/errorPage.jsp 페이지 응답(포워딩)
			    request.getRequestDispatcher("WEB-INF/-views/common/errorPage.jsp")
			    		.forward(request, response);
			  
		  }
		
	}

}
