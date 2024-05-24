package com.vti.template2.service;

import com.vti.template2.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(int id);
}
