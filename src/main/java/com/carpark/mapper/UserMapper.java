package com.carpark.mapper;

import com.carpark.model.Role;
import com.carpark.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet) {
        try {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setUserName(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setFullName(resultSet.getString("fullname"));
            user.setStatus(resultSet.getInt("status"));
            user.setRoleId(resultSet.getLong("roleid"));
            user.setCreatedDate(resultSet.getTimestamp("createddate"));
            user.setModifiedDate(resultSet.getTimestamp("modifieddate"));
            user.setCreateBy(resultSet.getString("createdby"));
            user.setModifiedBy(resultSet.getString("modifiedby"));
            try {
                Role role = new Role();
                role.setCode(resultSet.getString("code"));
                role.setName(resultSet.getString("name"));
                user.setRole(role);
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
