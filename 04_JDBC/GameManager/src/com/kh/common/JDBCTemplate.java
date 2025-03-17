package com.kh.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	static Connection conn = null;
	static Properties prop = null;

	// jdbc 사용하기 위한 정보를 파일로 작성

	// 경로 생성 여부 확인
	public static void saveJDBCpath() {
		File file = null;
		// 폴더 생성
		file = new File("resources");

		if (!file.exists()) {
			file.mkdir();
		} else {

		}
	}

	// Properties 파일 및 driver 정보 저장
	public static void createPropperties() {

		prop = new Properties();
		saveJDBCpath();
		// driver.properties 파일 생성및 정보 입력
		try {
			// 드라이버 정보
			prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
			// 접속할 db 정보
			prop.setProperty("url", "jdbc:oracle:thin:@115.90.212.20:10000:xe");
			// db 아이디
			prop.setProperty("user", "C##KKH");
			// db 비번
			prop.setProperty("pass", "KKH");
			// driver.properties로 내용 저장
			prop.store(new FileOutputStream("resources/driver.properties"), "driver 및 접속정보");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// xml파일 및 쿼리 정보 저장
	public static void createXml() {
		prop = new Properties();
		saveJDBCpath();
		try {
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "쿼리 정보");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 파일로 작성된 jdbc정보를 로드해 커넥션 만들기

	public static Connection conn() {

		prop = new Properties();

		try {

			prop.load(new FileInputStream("resources/driver.properties"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pass"));
			System.out.println("접속 성공");
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	// 각 클래스및 객체들 close 메소드 생성

	public static void close(Connection conn) {

		try {
			if (conn != null & conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stat) {
		try {
			if (stat != null & stat.isClosed()) {
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rset) {
		try {
			if (rset != null & rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
