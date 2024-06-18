package com.ntd.pratice.controller;

import com.ntd.pratice.dto.LoginInfor;
import com.ntd.pratice.entity.Account;
import com.ntd.pratice.form.LoginForm;
import com.ntd.pratice.service.IAccountService;
import com.ntd.pratice.utils.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody LoginForm form) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtUtil.generateToken(authentication);
        Account account = accountService.getAccountByUsername(form.getUsername());
        LoginInfor loginInfor = modelMapper.map(account, LoginInfor.class);
        loginInfor.setJwt(jwt);
        return new ResponseEntity<>(loginInfor, HttpStatus.OK);
    }
}