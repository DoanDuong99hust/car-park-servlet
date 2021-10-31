package com.carpark.dao.impl;

import com.carpark.dao.IUserDAO;
import com.carpark.mapper.UserMapper;
import com.carpark.model.User;

import java.util.List;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {
    @Override
    public User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
        sql.append(" WHERE username = ? AND password = ? AND status = ?");
        List<User> users = query(sql.toString(), new UserMapper(), userName, password, status);
        return users.isEmpty() ? null : users.get(0);
    }
}
