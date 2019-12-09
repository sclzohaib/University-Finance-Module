package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeSignatoryDTO;
import com.erp.university.Purchase.Model.AuthorizeSignatory;
import com.erp.university.Purchase.Repository.AuthorizeSignatoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizeSignatoryService {
    private static final Logger logger = LogManager.getLogger(AuthorizeSignatoryService.class);
    @Autowired
    AuthorizeSignatoryRepository authorizeSignatoryRepository;

    //Save
    public ResponseEntity<String> saveAuthorizedSignatory(AuthorizeSignatoryDTO authorizedSignatoryDTO) {
        logger.debug("--------->| Create Authorize Signatory: |<---------");
        logger.debug("AuthorizeSignatoryDTO: {}", authorizedSignatoryDTO);
        try {
            AuthorizeSignatory authorizeSignatory = new AuthorizeSignatory();
            authorizeSignatory.setLvlId(authorizedSignatoryDTO.getLvlId());
            logger.debug("Authorize Signatory (POST): {}", authorizeSignatory);
            authorizeSignatoryRepository.save(authorizeSignatory);
            logger.debug("--------->| Authorize Signatory Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAuthorizeSignatory() {
        logger.debug("--------->| Get All Authorize Signatory |<---------");
        List<AuthorizeSignatory> authorizeSignatories;
        try {
            authorizeSignatories = authorizeSignatoryRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (authorizeSignatories.isEmpty()) {
            logger.debug("No Authorize Signatory Record Found");
            return new ResponseEntity<>("No Authorize Signatory Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Authorize Signatory Found Successfully |<---------");
            return new ResponseEntity<>(authorizeSignatories, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getAuthorizeSignatoryById(Long id) {
        logger.debug("--------->| Get Authorize Signatory By ID |<---------");
        AuthorizeSignatory authorizeSignatory;
        try {
            authorizeSignatory = authorizeSignatoryRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Authorize Signatory not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Signatory Found Successfully |<---------");
        logger.debug("Application (GET): {}", authorizeSignatory);
        return new ResponseEntity<>(authorizeSignatory, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updateAuthorizeSignatory(Long id, AuthorizeSignatoryDTO authorizeSignatoryDTO) {
        logger.debug("---------> Update Authorize Signatory By ID <---------");
        logger.debug("ID: {}, ApplicationDTO: {}", id, authorizeSignatoryDTO);
        try {
            AuthorizeSignatory authorizeSignatory = authorizeSignatoryRepository.findById(id).get();
            logger.debug("Old Authorize Signatory: {}", authorizeSignatory);
            authorizeSignatory.setLvlId(authorizeSignatoryDTO.getLvlId());
            try {
                logger.debug("Updated Authorize Signatory (Save): {}", authorizeSignatory);
                authorizeSignatoryRepository.save(authorizeSignatory);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went worng", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Authorize Signatory not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Signatory Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
