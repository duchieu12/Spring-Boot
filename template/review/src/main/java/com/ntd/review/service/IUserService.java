package com.ntd.review.service;

import com.ntd.review.entity.User;
import com.ntd.review.form.CreateUserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
//    ======================================== GET ========================================
//    Get all users
    List<User> getAllUsers();

//    Get users with paging
    Page<User> getUsers(Pageable pageable);

//    Get user by id
    User getUserById(long id);

//    Check user exists by id
    boolean isUserExistsById(long id);

//    Check user exists by username
    boolean isUserExistsByUsername(String username);

//    Get user by name containing
    List<User> search(String firstName);
    Page<User> search(String firstName, Pageable pageable);


//    ======================================== POST ========================================
//    Create a new user
    void createUser(CreateUserForm form);


//    ======================================== PUT ========================================
//    Update user by id
    void updateUser(User user);


//    ======================================== DELETE ========================================
//    Delete user by id
    void deleteUser(long id);

//    Delete multiple users
    void deleteMultipleUsers(List<Long> ids);



}
