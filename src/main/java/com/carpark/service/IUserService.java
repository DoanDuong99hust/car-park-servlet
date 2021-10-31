package com.carpark.service;

import com.carpark.model.User;

public interface IUserService {
    User findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
