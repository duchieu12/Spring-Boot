package com.vti.template2.controller;

import com.vti.template2.dto.UserDTO;
import com.vti.template2.entity.User;
import com.vti.template2.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable(name = "id") int id) {
        User user = userService.getUserById(id);
        return modelMapper.map(user, UserDTO.class);
    }
}
