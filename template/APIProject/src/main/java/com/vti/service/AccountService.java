package com.vti.service;

import com.vti.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface AccountService {
    public Page<Account> getAllAccount(Pageable pageable);
    public Account findByID(int id);
    Account createAccount(Account account);
    public ResponseEntity<?> updateAccount(Account account);
}
