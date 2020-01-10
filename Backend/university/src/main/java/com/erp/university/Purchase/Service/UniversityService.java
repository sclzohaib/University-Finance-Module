package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.UniversityDTO;
import com.erp.university.Purchase.Model.Department;
import com.erp.university.Purchase.Model.University;
import com.erp.university.Purchase.Repository.DepartmentRepository;
import com.erp.university.Purchase.Repository.UniversityRepository;
import com.erp.university.Purchase.Repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    private static final Logger logger = LogManager.getLogger(UniversityService.class);
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    UserRepository userRepository;

    //Save
    public ResponseEntity<String> saveUniversity(UniversityDTO universityDTO) {
        logger.debug("--------->| Create University: |<---------");
        logger.debug("UniversityDTO: {}", universityDTO);
        try {
            University university = new University();
            university.setName(universityDTO.getName());
            university.setLocation(universityDTO.getLocation());
            logger.debug("University (POST): {}", university);
            universityRepository.save(university);
            logger.debug("--------->| University Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getAllUniversity() {
        logger.debug("--------->| Get All Universities |<---------");
        List<University> universityList;
        try {
            universityList = universityRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (universityList.isEmpty()) {
            logger.debug("No University Record Found");
            return new ResponseEntity<>("{\"No University Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Universities Found Successfully |<---------");
            return new ResponseEntity<>(universityList, HttpStatus.FOUND);
        }
    }

    //Get By Id
    public ResponseEntity<?> getUniversityById(Long id) {
        logger.debug("--------->| Get University By ID |<---------");
        University university;
        try {
            university = universityRepository.findById(id).get();

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"University Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| University Found Successfully |<---------");
        logger.debug("University (GET): {}", university);
        return new ResponseEntity<>(university, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updateUniversity(Long id, UniversityDTO universityDTO) {
        logger.debug("---------> Update University By ID <---------");
        logger.debug("ID: {}, UniversityDTO: {}", id, universityDTO);
        try {
            University university = universityRepository.findById(id).get();
            logger.debug("Old University: {}", university);
            university.setName(universityDTO.getName());
            university.setLocation(universityDTO.getLocation());
            try {
                logger.debug("Updated University (Save): {}", university);
                universityRepository.save(university);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"University Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| University Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteUniversity(Long id) {
        logger.debug("---------> Delete University By ID <---------");
        try {
            List<Department> departments = universityRepository.findById(id).get().getDepartments();
            if((departments!=null) && (!departments.isEmpty())) {
                departments.forEach(department -> {
                    department.getUsers().forEach(user -> {
                        userRepository.deleteROLE_USERSByUsersId(user.getId());
                        userRepository.deleteById(user.getId());
                    });
                    departmentRepository.deleteById(department.getId());
                });
            }
            universityRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"University not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| University Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
