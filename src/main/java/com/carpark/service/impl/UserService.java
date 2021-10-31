package com.carpark.service.impl;

import com.carpark.dao.IUserDAO;
import com.carpark.model.User;
import com.carpark.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDAO iUserDAO;

    @Override
    public User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return iUserDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }
}
