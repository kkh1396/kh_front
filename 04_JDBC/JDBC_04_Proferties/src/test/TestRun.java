package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestRun {

	
	/*
	 *  Properties 특징
	 *   - Map 계열의 컬렉션 중 하나 => key:value 형태로 데이터 저장
	 *   - 문자열(String) 형태로 데이터 저장 
	 *   
	 *  * 사용하는 메소드
	 *    - 값을 저장할 때 : setProperty(key값, value값)
	 *    - 값을 불러올 때 : getProperty(key값)
	 *    
	 *    
	 *  * 파일로 저장 시 종류(확장자)
	 *   - properties 
	 *   - xml
	 */
	public static void main(String[] args) {
		// Properties 객체에 담긴 데이터를 파일로 저장
//			saveProp();
             
			
	    // JDBC 관련 설정 파일 만들기 (저장)
			saveJdbcSettings();
			
		// JDBC 설정 파일 읽어오기
			readJdbcSettings();
			
		// 쿼리문 저장 파일에서 읽어오기 
		readQueryFile();
	}
	
	/*
	 *  쿼리문을 저장한 파일 내용 읽어오기
	 *  
	 *  - xml 형식의 팡리 내용 읽기 : loadFromXMl(InputStream)
	 * 
	 */
	private static void readQueryFile() {
		
		Properties prop = new Properties();
		
		try {
			
			 prop.loadFromXML(new FileInputStream("resources/query.xml"));
					 
			 System.out.println(prop.getProperty("insertMember"));
			 System.out.println(prop.getProperty("selectAll"));
			 System.out.println(prop.getProperty("updateMember"));
			 System.out.println(prop.getProperty("deleteMember"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/*
	 *  JDBC 설정 파일 내용 읽어오기
	 *  
	 *  - properties 형식의 파일 내용 읽기 : load(InputStream)
	 */
	private static void readJdbcSettings() {
		// * 객체 생성
		Properties prop = new Properties();
		
		try {
			// * 파일로부터 데이터를 읽어와서 Properties 객체에 담기
			prop.load(new FileInputStream("resources/settings.properties"));
			
			
			String driver = prop.getProperty("driver");
			System.out.println(driver);
			System.out.println("url ----->" + prop.getProperty("URL"));
			System.out.println("username ----->" + prop.getProperty("USERNAME"));
			System.out.println("password ----->" + prop.getProperty("PASSWORD"));
			
			
			
			// * 키값들이 기억이 안날 경우... 참고...
			
			/*
			for (Object key : prop.keySet() ) {
				System.out.println(key);
			}
			
			System.out.println(prop.getOrDefault(prop, prop));   키 : 밸류 전부 확인 가능
			*/
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("설정 파일 로딩중 문제 발생");
		}
		
	}

	/*
	 *  JDBC 관련된 설정 정보를 파일에 저장
	 *  
	 *  - driver 정보 : oracle.jdbc.driver.OracleDriver
	 *  - url		 : jdbc:oracle:thin:@ip:port:sid
	 *  - username	 : 사용자명
	 *  - password   : 비밀번호
	 *  
	 */
	
	private static void saveJdbcSettings() {
		// * JDBC용 계정 정보로 resources/settings.properties 파일에 저장
		
		Properties prop = new Properties();
		
		prop.setProperty("driver","oracle.jdbc.driver.OracleDriver");
		prop.setProperty("URL", "jdbc:oracle:thin:@localhost:1521:xe" );
		prop.setProperty("USERNAME","C##JDBC");
		prop.setProperty("PASSWORD","JDBC");
		
		
		try {
			prop.store(new FileOutputStream("resources/settings.properties"), "JDBC account");
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	/*
	 *  Properties 객체를 이용하여 데이터를 파일에 저장
	 *  
	 *  1) Properties 객체 생성
	 *  2) 객체에 데이터 저장 
	 *  3) 객체에 저장된 데이터를 파일에 저장(출력) => 파일용 기반 스트림 사용
	 *  
	 */

	private static void saveProp() {
		// 1) Properties 객체 생성
		Properties prop = new Properties();
		
		// 2) 객체에 데이터 저장
		prop.setProperty("C", "ISERT" ); 	// Create  : 데이터추가 / 게시글 작성/ 회원 등록 .... 등
		prop.setProperty("R", "SELECT"); 	// Read    : 데이터조회 / 게시글 목록 조회 ,검색, 상세페이지~
		prop.setProperty("U", "UPDATE"); 	// Update  : 데이터수정 / 게시글 수정 
		prop.setProperty("D", "DELETE");	// Delete  : 데이터삭제 / 게시글 삭제 / 회원 탈퇴
		
		
		// 3) 객체에 저장된 데이터를 파일에 출력
		//  * Properties 형식 : store(OutputStrem) -> 설정들을 저장하기 위한 용도 
		//  * xml 형식 : storeToXml(OutputStream)  -> SQL문들을 저장하기 위한 용도
		
		// properties 형식
		
		 try {
			 // Properties 형식
			prop.store(new FileOutputStream("test.properties"), "Properties Test");
			 // key=value 형태로 파일에 저장됨
			
			
			// xml 형식
			prop.storeToXML(new FileOutputStream("test.xml"), "Properties Test");
			
			/*
			 *  <entry key= "키 값">밸류값</entry> 형태로 파일에 저장된 
			 */
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
