package com.vti.testing.service;

import com.vti.testing.entity.Department;
import com.vti.testing.form.DepartmentFilterForm;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments(DepartmentFilterForm form);

    List<Department> getDepartments();
}
