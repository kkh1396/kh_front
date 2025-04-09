package com.kh.spring.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.board.dto.SearchDto;
import com.kh.spring.board.model.vo.Board;

@Mapper
public interface BoardDao {

	/* 게시글 목록 조회 */
	ArrayList<Board> selectBoardList();

	ArrayList<Board> selectBoardList(RowBounds rb, SearchDto searchDto);

	int selectBoardCount(SearchDto searchDto);
	

}
