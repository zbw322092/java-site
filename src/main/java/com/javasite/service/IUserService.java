package com.javasite.service;

import com.javasite.common.ServerResponse;
import com.javasite.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String username, String password);
}
