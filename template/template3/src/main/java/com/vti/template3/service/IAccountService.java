package com.vti.template3.service;

import com.vti.template3.entity.Account;
import com.vti.template3.form.AccountFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<Account> getAccounts(Pageable pageable);

    List<Account> getAllAccounts(AccountFilterForm form);
}
