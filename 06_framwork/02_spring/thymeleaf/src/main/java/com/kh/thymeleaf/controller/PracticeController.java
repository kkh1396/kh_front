package com.kh.thymeleaf.controller;




import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.thymeleaf.model.dto.PersonDTO;

import jakarta.servlet.http.HttpSession;


@Controller
public class PracticeController {

	
	
	// [GET] "/go" 요청 매핑 
	@GetMapping("go")
	public String practicePage() {
		
		
		/*
		 *  * thymeleaf 사용 시 기본 설정값
		 *    => classpath : src/main/resources/
		 *    - prefix : classpath:templates/
		 *    - suffix : .html
		 */
		
		// classpath: templates/practice/page1.html
		return "practice/page1";
	}
	
	
	/*
	 *  [POST] /add
	 *    { name:이름, age: 나이, birth: 생년월일, hobby: 취미, ....}
	 */
	
//	 @PostMapping("add")
//	 public String postMethodName(@RequestParam String name, int age, String birth , String hobby) {
//		 
//		 System.out.println(name +" "+ age + " " + birth + " " + hobby );
//		 System.out.println(name +" "+ age + " " + hobby );
//		 
//
//	 	
//	 	return "practice/page2";
//	 }
	
	@PostMapping("add")
	public String postMethodName(
//			HttpServletRequest request    // 서블릿의 request 객체를 이용 
			
			/*    // 변수를 직접 받는 형태
			String name
			, @RequestParam(defaultValue="20") int age
			, @RequestParam String birth
			, String[] hobby
			*/
			
			 PersonDTO pdto		// 페이지에서 오는 값을 객체로 받아 처리하는 방법 
			 , Model model, HttpSession session
			) {
		
		  // HttpServletRequest request 로 값을 받을 경우 
//		 String name = request.getParameter("name");
//		 String age = request.getParameter("age");
//		 String birth = request.getParameter("birth");
//		 
//		 String[] hobbies = request.getParameterValues("hobby");
//		 
//		System.out.println(name +" "+ age + " " + birth + " " + Arrays.toString(hobbies) );
		
		
//		System.out.println(name + age + birth + Arrays.toString(hobby) );
		
		System.out.println(pdto);
		// ----- service --- dao ---- .... 비즈니스 로직 처리 ...
		
		// Model : 스프링에서 제공하는 객체로, request 영역에 데이터 저장 
		
		// * request 영역에 전달받은 데이터를 "p" 키값으로 저장 
		model.addAttribute("p", pdto);
		
		// * session 영역에 전달받은 데이터를 "user" 키값으로 저장
		session.setAttribute("user", pdto);
		
		// * 임의의 데이터를 리스트에 담아 request 영역에 "persionList" 키값으로 저장
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("금이유", 20, "2005-03-13"));
		list.add(new PersonDTO("토이유", 20, "2005-11-13"));
		list.add(new PersonDTO("일이유", 20, "2005-05-13"));
		
		model.addAttribute("personList", list);
		
//		 return "redirect:go";
		 return "practice/page2";
		
	}
	
}








