package com.kh.spring.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;

@Service
public class BoardServiceImpl implements BoardService {

	// 필드 주입 방식
	/*
	@Autowired
	private BoardDao boardDao;
	*/
	
	// 생성자 주입 방식
	private final BoardDao boardDao;
	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	/*
	 *  게시글 목록 조회
	 */
	@Override
	public ArrayList<Board> selectBoardList() {
		return boardDao.selectBoardList();
		
	}

	@Override
	public Board selectBoardDetail(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int increasecCount(int BoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
