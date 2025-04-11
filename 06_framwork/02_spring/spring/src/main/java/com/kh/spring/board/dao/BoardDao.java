package com.kh.spring.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.board.dto.SearchDto;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;

@Mapper
public interface BoardDao {

	/* 게시글 목록 조회 */
	ArrayList<Board> selectBoardList();

	ArrayList<Board> selectBoardList(RowBounds rb, SearchDto searchDto);

	/* 게시글 전체 수 조회 */
	int selectBoardCount(SearchDto searchDto);
	
	/* 게시글 작성 */
	int insertBoard(Board board);

	/* 게시글 상세페이지 조회 */
	Board selectBoardDetail(int boardNo);

	/*  게시글 조회수 증가 */
	int increasecCount(int boardNo);

	/* 게시글 댓글 목록 조회 */
	ArrayList<Reply> selectReplyList(int boardNo);

	/* 게시글 삭제 */
	int deleteBoard(int boardNo);

	

}
