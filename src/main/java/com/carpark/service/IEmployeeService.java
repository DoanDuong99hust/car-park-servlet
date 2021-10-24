package com.carpark.service;

import java.util.List;

import com.carpark.model.Employee;
import com.carpark.paging.Pageble;

public interface IEmployeeService {
	Employee save(Employee employee);
	Employee update(Employee updateEmployee);
	void delete(long[] ids);
	List<Employee> findAll(Pageble pageble);
	List<Employee> findAll();
	int getTotalItem();
	Employee findOne(long id);
}
