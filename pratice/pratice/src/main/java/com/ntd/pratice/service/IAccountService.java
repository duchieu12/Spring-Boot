package com.ntd.pratice.service;

import com.ntd.pratice.entity.Account;
import com.ntd.pratice.form.AccountFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    Page<Account> getAccounts(Pageable pageable, AccountFilterForm form);

    Account getAccountByUsername(String username);
}
