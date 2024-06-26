package com.ntd.review.service;

import com.ntd.review.entity.User;
import com.ntd.review.form.CreateUserForm;
import com.ntd.review.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

//    ======================================== GET ========================================
//    Get all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    Get users with paging
    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

//    Get user by id
    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

//    Check user exists
    @Override
    public boolean isUserExistsById(long id) {
        return userRepository.existsById(id);
    }

//    Check user exists by username
    @Override
    public boolean isUserExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    //    Get user by name containing
    @Override
    public List<User> search(String firstName) {
        return userRepository.search(firstName);
    }
    @Override
    public Page<User> search(String firstName, Pageable pageable) {
        return userRepository.findByFirstNameContaining(firstName, pageable);
    }


    //    ======================================== POST ========================================
//    Create a new user
    @Override
    public void createUser(CreateUserForm form) {
        User user = modelMapper.map(form, User.class);
        if (isUserExistsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }
        userRepository.save(user);
    }


//    ======================================== PUT ========================================
//    Update user by id
    @Override
    public void updateUser(User user) {
        User oleUser = getUserById(user.getId());
        user.setUsername(oleUser.getUsername());
        userRepository.save(user);
    }


//    ======================================== DELETE ========================================
//    Delete user by id
    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

//    Delete multiple users
    @Override
    public void deleteMultipleUsers(List<Long> ids) {
        for (long id : ids) {
            if (isUserExistsById(id)) {
                userRepository.deleteById(id);
            }
        }
    }

}
