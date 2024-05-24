package com.vti.template.service;

import com.vti.template.entity.Department;
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

//    Search all by name
//    List<Department> getDepartmentByNameContaining(String name);

    Page<Department> getDepartmentByNameContaining(String characterName, Pageable pageable);


    //    POST
    void createDepartment(Department department);


    //    PUT
    void updateDepartment(Department department);


    //    DELETE
    void deleteDepartmentById(int id);

    void deleteSelectedDepartments(List<Integer> listId);
}
