package com.kh.spring.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kh.spring.model.vo.Member;

@Mapper // MyBatis를 사용해서 빈 등록
public interface MemberDao {
	
	/* 회원 가입 -  데이터 추가 */
	int insertMember(Member member);

	/* 로그인 - 데이터 조회 */
	Member loginMember(Member m);
	
	/* 마이페이지 - 정보 수정 */
	int updateMember(Member member);
	
}
