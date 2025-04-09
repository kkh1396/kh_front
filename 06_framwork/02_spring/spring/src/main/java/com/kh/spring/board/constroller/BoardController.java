package com.kh.spring.board.constroller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.board.dto.SearchDto;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.service.BoardService;
import com.kh.spring.common.PageInfo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor   //  롬복 사용하여 생성자 주입시 표시하며 밑에 주석된 부분은 생략이 된다. 
public class BoardController {

	private final BoardService bService;
	
	/*
	@Autowired
	public BoardController(BoardService bService) {
		this.bService = bService;
	}
	*/
	
	
	
	@GetMapping("/list")
	public String boardList(@RequestParam(defaultValue="1") int cpage
			   // , String condition, String keyword
			   , SearchDto searchDto
			   , Model model) {
		// 페이징 처리
		//  한 페이지당 게시글 개수: 10, 페이징바 표시 개수: 5
		//  현재 페이지 번호 --> 요청 시 전달! (cpage)
		//  전체 게시글 개수 --> 조회
		int count = bService.selectBoardCount(searchDto);
		
		// 페이징 정보를 담은 PageInfo 객체 생성
		PageInfo pi = new PageInfo(count, cpage, 5, 2);
		
		ArrayList<Board> list = bService.selectBoardList(pi, searchDto);
		
		// request 영역에 조회된 데이터 저장
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("condition", searchDto.getCondition());
		model.addAttribute("keyword", searchDto.getKeyword());
		
		return "board/boardList";
}
	
	
}




