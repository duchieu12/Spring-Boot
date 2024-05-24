package com.vti.template.controller;

import com.vti.template.entity.Department;
import com.vti.template.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

//    GET

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping
    public Page<Department> getDepartments(@PageableDefault Pageable pageable) {
        return departmentService.getDepartments(pageable);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") int id) {
        return departmentService.getDepartmentById(id);
    }

//    @GetMapping
//    public Department getDepartmentById(@RequestBody Department department) {
//        return departmentService.getDepartmentById(department.getId());
//    }

    @GetMapping("/exists/{id}")
    public boolean isDepartmentExistsById(@PathVariable(name = "id") int id) {
        return departmentService.isDepartmentExistsById(id);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable(name = "name") String name) {
        return departmentService.getDepartmentByName(name);
    }

//    Search all by name
//    @GetMapping("/search/{name}")
//    public List<Department> getDepartmentByNameContaining(@PathVariable(name = "name") String name) {
//        return departmentService.getDepartmentByNameContaining(name);
//    }

    @GetMapping("/search/{characterName}")
    public Page<Department> getDepartmentByNameContaining(@PathVariable(name = "characterName") String characterName, Pageable pageable) {
        return departmentService.getDepartmentByNameContaining(characterName, pageable);
    }


    //    POST
    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }


    //    PUT
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable(name = "id") int id, @RequestBody Department department) {
//        department.setId(id);
        departmentService.updateDepartment(department);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }


    //    DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable(name = "id") int id) {
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/multiple/{listId}")
    public ResponseEntity<String> deleteSelectedDepartments(@PathVariable(name = "listId") List<Integer> listId) {
        departmentService.deleteSelectedDepartments(listId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
