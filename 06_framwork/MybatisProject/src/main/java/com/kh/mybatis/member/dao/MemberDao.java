package com.kh.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertmember",m);	
	}

}  
