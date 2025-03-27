package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mybatis.member.service.MemberService;
import com.kh.mybatis.member.service.MemberServiceImpl;
import com.kh.mybatis.member.vo.Member;

/**
 * Servlet implementation class MemberUpdatecontroller
 */
@WebServlet("/update.me")
public class MemberUpdatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatecontroller() {
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
		// *  POST 요청 시 인코딩 설정 (한글이 포함되어 있을 경우)
		        
		      request.setCharacterEncoding("UTF-8");
		
		// * 전달된 데이터 추출 (id, email, gender, phone, address 필수)
		    
		     String userid = request.getParameter("userId");
		     String userName = request.getParameter("userName");
		     String email = request.getParameter("email");
		     String gender = request.getParameter("gender");
		     String birthday = request.getParameter("birthday");
		     String phone = request.getParameter("phone");
		     String address = request.getParameter("address");
		      
		    
		     // -> Member 객체로 가공처리
		     Member  m = new Member(
						      userid
						     ,userName
						     ,email
						     ,gender
						     ,birthday
						     ,phone
						     ,address
					   );
		
		// * Service 객체에 전달
			   
			 MemberService mService = new MemberServiceImpl();
			   
			   
			 int result = mService.updateMember(m);   
		
		// * 결과에 따라
		    if (result > 0 ) {
		    	// 	변경된 회원 정보를 조회하여 session영역에 저장 ( loginUser )
		    		HttpSession session = request.getSession();
		    		
		    	// id, pwd --> session 영역에 저장되어 있는 loginUser 키값에 대한 데이터 추출
		    			// => 처음 로그인했을때 Session 영역에 저장된 유저 정보   
		    			m = (Member)session.getAttribute("loginUser");
		    		   
		    			// => 수정사항이 반영된 회원 정보
		    		   Member updMem = mService.selectMember(m);
		    		   
		    		   session.setAttribute("loginUser", updMem);
		    		   
		    	//  수정 성공 시 "수정 성공했습니다." 메시지 저장
		    		request.getSession().setAttribute("alertMsg", "수정 성공했습니다");
		    		
	    		//  마이페이지로 url 재요청
		    		response.sendRedirect(request.getContextPath()+"/mypage.me");		
		    		
		    } else {
		    	
		    	//  수정 실패 시 "수정 실패했습니다." 메시지 저장
		    		request.setAttribute("errorMsg", "수정에 실패했습니다.");
		    		
		    	//  에러 페이지로 응답(포워딩)
		    		request.getRequestDispatcher("WEB-INF/-views/common/errorPage.jsp")
		    		.forward(request, response);
		    }
	}

}
