package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.MinorHeadDTO;
import com.erp.university.Purchase.Model.MinorHead;
import com.erp.university.Purchase.Repository.MinorHeadRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinorHeadService {
    private static final Logger logger = LogManager.getLogger(MinorHeadService.class);
    @Autowired
    MinorHeadRepository minorHeadRepository;

    //Save
    public ResponseEntity<String> saveMinorHead(MinorHeadDTO minorHeadDTO) {
        logger.debug("--------->| Create Minor Head: |<---------");
        logger.debug("MinorHeadDTO: {}", minorHeadDTO);
        try {
            MinorHead minorHead = new MinorHead();
            minorHead.setCodeNo(minorHeadDTO.getCodeNo());
            minorHead.setName(minorHeadDTO.getName());
            minorHead.setMajorHead(minorHeadDTO.getMajorHead());
            logger.debug("Minor Head (POST): {}", minorHead);
            minorHeadRepository.save(minorHead);
            logger.debug("--------->| Minor Head Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Succesfully\":1}", HttpStatus.CREATED);

    }

    //Get all
    public ResponseEntity<?> getAllMinorHead() {
        logger.debug("--------->| Get All Minor Heads |<---------");
        List<MinorHead> minorHeads;
        try {
            minorHeads = minorHeadRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (minorHeads.isEmpty()) {
            logger.debug("No Minor Head Record Found");
            return new ResponseEntity<>("{\"No Minor Head Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Minor Head Found Successfully |<---------");
            return new ResponseEntity<>(minorHeads, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getMinorHeadById(Long id) {
        logger.debug("--------->| Get Minor Head By ID |<---------");
        MinorHead minorHead;
        try {
            minorHead = minorHeadRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Minor Head Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Minor Head Found Successfully |<---------");
        logger.debug("Minor Head (GET): {}", minorHead);
        return new ResponseEntity<>(minorHead, HttpStatus.FOUND);

    }

    //Update
    public ResponseEntity<String> updateMinorHead(Long id, MinorHeadDTO minorHeadDTO) {
        logger.debug("---------> Update Minor Head By ID <---------");
        logger.debug("ID: {}, MinorHeadDTO: {}", id, minorHeadDTO);
        try {
            MinorHead minorHead = minorHeadRepository.findById(id).get();
            logger.debug("Old Minor Head: {}", minorHead);
            minorHead.setCodeNo(minorHeadDTO.getCodeNo());
            minorHead.setName(minorHeadDTO.getName());
            try {
                logger.debug("Updated Minor Head (Save): {}", minorHead);
                minorHeadRepository.save(minorHead);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Minor Head Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Minor Head Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteMinorHead(Long id) {
        logger.debug("---------> Delete Minor Head By ID <---------");
        try {
            minorHeadRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Minor Head not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Minor Head Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
