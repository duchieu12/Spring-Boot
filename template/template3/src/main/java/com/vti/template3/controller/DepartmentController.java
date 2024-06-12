package com.vti.template3.controller;

import com.vti.template3.dto.DepartmentDTO;
import com.vti.template3.entity.Department;
import com.vti.template3.form.CreateDepartmentForm;
import com.vti.template3.form.DepartmentFilterForm;
import com.vti.template3.form.UpdateDepartmentForm;
import com.vti.template3.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@Validated
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public Page<DepartmentDTO> getDepartments(Pageable pageable) {
        Page<Department> departments = departmentService.getDepartments(pageable);
        List<DepartmentDTO> dtos = modelMapper.map(departments.getContent(), new TypeToken<List<DepartmentDTO>>() {
        }.getType());
        return new PageImpl<>(dtos, pageable, departments.getTotalElements());
    }

    @GetMapping("/all")
    public List<DepartmentDTO> getAllDepartments(DepartmentFilterForm form) {
        List<Department> departments = departmentService.getAllDepartments(form);
        return modelMapper.map(departments, new TypeToken<List<DepartmentDTO>>() {
        }.getType());
    }


    @PostMapping
    public ResponseEntity<Object> createDepartment(@RequestBody @Valid CreateDepartmentForm form) {
        departmentService.createDepartment(form);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDepartment(@PathVariable(name = "id") int id, @RequestBody UpdateDepartmentForm form) {
        departmentService.updateDepartment(id, form);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }
}
