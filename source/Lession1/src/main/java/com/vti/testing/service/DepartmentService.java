package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

//    GET
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public boolean isDepartmentExistsById(int id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public List<Department> getDepartmentByNameContaining(String name) {
        return departmentRepository.findByNameContaining(name);
    }

    //    POST
    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

//    PUT
    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

//    DELETE
    @Override
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
