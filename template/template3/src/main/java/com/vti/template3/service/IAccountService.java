package com.vti.template3.service;

import com.vti.template3.entity.Account;
import com.vti.template3.form.AccountFilterForm;
import com.vti.template3.form.CreateAccountForm;
import com.vti.template3.form.UpdateAccountForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    Page<Account> getAccounts(Pageable pageable);

    List<Account> getAllAccounts(AccountFilterForm form);

    Account getAccountByUsername(String username);

    void createAccout(CreateAccountForm form);

    void updateAccout(int id, UpdateAccountForm form);

    void deleteAccount(int id);

    void deleteSelectedAccounts(List<Integer> listId);

    boolean isExistsByUsername(String username);
}
