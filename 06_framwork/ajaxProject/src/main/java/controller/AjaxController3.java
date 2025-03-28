package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.vo.Member;

/**
 * Servlet implementation class AjaxController3
 */
@WebServlet("/jqAjax3.do")
public class AjaxController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * 데이터 추출
		
		String userNo =  request.getParameter("userNo");
		
		// Member 객체로 생성
		Member m = new Member(Integer.parseInt(userNo)
								, "kkh", "kkh", "seoul");
		
		// => vo 객체를 전달(응답)하고자 할 경우, JSONObject 형태로 전달해줘야 함!!
		/*
		JSONObject jsonObj = new JSONObject();  
	    jsonObj.put("userNo", m.getUserNo()); 					    
	    jsonObj.put("userName", m.getUserName());
	    jsonObj.put("userId", m.getUserId());
	    jsonObj.put("addrss", m.getAddrss());
	    
	    response.setContentType("application/json; charset=utf-8 ");
	    response.getWriter().print(jsonObj);
	    */
	    
	    // => 좀더 간단한 방법으로 처리(GSON: google JSON)
		Gson gson = new Gson();
		
		response.setContentType("application/json; charset=UTF-8");
		
		// Gson객체.toJson(vo객체, 응답시사용되는스트림)
		gson.toJson(m, response.getWriter());
		/*
		 *  Gson 사용 시 vo 객체를 응답하는 경우 JSONObject 형태로 전달
		 *     이떄, 키값은 vo 객체의 필드명으로 전달 
		 *     
		 *  ArrayList/배열 데이터를 응답하는 경우 JSONArray 형태로 전달 
		 * 
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
