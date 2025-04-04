package com.kh.spring.notice.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.common.PageInfo;
import com.kh.spring.notice.model.vo.Notice;
import com.kh.spring.notice.service.NoticeService;
import com.kh.spring.notice.service.NoticeServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller		// Controller 어노테이션 추가 시 빈 스캐닝을 통해 자동으로 빈 등록
@RequestMapping("/notice") // 공통 주소 설정
public class NoticeController {

    private final NoticeServiceImpl noticeServiceImpl;

	// NoticeService 객체를 생성자 주입방식으로 추가
	
	
	private final NoticeService nService;
	
	@Autowired
	public NoticeController ( NoticeService nService, NoticeServiceImpl noticeServiceImpl) {
		this.nService = nService;
		this.noticeServiceImpl = noticeServiceImpl;
	}
	
	/*
	 *  요청 받는 주소 : /notice/list
	 *  @return
	 */

	@GetMapping("/list")
	public ModelAndView noticeList(@RequestParam(value="cpage", defaultValue = "1") int currPage
							, ModelAndView mv) {
		
		// * 페이징 처리를 위한 추가 작업 *
		// [1] 전체 게시글 수 조회
			int listCount = nService.selectNoticeCount();
			
		// [2] 현재 페이지 번호 --> 요청 시 전달되어야 하는 값
			
		
		// [3] 페이징바 개수, 한 페이지당 표시할 게시글 개수 --> 지정 
		int pageLimit = 10;  // 페이징바 개수
		int boardLimit = 10; // 한페이지 당 10개 표시
		
		PageInfo pi = new PageInfo(listCount, currPage, pageLimit, boardLimit);
		
		// * 페이징바 정보를 request 영역에 저장 --> 페이징 바 표시할 때 사용할 것임!
		mv.addObject("pi", pi);
		
		
		
		// 응답 전 DB에서 공지사항 목록 조회
		ArrayList<Notice> list = nService.selectNoticeList(pi);
		
		// request 영역에 조회된 목록을 저장 => model
		
		// ModelAndView : 스프링에서 제공해주는 객체
		// - Model : 데이터를 key-value 형태로 저장할 수 있는 공간 (단독 사용)
		// - View : 응답 페이지에 대한 정보를 저장할 수 있는 공간 (단독 사용불가 => ModelAndView사용)
		mv.addObject("list", list);
		
		
		// 공지사항 목록 페이지 응답
//		return "notice/noticeList"; 
		mv.setViewName("notice/noticeList");
		
//		
		return mv;
//		return "redirect:/";
	}
	
	/*
	 *  /notice/detail 요청을 받을 메소드
	 *  ?no=게시글번호
	 */
	
	@RequestMapping("/detail")
	public String noticeDetail(@RequestParam(value="no", 
								defaultValue="0") int no
								, Model mv) {
		
		// 글번호에 해당하는 공지사항 정보(글번호, 제목, 작성자, 내용, 작성일)
		Notice notice = nService.selectNoticeDetail(no);
		
		
		
		// request영역에 저장 => model 객체 사용
		
		mv.addAttribute("n",notice);
		
		// 상세페이지 응답
		return "notice/noticeDetail";
	}
	
	/*
	 *  /notice/enrollForm 요청을 받아
	 *   	공지사항 작성 페이지 응답
	 *   	=> /WEB-INF/views/notice/
	 *  
	 */
	@GetMapping("/enrollForm")
	public String enrollFrom() {
		
		
		
		return "notice/enrollForm";
	}
	
	/*
	 *  /notice/write 요청을 받아
	 *  		전달된 공지사항 정보를 DB에 저장
	 *   + 성공시 공지사항 목록 페이지로 url 재요청
	 *   + 실패 시 에러 페이지로 응답
	 *   
	 */
	
	@PostMapping("/write")
	public String noticeWrite(Notice notice, Model model
							, HttpSession session) {
		int result = nService.insertNotice(notice);
		
		if (result > 0) {
			//공지사항 등록 성공
			session.setAttribute("alertMsg", "공지사항 등록 성공");
			return "redirect:/notice/list";
		}else {
			//공지사항 등록 실패
			model.addAttribute("errorMsg", "공지사항 등록 실패했습니다.");
			return "common/errorPage";
		}
	}
	
	/**
	 * 	/notice/updateFrom 요청을 받아
	 * 		공지사항 수정 페이지 응답
	 * 		=> WEB-INF/views/notice/updateForm.jsp	 	
	 **/
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam(value="no", defaultValue="0") int no
						, Model model) {
		// * 공지 사항 번호에 해당하는 정보를 조회 
		Notice notice = nService.selectNoticeDetail(no);
		
		// * 공지 사항 데이터를 저장 
		
		model.addAttribute("n", notice);
		
		// * 공지 사항 수정 페이지 응답 
		
		return "notice/updateForm";		
	}
	

	/*
	 *  [POST]/notice/update 요청을 받아
	 *  		공지사항 수정 후 해당 공지사항 상세페이지로 응답
	 */
	@PostMapping("/update")
	public String updateEnroll(Notice notice, Model model
								, HttpSession session) {
		
		
		int result = nService.updateNotice(notice);
		
		if (result > 0) {
			//공지사항 수정 성공
			session.setAttribute("alertMsg", "공지사항 수정 성공했습니다.");
			return "redirect:/notice/detail?no=" + notice.getNoticeNo();
		}else {
			//공지사항 수정 실패
			model.addAttribute("errorMsg", "공지사항 수정 실패했습니다.");
			return "common/errorPage";
		}
	}
	
	/*
	 *  /notice/delete 요청을 받아 
	 *  		?no=공지사항번호	해당 공지사항 삭제
	 */
	@GetMapping("/delete")
	public String deleteNotice(@RequestParam(defaultValue = "0") int no,
								Model model, HttpSession session) {
		
		int result = nService.deleteNotice(no);
		
		if ( result >0 ) { // 삭제 성공
			// 공지 사항 목록 페이지로 응답(url 재요청)
			session.setAttribute("alertMsg", "공지사항 삭제");
			return "redirect:/notice/list";
		} else {		   // 삭제 실패 
			// 에러페이지 응답 
			model.addAttribute("errorMsg", "공지사항 삭제 실패");
			return "common/errorPage";
		}
	}
	
	/*
	 * 제목으로 공지사항 검색
	 * [GET] /notice/search
	 * 		 ?keyword=검색어
	 * 
	 */
	@GetMapping("/serach")
	public String serachNoticeByTitle(String keyword
						, @RequestParam(value="cpage", defaultValue = "1") int currPage
						, Model model) {
		
		// * PageInfo 객체 생성
		int listCount = nService.selectselectByNoticeTitleCount(keyword);
		int pageLimit = 10;
		int boardLimit = 10;
		
		PageInfo pi = new PageInfo(listCount,currPage,pageLimit, boardLimit);
		
		
		// * 조회된 목록을 request 영역에 "list" 키 값으로 저장
		ArrayList<Notice> list = nService.searchNoticeByTitle(keyword, pi);
		model.addAttribute("list", list);
		
		// * 페이징 바 표시를 위해 request 영역에 "pi" 키값으로 PageInfo 저장
		model.addAttribute("pi",pi);

		return "notice/noticeList";
	}
	
	
}
