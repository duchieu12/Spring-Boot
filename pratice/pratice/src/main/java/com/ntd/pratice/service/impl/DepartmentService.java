package com.ntd.pratice.service.impl;

import com.ntd.pratice.entity.Department;
import com.ntd.pratice.form.CreateDepartmentForm;
import com.ntd.pratice.repository.IDepartmentRepository;
import com.ntd.pratice.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public boolean isExistsByName(String name) {
        return departmentRepository.existsByName(name);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void createDepartment(@Valid CreateDepartmentForm form) {
        Department department = modelMapper.map(form, Department.class);
        departmentRepository.save(department);
    }
}
