package com.ntd.review.controller;

import com.ntd.review.dto.UserDTO;
import com.ntd.review.entity.User;
import com.ntd.review.form.CreateUserForm;
import com.ntd.review.form.UpdateUserForm;
import com.ntd.review.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

//    ======================================== GET ========================================
//    Get all users
    @GetMapping("/all")
    public List<UserDTO> getAllUsers () {
        List<User> users = userService.getAllUsers();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
    }

//    Get users with paging
    @GetMapping
    public Page<UserDTO> getUsers (Pageable pageable) {
        Page<User> users = userService.getUsers(pageable);
        List<UserDTO> dtos = modelMapper.map(users.getContent(), new TypeToken<List<UserDTO>>(){}.getType());
        return new PageImpl<>(dtos, pageable, users.getTotalElements());
    }

//    Get user by id
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return modelMapper.map(user, UserDTO.class);
    }

//    Check user exists
    @GetMapping("/exists/{id}")
    public boolean isUserExistsById(@PathVariable long id) {
        return userService.isUserExistsById(id);
    }

//    Search
    @GetMapping("/search/{firstName}")
//    public List<UserDTO> search(@PathVariable String firstName) {
//        List<User> users = userService.search(firstName);
//        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
//    }
    public Page<UserDTO> search(@PathVariable String firstName, @PageableDefault(size = 5) Pageable pageable) {
        Page<User> users = userService.search(firstName, pageable);
        List<UserDTO> dtos = modelMapper.map(users.getContent(), new TypeToken<List<UserDTO>>(){}.getType());
        return new PageImpl<>(dtos, pageable, users.getTotalElements());
    }


//    ======================================== POST ========================================
//    Create user
    @PostMapping
    public ResponseEntity<Object> createUser (@RequestBody @Valid CreateUserForm form) {
        userService.createUser(form);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }


//    ======================================== PUT ========================================
//    Update user
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable long id, @RequestBody @Valid UpdateUserForm form) {
        User user = modelMapper.map(form, User.class);
        user.setId(id);
        userService.updateUser(user);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }


//    ======================================== DELETE ========================================
//    Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

//    Delete multiple users
    @DeleteMapping("/multiple/{ids}")
    public ResponseEntity<Object> deleteMultipleUsers(@PathVariable List<Long> ids) {
        userService.deleteMultipleUsers(ids);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}