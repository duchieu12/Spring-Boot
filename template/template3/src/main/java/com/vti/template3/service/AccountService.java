package com.vti.template3.service;

import com.vti.template3.entity.Account;
import com.vti.template3.entity.Department;
import com.vti.template3.form.AccountFilterForm;
import com.vti.template3.repository.IAccountRepository;
import com.vti.template3.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public List<Account> getAllAccounts(AccountFilterForm form) {
        Specification<Account> where = AccountSpecification.buildWhere(form);
        return accountRepository.findAll(where);
    }
}
