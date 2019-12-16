package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.CoveringLetterDTO;
import com.erp.university.Purchase.Model.CoveringLetter;
import com.erp.university.Purchase.Repository.CoveringLetterRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoveringLetterService {
    private static final Logger logger = LogManager.getLogger(CoveringLetterService.class);
    @Autowired
    CoveringLetterRepository coveringLetterRepository;

    //Save
    public ResponseEntity<String> saveCoveringLetter(CoveringLetterDTO coveringLetterDTO) {
        logger.debug("--------->| Create Covering Letter: |<---------");
        logger.debug("CoveringLetterDTO: {}", coveringLetterDTO);
        try {
            CoveringLetter coveringLetter = new CoveringLetter();
            logger.debug("Covering Letter (POST): {}", coveringLetter);
            coveringLetterRepository.save(coveringLetter);
            logger.debug("--------->| Covering Letter Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get All
    public ResponseEntity<?> getCoveringLetter() {
        logger.debug("--------->| Get All Covering Letter |<---------");
        List<CoveringLetter> coveringLetters;
        try {
            coveringLetters = coveringLetterRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (coveringLetters.isEmpty()) {
            logger.debug("No Covering Letter Record Found");
            return new ResponseEntity<>("No Covering Letter Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Covering Letter Found Successfully |<---------");
            return new ResponseEntity<>(coveringLetters, HttpStatus.FOUND);
        }
    }

    //Get By id
    public ResponseEntity<?> getCoveringLetterById(Long id) {
        logger.debug("--------->| Get Covering Letter By ID |<---------");
        CoveringLetter coveringLetter;
        try {
            coveringLetter = coveringLetterRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Covering Letter Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Covering Letter Found Successfully |<---------");
        logger.debug("Application (GET): {}", coveringLetter);
        return new ResponseEntity<>(coveringLetter, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateCoveringLetter(Long id, CoveringLetterDTO coveringLetterDTO) {
        logger.debug("---------> Update Covering Letter By ID<---------");
        logger.debug("ID: {}, ApplicationDTO: {}", id, coveringLetterDTO);
        try {
            CoveringLetter coveringLetter = coveringLetterRepository.findById(id).get();
            logger.debug("Old Covering Letter: {}", coveringLetter);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Covering Letter Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Covering Letter Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

}

