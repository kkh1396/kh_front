package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class requestTest_POST
 */
@WebServlet("/test2.do")
public class requestTest_POST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestTest_POST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("doget 메소드 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("dopost 메소드 실행");
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("username");
		String gender  = request.getParameter("gender");
		String age =  request.getParameter("age");
		String address =  request.getParameter("address");
		String height =  request.getParameter("height");
		String[] foods = request.getParameterValues("food");
		
		System.out.println();
		System.out.println("이름 : "+ name);
		System.out.println("성별 : "+ gender);
		System.out.println("나이 : "+ age);
		System.out.println("주소 : "+ address);
		System.out.println("키 : "+ height);
		
		System.out.println("음식 : " + String.join(",", foods));
		
		if (foods != null ) {
			for (String f : foods) {
				System.out.println(f);
			}
		}
		
		/*
		 *  * 순수 서블릿 방식 : JAVA 코드 내에서 html을 작성
		 *  
		 *  * JSP(Java Server Page) 방식 : HTML 내에 Java 코드 작성
		 * 
		 */
	
		// 응답 페이지에서 필요한 데이터를 전달
		// --> 전달하는 공간 : request 객체의 attribute라는 공간 사용 (key,value)
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("address", address);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
	    // 응답 페이지를 jsp에 맡겨보자.
		
		// * jsp 페이지로 응답
		//   -> request.getRequestDispatcher(응답할페이지경로);
		RequestDispatcher view  = request.getRequestDispatcher("views/responsePage.jsp");
		// -> 변수명 forward(request, response);
		view.forward(request, response);
		
		
	}

}
