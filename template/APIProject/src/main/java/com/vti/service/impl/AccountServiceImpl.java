package com.vti.service.impl;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.service.AccountService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Objects;

@Service
@Scope(scopeName = "singleton")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository; // DI Inject

    @Override
    public Page<Account> getAllAccount(Pageable pageable) {

        Page<Account> accountPage = null;

        if (Objects.nonNull(accountRepository))
            accountPage = accountRepository.findAll(pageable);

        return accountPage;
    }

    @Override
    public Account findByID(int id) {
        Account account = null;
        if (Objects.nonNull(accountRepository))
            account = accountRepository.findById(id).orElse(null);

        if (account == null)
            account = new Account();

        return account;
    }

    @Override
    public Account createAccount(Account account) {
        account.setId(0);
        return accountRepository.save(account);
    }

    @Override
    public ResponseEntity<?> updateAccount(Account account) {
        Account account1 = accountRepository.findById(account.getId()).orElse(null);
        if (Objects.isNull(account1))
            return new ResponseEntity<>("Can not find account id = " +account.getId(), HttpStatus.NOT_FOUND);

        if (Strings.isNotEmpty(account.getUserName()))
            account1.setUserName(account.getUserName());

        if (Strings.isNotEmpty(account.getAddress()))
            account1.setAddress(account.getAddress());

        accountRepository.save(account1);
        return new ResponseEntity<>("Update sccess", HttpStatus.OK);
    }
}
