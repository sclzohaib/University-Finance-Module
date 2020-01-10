package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TendorDTO;
import com.erp.university.Purchase.Model.Tendor;
import com.erp.university.Purchase.Repository.TendorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TendorService {
    private static final Logger logger = LogManager.getLogger(TendorService.class);
    @Autowired
    TendorRepository tendorRepository;

    //Save
    public ResponseEntity<String> saveTendor(TendorDTO tendorDTO) {
        logger.debug("--------->| Create Tendor: |<---------");
        logger.debug("TendorDTO: {}", tendorDTO);
        try {
            Tendor tendor = new Tendor();
            tendor.settNo(tendorDTO.gettNo());
            tendor.settStatus(tendor.gettStatus());
            logger.debug("Tendor (POST): {}", tendor);
            tendorRepository.save(tendor);
            logger.debug("--------->| Tendor Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllTendor() {
        logger.debug("--------->| Get All Tendors |<---------");
        List<Tendor> tendors;
        try {
            tendors = tendorRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (tendors.isEmpty()) {
            logger.debug("No Tendor Record Found");
            return new ResponseEntity<>("{\"No Tendor Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Tendor Found Successfully |<---------");
            return new ResponseEntity<>(tendors, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getTendorById(Long id) {
        logger.debug("--------->| Get Tendor By ID |<---------");
        Tendor tendor;
        try {
            tendor = tendorRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tendor Not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tendor Found Successfully |<---------");
        logger.debug("Tendor (GET): {}", tendor);
        return new ResponseEntity<>(tendor, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateTendor(Long id, TendorDTO tendorDTO) {
        logger.debug("---------> Update Tendor By ID <---------");
        logger.debug("ID: {}, TendorDTO: {}", id, tendorDTO);
        try {
            Tendor tendor = tendorRepository.findById(id).get();
            logger.debug("Old Tendor: {}", tendor);
            tendor.settNo(tendorDTO.gettNo());
            tendor.settStatus(tendorDTO.gettStatus());
            try {
                logger.debug("Updated Tendor (Save): {}", tendor);
                tendorRepository.save(tendor);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tendor not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tendor Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteTendor(Long id) {
        logger.debug("---------> Delete Tendor By ID <---------");
        try {
            tendorRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tendor not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tendor Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}

