package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.DepartmentDTO;
import com.erp.university.Purchase.Model.Department;
import com.erp.university.Purchase.Model.User;
import com.erp.university.Purchase.Repository.DepartmentRepository;
import com.erp.university.Purchase.Repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private static final Logger logger = LogManager.getLogger(DepartmentService.class);
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    UserRepository userRepository;

    //Save Department
    public ResponseEntity<String> saveDepartment(DepartmentDTO departmentDTO) {
        logger.debug("--------->| Create Department: |<---------");
        logger.debug("DepartmentDTO: {}", departmentDTO);
        try {
            Department department = new Department();
            department.setName(departmentDTO.getName());
            department.setLocation(departmentDTO.getLocation());
            department.setExtensionNo(departmentDTO.getExtensionNo());
            department.setTelephone(departmentDTO.getTelephone());
            department.setUniversity(departmentDTO.getUniversity());
            logger.debug("Department (POST): {}", department);
            departmentRepository.save(department);
            logger.debug("--------->| Department Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
    }

    //Get all department
    public ResponseEntity<?> getDepartment() {
        logger.debug("--------->| Get All Departments |<---------");
        List<Department> departments;
        try {
            departments = departmentRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (departments.isEmpty()) {
            logger.debug("No Department Record Found");
            return new ResponseEntity<>("{\"No Department Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Department Found Successfully |<---------");
            return new ResponseEntity<>(departments, HttpStatus.FOUND);
        }
    }

    //Get department By id
    public ResponseEntity<?> getDepartmentById(Long id) {
        logger.debug("--------->| Get Department By ID |<---------");
        Department department;
        try {
            department = departmentRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Department Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Department Found Successfully |<---------");
        logger.debug("Department (GET): {}", department);
        return new ResponseEntity<>(department, HttpStatus.FOUND);
    }

    //Update Department
    public ResponseEntity<String> updateDepartment(Long id, DepartmentDTO departmentDTO) {
        logger.debug("---------> Update Department By ID<---------");
        logger.debug("ID: {}, DepartmentDTO: {}", id, departmentDTO);
        try {
            Department department = departmentRepository.findById(id).get();
            logger.debug("Old Department: {}", department);
            department.setName(departmentDTO.getName());
            department.setTelephone(departmentDTO.getTelephone());
            department.setExtensionNo(departmentDTO.getExtensionNo());
            department.setLocation(departmentDTO.getLocation());
            department.setUniversity(departmentDTO.getUniversity());
            try {
                logger.debug("Updated Department (Save): {}", department);
                departmentRepository.save(department);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Department Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Department Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);

    }

    //delete by id
    public ResponseEntity<String> deleteDepartment(Long id) {
        logger.debug("---------> Delete Department By ID <---------");
        try {
            List<User> users = departmentRepository.findById(id).get().getUsers();
           if((users!=null) && (!users.isEmpty())) {
               users.forEach(user -> {
                   userRepository.deleteROLE_USERSByUsersId(user.getId());
                   userRepository.deleteById(user.getId());
               });
           }
                departmentRepository.deleteById(id);


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Department not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Department Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
