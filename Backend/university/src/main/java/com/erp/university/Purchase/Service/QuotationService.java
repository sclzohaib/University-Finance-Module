package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.QuotationDTO;
import com.erp.university.Purchase.Model.Quotation;
import com.erp.university.Purchase.Repository.QuotationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotationService {

    private static final Logger logger = LogManager.getLogger(QuotationService.class);
    @Autowired
    QuotationRepository quotationRepository;

    //Save Quotation
    public ResponseEntity<String> saveQuotation(QuotationDTO quotationDTO) {
        logger.debug("--------->| Create Quotation: |<---------");
        logger.debug("QuotationDTO: {}", quotationDTO);
        try {
            Quotation quotation = new Quotation();
            quotation.setDate(quotationDTO.getDate());
            quotation.setRefNo(quotationDTO.getRefNo());
            quotation.setTermsCondition(quotationDTO.getTermsCondition());
            quotation.setTotal(quotationDTO.getTotal());
            logger.debug("Quotation (POST): {}", quotation);
            quotationRepository.save(quotation);
            logger.debug("--------->| Quotation Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }

    //Get all Quotations
    public ResponseEntity<?> getAllQuotation() {
        logger.debug("--------->| Get All Quotations |<---------");
        List<Quotation> quotations;
        try {
            quotations = quotationRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
        }
        if (quotations.isEmpty()) {
            logger.debug("No Quotation Record Found");
            return new ResponseEntity<>("No Quotation Record Found", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Quotation Found Successfully |<---------");
            return new ResponseEntity<>(quotations, HttpStatus.FOUND);
        }
    }

    //Get Quotations By id
    public ResponseEntity<?> getQuotationById(Long id) {
        logger.debug("--------->| Get Quotation By ID |<---------");
        Quotation quotation;
        try {
            quotation = quotationRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Quotation Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Quotation Found Successfully |<---------");
        logger.debug("Quotation (GET): {}", quotation);
        return new ResponseEntity<>(quotation, HttpStatus.FOUND);
    }

    //Update Quotation by Id
    public ResponseEntity<String> updateQuotation(Long id, QuotationDTO quotationDTO) {
        logger.debug("---------> Update Quotation By ID <---------");
        logger.debug("ID: {}, QuotationDTO: {}", id, quotationDTO);
        try {
            Quotation quotation = quotationRepository.findById(id).get();
            logger.debug("Old Quotation: {}", quotation);
            quotation.setDate(quotationDTO.getDate());
            quotation.setRefNo(quotationDTO.getRefNo());
            quotation.setTermsCondition(quotationDTO.getTermsCondition());
            quotation.setTotal(quotationDTO.getTotal());
            try {
                logger.debug("Updated Quotation (Save): {}", quotation);
                quotationRepository.save(quotation);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Quotation Not Found", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Quotation Updated Successfully |<---------");
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
