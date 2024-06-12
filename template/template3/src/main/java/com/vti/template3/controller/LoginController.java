package com.vti.template3.controller;

import com.vti.template3.dto.LoginInfor;
import com.vti.template3.entity.Account;
import com.vti.template3.form.LoginForm;
import com.vti.template3.service.IAccountService;
import com.vti.template3.ultis.JwtUtil;
import org.apache.catalina.User;
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
