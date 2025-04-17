package com.kh.spring.board.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.board.service.BoardService;

@RestController				// = @Controller + @ResponseBody
							// 모든 요청에 대한 응답을 페이지(화면)가 아닌 데이터로 응답하겠다.
@RequestMapping("/api/board")
public class BoardAPIController {
	
	private final BoardService bService;
	public BoardAPIController(BoardService bService) {
			this.bService = bService;
	}
	
	// put : 수정 // delete : 삭제
	
	
	@PostMapping("reply")	// POST: 추가 
	public String replyInsert(Reply reply) {
		
			// * 댓글 정보를 DB에 추가 
			int result = bService.insertReply(reply);
			
			if (result > 0 ) {
				// * 댓글 추가 성공 시 "success"로 응답
				return "success";
				
			}else {
				// * 댓글 추가 실패 시 "failed"로 응답 
				return "failed";
			}
								
	}
	
	
	@GetMapping("reply")		// GET : 조회
	public ArrayList<Reply> selectReplyList(@RequestParam(required=true) int boardNo) {
		 // * 해당 게시글의 댓글 목록 조회 
			
		   ArrayList<Reply> rlist =  bService.selectReplyList(boardNo);
		
		// * 조회된 결과 응답 
		
		   return rlist;
	}	
	
	
	@GetMapping("top5")
	public ArrayList<Board> selectBoardTop5List() {
		
		return bService.selectBoardTop5List();
	
	}
	
}
