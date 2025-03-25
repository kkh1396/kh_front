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
		 System.out.println(result);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
