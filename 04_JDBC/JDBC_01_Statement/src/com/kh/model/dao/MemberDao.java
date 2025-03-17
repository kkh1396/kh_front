package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.vo.Member;

/*
 *  DAO (Database Access Object)
 *  : DB에 직접 접근하여 사용자의 요청에 맞는 SQL문 실행 후 결과 반환
 *    --> JDBC 사용
 * 
 */

public class MemberDao {
		// * DB정보 : 서버주소, 사용자명, 비밀번호
	
	   private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	   private final String USER_NAME = "C##JDBC";
	   private final String PASSWORD = "JDBC";
			   
	   

	   
	   
	   public Member searchById(String id) {
		   
		   Member m = null;
		   // => controller에서 결과처리를 null로 비교하도록 작성되어 있음!
		   
		   // jdbc 객체 선언
		   
		   Connection conn = null;
		   Statement stat = null;
		   ResultSet rset = null;
		   
		   
		   // 실행할 sql문
		   String sql = "select * from member where memberid = '" + id + "'";
		   // 포맷형태로 작성한것
		   // String sql = String.format("select * from member where memberid = '%s'",id);
		   
		   try {
			   // 1) jdbc 드라이버 로드 
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   
			   // 2) 연결객체 생성
			   conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
			   
			   // 3) stat 객체 생성
			   stat = conn.createStatement();
			   
			   // 4,5) 쿼리를 보내고 결과 받아오기 
			   rset = stat.executeQuery(sql);
			   
			   
			   // 결과 처리 --> 조회된 데이터 추출
			   
			   
			   if ( rset.next() ) {
			      // => 조회된 결과가 있다면 한 행만 있을 것임! => 아디에 UNiQUE 제약 조건이 있기 때문에
				   m = new Member(
							rset.getInt("MEMBERNO"),
							rset.getString("MEMBERID"),
							rset.getString("MEMBERPW"),
							rset.getString("gender").charAt(0), // --> DB에 gender 컬럼에 null값 존재 => 오류 발생!
							 // 2) 추출시 조건에 따라 분기 처리
							//rset.getString("gender") == null ? ' ' : rset.getString("gender").charAt(0),
							rset.getInt("AGE"),
							rset.getString("email"),
							rset.getString("address"),
							rset.getString("phone"),
							rset.getString("hobby"),
							rset.getDate("enrolldate")
						);
			   }
			   // * 조건문이 끝난 시점에
			   // - 조회된 데이터가 없다면? m(Member) 변수는 null;
			   
			   
		   }catch (ClassNotFoundException e) {
			   e.printStackTrace();
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }finally {
			  // 7) 자원 반납
			   try {
				rset.close();
				   stat.close();
				   conn.close();
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }

			   
		   }
		   
		   
		   return m;
	   }
	   
	   /*
	    *  회원 전체 목록을 조회하여 반환하는 메소드
	    *  @return 전체 회원 목록
	    * 
	    */
	   public ArrayList<Member> selectAllList(){
		   
		   ArrayList<Member> list = new ArrayList<>(); // []
		   
		   // DQL(SELECT)문 실행 (여러 행 조회) ---> ResultSet 객체 ---> ArrayList에 담기
		   
		   // * JDBC 용 객체 선언
		   Connection conn = null;
		   Statement stat = null;
		   ResultSet rset = null;
		   
		   // * 실행할 sql문
//		   String sql = "SELECT * FROM MEMBER order by memberno ";
		   
		   String sql = "SELECT MEMBERNO, MEMBERID, "
		   				+ "MEMBERPW, nvl(GENDER,' ') gender, AGE, "
		   				+ "EMAIL, ADDRESS, PHONE, HOBBY, "
		   				+ "ENROLLDATE FROM MEMBER order by memberno ";
		   
		   
		   try {
			// 1) jdbc 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성
			conn = DriverManager.getConnection(url, USER_NAME,PASSWORD);
			
			// 3) Statement 객체 생성
			stat = conn.createStatement();
			
			
			// 4) SQL 실행 , 5) 결과 받기
			rset = stat.executeQuery(sql);
			
			// 6) ResultSet 에 담겨져 있는 데이터를 하나하나 추출 
			
			while (rset.next()) {
				// [1] 데이터를 추출하여 Member 객체에 담기(생성)
				Member m = new Member(
							rset.getInt("MEMBERNO"),
							rset.getString("MEMBERID"),
							rset.getString("MEMBERPW"),
							rset.getString("gender").charAt(0), // --> DB에 gender 컬럼에 null값 존재 => 오류 발생!
							 // 2) 추출시 조건에 따라 분기 처리
							//rset.getString("gender") == null ? ' ' : rset.getString("gender").charAt(0),
							rset.getInt("AGE"),
							rset.getString("email"),
							rset.getString("address"),
							rset.getString("phone"),
							rset.getString("hobby"),
							rset.getDate("enrolldate")
						);
				
				// [2] Member 객체를 리스트에 추가 
					list.add(m);
				
				
			}
			// * 반복문이 끝난 시점
			// --> 조회된 데이터가 있다면 ? 리스트에는 최소 한 개 이상의 데이터가 담겨져있을 것임!
			// --> 조회된 데이터가 없다면? 리스트는 비어있을 것임
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 7) 자원 반납
			try {
				rset.close();
				stat.close();
				conn.close();
			}
			catch (SQLException e) {
			   e.printStackTrace();
				
			}
		}
		   
		   return list;
		   
	   }
	   
	   
	   
	   
	   /*
	    *  요청된 회원 정보를 DB에 추가하는 메소드
	    *  @param m 사용자가 입력한 정보들이 담겨있는 Member 객체
	    *  @return 추가(INSERT) 후 처리된 행 수
	    *  
	    */
	
	  public int insertMember(Member m) {
		  int result = 0;
		  // DML(insert) ---> int (처리된 행 수) ---> 트랜잭션 처리
		  
		  String sql = "INSERT INTO MEMBER "
		  		+ "   VALUES (SEQ_MNO.NEXTVAL"
		  		+ " , '" + m.getMemberId() + "'"
		  		+ " , '" + m.getMemberPw() + "'"
		  		+ ",  '" + m.getGender() +   "'"
		  		+ ",   " + m.getAge()
		  		+ ",  '" + m.getEmail() + "'"
		  		+ " , '" + m.getEmail() + "'"
		  		+ ",  '" + m.getPhone() + "'"
		  		+ ",  '" + m.getHobby() + "'"
		  		+ ", SYSDATE)";
		  		
		  
		  System.out.println("------------------------------");
		  System.out.println(sql);
		  System.out.println("------------------------------");
		  
		  // * JDBC용 객체 선언 
		  Connection conn = null;
		  Statement stat = null;
		  
		  // 1) jdbc driver 등록
		  try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 객체 생성 (DB 정보로 연결)
			conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
			conn.setAutoCommit(false); // autoCommit off 
			
			// 3) Statement 객체 생성 (Connection 객체로 생성)
			stat = conn.createStatement();
			
			// 4) SQL 실행 5) 결과 받기 
			result = stat.executeUpdate(sql);
			
			// 6) 트랜잭션 처리
			if (result > 0 ) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 try {
				stat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			
		}
		  
		  
		  return result;
		  
	  }

	  /*
	   *  요청된 회원 정보로 수정
	   *  @param m 회원 아이디, 변경할 데이터 (비밀번호, 성별, 주소, 취미)
	   *  @return 처리 결과(처리된 행 수)
	   */
	public int updateMember(Member m) {
		  int result = 0;
		  Connection conn = null;
		  Statement stat = null;
		  
		  
		             try {
		            	// * JDBC용 객체 선언
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
						conn.setAutoCommit(false);
						stat = conn.createStatement();							
						
						// * 실행할 쿼리문
						
						String sql = "update member set MemberPW = '"+m.getMemberPw() +"', "
								+ " gender = '"+ m.getGender()+ "' , "
								+ " address = '"+ m.getAddress()+ "', "
								+ " hobby = '"+m.getHobby()+"' "
								+ " where MemberID  = '"+m.getMemberId()+ "'";
						
						result = stat.executeUpdate(sql);
						
						if (result > 0 ) {
							conn.commit();
						} else {
							conn.rollback();
						}
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							stat.close();
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						;
					}
		  
		  
		  
		  // * JDBC 순서에 맞게 코드 작성
		  
		  
		
		return result;
	}

	public int deleteMember(String id) {
		
		int result = 0;
		Connection conn = null;
		Statement stat = null;
		
		String sql = String.format("delete from member where Memberid = '%s'", id);
		// * JDBC 객체 생성
		
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url,USER_NAME,PASSWORD);
					conn.setAutoCommit(false);
					stat = conn.createStatement();
					
					result = stat.executeUpdate(sql);
					
					if ( result > 0) {
						conn.commit();
					} else {
						conn.rollback();
					}
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					
					try {
						stat.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			
		
		return result;
	}
}



