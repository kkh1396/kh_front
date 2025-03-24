package com.kh.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.employee.template.JDBCTemplate;
import com.kh.employee.vo.Employee;

public class EmployeeDao {

	/*
	 *  * Statement 객체 생성 (=> Connection 객체 사용)
	 * 
	 *  * query문 실행 후 결과 받기
	 *  
	 *  * 결과에 대한 처리 
	 *   - DQL : ResultSet 객체로 결과를 받아서 필요한 데이터를 저장
	 *   - DML : int 타입으로 결과를 받아서 리턴(=> 트랜잭션 처리는 서비스 담당)
	 *   
	 *  * 객체 반납(close) => Statement, ResultSet
	 */
	
	private Properties prop = new Properties();
	Statement stat = null;
	ResultSet rset = null;
	
	
	public EmployeeDao() {
		try {
			// employee-mapper.xml 파일 경로
			String filepath =  EmployeeDao.class.getResource("/sql/employee-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(filepath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Employee> selectEmployeeList(Connection conn) {
		
		ArrayList<Employee> list = new ArrayList<>();
		
		
		try {
			stat = conn.createStatement();
			
			
			rset = stat.executeQuery(prop.getProperty("selectEmployeeList"));
			
			
			while (rset.next()) {
				// * Employee 객체에 조회 결과 담기
				  
			Employee e = new Employee( 
						     rset.getInt("emp_id")
						   , rset.getString("emp_name")
						   , rset.getString("dept_title")
						   , rset.getString("job_name")
						   , rset.getString("hire_date")
						);
						
				
				// * ArrayList에  담아둔 데이터 추가 
				list.add(e);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stat);
		}
	
		
		return list;
	}

	
}
