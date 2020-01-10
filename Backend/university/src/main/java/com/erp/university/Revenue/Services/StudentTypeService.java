package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.StudentTypeDTO;
import com.erp.university.Revenue.Model.StudentType;
import com.erp.university.Revenue.Repository.StudentTypeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentTypeService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    StudentTypeRepository studentTypeRepository;

    //save
    public ResponseEntity<String> saveStudentType(StudentTypeDTO studentTypeDTO) {
        logger.debug("--------->| Create Student Type: |<---------");
        logger.debug("StudentTypeDTO: {}", studentTypeDTO);
        try {
            StudentType studentType = new StudentType();
            studentType.setName(studentTypeDTO.getName());
            logger.debug("Student Type (POST): {}", studentType);
            studentTypeRepository.save(studentType);
            logger.debug("--------->| Student Type Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
    }

    //get all
    public ResponseEntity<?> getAllStudentType() {
        logger.debug("--------->| Get All Student Types |<---------");
        List<StudentType> studentTypes;
        try {
            studentTypes = studentTypeRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (studentTypes.isEmpty()) {
            logger.debug("No Student Type Record Found");
            return new ResponseEntity<>("{\"No Student Type Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Student Types Found Successfully |<---------");
            return new ResponseEntity<>(studentTypes, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getStudentTypeById(Long id) {
        logger.debug("--------->| Get Student Type By ID |<---------");
        StudentType studentType;
        try {
            studentType = studentTypeRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Student Type not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Student Type Found Successfully |<---------");
        logger.debug("Student Type (GET): {}", studentType);
        return new ResponseEntity<>(studentType, HttpStatus.FOUND);
    }

    //update by id
    public ResponseEntity<String> updateStudentType(Long id, StudentTypeDTO studentTypeDTO) {
        logger.debug("---------> Update Student Type By ID <---------");
        logger.debug("ID: {}, StudentTypeDTO: {}", id, studentTypeDTO);
        try {
            StudentType studentType = studentTypeRepository.findById(id).get();
            logger.debug("Old Student Type: {}", studentType);
            studentType.setName(studentTypeDTO.getName());
            try {
                logger.debug("Updated Student Type (Save): {}", studentType);
                studentTypeRepository.save(studentType);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Student Type not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Student Type Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteStudentTypeById(Long id) {
        logger.debug("---------> Delete Student Type By ID <---------");
        try {
            studentTypeRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Student Type not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Student Type Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }

}
