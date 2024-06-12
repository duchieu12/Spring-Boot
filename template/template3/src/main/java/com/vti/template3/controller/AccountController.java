package com.vti.template3.controller;

import com.vti.template3.dto.AccountDTO;
import com.vti.template3.dto.DepartmentDTO;
import com.vti.template3.entity.Account;
import com.vti.template3.entity.Department;
import com.vti.template3.form.AccountFilterForm;
import com.vti.template3.form.CreateAccountForm;
import com.vti.template3.form.UpdateAccountForm;
import com.vti.template3.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@Validated
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public Page<AccountDTO> getAccounts(Pageable pageable) {
        Page<Account> accounts = accountService.getAccounts(pageable);
        List<AccountDTO> dtos = modelMapper.map(accounts.getContent(), new TypeToken<List<AccountDTO>>(){}.getType());
        return new PageImpl<>(dtos, pageable, accounts.getTotalElements());
    }

    @GetMapping("/all")
    public List<AccountDTO> getAllAccounts(AccountFilterForm form) {
        List<Account> accounts = accountService.getAllAccounts(form);
        return modelMapper.map(accounts, new TypeToken<List<AccountDTO>>() {
        }.getType());
    }

    @PostMapping
    public ResponseEntity<Object> createAccout(@RequestBody @Valid CreateAccountForm form) {
        accountService.createAccout(form);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable(name = "id") int id, @RequestBody UpdateAccountForm form) {
        accountService.updateAccout(id, form);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable(name = "id") int id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/multiple/{listId}")
    public ResponseEntity<String> deleteSelectedAccounts(@PathVariable(name = "listId") List<Integer> listId) {
        accountService.deleteSelectedAccounts(listId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
