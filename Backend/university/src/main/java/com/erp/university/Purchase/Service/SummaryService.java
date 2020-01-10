package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.SummaryDTO;
import com.erp.university.Purchase.Model.Summary;
import com.erp.university.Purchase.Repository.SummaryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {
    private static final Logger logger = LogManager.getLogger(SummaryService.class);
    @Autowired
    SummaryRepository summaryRepository;

    //Save
    public ResponseEntity<String> saveSummary(SummaryDTO summaryDTO) {
        logger.debug("--------->| Create Summary: |<---------");
        logger.debug("SummaryDTO: {}", summaryDTO);
        try {
            Summary summary = new Summary();
            logger.debug("Summary (POST): {}", summary);
            summaryRepository.save(summary);
            logger.debug("--------->| Summary Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);
    }

    //Get all
    public ResponseEntity<?> getAllSummary() {
        logger.debug("--------->| Get All Summaries |<---------");
        List<Summary> summaries;
        try {
            summaries = summaryRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (summaries.isEmpty()) {
            logger.debug("No Summary Record Found");
            return new ResponseEntity<>("{\"No Summary Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Summaries Found Successfully |<---------");
            return new ResponseEntity<>(summaries, HttpStatus.FOUND);
        }
    }

    //Get by id
    public ResponseEntity<?> getSummaryById(Long id) {
        logger.debug("--------->| Get Summary By ID |<---------");
        Summary summary;
        try {
            summary = summaryRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Summary Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Summary Found Successfully |<---------");
        logger.debug("Summary (GET): {}", summary);
        return new ResponseEntity<>(summary, HttpStatus.FOUND);
    }

    //Update
    public ResponseEntity<String> updateSummary(Long id, SummaryDTO summaryDTO) {
        logger.debug("---------> Update Summary By ID <---------");
        logger.debug("ID: {}, SummaryDTO: {}", id, summaryDTO);
        try {
            Summary summary = summaryRepository.findById(id).get();
            logger.debug("Old Summary: {}", summary);
            try {
                logger.debug("Updated Summary (Save): {}", summary);
                summaryRepository.save(summary);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went Wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Summary Not Found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Summary Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteSummary(Long id) {
        logger.debug("---------> Delete Summary By ID <---------");
        try {
            summaryRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Summary not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Summary Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
