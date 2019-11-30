package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.DepartmentDTO;
import com.erp.university.Purchase.Model.Department;
import com.erp.university.Purchase.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public ResponseEntity<String> saveDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setLocation(departmentDTO.getLocation());
        department.setExtensionNo(departmentDTO.getExtensionNo());
        department.setTelephone(departmentDTO.getTelephone());
    departmentRepository.save(department);
    return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
    }
}
