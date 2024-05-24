package com.vti.template.service;

import com.vti.template.entity.Department;
import com.vti.template.entity.Type;
import com.vti.template.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    @Lazy
    private IDepartmentRepository departmentRepository;

    //    GET
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public boolean isDepartmentExistsById(int id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    //    Search all by name
    @Override
//    public List<Department> getDepartmentByNameContaining(String name) {
//        return departmentRepository.findByNameContaining(name);
//    }

    public Page<Department> getDepartmentByNameContaining(String characterName, Pageable pageable) {
        return departmentRepository.findByNameContaining(characterName, pageable);
    }


    //    POST
    @Override
    public void createDepartment(Department department) {
////        Convert Type to String
//        String prefix = converted(department.getType());
//
////        Count by Type
//        int count = departmentRepository.countByType(department.getType());
//
//        // Generate the new department code
//        String code = prefix + "-" + (count + 1);
//        department.setCode(code);
        departmentRepository.save(department);
    }
//
//    private String converted(Type type) {
//        switch (type) {
//            case DEV:
//                return "D";
//            case TEST:
//                return "T";
//            case PROJECT_MANAGER:
//                return "P";
//            default:
//                throw new IllegalArgumentException("Unknown status: " + type);
//        }
//    }


    //    PUT
    @Override
    public void updateDepartment(Department department) {
//        String code = null;
////        If no Type, set Type = old Type in db
//        if (department.getType() == null) {
//            department.setType(getDepartmentById(department.getId()).getType());
//
////        Convert Type to String
//            String prefix = converted(department.getType());
//
////        Count by Type
//            int count = departmentRepository.countByType(department.getType());
//
//            // Generate the new department code
//            code = prefix + "-" + count;
//        } else {
////        Convert Type to String
//            String prefix = converted(department.getType());
//
////        Count by Type
//            int count = departmentRepository.countByType(department.getType());
//
//            // Generate the new department code
//            code = prefix + "-" + (count + 1);
//        }
//
//        department.setCode(code);
        departmentRepository.save(department);
    }


    //    DELETE
    @Override
    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void deleteSelectedDepartments(List<Integer> listId) {
        for (Integer id : listId) {
            if (isDepartmentExistsById(id)) {
                departmentRepository.deleteById(id);
            }
        }
    }

}
