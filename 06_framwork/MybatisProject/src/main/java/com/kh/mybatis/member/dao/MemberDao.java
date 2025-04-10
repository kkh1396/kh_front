package com.kh.mybatis.member.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.vo.Member;

public class MemberDao {

	// 유저 추가
	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertmember",m);	
	}

	// 유저 조회
	public Member selectMember(SqlSession sqlSession, Member m) {
		// select --> selectOne  :  한  행 조회
		// 			  selectList : 여러 행 조회
		
		// * 데이터 조회 시 결과가 없을 경우 null을 반환 
		return sqlSession.selectOne("memberMapper.selectMember", m);
	}

	// 유저 정보 수정
	public int updateMember(SqlSession sqlSession, Member m) {
	
		return sqlSession.update("memberMapper.updateMember", m);
	}

	// 유저 비밀번호 수정
	public int updatePassword(SqlSession sqlSession, HashMap data) {
		
		return	sqlSession.update("memberMapper.updatePassword", data); 		
	}

	// 유저 정보 삭제
	public int deleteMember(SqlSession sqlSession, Member m) {
 
		return sqlSession.update("memberMapper.deleteMember", m);
	}

	// 회원가입의 중복체크 
	public int countMemberByUserId(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.countMemberByUserId",userId);
	}

}  
