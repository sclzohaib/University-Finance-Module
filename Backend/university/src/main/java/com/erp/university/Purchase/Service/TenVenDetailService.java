package com.erp.university.Purchase.Service;

import com.erp.university.Purchase.DTO.TenVenDTO;
import com.erp.university.Purchase.Model.TenVenDetails;
import com.erp.university.Purchase.Repository.TenVenRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenVenDetailService {
    private static final Logger logger = LogManager.getLogger(ApplicationService.class);
    @Autowired
    TenVenRepository tenVenRepository;

    //Save
    public ResponseEntity<String> saveTenVenDetail(TenVenDTO tenVenDTO) {
        logger.debug("--------->| Create Tendor Vendor Details: |<---------");
        logger.debug("TenVenDTO: {}", tenVenDTO);
        try {
            TenVenDetails tenVenDetails = new TenVenDetails();
            tenVenDetails.setVendorAddress(tenVenDetails.getVendorAddress());
            tenVenDetails.setQuotation(tenVenDTO.getQuotation());
            tenVenDetails.setVendorEmail(tenVenDTO.getVendorEmail());
            tenVenDetails.setVendorNic(tenVenDTO.getVendorNic());
            tenVenDetails.setVenNtn(tenVenDTO.getVenNtn());
            logger.debug("Tendor Vendor Details (POST): {}", tenVenDetails);
            tenVenRepository.save(tenVenDetails);
            logger.debug("--------->| Tendor Vendor Details Created |<---------");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{\"Added Successfully\":1}", HttpStatus.CREATED);

    }

    //Get all
    public ResponseEntity<?> getAllTenVenDetail() {
        logger.debug("--------->| Get All Tendor Vendor Details |<---------");
        List<TenVenDetails> tenVenDetails;
        try {
            tenVenDetails = tenVenRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.NOT_FOUND);
        }
        if (tenVenDetails.isEmpty()) {
            logger.debug("No Tendor Vendor Details Record Found");
            return new ResponseEntity<>("{\"No Tendor Vendor Details Record Found\":1}", HttpStatus.NOT_FOUND);
        } else {
            logger.debug("--------->| Tendor Vendor Details Found Successfully |<---------");
            return new ResponseEntity<>(tenVenDetails, HttpStatus.FOUND);
        }
    }


    //Get by id
    public ResponseEntity<?> getTenVenDetailById(Long id) {
        logger.debug("--------->| Get Tendor Vendor Details By ID |<---------");
        TenVenDetails tenVenDetails;
        try {
            tenVenDetails = tenVenRepository.findById(id).get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tendor Vendor Details not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tendor Vendor Details Found Successfully |<---------");
        logger.debug("Tendor Vendor Details (GET): {}", tenVenDetails);
        return new ResponseEntity<>(tenVenDetails, HttpStatus.FOUND);
    }

    //update
    public ResponseEntity<String> updateTenVenDetail(Long id, TenVenDTO tenVenDTO) {
        logger.debug("---------> Update Tendor Vendor Details By ID <---------");
        logger.debug("ID: {}, TenVenDTO: {}", id, tenVenDTO);
        try {
            TenVenDetails tenVenDetails = tenVenRepository.findById(id).get();
            logger.debug("Old Tendor Vendor Details: {}", tenVenDetails);
            tenVenDetails.setQuotation(tenVenDTO.getQuotation());
            tenVenDetails.setVendorAddress(tenVenDTO.getVendorAddress());
            tenVenDetails.setVendorEmail(tenVenDTO.getVendorEmail());
            tenVenDetails.setVendorNic(tenVenDTO.getVendorNic());
            tenVenDetails.setVenNtn(tenVenDTO.getVenNtn());
            try {
                logger.debug("Updated Tendor Vendor Details (Save): {}", tenVenDetails);
                tenVenRepository.save(tenVenDetails);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ResponseEntity<>("{\"Something went wrong\":1}", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tendor Vendor Details not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tendor Vendor Details Updated Successfully |<---------");
        return new ResponseEntity<>("{\"Updated Successfully\":1}", HttpStatus.OK);
    }

    //delete by id
    public ResponseEntity<String> deleteTenVenDetail(Long id) {
        logger.debug("---------> Delete Tendor Vendor Details By ID <---------");
        try {
            tenVenRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("{\"Tendor Vendor Details not found\":1}", HttpStatus.NOT_FOUND);
        }
        logger.debug("--------->| Tendor Vendor Details Deleted Successfully |<---------");
        return new ResponseEntity<>("{\"Deleted Successfully\":1}", HttpStatus.OK);
    }
}
