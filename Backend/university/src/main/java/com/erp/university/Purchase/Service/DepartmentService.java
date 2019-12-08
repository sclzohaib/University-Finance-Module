package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.DepartmentDTO;
import com.erp.university.Purchase.Model.Department;
import com.erp.university.Purchase.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    //Save Department
    public ResponseEntity<String> saveDepartment(DepartmentDTO departmentDTO) {
        try {
            Department department = new Department();
            department.setName(departmentDTO.getName());
            department.setLocation(departmentDTO.getLocation());
            department.setExtensionNo(departmentDTO.getExtensionNo());
            department.setTelephone(departmentDTO.getTelephone());
            departmentRepository.save(department);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all department
    public ResponseEntity<?> getDepartment() {
        List<Department> departments;
        try {
            departments = departmentRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departments, HttpStatus.FOUND);

    }

    //Get department By id
    public ResponseEntity<?> getDepartmentById(Long id) {
        Department department;
        try {
            department = departmentRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Department Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.FOUND);
    }

    //Update Department
    public ResponseEntity<String> updateDepartment(Long id, DepartmentDTO departmentDTO) {
        try {
            Department department = departmentRepository.findById(id).get();
            department.setName(departmentDTO.getName());
            department.setTelephone(departmentDTO.getTelephone());
            department.setExtensionNo(departmentDTO.getExtensionNo());
            department.setLocation(departmentDTO.getLocation());
            try {
                departmentRepository.save(department);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Department Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);

    }
}
