package com.erp.university.Revenue.Services;

import com.erp.university.Purchase.Service.ApplicationService;
import com.erp.university.Revenue.DTO.RevenueHeadDTO;
import com.erp.university.Revenue.Model.RevenueHead;
import com.erp.university.Revenue.Repository.RevenueHeadRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueHeadService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);

    @Autowired
    RevenueHeadRepository revenueHeadRepository;

    //save
    public ResponseEntity<String> saveRevenueHead(RevenueHeadDTO revenueHeadDTO) {
        logger.debug("--------->| Create Revenue Head: |<---------");
        logger.debug("RevenueHeadDTO: {}", revenueHeadDTO);
        try {
            RevenueHead revenueHead = new RevenueHead();
            revenueHead.setName(revenueHeadDTO.getName());
            revenueHead.setCode(revenueHeadDTO.getCode());
            logger.debug("Revenue Head (POST): {}", revenueHead);
            revenueHeadRepository.save(revenueHead);
            logger.debug("--------->| Revenue Head Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //get all
    public ResponseEntity<?> getAllRevenueHead() {
        logger.debug("--------->| Get All Revenue Heads |<---------");
        List<RevenueHead> revenueHeads;
        try {
            revenueHeads = revenueHeadRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (revenueHeads.isEmpty()) {
            logger.debug("No Revenue Head Record Found");
            return new ResponseEntity<>("No Revenue Head Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Revenue Heads Found Successfully |<---------");
            return new ResponseEntity<>(revenueHeads, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getRevenueHeadById(Long id) {
        logger.debug("--------->| Get Revenue Head By ID |<---------");
        RevenueHead revenueHead;
        try {
            revenueHead = revenueHeadRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Revenue Head not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Revenue Head Found Successfully |<---------");
        logger.debug("Revenue Head (GET): {}", revenueHead);
        return new ResponseEntity<>(revenueHead, HttpStatus.FOUND);
    }

    //update by id
    public ResponseEntity<String> updateRevenueHead(Long id, RevenueHeadDTO revenueHeadDTO) {
        logger.debug("---------> Update Revenue Head By ID <---------");
        logger.debug("ID: {}, RevenueHeadDTO: {}", id, revenueHeadDTO);
        try {
            RevenueHead revenueHead = revenueHeadRepository.findById(id).get();
            logger.debug("Old Revenue Head: {}", revenueHead);
            revenueHead.setCode(revenueHeadDTO.getCode());
            revenueHead.setName(revenueHeadDTO.getName());
            try {
                logger.debug("Updated Revenue Head (Save): {}", revenueHead);
                revenueHeadRepository.save(revenueHead);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Revenue Head not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Revenue Head Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteRevenueHead(Long id) {
        logger.debug("---------> Delete Revenue Head By ID <---------");
        try {
            revenueHeadRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Revenue Head not found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Revenue Head Deleted Successfully |<---------");
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
