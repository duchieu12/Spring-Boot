package com.vti.testing.repository;

import com.vti.testing.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByNameContaining(String name);
//     HQL
    @Query("FROM Department WHERE name LIKE CONCAT('%', ?1 , '%')")
    List<Department> getByName(String name);
}
