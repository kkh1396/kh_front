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

/**
 * Servlet implementation class deleteController
 */
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			
		  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 데이터 추출 (인코딩 생략 --> 한글x )
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		MemberService service = new MemberServiceImpl();
		
		int result = service.deleteMember(userId, userPwd);
		
		if ( result > 0) {
			// 탈퇴 성공
			HttpSession session = request.getSession();
			request.getSession().invalidate();
			// 	"회원 탈퇴가 완료되었습니다. "
			    request.getSession().setAttribute("alertMsg", "회원 탈퇴가 완료되었습니다. ");
			//   메인 페이지로 url 재요청 -> 로그인 정보가 제거되어야 할 것!
//			    request.getSession().removeAttribute("loginUser");
			    response.sendRedirect(request.getContextPath()); // /mybatis 요청
			    
		} else {
			// 탈퇴 실패
			//   " 회원 탈퇴에 실패했습니다." 메시지 저장 
				request.setAttribute("errorMsg", "회원 탈퇴가 실패했습니다.");
			//     에러페이지로 응답 
				request.getRequestDispatcher("WEBI-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
