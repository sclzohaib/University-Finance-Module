package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.ClassDTO;
import com.erp.university.Revenue.Model.Class;
import com.erp.university.Revenue.Repository.ClassRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    ClassRepository classRepository;

    //save
    public ResponseEntity<String> saveClass(ClassDTO classDTO) {
        logger.debug("--------->| Create Class: |<---------");
        logger.debug("ClassDTO: {}", classDTO);
        try {
            Class stdclass = new Class();
            stdclass.setName(classDTO.getName());
            logger.debug("Class (POST): {}", stdclass);
            classRepository.save(stdclass);
            logger.debug("--------->| Class Created |<---------");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //get all
    public ResponseEntity<?> getAllClass() {
        logger.debug("--------->| Get All Classes |<---------");
        List<Class> classes;
        try {
            classes = classRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (classes.isEmpty()) {
            logger.debug("No Class Record Found");
            return new ResponseEntity<>("No Class Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Classes Found Successfully |<---------");
            return new ResponseEntity<>(classes, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getClassById(Long id) {
        logger.debug("--------->| Get Class By ID |<---------");
        Class getClass;
        try {
            getClass = classRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Class not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Class Found Successfully |<---------");
        logger.debug("Class (GET): {}", getClass);
        return new ResponseEntity<>(getClass, HttpStatus.FOUND);
    }

    //update by id
    public ResponseEntity<String> updateClass(Long id, ClassDTO classDTO) {
        logger.debug("---------> Update Class By ID <---------");
        logger.debug("ID: {}, ClassDTO: {}", id, classDTO);
        try {
            Class getClass = classRepository.findById(id).get();
            logger.debug("Old Class: {}", getClass);
            getClass.setName(classDTO.getName());
            try {
                logger.debug("Updated Class (Save): {}", getClass);
                classRepository.save(getClass);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Class not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Class Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteClass(Long id) {
        logger.debug("---------> Delete Class By ID <---------");
        try {
            classRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Class not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Class Deleted Successfully |<---------");
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
