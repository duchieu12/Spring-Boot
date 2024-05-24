package com.vti.controller;

import com.vti.entity.Account;
import com.vti.service.AccountService;
import com.vti.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/v1/account/")
@Scope(scopeName = "singleton")
public class AccountController {

    @Autowired // DI
    AccountService accountService; // khoi tao khi chay project IoC

    @GetMapping("/get-all-accounts")
    public Page<Account> getAllAccount(Pageable pageable){
        AccountService accountServiceNew = new AccountServiceImpl();
        Page<Account> accountList1 = accountServiceNew.getAllAccount(pageable);
        Page<Account> accountList2 = accountService.getAllAccount(pageable);
        return accountList2;
    }

    @GetMapping("/get-by-id/{id}")
    public Account getAccountById(@PathVariable("id") int id){
        AccountService accountServiceNew = new AccountServiceImpl();

        Account account1 = accountServiceNew.findByID(id);
        Account account2 = accountService.findByID(id);
        return account2;
    }

    @PostMapping("/create-account")
    public Account createAccount(@RequestBody Account account){
        Account account2 = accountService.createAccount(account);
        return account2;
    }

    @PutMapping("/update-account")
    public ResponseEntity<?> updateAccount(@RequestBody Account account){
        return accountService.updateAccount(account);
    }
}
