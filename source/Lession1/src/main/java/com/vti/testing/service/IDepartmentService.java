package com.vti.testing.service;

import com.vti.testing.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
//    GET
    List<Department> getAllDepartments();

    Page<Department> getDepartments(Pageable pageable);

    Department getDepartmentById(int id);

    boolean isDepartmentExistsById(int id);

    Department getDepartmentByName(String name);

    List<Department> getDepartmentByNameContaining(String name);

//    POST
    void createDepartment(Department department);

//    PUT
    void updateDepartment(Department department);

//    DELETE
    void deleteDepartment(int id);

}
