package com.vti.template3.service;

import com.vti.template3.entity.Account;
import com.vti.template3.entity.Department;
import com.vti.template3.form.AccountFilterForm;
import com.vti.template3.form.CreateAccountForm;
import com.vti.template3.form.UpdateAccountForm;
import com.vti.template3.repository.IAccountRepository;
import com.vti.template3.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void createAccout(CreateAccountForm form) {
//        Account account = modelMapper.map(form, Account.class);  -> khong nen dung`
        Account account = new Account();
        account.setUsername(form.getUsername());
        Department department = new Department();
        department.setId(form.getDepartmentId());
        account.setDepartment(department);
        accountRepository.save(account);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void updateAccout(int id, UpdateAccountForm form) {
        Account account = new Account();
        account.setId(id);
        account.setUsername(form.getUsername());

//        Create department contain id
        Department department = new Department();
        department.setId(form.getDepartmentId());

//        Set department for account
        account.setDepartment(department);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void deleteSelectedAccounts(List<Integer> listId) {
        for (Integer id : listId) {
            accountRepository.deleteById(id);
        }
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(username, account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole().toString()));
    }
}
