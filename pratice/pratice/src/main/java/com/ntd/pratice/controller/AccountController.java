package com.ntd.pratice.controller;

import com.ntd.pratice.dto.AccountDTO;
import com.ntd.pratice.dto.DepartmentDTO;
import com.ntd.pratice.entity.Account;
import com.ntd.pratice.entity.Department;
import com.ntd.pratice.form.AccountFilterForm;
import com.ntd.pratice.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    Page<AccountDTO> getAccounts(Pageable pageable, AccountFilterForm form) {
        Page<Account> accounts = accountService.getAccounts(pageable, form);
        List<AccountDTO> dtos = modelMapper.map(accounts.getContent(), new TypeToken<List<AccountDTO>>(){}.getType());
        return new PageImpl<>(dtos, pageable, accounts.getTotalElements());
    }
}
