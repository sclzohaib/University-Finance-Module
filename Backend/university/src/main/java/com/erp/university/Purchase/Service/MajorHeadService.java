package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.MajorHeadDTO;
import com.erp.university.Purchase.Model.MajorHead;
import com.erp.university.Purchase.Repository.MajorHeadRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorHeadService {
    private static final Logger logger = LogManager.getLogger(MajorHeadService.class);
    @Autowired
    MajorHeadRepository majorHeadRepository;

    //Save
    public ResponseEntity<String> saveMajorHead(MajorHeadDTO majorHeadDTO) {
        logger.debug("--------->| Create Major Head: |<---------");
        logger.debug("MajorHeadDTO: {}", majorHeadDTO);
        try {
            MajorHead majorHead = new MajorHead();
            majorHead.setName(majorHeadDTO.getName());
            logger.debug("Major Head (POST): {}", majorHead);
            majorHeadRepository.save(majorHead);
            logger.debug("--------->| Major Head Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Succesfully\":1}", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllMajorHead() {
        logger.debug("--------->| Get All Major Heads |<---------");
        List<MajorHead> majorHeads;
        try {
            majorHeads = majorHeadRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (majorHeads.isEmpty()) {
            logger.debug("No Major Head Record Found");
            return new ResponseEntity<>("{\"No Major Head Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Major Head Found Successfully |<---------");
            return new ResponseEntity<>(majorHeads, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getMajorHeadById(Long id) {
        logger.debug("--------->| Get Major Head By ID |<---------");
        MajorHead majorHead;
        try {
            majorHead = majorHeadRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Major Head not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Major Head Found Successfully |<---------");
        logger.debug("Major Head (GET): {}", majorHead);
        return new ResponseEntity<>(majorHead, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateMajorHead(Long id, MajorHeadDTO majorHeadDTO) {
        logger.debug("---------> Update Major Head By ID<---------");
        logger.debug("ID: {}, MajorHeadDTO: {}", id, majorHeadDTO);
        try {
            MajorHead majorHead = majorHeadRepository.findById(id).get();
            logger.debug("Old Major Head: {}", majorHead);
            majorHead.setName(majorHeadDTO.getName());
            try {
                logger.debug("Updated Major Head (Save): {}", majorHead);
                majorHeadRepository.save(majorHead);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Major Head Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Major Head Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteMajorHead(Long id) {
        logger.debug("---------> Delete Major Head By ID <---------");
        try {
            majorHeadRepository.deleteMinorHeadById(id);
            majorHeadRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Major Head not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Major Head Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
