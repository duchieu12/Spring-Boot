package com.vti.template3.service;

import com.vti.template3.entity.Account;
import com.vti.template3.entity.Department;
import com.vti.template3.form.CreateDepartmentForm;
import com.vti.template3.form.DepartmentFilterForm;
import com.vti.template3.form.UpdateDepartmentForm;
import com.vti.template3.repository.IAccountRepository;
import com.vti.template3.repository.IDepartmentRepository;
import com.vti.template3.specification.DepartmentSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public List<Department> getAllDepartments(DepartmentFilterForm form) {
        Specification<Department> where = DepartmentSpecification.builWhere(form);
        return departmentRepository.findAll(where);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void createDepartment(CreateDepartmentForm form) {
        Department department = modelMapper.map(form, Department.class);
        departmentRepository.save(department);
        List<Account> accounts = department.getAccounts();
        accounts.forEach(account -> account.setDepartment(department));
        accountRepository.saveAll(accounts);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void updateDepartment(int id, UpdateDepartmentForm form) {
        Department department = modelMapper.map(form, Department.class);
        department.setId(id);
        departmentRepository.save(department);
    }

    @Override
    public boolean isExistsByName(String name) {
        return departmentRepository.existsByName(name);
    }
}
