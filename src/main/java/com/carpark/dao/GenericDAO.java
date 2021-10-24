package com.carpark.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.carpark.mapper.RowMapper;
import com.carpark.model.Employee;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
