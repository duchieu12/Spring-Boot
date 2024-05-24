package com.vti.testing.repository;

import com.vti.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

//    Department findByName(String name);

    @Query("FROM Department WHERE name = ?1")
    Department findByName(String name);

    List<Department> findByNameContaining(String name);
}
