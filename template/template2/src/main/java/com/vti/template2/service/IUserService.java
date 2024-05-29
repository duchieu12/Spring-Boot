package com.vti.template2.service;

import com.vti.template2.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(int id);

    Page<User> getUsers(Pageable pageable);
}
