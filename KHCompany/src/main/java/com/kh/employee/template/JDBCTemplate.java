package com.kh.employee.template;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	/* Connection 객체 생성 */
	
	   public static Connection getConnection() {
		   Connection conn = null ;
		   Properties prop = new Properties();
		   
		     
		   
		   try {
			   String filepath = JDBCTemplate.class.getResource("/settings.properties").getPath();
			   // 클래스명.class : class 객체로 접근. 모든 클래스는 실행 시 Calss 객체로 표현됨
			   // - 클래스 정보를 확인할 때 사용(리플렉션) 
			   // - 객체 생성 또는 타입 비교 시 사용 
			   
			   // * getResource()  : 리소스 파일을 읽어오기 위해 사용된 메소드 
			   
			   
			   
				prop.load(new FileInputStream(filepath));
				
				// 1) jdbc driver 등록 
				Class.forName(prop.getProperty("driver"));
				
				// 2) Connection 객체 생성 
				conn = DriverManager.getConnection(prop.getProperty("url")
	 						, prop.getProperty("username")
	 						, prop.getProperty("password"));
				conn.setAutoCommit(false);
		   } catch (ClassNotFoundException | SQLException | IOException e) {
			// 
			   e.printStackTrace();
		   }
	   return conn;
	   }
	
	/* commit 처리 */
	   
	   public static void commit(Connection conn) {	   
		   try {
			   if (conn.isClosed() && conn != null) {
				   conn.commit();
			   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	   }
	   
	
	/* roollback 처리 */
	   
	   public static void rollback(Connection conn) {	   
		   try {
			   if (conn.isClosed() && conn != null) {
				   conn.rollback();
			   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	   }
	
	/* close 처리 */
	   // - Connection, [Predpared]Statement, ResultSet
	
	   public static void close(Connection conn) {	   
		   try {
			   if (conn.isClosed() && conn != null) {
				   conn.close();
			   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public static void close(Statement stat) {	   
		   try {
			   if (stat.isClosed() && stat != null) {
				   stat.close();
			   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	   }
	   
	   public static void close(ResultSet rset) {	   
		   try {
			   if (rset.isClosed() && rset != null) {
				   rset.close();
			   }
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
	   }
	   
}
