package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.ApplicationDTO;
import com.erp.university.Purchase.Model.Application;
import com.erp.university.Purchase.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    //Save Application
    public ResponseEntity<String> saveApplication(ApplicationDTO applicationDTO) {

        try {
            Application application = new Application();
            application.setAssociatePerson(applicationDTO.getAssociatePerson());
            application.setDate(new Date());
            application.setStatus(applicationDTO.getStatus());
            application.setSubject(applicationDTO.getSubject());
            applicationRepository.save(application);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);

    }

    //Get all Applications
    public ResponseEntity<?> getApplication() {
        List<Application> applications;
        try {
            applications = applicationRepository.findAll();
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(applications, HttpStatus.FOUND);
    }

    //Get By id
    public ResponseEntity<?> getApplicationById(Long id) {
        Application application;
        try {
            application = applicationRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>("Application not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(application, HttpStatus.FOUND);
    }

    //Update Application
    public ResponseEntity<String> updateApplication(Long id, ApplicationDTO applicationDTO) {
        try {
            Application application = applicationRepository.findById(id).get();
            application.setAssociatePerson(applicationDTO.getAssociatePerson());
            application.setDate(applicationDTO.getDate());
            application.setStatus(applicationDTO.getStatus());
            application.setSubject(applicationDTO.getSubject());
            try {
                applicationRepository.save(application);
            } catch (Exception e) {
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Application not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}