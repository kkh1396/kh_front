package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.dao.MemberDao;
import com.kh.mybatis.member.vo.Member;
import com.kh.mybatis.template.Template;

public class MemberServiceImpl implements MemberService {
	private MemberDao mDao = new MemberDao();
	@Override
	public int insertMember(Member m) {
		
		/*
		 *  기존(JDBC) 방식
		 *   - Connection 객체 생성
		 *   - DAO에게 Connection 객체와 전달받은 데이터 전달(요청)
		 *   - 결과에 따라(DML) --> 트랜잭션처리
		 *   - Connection 객체 반납(close)
		 *   - 결과를 리턴 
		 */
		
		/* Mybatis */
		
		 SqlSession sqlSession = Template.getSqlSession();
		 int result = mDao.insertMember(sqlSession, m);
		 if (result >0 ) {
			 sqlSession.commit();
		 }
		 
		 // rollback의 경우 여러 개의 DML을 실행시켰을 경우만 작성
		 // 단일 행일 경우 생략 가능 
		 sqlSession.close();
		 

		 return result;
	}

	@Override
	public Member selectMember(Member m) {
		// * SqlSession 객체 생성
		
		 SqlSession sqlSession = Template.getSqlSession();
		
		// * Dao 객체에게 작업 요청 후 결과 받기
		 
		 Member loginUser = mDao.selectMember(sqlSession, m);		
		 
		// * SqlSession 객체 반납 (close)
		 sqlSession.close();
		
		// * 결과 리턴

		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		
		
		 SqlSession sqlSession = Template.getSqlSession();
		 int result = mDao.updateMember(sqlSession, m);
		 if (result >0 ) {
			 sqlSession.commit();
		 }
		 
		 // rollback의 경우 여러 개의 DML을 실행시켰을 경우만 작성
		 // 단일 행일 경우 생략 가능 
		 sqlSession.close();
		 

		 return result;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
