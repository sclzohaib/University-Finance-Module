package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.DepartmentDTO;
import com.erp.university.Purchase.Model.Department;
import com.erp.university.Purchase.Model.University;
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
    public ResponseEntity<String> saveDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setLocation(departmentDTO.getLocation());
        department.setExtensionNo(departmentDTO.getExtensionNo());
        department.setTelephone(departmentDTO.getTelephone());
    departmentRepository.save(department);
    return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all department
    public ResponseEntity<List<Department>> getDepartment(){
        List<Department> departments = departmentRepository.findAll();
        return new ResponseEntity<List<Department>>(departments,HttpStatus.FOUND);

    }

    //Get department By id
    public ResponseEntity<Department> getDepartmentById(Long id){
        Department department = departmentRepository.findById(id).get();
        return new ResponseEntity<Department>(department, HttpStatus.FOUND);
    }

    //Update Department
    public ResponseEntity<String> updateDepartment(Long id, DepartmentDTO departmentDTO){
        Department department = departmentRepository.findById(id).get();
        department.setName(departmentDTO.getName());
        department.setTelephone(departmentDTO.getTelephone());
        department.setExtensionNo(departmentDTO.getExtensionNo());
        department.setLocation(departmentDTO.getLocation());
        departmentRepository.save(department);
        return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);

    }
}
