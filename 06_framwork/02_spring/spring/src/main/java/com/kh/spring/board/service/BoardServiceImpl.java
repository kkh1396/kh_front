package com.kh.spring.board.service;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import com.kh.spring.board.dao.BoardDao;
import com.kh.spring.board.dto.SearchDto;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {

    private final SecurityFilterChain filterChain;

	// 필드 주입 방식
	/*
	@Autowired
	private BoardDao boardDao;
	*/
	
	// 생성자 주입 방식
	private final BoardDao boardDao;
	@Autowired
	public BoardServiceImpl(BoardDao boardDao, SecurityFilterChain filterChain) {
		this.boardDao = boardDao;
		this.filterChain = filterChain;
	}
	
	/**
	 * 게시글 개수 조회
	 */
	@Override
	public int selectBoardCount(SearchDto searchDto) {
		return boardDao.selectBoardCount(searchDto);
	}
	
	
	/*
	 *  게시글 목록 조회
	 */
	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi, SearchDto searchDto) {
		// RowBounds 객체 => MyBatis 프레임워크에서 제공하는 객체
		int offset = (pi.getCurrPage() - 1) * pi.getBoardLimit();
		RowBounds rb = new RowBounds(offset, pi.getBoardLimit());
		
		return boardDao.selectBoardList(rb, searchDto);
	}

	@Override
	public Board selectBoardDetail(int boardNo) {
		
		return boardDao.selectBoardDetail(boardNo);
	}

	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
			
		
		return boardDao.insertBoard(board);
	}

	@Override
	public int updateBoard(Board board) {

		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public int insertReply(Reply reply) {

		return boardDao.insertReply(reply);
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {

		return boardDao.selectReplyList(boardNo);
	}

	@Override
	public int increasecCount(int BoardNo) {

		return boardDao.increasecCount(BoardNo);
	}

	@Override
	public ArrayList<Board> selectBoardTop5List() {
		// * RowBounds 객체 사용 => 페이징 처리 시 활용했던 객체
		//   => RowBounds(시작위치, 개수)
		RowBounds rb = new RowBounds(0,5);
		
		
		// * 실행할 쿼리문 => 게시글 목록 조회 시 사용했던 쿼리문 사용 
		//   SearchDto 객체에 정렬 기준 데이터를 추가 
		SearchDto searchDto = new SearchDto();
		searchDto.setOrderby("count");
		
		return boardDao.selectBoardList(rb, searchDto);
		
		
	}


}
