package com.vti.template3.service;

import com.vti.template3.entity.Department;
import com.vti.template3.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;


    @Override
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
