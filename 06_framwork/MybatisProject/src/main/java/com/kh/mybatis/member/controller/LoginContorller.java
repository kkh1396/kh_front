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

// login.me 요청을 받아 아이디, 비밀번호 데이터 추출 -> 출력
/*
 *  1) HttpServlet 상속
 *  2) @WebServlet("요청 url")  --> URL Mapping
 */

@WebServlet("/login.me")
public class LoginContorller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 요청시 데이터에 한글이 포함된 경우 인코딩 처리
		req.setCharacterEncoding("UTF-8"); // 데이터 추출 전 인코딩 처리!!
		
		// * 아이디, 비밀번호 데이터 추출
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		
		
		// Service 객체에게 요청하기 위해 데이터 가공처리 (=> Member 객체 생성)
		Member m = new Member();
			m.setUserId(userId);
			m.setUserPwd(userPwd);
			
			MemberService service = new MemberServiceImpl();
			  Member loginUser = service.selectMember(m);
			  // => 조회된 결과가 있을 경우 Member 객체 전달
			  //			   없을 경우 null 값 전달 
			  
			  if (loginUser != null) {
			  // 로그인 성공 시  
			  HttpSession session = req.getSession();
			  //	조회된 결과가 있을 것임! (null 값이 아닌 경우)
			  //	session 영역에 loginUser 키값으로 조회된 결과 저장
			  session.setAttribute("loginUser", loginUser);
			  // 	" 로그인 성공했습니다" 메시지 저장  --> session 영역. alertMsg
			  session.setAttribute("alertMsg", "로그인 성공했습니다.");
			  //    메인 페이지로 url 재요청 -> "/mybatis" url재요청
			  resp.sendRedirect(req.getContextPath());
			  } else{
			  // 로그인 실패 시 
			  //     null값인 경우
			  //	"로그인에 실패했습니다." 메시지 저장 
			  //	  --> 에러페이지에 출력하기 위해 request 영역 
				  req.setAttribute("errorMsg", "로그인에 실패했습니다.");
			  //	 에러 페이지로 포워딩(응답)
				  req.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			  }

	}
			
	
	
}
