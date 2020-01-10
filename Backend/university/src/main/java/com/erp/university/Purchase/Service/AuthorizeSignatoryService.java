package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeSignatoryDTO;
import com.erp.university.Purchase.Model.AuthorizeSignatory;
import com.erp.university.Purchase.Model.User;
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
            authorizeSignatory.setName(authorizedSignatoryDTO.getName());
            authorizeSignatory.setAuthorizeLvl(authorizedSignatoryDTO.getAuthorizeLvl());
            logger.debug("Authorize Signatory (POST): {}", authorizeSignatory);
            authorizeSignatoryRepository.save(authorizeSignatory);
            logger.debug("--------->| Authorize Signatory Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAuthorizeSignatory() {
        logger.debug("--------->| Get All Authorize Signatory |<---------");
        List<AuthorizeSignatory> authorizeSignatories;
        try {
            authorizeSignatories = authorizeSignatoryRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (authorizeSignatories.isEmpty()) {
            logger.debug("No Authorize Signatory Record Found");
            return new ResponseEntity<>("{\"No Authorize Signatory record found\":1}", HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>("{\"Authorize Signatory not found\":1}", HttpStatus.NOT_FOUND);
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
            authorizeSignatory.setName(authorizeSignatoryDTO.getName());
            authorizeSignatory.setAuthorizeLvl(authorizeSignatoryDTO.getAuthorizeLvl());
            try {
                logger.debug("Updated Authorize Signatory (Save): {}", authorizeSignatory);
                authorizeSignatoryRepository.save(authorizeSignatory);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Authorize Signatory not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Signatory Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }


    //delete by id
    public ResponseEntity<String> deleteAuthorizeSignatory(Long id) {
        logger.debug("---------> Delete Authorize Signatory By ID <---------");
        try {
            User user = authorizeSignatoryRepository.findById(id).get().getUser();
            if(user==null) {
                authorizeSignatoryRepository.deleteById(id);
            }
            else{
                return new ResponseEntity<>("{\"User Associated with this Signatory, It cannot be delete\":1}", HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Authorize Signatory not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Signatory Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
