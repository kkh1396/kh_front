package com.kh.spring.board.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.dto.SearchDto;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.board.service.BoardService;
import com.kh.spring.common.MyFileUtils;
import com.kh.spring.common.PageInfo;

import jakarta.servlet.http.HttpSession;
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
		PageInfo pi = new PageInfo(count, cpage, 5, 10);
		
		ArrayList<Board> list = bService.selectBoardList(pi, searchDto);
		
		// request 영역에 조회된 데이터 저장
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("condition", searchDto.getCondition());
		model.addAttribute("keyword", searchDto.getKeyword());
		
		return "board/boardList";
}
	
	@GetMapping("/enrollForm")
	public String boardEnrollFrom() {
		return "board/enrollForm";  // WEB-INF/views/board/enrollForm.jsp
	}
	
	
	@PostMapping("/write")
	public String boardWrite(Board board, MultipartFile upfile
						, HttpSession session, Model model
			) {
		// * MutipartFile : springboot-start-web 패키지에 포함되어 있음
		//		=> commons-io, commons-fileupload 라이브러리 
		
	
		/*
		System.out.println(upfile.isEmpty());
		*/
		  //int result = bService.insertBoard(board);
		
		// 첨부파일이 있는 경우 파일에 대한 처리
		if  (!upfile.isEmpty( )) {
			// 파일명을 변경 -> "spring_" + 현재날짜시간 + 랜덤값 + 확장자 
			String changeName = MyFileUtils.saveFile(upfile, session, "/resources/upfile/");
			
			// * Board 객체에 파일 관련된 필드 => originName, changeName
			board.setOriginName(upfile.getOriginalFilename()); // 파일 원본명 저장 
			board.setChangeName(changeName);
			
		}
		
		// * DB에 게시글 정보 저장 --> 첨부파일 유무 상관없이 처리 해야함 
		  
		int result = bService.insertBoard(board);
		
		if (result >0 ) {
			// 게시글 작성 성공	
			session.setAttribute("alertMsg", "게시글 작성 성공했습니다.");
			return "redirect:/board/list";
		} else {
			// 게시글 작성 실패
			model.addAttribute("errortMsg", "게시글 작성 실패했습니다.");
			return "common/errorPage";
		}
		
	}
	
	
	@GetMapping("/detail")
	public String boardDetail(@RequestParam(required = true) int bno, Model model) {
		
		// * 상세 페이지 요청 시 해야할 작업
		
		// [1] 해당 게시글의 조회 수 증가 (=> DB에서 업데이트

			 int result = bService.increasecCount(bno);
			 
			 System.out.println(bno);
			
			 if (result > 0) {				
			 		   
		// [2] 해당 게시글 정보 (=> DB에서 조회)
		
			Board board = bService.selectBoardDetail(bno);
			
				 
		// [3] 해당 게시글에 달린 댓글 정보 (=> DB에서 조회)
				 ArrayList<Reply> rlist = bService.selectReplyList(bno);
			
				
				 
				 model.addAttribute("board", board);
				 model.addAttribute("rlist", rlist);
				 
			
				 return "board/boardDetail";
			 
			 } else {
			
				 // 조회수 증가 실패 시, 에러페이지로 응답
				 model.addAttribute("errorMsg", "게시글 조회에 실패했습니다.");
				 return "common/errorPage";
			 }  			
	}
	
	
	
	@GetMapping("/delete")
	public String boardDelte(@RequestParam(required=true) int bno, Model model, HttpSession session) {
		// @RequestParam(required=true) 필수 항목에 대해서는 ()안처럼 지정
		
		int result = bService.deleteBoard(bno);
		
		if (result >0 ) {
			// 삭제 성공
			session.setAttribute("alertMsg", "게시글 삭제에 성공했습니다.");			
			return "redirect:/board/list";
		}else {
			// 삭제 실패
			session.setAttribute("errorMsg", "게시글 삭제에 실패했습니다.");
			 return "common/errorPage";
		}
		
	}
	
	
	@GetMapping("/updateForm")
	public String boardUpdateForm(@RequestParam(required=true) int bno, Model model) {
		
		

		
		Board board = bService.selectBoardDetail(bno);
		
		
		model.addAttribute("board", board);
		
		
		return "board/boardUpdate";
	}
	
	
	// * 요청 주소 : /board/update
	// * 요청 방식 : POST
	// * 요청 시 전달 데이터 형식 : boardNo, boardTitle   -> Board
	//							파일 upfile -> MultipartFile
	
	@PostMapping("/update")
	public ModelAndView boardUpdate(Board board, MultipartFile upfile,
									ModelAndView mv, HttpSession session) {
		
		// * 새로 추가된 첨부파일이 있는 경우
		//   Board 객체에 첨부파일 정보를 저장. 서버에 해당 파일 저장.
		
		// * 새로운 첨부파일이 있는 지 체크 
		 if (!upfile.isEmpty()) { // 첨부파일 객체가 비어있지 않은 경우 
			 // TODO : 기존 첨부파일이 있을 경우, 해당 파일 삭제
			 
			String changeName =  MyFileUtils.saveFile(upfile, session , "/resources/upfile/" );
			// => 서버에 파일명을 변경하여 저장 .
			
			// * Board 객체에 첨부파일 정보 저장 (변경된 파일명, 원본 파일명)
			board.setChangeName(changeName);
			board.setOriginName(upfile.getOriginalFilename() );
		 }
		 /*
		  *  * 첨부파일이 새로 추가된 경우
		  *    - originName : 추가된 첨부파일 원본명
		  *    - changeName : 추가된 첨부파일의 변경된 이름
		  * 
		  *  * 첨부파일이 새로 추가되지 않은 경우
		  *    - originName : 게시글 추가 시 원본 정보
		  *    - changName  : 게시글 추가 시 변경된 파일명 정보
		  * 
		  */
		
		// * 게시글 정보를 DB에 업데이트 
		int result = bService.updateBoard(board);
		

		
		if (result >0 ) {
			
			// * 게시글 변경 성공 시 --> "게시글 수정 성공했습니다" 메시지 저장
			// 						  해당 게시글의 상세페이지로 이동 (URL 재요청)
				
			session.setAttribute("alertMsg", "게시글 수정 성공했습니다" );
			mv.setViewName("redirect:board/detail?bno=" + board.getBoardNo());

		} else {
		
			// * 게시글 변경 실패 시 --> "게시글 수정 실패했습니다." 메시지 저장
			//						  에러 페이지로 응답 
			
			session.setAttribute("errorMsg", "게시글 수정 실패했습니다" );
			mv.setViewName("common/errorPage");

		}
		
			return mv;
	}
	
	
	/** -------------------------------------------------- **/ 
	
	/*
	@PostMapping("rinsert")
	@ResponseBody		// 페이지가 아닌 데이터 형식으로 응답하고자 할때 사용 
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
	
	
	@GetMapping("rlist")
	@ResponseBody
	public ArrayList<Reply> selectReplyList(@RequestParam(required=true) int boardNo) {
		 // * 해당 게시글의 댓글 목록 조회 
			
		   ArrayList<Reply> rlist =  bService.selectReplyList(boardNo);
		
		// * 조회된 결과 응답 
		
		   return rlist;
	}	
	*/
}




