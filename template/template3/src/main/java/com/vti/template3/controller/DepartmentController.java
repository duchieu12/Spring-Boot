package com.vti.template3.controller;

import com.vti.template3.dto.DepartmentDTO;
import com.vti.template3.entity.Department;
import com.vti.template3.form.DepartmentFilterForm;
import com.vti.template3.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
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

}
