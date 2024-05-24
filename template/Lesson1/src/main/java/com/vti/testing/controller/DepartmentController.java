package com.vti.testing.controller;

import com.vti.testing.entity.Department;
import com.vti.testing.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public Page<Department> getAllDepartments(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return departmentService.getAllDepartments(pageable);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") int id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/name/{name}")
    public List<Department> getDepartmentByName(@PathVariable String name){
        return departmentService.getDepartmentByName(name);
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable int id, @RequestBody Department department) {
        department.setId(id);
        departmentService.updateDepartment(department);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
