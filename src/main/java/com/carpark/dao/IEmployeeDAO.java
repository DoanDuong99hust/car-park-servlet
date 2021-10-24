package com.carpark.dao;

import com.carpark.model.Employee;
import com.carpark.paging.Pageble;

import java.util.List;

public interface IEmployeeDAO extends GenericDAO<Employee>{
    Employee findOne(Long id);
    Long save(Employee employee);
    void update(Employee updateEmployee);
    void delete(long id);
    List<Employee> findAll(Pageble pageble);
    List<Employee> findAll();
    int getTotalItem();
}
