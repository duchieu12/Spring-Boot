package com.ntd.pratice.repository;

import com.ntd.pratice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    boolean existsByName(String name);
}
