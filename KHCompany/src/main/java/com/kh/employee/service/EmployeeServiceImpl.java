package com.kh.employee.service;

// static으로 JDBCTemplate의 모든 메소드 임포트  메소드별로도 임포트 가능 필드는 불가능
import static com.kh.employee.template.JDBCTemplate.close;
import static com.kh.employee.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.vo.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao eDao = new EmployeeDao();
	
	/* 
	 * 사원 전체 목록 조회 
	 */
	
	@Override
	public ArrayList<Employee> selectEmployeeList() {
		// * Connection 객체 생성
		Connection conn = getConnection();
		
		// * DAO로 Connection 객체를 전달 (필요한 기능 요청)
		ArrayList<Employee> list = eDao.selectEmployeeList(conn); // DAO에게 요청
		
		// * Connection 객체 반납 
		close(conn);
		
		// * 결과를 리턴

		return list;
	}

	@Override
	public Employee selectEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertEmployee(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmploye(Employee e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}

		
}
