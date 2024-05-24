package com.vti.template2.service;

import com.vti.template2.entity.User;
import com.vti.template2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice implements IUserService {
    @Autowired
    private IUserRepository userRepository;

//    Get

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }
}
