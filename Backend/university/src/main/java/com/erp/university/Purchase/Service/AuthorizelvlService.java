package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.AuthorizeLvlDTO;
import com.erp.university.Purchase.Model.AuthorizeLvl;
import com.erp.university.Purchase.Model.AuthorizeSignatory;
import com.erp.university.Purchase.Repository.AuthorizeLvlRepository;
import com.erp.university.Purchase.Repository.AuthorizeSignatoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizelvlService {

    private static final Logger logger = LogManager.getLogger(AuthorizelvlService.class);
    @Autowired
    AuthorizeLvlRepository authorizeLvlRepository;
    @Autowired
    AuthorizeSignatoryRepository authorizeSignatoryRepository;

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
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Sucessfully\":1}", HttpStatus.CREATED);
    }

    //Get all authorize level
    public ResponseEntity<?> getAuthorizeLvl() {
        logger.debug("--------->| Get All Authorize Levels |<---------");
        List<AuthorizeLvl> authorizeLvls;
        try {
            authorizeLvls = authorizeLvlRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (authorizeLvls.isEmpty()) {
            logger.debug("No Authorize Level Record Found");
            return new ResponseEntity<>("{\"No Authorize Level Record Found\":1}", HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>("{\"Authorize Level not found\":1}", HttpStatus.NOT_FOUND);
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
            }
            catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Authorize Level not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Level Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteAuthorizeLvl(Long id) {
        logger.debug("---------> Delete Authorize Level By ID <---------");
        try {
            List<AuthorizeSignatory> authorizeSignatories = authorizeLvlRepository.findById(id).get().getAuthorizeSignatories();
            if((authorizeSignatories!=null) && (!authorizeSignatories.isEmpty())) {
                List<AuthorizeSignatory> filteredAuthSign = new ArrayList<>();
                authorizeSignatories.forEach(authorizeSignatory -> {
                    if(authorizeSignatory.getUser()!=null) {
                        filteredAuthSign.add(authorizeSignatory);
                     }
                });
                if(filteredAuthSign.size()>0){
                   return new ResponseEntity<>("{\"Can't be delete, Authorize Level associated with any User\":1}", HttpStatus.NOT_ACCEPTABLE);
                }
                else{
                    authorizeSignatories.forEach(authorizeSignatory -> {
                        authorizeSignatoryRepository.deleteById(authorizeSignatory.getId());
                    });
                }
            }

                authorizeLvlRepository.deleteById(id);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Authorize Level not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Authorize Level Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }

}
