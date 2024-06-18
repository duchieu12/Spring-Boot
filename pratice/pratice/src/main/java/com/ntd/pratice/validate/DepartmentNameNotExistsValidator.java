package com.ntd.pratice.validate;

import com.ntd.pratice.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentNameNotExistsValidator implements ConstraintValidator<DepartmentNameNotExists, String> {
    @Autowired
    private IDepartmentService departmentService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !departmentService.isExistsByName(name);
    }
}
