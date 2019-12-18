package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TenderDetailsDTO;
import com.erp.university.Purchase.Model.TenderDetails;
import com.erp.university.Purchase.Repository.TenderDetailsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenderDetailsService {
    private static final Logger logger = LogManager.getLogger(PaymentVoucherService.class);
    @Autowired
    TenderDetailsRepository tenderDetailsRepository;

    //save
    public ResponseEntity<String> saveTenderDetails(TenderDetailsDTO tenderDetailsDTO) {
        logger.debug("--------->| Create Tender Details: |<---------");
        logger.debug("TenderDetailsDTO: {}", tenderDetailsDTO);
        try {
            TenderDetails tenderDetails = new TenderDetails();
            tenderDetails.setDescription(tenderDetailsDTO.getDescription());
            tenderDetails.setDescriptionId(tenderDetailsDTO.getDescriptionId());
            tenderDetails.setQty(tenderDetailsDTO.getQty());
            tenderDetails.setId(tenderDetailsDTO.getTenderDetailId());
            tenderDetails.setTotalPrice(tenderDetailsDTO.getTotalPrice());
            tenderDetails.setUnitPrice(tenderDetailsDTO.getUnitPrice());
            logger.debug("Tender Details (POST): {}", tenderDetails);
            tenderDetailsRepository.save(tenderDetails);
            logger.debug("--------->| Tender Details Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }


    //get all
    public ResponseEntity<?> getAllTenderDetails() {
        logger.debug("--------->| Get All Tender Details |<---------");
        List<TenderDetails> tenderDetails;
        try {
            tenderDetails = tenderDetailsRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (tenderDetails.isEmpty()) {
            logger.debug("No Tender Detail Record Found");
            return new ResponseEntity<>("No Tender Detail Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Tender Details Found Successfully |<---------");
            return new ResponseEntity<>(tenderDetails, HttpStatus.FOUND);
        }
    }

    //get by id
    public ResponseEntity<?> getTenderDetailsById(Long id) {
        logger.debug("--------->| Get Tender Details By ID |<---------");
        TenderDetails tenderDetails;
        try {
            tenderDetails = tenderDetailsRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Tender Details Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tender Details Found Successfully |<---------");
        logger.debug("Tender Details (GET): {}", tenderDetails);
        return new ResponseEntity<>(tenderDetails, HttpStatus.FOUND);
    }

    //update
    public ResponseEntity<String> updateTenderDetails(Long id, TenderDetailsDTO tenderDetailsDTO) {
        logger.debug("---------> Update Tender Details By ID <---------");
        logger.debug("ID: {}, TenderDetailsDTO: {}", id, tenderDetailsDTO);
        try {
            TenderDetails tenderDetails = tenderDetailsRepository.findById(id).get();
            logger.debug("Old Tender Details: {}", tenderDetails);
            tenderDetails.setDescription(tenderDetailsDTO.getDescription());
            tenderDetails.setDescriptionId(tenderDetailsDTO.getDescriptionId());
            tenderDetails.setQty(tenderDetailsDTO.getQty());
            tenderDetails.setTotalPrice(tenderDetailsDTO.getTotalPrice());
            tenderDetails.setUnitPrice(tenderDetailsDTO.getUnitPrice());
            try {
                logger.debug("Updated Tender Details (Save): {}", tenderDetails);
                tenderDetailsRepository.save(tenderDetails);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Tender Details Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tender Details Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }


}
