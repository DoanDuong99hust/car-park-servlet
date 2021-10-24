package com.carpark.model;

import java.util.Date;


public class Employee extends AbstractModel<Employee>{
	
	private Long employeeId;
	private String employeeName;
	private String employeeBirthday;
	private String sex;
	private String employeeAddress;
	private String employeePhone;
	private String employeeEmail;
	private String account;
	private String password;
	private String department;

	public Employee(int employeeId, String employeeName) {
		super();
	}

	public Employee() {
	}

	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeBirthday() {
		return employeeBirthday;
	}
	public void setEmployeeBirthday(String employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	

}
