package com.vti.template.generator;

import com.vti.template.entity.Department;
import com.vti.template.repository.IDepartmentRepository;
import com.vti.template.service.DepartmentService;
import com.vti.template.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentCodeGenerator implements IdentifierGenerator {
    private final IDepartmentService departmentService;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Department department = (Department) o;
        List<Department> departments = departmentService.getAllDepartments();
        int count = 0;
        for (Department dep : departments) {
            if (dep.getType().equals(department.getType())) {
                count++;
            }
        }
        return department.getType().getSql() + "-" + (count + 1);
    }
}
