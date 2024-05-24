package com.vti.testing.generator;

import com.vti.testing.kkentity.Department;
import com.vti.testing.repository.IDepartmentRepository;
import com.vti.testing.service.DepartmentService;
import com.vti.testing.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentIdGenerator implements IdentifierGenerator {
//    @Autowired
    private IDepartmentService departmentService = new DepartmentService();

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
        return department.getType().getSql() + "-" + (count + 1); // D-1
    }
}
