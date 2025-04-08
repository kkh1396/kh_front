package com.kh.spring.board.constroller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.service.BoardService;

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
	public String BoardList(Model model) {
		
		ArrayList<Board> list = bService.selectBoardList();
		
		// request 영역에 조회된 데이터 저장
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
	
	
}




