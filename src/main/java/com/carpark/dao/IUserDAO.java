package com.carpark.dao;

import com.carpark.model.User;

public interface IUserDAO extends GenericDAO<User>{
    User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
