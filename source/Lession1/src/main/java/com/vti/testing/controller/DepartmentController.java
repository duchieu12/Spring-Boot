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

//    GET
//    @GetMapping
//    public List<Department> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }

    @GetMapping
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentService.getDepartments(pageable);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") int id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/exists/{id}")
    public boolean isDepartmentExistsById(@PathVariable(name = "id") int id) {
        return departmentService.isDepartmentExistsById(id);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable(name = "name") String name) {
        return departmentService.getDepartmentByName(name);
    }

    @GetMapping("/search/{name}")
    public List<Department> getDepartmentByNameContaining(@PathVariable(name = "name") String name) {
        return departmentService.getDepartmentByNameContaining(name);
    }

//    POST
    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }


//    PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable(name = "id") int id, @RequestBody Department department) {
        department.setId(id);
        departmentService.updateDepartment(department);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }


//    DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable(name = "id") int id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
