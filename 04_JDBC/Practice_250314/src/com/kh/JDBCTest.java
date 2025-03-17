package com.kh;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 아래 코드에서 잘못된 부분을 찾아 수정하시오.
public class JDBCTest {

	public static void main(String[] args) {
	
		/*
			*---- DataBase Server Info ----*
			 - IP : 192.168.22.55
			 - PORT : 1521
			 - sid  : xe
			 - username : C##DBTEST
			 - password : TEST1234
			*------------------------------*
			
			 - MEMBER 테이블은 JDBC 계정과 동일하다고 가정
			 - Member 클래스도 수업용 프로젝트와 동일하다고 가정
		*/
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Scanner sc = new Scanner(System.in);
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			conn = DriverManager.getConnection("JDBC:oracle:thin:@localhost:1521:xe", 
												"C##JDBC", "JDBC");
			
			System.out.println("연결 완료");
			
			System.out.print("검색할 아이디 입력");
			String name = sc.nextLine();
			String query = "SELECT * FROM MEMBER WHERE MEMBERID = ?";
			
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,name);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				Member member = new Member(
								   rset.getInt("MEMBERNO"),
								   rset.getString("MEMBERID"),
								   rset.getString("MEMBERPW"),
								   rset.getString("MEMBERPW"),
								   rset.getInt("AGE"),
								   rset.getString("EMAIL"),
								   rset.getString("ADDRESS"),
								   rset.getString("PHONE"),
								   rset.getString("HOBBY"),
								   rset.getDate("ENROLLDATE"));
								    System.out.println(member);
									
				}
		
			
		} catch (ClassNotFoundException | SQLException e){
			 e.printStackTrace();
			} 	finally {
				try {
				rset.close();
				pstmt.close();
				conn.close();
				} catch(SQLException e){
				 e.printStackTrace();
				}
			}
	}
}