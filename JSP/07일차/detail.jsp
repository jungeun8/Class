<%@page import="com.sample.hr.vo.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@page import="com.sample.hr.dto.DepartmentDto"%>
<%@page import="com.sample.hr.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 :: 부서관리</title>
</head>
<body>
	<h1>부서 상세 정보 페이지</h1>
	<p>
		부서의 기본정보를  표시하고, 그 부서에 소속된 사원 목록을 표시한다.
	</p>
	
	<%
		// http://localhost/sample/hr/dept/detail.jsp?deptId=10
		// 요청객체에서 요청파라미터값 조회하기
		int departmentId = Integer.parseInt(request.getParameter("deptId"));	 // "10" -> 10
		
		DepartmentDao departmentDao = new DepartmentDao();
		DepartmentDto departmentDto = departmentDao.getDepartmentDto(departmentId);
		
	%>
	
	<h3>부서 기본 정보</h3>
	
	<dl>
		<dt>부서아이디</dt><dd><%=departmentId %><dd>
		<dt>부서 이름</dt><dd><%=departmentDto.getName() %><dd>
		<dt>부서관리자 아이디</dt><dd><%=departmentDto.getManagerId() %><dd>
		<dt>부서관리자 이름</dt><dd><%=departmentDto.getManagerName() %><dd>
		<dt>부서소재지 아이디</dt><dd><%=departmentDto.getLocationId() %><dd>
		<dt>부서소재지 도시명</dt><dd><%=departmentDto.getCity() %><dd>
		<dt>부서에 소속된 사원수</dt><dd><%=departmentDto.getEmpCount() %><dd>
	</dl>
	<p>
		<a href="">부서정보 수정</a>
	<% 
		if(departmentDto.getEmpCount()== 0){
	%>
		<a href="remove.jsp?deptId=<%=departmentId%>">부서정보 삭제</a>
	<%
		}
	%>
	</p>
	
	<h3>소속사원 정보</h3>
	<%
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employees = employeeDao.getEmployeesByDepartmentId(departmentId);
	%>
	<table border="1" style="width: 80%">
		<thead>
			<tr>
				<th>사원이름</th>
				<th>직종아이디</th>
				<th>입사일</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
	
			<%
			if(employees.isEmpty()){
				%>
				<tr>
				<td colspan="5">소속된 사원이 존재하지 않습니다.</td>
				</tr>
			<%
			}else{
			%>	
			
			<%
				for(Employee emp:employees){
					%>
					<tr>
					<td><%= emp.getFirstName() %></td>
					<td><%= emp.getJobId() %></td>
					<td><%= emp.getHireDate() %></td>
					<td><%= emp.getPhoneNumber() %></td>
					<td><%= emp.getEmail() %></td>
				</tr>
				<%
				}
			}
				%>
			
		</tbody>
	</table>
	
	<p><a href="list.jsp">부서 목록페이지로 되돌아가기</a></p>
</body>
</html>