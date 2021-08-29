package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.vo.Employee;
import com.sample.utils.ConnectionUtil;

/**
 * EMPLOYEES 테이블에 대한 CRUD를 제공하는 클래스다.
 * @author jungeun-kim
 *
 */
public class EmployeeDao {
	
	/**
	 * 부서아이디를 전달받아서 해당 부서에 소속된 사원들을 반환한다.
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> getEmployeesByDepartmentId(int deptId) throws SQLException{
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql ="select * "
				+ "from employees "
				+ "where department_id = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return employees;
		
	}

}
