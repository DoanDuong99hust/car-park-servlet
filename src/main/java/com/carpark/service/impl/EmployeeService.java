package com.carpark.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.carpark.dao.impl.EmployeeDAO;
import com.carpark.model.Employee;
import com.carpark.paging.Pageble;
import com.carpark.service.IEmployeeService;

public class EmployeeService implements IEmployeeService {

	@Inject
	private EmployeeDAO employeeDao;

	@Override
	public Employee save(Employee employee) {
		Long newId = employeeDao.save(employee);
		return employeeDao.findOne(newId);
	}

	@Override
	public Employee update(Employee updateEmployee) {
		employeeDao.update(updateEmployee);
		return employeeDao.findOne(updateEmployee.getEmployeeId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			employeeDao.delete(id);
		}
	}

	@Override
	public List<Employee> findAll(Pageble pageble) {
		return employeeDao.findAll(pageble);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public int getTotalItem() {
		return employeeDao.getTotalItem();
	}

	@Override
	public Employee findOne(long id) {
		Employee employee = employeeDao.findOne(id);
		return employee;
	}
}
