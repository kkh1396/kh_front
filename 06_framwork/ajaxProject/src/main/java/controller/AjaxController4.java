package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.vo.Member;

/**
 * Servlet implementation class AjaxController4
 */
@WebServlet("/jqAjax4.do")
public class AjaxController4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체 3개 만들기
		
		 ArrayList list = new ArrayList<>();
		 Member m = null;
		 list.add(new Member(1,"k1","k","k1"));
		 list.add(new Member(2,"k2","k","k2"));
		 list.add(new Member(3,"k3","k","k3"));
		 
		 // GSON 객체 생성
		 Gson gson = new Gson();
		 
		 response.setContentType("application/json; charset=UTF-8");
		 gson.toJson(list, response.getWriter());
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
