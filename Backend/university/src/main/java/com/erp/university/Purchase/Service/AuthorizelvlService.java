package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeLvlDTO;
import com.erp.university.Purchase.Model.AuthorizeLvl;
import com.erp.university.Purchase.Repository.AuthorizeLvlRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizelvlService {

    private static final Logger logger = LogManager.getLogger(AuthorizelvlService.class);
    @Autowired
    AuthorizeLvlRepository authorizeLvlRepository;

    //Save Authorize Level
    public ResponseEntity<String> saveAuthorizeLvl(AuthorizeLvlDTO authorizeLvlDTO) {
        logger.debug("--------->| Create Authorize Level: |<---------");
        logger.debug("Authorize Level DTO: {}", authorizeLvlDTO);
        try {
            AuthorizeLvl authorizeLvl = new AuthorizeLvl();
            authorizeLvl.setLvlNo(authorizeLvlDTO.getLvlNo());
            logger.debug("Authorize Level: {}", authorizeLvl);
            authorizeLvlRepository.save(authorizeLvl);
            logger.debug("--------->| Authorize Level Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Succesfully", HttpStatus.CREATED);
    }

    //Get all authorize level
    public ResponseEntity<?> getAuthorizeLvl() {
        logger.debug("--------->| Get All Authorize Levels |<---------");
        List<AuthorizeLvl> authorizeLvls;
        try {
            authorizeLvls = authorizeLvlRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (authorizeLvls.isEmpty()) {
            logger.debug("No Authorize Level Record Found");
            return new ResponseEntity<>("No Authorize Level Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Authorize Level Found Successfully |<---------");
            return new ResponseEntity<>(authorizeLvls, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getAuthorizeLvlById(Long id) {
        logger.debug("--------->| Get Authorize Level By ID |<---------");
        AuthorizeLvl authorizeLvl;
        try {
            authorizeLvl = authorizeLvlRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Authorize Level not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Level Found Successfully |<---------");
        logger.debug("Application (GET): {}", authorizeLvl);
        return new ResponseEntity<>(authorizeLvl, HttpStatus.FOUND);
    }

    //Update Authorized Level
    public ResponseEntity<String> updateAuthorizeLvl(Long id, AuthorizeLvlDTO authorizeLvlDTO) {
        logger.debug("---------> Update Authorize Level By ID<---------");
        logger.debug("ID: {}, AuthorizeLvlDTO: {}", id, authorizeLvlDTO);
        try {
            AuthorizeLvl authorizeLvl = authorizeLvlRepository.findById(id).get();
            authorizeLvl.setLvlNo(authorizeLvlDTO.getLvlNo());
            try {
                logger.debug("Authorize Level (Save): {}", authorizeLvl);
                authorizeLvlRepository.save(authorizeLvl);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Authorize Level not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Level Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}
