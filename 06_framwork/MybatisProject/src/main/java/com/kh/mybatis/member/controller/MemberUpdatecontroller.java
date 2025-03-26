package com.kh.mybatis.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			   
			   System.out.println(String.format("%s,%s,%s,%s,%s,%s,%s"
					   						, userid ,userName, email, gender, birthday, phone, address));
			   
			   Member m = new Member(
					      userid
					     ,userName
					     ,email
					     ,gender
					     ,birthday
					     ,phone
					     ,address
					   );
		
		// * Service 객체에 전달
			   
		    int result = new MemberServiceImpl().updateMember(m);   
		
		// * 결과에 따라
		    if (result > 0 ) {
		//			수정 성공 시 "수정 성공했습니다." 메시지 저장
		    	request.getSession().setAttribute("alertMsg", "수정 성공했습니다");
		    	response.sendRedirect(request.getContextPath());
		    	
		    } else {
		    	request.setAttribute("errorMsg", "수정에 실패했습니다.");
		    	 request.getRequestDispatcher("WEB-INF/-views/common/errorPage.jsp")
		    		.forward(request, response);
		    }
	}

}
