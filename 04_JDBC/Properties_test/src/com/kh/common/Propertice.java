package com.kh.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertice {

	
	public static void main(String[] args) {
	 // 파일 저장 테스트
//		saveTest();
		
	 // 파일 읽기 테스트
		readTest();
	}
		
	private static void readTest() {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/test.propertices"));
			
			
			for (Object p : prop.keySet()) {
				System.out.println(p);
				
			}
			
			
			System.out.println("=================================");
			prop.loadFromXML(new FileInputStream("resources/text.xml"));
			
			
			for (Object p : prop.values()) {
				System.out.println(p);
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	// Properties 파일 저장 테스트
	public static void saveTest() {
		
		Properties prop = new Properties();
		
		
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("username", "C##JDB" );
		prop.setProperty("password", "JDBC");
		
		
		File folder = new File("resources");
		
		if ( !folder.exists() ) {
			 folder.mkdir();
			 System.out.println("폴더 생성 완료");
		} else {
			 System.out.println("폴더 생성 실패");
		}
		
		
		
		try {
		prop.store(new FileOutputStream("resources/test.propertices"), "propertices test");
		prop.storeToXML(new FileOutputStream("resources/text.xml"), "text.xml 생성 성공!");
		
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
