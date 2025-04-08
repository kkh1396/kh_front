package com.kh.spring.board.service;

import java.util.ArrayList;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;

public interface BoardService {

		/* 게시글 전체 목록 조회 R */
		ArrayList<Board> selectBoardList();
		
		/* 게시글 상세 조회 R */
		Board selectBoardDetail(int boardNo);
		
		/* 게시글 작성 C */
		int insertBoard(Board board);
		
		/* 게시글 수정 U */
		int updateBoard(Board board);
		
		/* 게시글 삭제 D */
		int deleteBoard(int boardNo);
		
		/* 댓글 등록 C */
		int insertReply(Reply reply);
		
		/* 댓글 목록 조회 R */
		ArrayList<Reply> selectReplyList(int boardNo);
		
		/* 게시글 조회 수 증가 U */
		int increasecCount(int BoardNo);
		
		
}






