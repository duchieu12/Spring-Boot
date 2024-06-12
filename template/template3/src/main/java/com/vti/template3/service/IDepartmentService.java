package com.vti.template3.service;

import com.vti.template3.entity.Department;
import com.vti.template3.form.CreateDepartmentForm;
import com.vti.template3.form.DepartmentFilterForm;
import com.vti.template3.form.UpdateDepartmentForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> getDepartments(Pageable pageable);

    List<Department> getAllDepartments(DepartmentFilterForm form);

    void createDepartment(CreateDepartmentForm form);

    void updateDepartment(int id, UpdateDepartmentForm form);

    boolean isExistsByName(String name);
}
