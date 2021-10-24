package com.carpark.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpark.dao.IEmployeeDAO;
import com.carpark.mapper.EmployeeMapper;
import com.carpark.mapper.RowMapper;
import com.carpark.model.Employee;
import com.carpark.paging.Pageble;
import org.apache.commons.lang.StringUtils;

public class EmployeeDAO extends AbstractDAO<Employee> implements IEmployeeDAO {

    @Override
    public Employee findOne(Long id) {
        String sql = "SELECT * FROM employee WHERE employeeId = ?";
        List<Employee> news = query(sql, new EmployeeMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public Long save(Employee employee) {
        StringBuilder sql = new StringBuilder("INSERT INTO employee (employeeName, account,");
        sql.append(" department, employeeAddress, employeeBirthday, employeeEmail, employeePhone,");
        sql.append(" password, sex)");
        sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), employee.getEmployeeName(), employee.getAccount(),employee.getDepartment(),
                employee.getEmployeeAddress(),employee.getEmployeeBirthday(), employee.getEmployeeEmail(),
                employee.getEmployeePhone(), employee.getPassword(), employee.getSex());

    }

    @Override
    public void update(Employee updateEmployee) {
        StringBuilder sql = new StringBuilder("UPDATE employee SET employeeName = ?, account = ?,");
        sql.append(" department = ?, employeeAddress = ?, employeeBirthday = ?, employeeEmail = ?, employeePhone = ?,");
        sql.append(" password = ?, sex = ? WHERE employeeId = ?");
        update(sql.toString(), updateEmployee.getEmployeeName(), updateEmployee.getAccount(),updateEmployee.getDepartment(),
                updateEmployee.getEmployeeAddress(),updateEmployee.getEmployeeBirthday(), updateEmployee.getEmployeeEmail(),
                updateEmployee.getEmployeePhone(), updateEmployee.getPassword(), updateEmployee.getSex(), updateEmployee.getEmployeeId());
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM employee WHERE employeeId = ?";
        update(sql, id);
    }

    @Override
    public List<Employee> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM employee");
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
            sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
        }
        if (pageble.getOffset() == null && pageble.getLimit() == null ||
                pageble.getSorter() == null && StringUtils.isBlank(pageble.getSorter().getSortName()) && StringUtils.isBlank(pageble.getSorter().getSortBy())
        ) {
            return query(sql.toString(), new EmployeeMapper());
        }
        return query(sql.toString(), new EmployeeMapper());
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";

        List<Employee> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement =  connection.prepareStatement(sql);
            RowMapper<Employee> rowMapper = new EmployeeMapper();
//            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT count(*) FROM employee";
        return count(sql);
    }
}
