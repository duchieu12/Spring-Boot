package com.vti.template.repository;

import com.vti.template.entity.Department;
import com.vti.template.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);

    //    Option 1
//    List<Department> findByNameContaining(String characterName);
    Page<Department> findByNameContaining(String characterName, Pageable pageable);

//    Option 2
//    Search all by name
//    @Query("FROM Department d WHERE d.name LIKE CONCAT('%', ?1, '%')")
//    List<Department> findByNameContaining(String name);

//    @Query("FROM Department d WHERE d.name LIKE CONCAT('%', ?1, '%')")
//    Page<Department> findByNameContaining(String characterName, Pageable pageable);

    @Query("SELECT count(d) FROM Department d WHERE d.type = ?1")
    int countByType(Type type);
}
