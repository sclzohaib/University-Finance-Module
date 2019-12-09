package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.ApplicationDTO;
import com.erp.university.Purchase.Model.Application;
import com.erp.university.Purchase.Repository.ApplicationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);
    @Autowired
    ApplicationRepository applicationRepository;

    //Save Application
    public ResponseEntity<String> saveApplication(ApplicationDTO applicationDTO) {
        logger.debug("--------->| Create Application: |<---------");
        logger.debug("ApplicationDTO: {}", applicationDTO);
        try {
            Application application = new Application();
            application.setAssociatePerson(applicationDTO.getAssociatePerson());
            application.setDate(new Date());
            application.setStatus(applicationDTO.getStatus());
            application.setSubject(applicationDTO.getSubject());
            logger.debug("Application (POST): {}", application);
            applicationRepository.save(application);
            logger.debug("--------->| Application Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get all Applications
    public ResponseEntity<?> getApplication() {
        logger.debug("--------->| Get All Applications |<---------");
        List<Application> applications;
        try {
            applications = applicationRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (applications.isEmpty()) {
            logger.debug("No Application Record Found");
            return new ResponseEntity<>("No Application Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Applications Found Successfully |<---------");
            return new ResponseEntity<>(applications, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getApplicationById(Long id) {
        logger.debug("--------->| Get Application By ID |<---------");
        Application application;
        try {
            application = applicationRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Application not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Application Found Successfully |<---------");
        logger.debug("Application (GET): {}", application);
        return new ResponseEntity<>(application, HttpStatus.FOUND);
    }

    //Update Application
    public ResponseEntity<String> updateApplication(Long id, ApplicationDTO applicationDTO) {
        logger.debug("---------> Update Application By ID <---------");
        logger.debug("ID: {}, ApplicationDTO: {}", id, applicationDTO);
        try {
            Application application = applicationRepository.findById(id).get();
            logger.debug("Old Application: {}", application);
            application.setAssociatePerson(applicationDTO.getAssociatePerson());
            application.setDate(applicationDTO.getDate());
            application.setStatus(applicationDTO.getStatus());
            application.setSubject(applicationDTO.getSubject());
            try {
                logger.debug("Updated Application (Save): {}", application);
                applicationRepository.save(application);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Application not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Application Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}