package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.vo.Member;

/*
 *  DAO (Database Access Object)
 *  : DB에 직접 접근하여 사용자의 요청에 맞는 SQL문 실행 후 결과 반환
 *    --> JDBC 사용
 * 
 */

public class MemberDao {
	// * 기존 상수 필드 정보는 JDBCTemplate 클래스에서 사용되어 제거

	/*
	 * 회원 정보 추가 메소드
	 * 
	 * @param conn 생성되어 있는 Connection 객체
	 * 
	 * @param m 회원 정보가 저장된 Member 객체
	 * 
	 * @return 처리된 결과(처리된 행 수)
	 * 
	 */
	public int insertMember(Connection conn, Member m) {
		int result = 0;

		// 1) jdbc driver 등록 -- Service 객체가 완료
		// 2) Connection 객체 생성 -- Service 객체가 완료
		// ----------------------------------------
		// 3) Statement 객체 생성
		String sql = "INSERT INTO MEMBER " + "VALUES (SEQ_MNO.NEXTVAL, ?, ?, ?, ?, ? ,? ,? ,?, SYSDATE)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getGender());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getHobby());

//			System.out.println("-".repeat(30));
//			System.out.println(sql);
//			System.out.println(m);
//			System.out.println("-".repeat(30));
			// 4) SQL문 실행 5) 결과 받기
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6) 결과에 대한 처리 -> Service 객체에서 담당
			// 7) 자원 반납
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	/*
	 * 전체 회원에 대한 정보를 DB에서 조회
	 * 
	 * @param conn Connection 객체
	 * 
	 * @return 조회된 결과(회원목록)
	 */
	public ArrayList<Member> selectAll(Connection conn) {

		ArrayList<Member> list = new ArrayList<>();

		// 1) jdbc driver 등록

		// 2) Connection 객체 생성 ----> Service 객체에서 처리되어 있음

		// 3) Statement 객체 생성
		String query = "select * from member order by Memberid";

		try (PreparedStatement pstmt = conn.prepareStatement(query); ResultSet rset = pstmt.executeQuery();) {
			// 4) 실행 후 결과를 받기
			// -> try~with~resource문 사용 시 자원 관리를 자동으로 해줌!

			// 5) 결과 처리
			while (rset.next()) { // 조회된 결과가 있는지 확인
				Member m = new Member(rset.getInt("MEMBERNO"), rset.getString("MEMBERID"), rset.getString("MEMBERPW"),
						rset.getString("MEMBERPW"), rset.getInt("AGE"), rset.getString("EMAIL"),
						rset.getString("ADDRESS"), rset.getString("PHONE"), rset.getString("HOBBY"),
						rset.getDate("ENROLLDATE"));

				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	/*
	 * 전달받은 아이디로 DB에 포함하고 있는 데이터가 있는 지 조회
	 * 
	 * @param conn 생성된 Connection 객체
	 * 
	 * @param searchId 검색할 회원아이디
	 * 
	 * @return 검색 결과
	 */
	public ArrayList<Member> searchById(Connection conn, String searchId) {

		ArrayList<Member> list = new ArrayList<>();
		Statement stat = null;
		ResultSet rset = null;
		try {
			// * Statement 객체 생성
			stat = conn.createStatement();

			// * 쿼리문 실행 후 결과 받기
			String sql = "select * from member where memberid like '%" + searchId + "%'";

			rset = stat.executeQuery(sql);

			while (rset.next()) {
				Member m = new Member(rset.getInt("MEMBERNO"), rset.getString("MEMBERID"), rset.getString("MEMBERPW"),
						rset.getString("GENDER"), rset.getInt("AGE"), rset.getString("EMAIL"),
						rset.getString("ADDRESS"), rset.getString("PHONE"), rset.getString("HOBBY"),
						rset.getDate("ENROLLDATE"));
				list.add(m);
			}
		} catch (SQLException e) {
			// * 현재 메소드에서 생성한 객체 반납
			e.printStackTrace();

		}
		JDBCTemplate.close(rset);
		JDBCTemplate.close(stat);

		// * 결과 반환

		return list;
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			// stat 객체 생성
			String sql = "update member set MEMBERPW = ? "
					+ ", GENDER = ? , ADDRESS = ? , HOBBY = ?  where MEMBERID  = ?  ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getGender());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getMemberId());
			System.out.println(m);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
		return result;
	}

	
	
	/*
	 *  DB에서 해당 회원에 대한 데이터를 삭제 처리
	 *  @param conn			생성된 Connection 객체
	 *  @param id			삭제할 회원 아이디 			
	 *  @return				처리 결과
	 */
	public int deleteMember(Connection conn, String id) {

		// * DML(delete)
		
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from member where memberid = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

}
