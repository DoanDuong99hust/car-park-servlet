package com.carpark.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.carpark.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet) {
		try {
			Employee employee = new Employee();
			employee.setEmployeeId(resultSet.getLong("employeeId"));
			employee.setEmployeeName(resultSet.getString("employeeName"));
			employee.setAccount(resultSet.getString("account"));
			employee.setDepartment(resultSet.getString("department"));
			employee.setEmployeeAddress(resultSet.getString("employeeAddress"));
			employee.setEmployeeBirthday(resultSet.getString("employeeBirthday"));
			employee.setEmployeeEmail(resultSet.getString("employeeEmail"));
			employee.setEmployeePhone(resultSet.getString("employeePhone"));
			employee.setPassword(resultSet.getString("password"));
			employee.setSex(resultSet.getString("sex"));
			return employee;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
