package com.kh.spring.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.kh.spring.board.model.vo.Board;

@Mapper
public interface BoardDao {

	/* 게시글 목록 조회 */
	ArrayList<Board> selectBoardList();
	

}
