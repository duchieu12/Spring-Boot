package com.ntd.pratice.controller;

import com.ntd.pratice.dto.DepartmentDTO;
import com.ntd.pratice.entity.Department;
import com.ntd.pratice.form.CreateDepartmentForm;
import com.ntd.pratice.service.IDepartmentService;
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

    @GetMapping("/all")
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return modelMapper.map(departments, new TypeToken<List<DepartmentDTO>>(){}.getType());
    }

    @GetMapping
    public Page<DepartmentDTO> getDepartments(Pageable pageable) {
        Page<Department> departments = departmentService.getDepartments(pageable);
        List<DepartmentDTO> dtos = modelMapper.map(departments.getContent(), new TypeToken<List<DepartmentDTO>>(){}.getType());
        return new PageImpl<>(dtos, pageable, departments.getTotalElements());
    }

    @PostMapping
    public ResponseEntity<Object> createDepartment(@RequestBody @Valid CreateDepartmentForm form) {
        departmentService.createDepartment(form);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);
    }
}
