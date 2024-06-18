package com.ntd.pratice.service;

import com.ntd.pratice.entity.Department;
import com.ntd.pratice.form.CreateDepartmentForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;

public interface IDepartmentService {

    List<Department> getAllDepartments();

    Page<Department> getDepartments(Pageable pageable);

    boolean isExistsByName(String name);

    void createDepartment(CreateDepartmentForm form);
}
