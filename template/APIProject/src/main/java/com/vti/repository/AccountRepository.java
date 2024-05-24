package com.vti.repository;

import com.vti.entity.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

@Scope(scopeName = "singleton")
public interface AccountRepository extends JpaRepository<Account, Integer> {
    void deleteAccountByUserName(String userName);
}
