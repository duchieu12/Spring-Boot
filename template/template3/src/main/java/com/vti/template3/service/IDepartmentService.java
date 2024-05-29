package com.vti.template3.service;

import com.vti.template3.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> getDepartments(Pageable pageable);

    List<Department> getAllDepartments();
}
