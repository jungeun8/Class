package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.vo.Department;
import com.sample.utills.ConnectionUtill;

/**
 * DEPARTMENTS 테이블에 대한 CRUD 기능을 제공하는 클래스다. 
 * @author jungeun-kim
 *
 */
public class DepartmentDao {

	/**
	 * 모든 부서정보를 반환한다.
	 * @return 부서정보 목록 
	 * @throws SQLException
	 */
	public List<Department> getAllDepartments() throws SQLException{
		List<Department> departments = new ArrayList<Department>();
		String sql = "select department_id, department_name, manager_id,local_id  "
				+ "from departments  "
				+ "order by department_id asc";
		Connection con = ConnectionUtill.getConnection(); //DBMS와 연결을 담당하는 connection 객체획득
		PreparedStatement pstmt = con.prepareStatement(sql);// 지정된 SQL을 DBMS로 전송하는 PreparedStatements 획득
		ResultSet rs = pstmt.executeQuery();	// SQL을 DBMS로 전송하고 실행결과가 포함된 ResultSet 객체 획득 
		
		while(rs.next()) {
			Department department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			department.setManagerId(rs.getInt("department_managerid"));
			department.setLocationId(rs.getInt("department_locationid"));
			
			
			departments.add(department);
			
		}
		return null;
	}
}
