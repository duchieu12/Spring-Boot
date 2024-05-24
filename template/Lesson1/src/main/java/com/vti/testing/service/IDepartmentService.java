package com.vti.testing.service;

import com.vti.testing.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> getAllDepartments(Pageable pageable);

    Department getDepartmentById(int id);

    void createDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(int id);

    List<Department> getDepartmentByName(String name);

    List<Department> getAllDepartments();
}
