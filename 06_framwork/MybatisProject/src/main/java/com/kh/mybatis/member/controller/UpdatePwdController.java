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
 * Servlet implementation class upDatePwd
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
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
		// POST 방식인 경우 인코딩 처리 (=> 한글포함시 필수)
		request.setCharacterEncoding("UTF-8");
		
		// * 전달된 데이터 추출 (아이디, 현재비밀번호, 변경할 비밀번호)
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		
		
		MemberService mService = new MemberServiceImpl();
		
		int result = mService.updatePassword(userId, userPwd, newPwd);
		
		if (result > 0 ) {
			 // 비밀번호 변경 성공
			 // 	로그아웃 처리 --> 세션 영역을 비워주기(제거)
				request.getSession().invalidate();
			 // 	" 비밀번호 변경 성공했습니다" 메시지 저장 
				request.getSession().setAttribute("alertMsg", "비밀번호 변경 성공했습니다");
			 //		 메인 페이지로 url 재요청
				response.sendRedirect(request.getContextPath());
		} else {
			 // 비밀번호 변경 실패
			 // 		"비밀번호 변경 실패했습니다" 메시지 저장
				request.setAttribute("errorMsg", "비밀번호 변경 실패했습니다.");
			 //			 에러페이지로 응답(포워딩)
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

}
